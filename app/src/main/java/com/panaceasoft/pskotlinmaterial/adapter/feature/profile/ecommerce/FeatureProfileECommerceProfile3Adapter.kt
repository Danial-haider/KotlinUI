package com.panaceasoft.pskotlinmaterial.adapter.feature.profile.ecommerce

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_profile_ecommerce_profile_3_item.view.*
import java.util.*

/**
 * Created by Panacea-Soft on 20/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureProfileECommerceProfile3Adapter(private val shopItemArrayList: ArrayList<ShopItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
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

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_profile_ecommerce_profile_3_item, parent, false)

        return ItemViewHolder(itemView)

    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is ItemViewHolder) {

            // Get Shop Item
            val shopItem = shopItemArrayList[position]

            // Convert Item Holder

            // Get Context
            val context = viewHolder.holderCardView.context

            // Set Data to UI
            viewHolder.itemNameTextView.text = shopItem.name
            viewHolder.categoryTextView.text = shopItem.categoryName

            val price = shopItem.currency + shopItem.price
            viewHolder.priceTextView.text = price

            val originalPrice = shopItem.currency + shopItem.originalPrice
            viewHolder.originalPriceTextView.text = originalPrice

            if (shopItem.discount == "0") {
                viewHolder.discountCardView.visibility = View.GONE
                viewHolder.originalPriceTextView.visibility = View.GONE
            } else {
                viewHolder.discountCardView.visibility = View.VISIBLE
                viewHolder.originalPriceTextView.visibility = View.VISIBLE

                val discount = shopItem.discount + " %"
                viewHolder.percentTextView.text = discount
                viewHolder.ratingTextView.text = shopItem.totalRating
            }

            viewHolder.originalPriceTextView.paintFlags = viewHolder.originalPriceTextView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG


            // Set Image
            val id = Utils.getDrawableInt(context, shopItem.imageName)
            Utils.setImageToImageView(context, viewHolder.itemImageView, id)

            // Listeners

            viewHolder.holderCardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, shopItemArrayList[position], position) }
            viewHolder.addToCartImageView.setOnClickListener { v: View -> itemClickListener.onAddToCartClick(v, shopItemArrayList[position], position) }
            viewHolder.likeImageView.setOnClickListener { v: View -> itemClickListener.onLikeClick(v, shopItemArrayList[position], position) }
            viewHolder.menuImageView.setOnClickListener { v: View -> itemClickListener.onMenuClick(v, shopItemArrayList[position], position) }

        }
    }

    override fun getItemCount(): Int {
        return shopItemArrayList.size
    }


    inner class ItemViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var itemImageView: ImageView = view.itemImageView
        internal var percentTextView: TextView = view.percentTextView
        internal var ratingTextView: TextView = view.ratingTextView
        internal var itemNameTextView: TextView = view.itemNameTextView
        internal var categoryTextView: TextView = view.categoryTextView
        internal var priceTextView: TextView = view.priceTextView
        internal var originalPriceTextView: TextView = view.originalPriceTextView
        internal var addToCartImageView: ImageView = view.addToCartImageView
        internal var likeImageView: ImageView = view.likeImageView
        internal var menuImageView: ImageView = view.menuImageView
        internal var holderCardView: CardView = view.holderCardView
        internal var discountCardView: CardView = view.discountCardView

    }
}
