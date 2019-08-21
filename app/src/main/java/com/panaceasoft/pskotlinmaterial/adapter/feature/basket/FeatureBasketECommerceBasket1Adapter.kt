package com.panaceasoft.pskotlinmaterial.adapter.feature.basket

import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Basket
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_basket_ecommerce_basket_1_item.view.*

/**
 * Created by Panacea-Soft on 19/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureBasketECommerceBasket1Adapter(private val basketList: List<Basket>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener


    interface OnItemClickListener {
        fun onItemClick(view: View, obj: Basket, position: Int)

        fun onDeleteClick(view: View, obj: Basket, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_basket_ecommerce_basket_1_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is PlaceViewHolder) {

            val basket = basketList[position]

            viewHolder.itemNameTextView.text = basket.name

            val context = viewHolder.holderCardView.context

            val id = Utils.getDrawableInt(context, basket.image)
            Utils.setImageToImageView(context, viewHolder.itemImageView, id)

            val priceStr = basket.currency + " " + basket.price
            viewHolder.priceTextView.text = priceStr

            viewHolder.sizeTextView.text = basket.size
            viewHolder.colorTextView.text = basket.color


            viewHolder.holderCardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, basket, position) }
            viewHolder.deleteImageView.setOnClickListener { v: View -> itemClickListener.onDeleteClick(v, basket, position) }


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
        internal var deleteImageView: ImageView
        internal var sizeTextView: TextView
        internal var colorTextView: TextView

        init {

            itemImageView = view.itemImageView
            itemNameTextView = view.itemNameTextView
            priceTextView = view.priceTextView
            holderCardView = view.holderCardView
            deleteImageView = view.deleteImageView
            sizeTextView = view.sizeTextView
            colorTextView = view.colorTextView

        }
    }
}
