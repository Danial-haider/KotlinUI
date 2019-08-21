package com.panaceasoft.pskotlinmaterial.adapter.application.ecommerce.home.home2

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_ecommerce_home_2_item.view.*
import java.util.*

/**
 * Created by Panacea-Soft on 6/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class AppECommerceHome2ItemAdapter(private val shopItemArrayList: ArrayList<ShopItem>, private val numberOfColumns: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener
    private val topEmptyCellHeight = 47

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
        if (viewType == 0) {
            val relativeLayout = RelativeLayout(parent.context)

            // SET THE SIZE
            relativeLayout.layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, Utils.dpToPx(parent.context, topEmptyCellHeight))

            return ItemView(relativeLayout)
        } else {

            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_ecommerce_home_2_item, parent, false)

            return ItemViewHolder(itemView)
        }

    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is ItemViewHolder && position > 1) {

            val actualDataPosition = position - numberOfColumns

            // Get Shop Item
            val shopItem = shopItemArrayList[actualDataPosition]

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
                viewHolder.holderCardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, shopItemArrayList[actualDataPosition], actualDataPosition) }
                viewHolder.addToCartImageView.setOnClickListener { v: View -> itemClickListener.onAddToCartClick(v, shopItemArrayList[actualDataPosition], actualDataPosition) }
                viewHolder.likeImageView.setOnClickListener { v: View -> itemClickListener.onLikeClick(v, shopItemArrayList[actualDataPosition], actualDataPosition) }
                viewHolder.menuImageView.setOnClickListener { v: View -> itemClickListener.onMenuClick(v, shopItemArrayList[actualDataPosition], actualDataPosition) }

        }
    }

    override fun getItemCount(): Int {
        return shopItemArrayList.size + numberOfColumns
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0 || position == 1) {
            0
        } else {
            1
        }
    }

    inner class ItemView internal  constructor(view: View):RecyclerView.ViewHolder(view)

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