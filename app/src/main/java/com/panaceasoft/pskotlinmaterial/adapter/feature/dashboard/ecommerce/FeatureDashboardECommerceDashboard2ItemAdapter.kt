package com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.ecommerce

import android.graphics.Paint
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_dashboard_ecommerce_dashboard_2_item.view.*

import java.util.ArrayList

/**
 * Created by Panacea-Soft on 17/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureDashboardECommerceDashboard2ItemAdapter(private val shopItemArrayList: ArrayList<ShopItem>, private val numberOfColumns: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
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

            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_dashboard_ecommerce_dashboard_2_item, parent, false)

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
        internal var itemImageView: ImageView
        internal var percentTextView: TextView
        internal var ratingTextView: TextView
        internal var itemNameTextView: TextView
        internal var categoryTextView: TextView
        internal var priceTextView: TextView
        internal var originalPriceTextView: TextView
        internal var addToCartImageView: ImageView
        internal var likeImageView: ImageView
        internal var menuImageView: ImageView
        internal var holderCardView: CardView
        internal var discountCardView: CardView

        init {

            itemImageView = view.itemImageView
            originalPriceTextView = view.originalPriceTextView
            percentTextView = view.percentTextView
            ratingTextView = view.ratingTextView
            itemNameTextView = view.itemNameTextView
            categoryTextView = view.categoryTextView
            priceTextView = view.priceTextView
            addToCartImageView = view.addToCartImageView
            likeImageView = view.likeImageView
            menuImageView = view.menuImageView
            holderCardView = view.holderCardView
            discountCardView = view.discountCardView

        }
    }
}