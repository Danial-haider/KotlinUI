package com.panaceasoft.pskotlinmaterial.adapter.application.ecommerce.grid

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
import kotlinx.android.synthetic.main.app_ecommerce_grid_10_item.view.*
import java.util.*

/**
 * Created by Panacea-Soft on 1/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class AppECommerceGrid10Adapter(private val itemArrayList: ArrayList<ShopItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: ShopItem, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_ecommerce_grid_10_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(reholder: RecyclerView.ViewHolder, position: Int) {

        if (reholder is PlaceViewHolder) {
            val item = itemArrayList[position]

            reholder.itemNameTextView.text = item.name

            val context = reholder.placeHolderCardView.context

            val id = Utils.getDrawableInt(context, item.imageName)
            Utils.setImageToImageView(context, reholder.itemImageView, id)

            reholder.originalPriceTextView.paintFlags = reholder.originalPriceTextView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

            if (Integer.parseInt(item.discount) > 0) {
                reholder.discountCardView.visibility = View.VISIBLE
                val discountPrice = item.discount + "% OFF"
                reholder.percentTextView.text = discountPrice
            } else {
                reholder.discountCardView.visibility = View.GONE
            }


            if (item.isLiked != null && item.isLiked == true) {
                val likeImg = Utils.getDrawableInt(context, "baseline_heart")
                Utils.setImageToImageView(context, reholder.likeImageView, likeImg)
            } else {
                val notLikeImg = Utils.getDrawableInt(context, "baseline_heart_white")
                Utils.setImageToImageView(context, reholder.likeImageView, notLikeImg)
            }

            reholder.placeHolderCardView.setOnClickListener { view ->
                    itemClickListener.onItemClick(view, itemArrayList[position], position)
            }

        }

    }

    override fun getItemCount(): Int {
        return itemArrayList.size
    }

    inner class PlaceViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var placeHolderCardView: CardView = view.placeHolderCardView
        var likeImageView: ImageView = view.likeImageView
        var itemImageView: ImageView = view.itemImageView
        var itemNameTextView: TextView = view.itemNameTextView
        var percentTextView: TextView = view.percentTextView
        var priceTextView: TextView? = null
        var originalPriceTextView: TextView = view.originalPriceTextView
        var discountCardView: CardView = view.discountCardView


    }

}

