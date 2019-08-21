package com.panaceasoft.pskotlinmaterial.adapter.feature.list.wallpaper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.WallpaperCategory
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_list_wallpaper_category_list_2_item.view.*
import java.util.*

/**
 * Created by Panacea-Soft on 18/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureListWallpaperCategoryList2Adapter(private val itemArrayList: ArrayList<WallpaperCategory>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: WallpaperCategory, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_list_wallpaper_category_list_2_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(reholder: RecyclerView.ViewHolder, position: Int) {

        if (reholder is PlaceViewHolder) {
            val item = itemArrayList[position]

            reholder.categoryNameTextView.text = item.name

            val productCount = item.count + " Products"
            reholder.productCountTextView.text = productCount

            val context = reholder.placeHolderCardView.context

            val id = Utils.getDrawableInt(context, item.imageName)
            Utils.setImageToImageView(context, reholder.itemImageView, id)


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
        var itemImageView: ImageView = view.itemImageView
        var categoryNameTextView: TextView = view.categoryNameTextView
        var productCountTextView: TextView = view.productCountTextView


    }

}
