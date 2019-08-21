package com.panaceasoft.pskotlinmaterial.adapter.application.ecommerce.basket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Basket
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_ecommerce_basket_1_item.view.*

/**
 * Created by Panacea-Soft on 6/27/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class AppECommerceBasket1Adapter(private val basketList: List<Basket>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener


    interface OnItemClickListener {
        fun onItemClick(view: View, obj: Basket, position: Int)

        fun onDeleteClick(view: View, obj: Basket, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_ecommerce_basket_1_item, parent, false)

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
        internal var itemImageView: ImageView = view.itemImageView
        internal var itemNameTextView: TextView = view.itemNameTextView
        internal var priceTextView: TextView = view.priceTextView
        internal var holderCardView: CardView = view.holderCardView
        internal var deleteImageView: ImageView = view.deleteImageView
        internal var sizeTextView: TextView = view.sizeTextView
        internal var colorTextView: TextView = view.colorTextView

    }
}