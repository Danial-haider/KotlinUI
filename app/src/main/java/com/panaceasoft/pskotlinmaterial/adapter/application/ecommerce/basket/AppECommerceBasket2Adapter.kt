package com.panaceasoft.pskotlinmaterial.adapter.application.ecommerce.basket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Basket
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_ecommerce_basket_2_item.view.*

/**
 * Created by Panacea-Soft on 6/28/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class AppECommerceBasket2Adapter(private val basketList: List<Basket>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener
    private lateinit var currency: String
    private var total = 0

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: Basket, position: Int)

        fun onDeleteClick(view: View, obj: Basket, position: Int)

        fun onPriceChange(currency: String, subTotal: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_ecommerce_basket_2_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is PlaceViewHolder) {

            val basket = basketList[position]
            currency = basket.currency
            viewHolder.itemNameTextView.text = basket.name

            val context = viewHolder.holderCardView.context

            val id = Utils.getDrawableInt(context, basket.image)
            Utils.setImageToImageView(context, viewHolder.itemImageView, id)


            val priceStr = basket.currency + " " + basket.price
            viewHolder.priceTextView.text = priceStr

            var attributeStr = basket.size

            if (attributeStr != "") {
                attributeStr += ", "
            }

            attributeStr += basket.color
            viewHolder.attributeTextView.text = attributeStr

            try {
                val value = Integer.parseInt(viewHolder.qtyEditText.text.toString())
                val price = Integer.parseInt(basket.price)
                val subTotal = value * price
                val subTotalStr = basket.currency + " " + subTotal

                total += subTotal

                viewHolder.subTotalTextView.text = subTotalStr
            } catch (ignored: Exception) {
            }

            viewHolder.minusImageView.setOnClickListener {

                try {
                    var value = Integer.parseInt(viewHolder.qtyEditText.text.toString())

                    if (value > 1) {
                        value -= 1
                    }

                    viewHolder.qtyEditText.setText(value.toString())

                    val itemPriceStr = viewHolder.priceTextView.text.toString()
                    if (itemPriceStr != "") {

                        val price = convertPriceStrToInt(itemPriceStr)
                        val originalSubTotal = convertPriceStrToInt(viewHolder.subTotalTextView.text.toString())
                        total -= originalSubTotal

                        val subTotal = value * price
                        val subTotalStr = basket.currency + " " + subTotal
                        viewHolder.subTotalTextView.text = subTotalStr

                        total += subTotal
                        itemClickListener.onPriceChange(basket.currency, total)

                    }

                } catch (ignored: Exception) {
                }
            }

            viewHolder.plusImageView.setOnClickListener {

                try {
                    var value = Integer.parseInt(viewHolder.qtyEditText.text.toString())

                    value += 1

                    viewHolder.qtyEditText.setText(value.toString())

                    val itemPriceStr = viewHolder.priceTextView.text.toString()
                    if (itemPriceStr != "") {

                        val price = convertPriceStrToInt(itemPriceStr)
                        val originalSubTotal = convertPriceStrToInt(viewHolder.subTotalTextView.text.toString())
                        total -= originalSubTotal

                        val subTotal = value * price
                        val subTotalStr = basket.currency + " " + subTotal
                        viewHolder.subTotalTextView.text = subTotalStr

                        total += subTotal
                        itemClickListener.onPriceChange(basket.currency, total)

                    }

                } catch (ignored: Exception) {
                }
            }

        }
    }

    private fun convertPriceStrToInt(priceStr: String): Int {
        var price = 0
        try {
            val lPriceStr = priceStr.replace(currency, "").replace(" ", "")
            price = Integer.parseInt(lPriceStr)
        } catch (ignored: Exception) {
        }

        return price
    }

    override fun getItemCount(): Int {
        return basketList.size
    }

    inner class PlaceViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var itemImageView: ImageView = view.itemImageView
        internal var itemNameTextView: TextView = view.itemNameTextView
        internal var priceTextView: TextView = view.priceTextView
        internal var holderCardView: CardView = view.holderCardView
        internal var deleteImageView: ImageView = view.deleteImageView
        internal var subTotalTextView: TextView = view.subTotalTextView
        internal var attributeTextView: TextView = view.attributeTextView
        internal var minusImageView: ImageView = view.minusImageView
        internal var plusImageView: ImageView = view.plusImageView
        internal var qtyEditText: EditText = view.qtyEditText

    }
}