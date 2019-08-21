package com.panaceasoft.pskotlinmaterial.adapter.feature.list.ecommerce

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
import kotlinx.android.synthetic.main.feature_list_ecommerce_item_list_6_item.view.*

/**
 * Created by Panacea-Soft on 18/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureListECommerceItemList6Adapter(private val shopItemList: List<ShopItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener


    interface OnItemClickListener {
        fun onItemClick(view: View, obj: ShopItem, position: Int)
        fun onAddToCartClick(view: View, obj: ShopItem, position: Int)
        fun onMenuClick(view: View, obj: ShopItem, position: Int)
        fun onLikeClick(view: View, obj: ShopItem, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_list_ecommerce_item_list_6_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is PlaceViewHolder) {

            val shopItem = shopItemList[position]

            viewHolder.itemNameTextView.text = shopItem.name

            val context = viewHolder.holderCardView.context

            val id = Utils.getDrawableInt(context, shopItem.imageName)
            Utils.setImageToImageView(context, viewHolder.itemImageView, id)

            val priceStr = shopItem.currency + " " + shopItem.price
            viewHolder.priceTextView.text = priceStr

            viewHolder.viewCountTextView.text = shopItem.viewCount

            val ratingSr = shopItem.totalRating + " Ratings"
            viewHolder.ratingTextView.text = ratingSr

            if (Integer.parseInt(shopItem.discount) > 0) {
                viewHolder.promoCardView.visibility = View.VISIBLE
                val discount = shopItem.discount + " %"
                viewHolder.promoAmtTextView.text = discount

            } else {
                viewHolder.promoCardView.visibility = View.GONE

            }

            viewHolder.holderCardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, shopItemList[position], position) }
            viewHolder.addToBasketImageView.setOnClickListener { v: View -> itemClickListener.onAddToCartClick(v, shopItemList[position], position) }
            viewHolder.menuImageView.setOnClickListener { v: View -> itemClickListener.onMenuClick(v, shopItemList[position], position) }
            viewHolder.likeImageView.setOnClickListener { v: View -> itemClickListener.onLikeClick(v, shopItemList[position], position) }

        }
    }

    override fun getItemCount(): Int {
        return shopItemList.size
    }

    inner class PlaceViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var itemImageView: ImageView = view.itemImageView
        internal var itemNameTextView: TextView = view.itemNameTextView
        internal var priceTextView: TextView = view.priceTextView
        internal var promoAmtTextView: TextView = view.promoAmtTextView
        internal var promoCardView: CardView = view.promoCardView
        internal var holderCardView: CardView = view.holderCardView
        internal var addToBasketImageView: ImageView = view.addToCartImageView
        internal var menuImageView: ImageView = view.menuImageView
        internal var likeImageView: ImageView = view.likeImageView
        internal var viewCountTextView: TextView = view.viewCountTextView
        internal var ratingTextView: TextView = view.ratingTextView

    }
}
