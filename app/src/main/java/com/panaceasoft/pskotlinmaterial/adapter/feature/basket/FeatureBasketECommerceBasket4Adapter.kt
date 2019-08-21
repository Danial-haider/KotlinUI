package com.panaceasoft.pskotlinmaterial.adapter.feature.basket

import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView

import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Basket
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_basket_ecommerce_basket_4_item.view.*

import java.util.ArrayList

/**
 * Created by Panacea-Soft on 20/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureBasketECommerceBasket4Adapter(private val basketList: List<Basket>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    private val countList: List<String>
        get() {
            val sizeList = ArrayList<String>()

            sizeList.add(" 1 ")
            sizeList.add(" 2 ")
            sizeList.add(" 3 ")
            sizeList.add(" 4 ")
            sizeList.add(" 5 ")
            sizeList.add(" 6 ")
            sizeList.add(" 7 ")
            sizeList.add(" 8 ")
            sizeList.add(" 9 ")
            sizeList.add(" 10 ")

            return sizeList
        }

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: Basket, position: Int)

        fun onSaveClick(view: View, obj: Basket, position: Int)

        fun onRemoveClick(view: View, obj: Basket, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_basket_ecommerce_basket_4_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is PlaceViewHolder) {

            val basket = basketList[position]

            viewHolder.itemNameTextView.text = basket.name

            val context = viewHolder.holderCardView.context

            val id = Utils.getDrawableInt(context, basket.image)
            Utils.setImageToImageView(context, viewHolder.itemImageView, id)

            val countList = countList
            val arrayAdapter = ArrayAdapter(viewHolder.holderCardView.context, android.R.layout.simple_spinner_item, countList)

            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            viewHolder.noSpinner.adapter = arrayAdapter

            val priceStr = basket.currency + " " + basket.price
            viewHolder.priceTextView.text = priceStr

            viewHolder.sizeTextView.text = basket.size
            viewHolder.colorTextView.text = basket.color


            //itemClickListener.onPriceChange(basket.currency, total);
            viewHolder.holderCardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, basket, position) }

            viewHolder.removeTextView.setOnClickListener { v: View -> itemClickListener.onRemoveClick(v, basket, position) }

            viewHolder.saveTextView.setOnClickListener { v: View -> itemClickListener.onSaveClick(v, basket, position) }


        }
    }

    override fun getItemCount(): Int {
        return basketList.size
    }

    inner class PlaceViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var itemImageView: ImageView
        internal var itemNameTextView: TextView
        internal var priceTextView: TextView
        internal var holderCardView: CardView
        internal var sizeTextView: TextView
        internal var colorTextView: TextView
        internal var removeTextView: TextView
        internal var saveTextView: TextView
        internal var noSpinner: Spinner

        init {

            itemImageView = view.itemImageView
            itemNameTextView = view.itemNameTextView
            priceTextView = view.priceTextView
            holderCardView = view.holderCardView
            sizeTextView = view.sizeTextView
            colorTextView = view.colorTextView
            noSpinner = view.noSpinner
            removeTextView = view.removeTextView
            saveTextView = view.saveTextView

        }
    }
}
