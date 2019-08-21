package com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.ecommerce

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
import kotlinx.android.synthetic.main.feature_dashboard_ecommerce_dashboard_1_featured_item.view.*
import java.util.*

/**
 * Created by Panacea-Soft on 17/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureDashboardECommerceDashboard1FeaturedItemAdapter(private val shopItemArrayList: ArrayList<ShopItem>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
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
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_dashboard_ecommerce_dashboard_1_featured_item, parent, false)

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
        internal var itemImageView: ImageView
        internal var itemNameTextView: TextView
        internal var itemCurrencyTextView: TextView
        internal var itemPriceTextView: TextView
        internal var itemDescTextView: TextView
        internal var itemRatingBar: RatingBar
        internal var addToCartImageView: ImageView
        internal var likeImageView: ImageView
        internal var menuImageView: ImageView
        internal var holderCardView: CardView

        init {

            itemImageView = view.itemImageView
            itemNameTextView = view.itemNameTextView
            itemCurrencyTextView = view.currencyTextView
            itemPriceTextView = view.priceTextView
            itemDescTextView = view.itemDescTextView
            itemRatingBar = view.itemRatingBar
            addToCartImageView = view.addToCartImageView
            likeImageView = view.likeImageView
            menuImageView = view.menuImageView
            holderCardView = view.holderCardView

        }
    }
}
