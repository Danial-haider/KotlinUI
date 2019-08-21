package com.panaceasoft.pskotlinmaterial.adapter.application.ecommerce.home.home1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.utils.Utils
import java.util.*

/**
 * Created by Panacea-Soft on 6/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class AppECommerceHome1FeaturedItemAdapter(private val shopItemArrayList: ArrayList<ShopItem>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: ShopItem, position: Int)
        fun onAddToCartClick(view: View, obj: ShopItem, position: Int)
        fun onLikeClick(view: View, obj: ShopItem, position: Int)
        fun onMenuClick(view: View, obj: ShopItem, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_ecommerce_home_1_featured_item, parent, false)

        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is ItemViewHolder) {

            val shopItem = shopItemArrayList!![position]

            viewHolder.itemNameTextView.text = shopItem.name

            val context = viewHolder.holderCardView.context

            val id = Utils.getDrawableInt(context, shopItem.imageName)
            Utils.setImageToImageView(context, viewHolder.itemImageView, id)

            viewHolder.itemCurrencyTextView.text = shopItem.currency
            viewHolder.itemPriceTextView.text = shopItem.price
            viewHolder.itemRatingBar.rating = java.lang.Float.parseFloat(shopItem.totalRating)
            viewHolder.itemDescTextView.text = shopItem.description


                viewHolder.holderCardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, shopItemArrayList[position], position) }

                viewHolder.addToCartImageView.setOnClickListener { v: View -> itemClickListener.onAddToCartClick(v, shopItemArrayList[position], position) }

                viewHolder.likeImageView.setOnClickListener { v: View -> itemClickListener.onLikeClick(v, shopItemArrayList[position], position) }

                viewHolder.menuImageView.setOnClickListener { v: View -> itemClickListener.onMenuClick(v, shopItemArrayList[position], position) }

        }
    }

    override fun getItemCount(): Int {

        return if (shopItemArrayList != null) {
            if (shopItemArrayList.size > 4) {
                4
            } else {
                shopItemArrayList.size
            }
        } else {
            0
        }
    }

    inner class ItemViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var itemImageView: ImageView = view.findViewById(R.id.itemImageView)
        internal var itemNameTextView: TextView = view.findViewById(R.id.itemNameTextView)
        internal var itemCurrencyTextView: TextView = view.findViewById(R.id.currencyTextView)
        internal var itemPriceTextView: TextView = view.findViewById(R.id.priceTextView)
        internal var itemDescTextView: TextView = view.findViewById(R.id.itemDescTextView)
        internal var itemRatingBar: RatingBar = view.findViewById(R.id.itemRatingBar)
        internal var addToCartImageView: ImageView = view.findViewById(R.id.addToCartImageView)
        internal var likeImageView: ImageView = view.findViewById(R.id.likeImageView)
        internal var menuImageView: ImageView = view.findViewById(R.id.menuImageView)
        internal var holderCardView: CardView = view.findViewById(R.id.holderCardView)

    }
}