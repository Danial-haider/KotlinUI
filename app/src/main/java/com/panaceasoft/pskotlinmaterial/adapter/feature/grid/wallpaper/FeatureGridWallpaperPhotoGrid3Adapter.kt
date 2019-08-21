package com.panaceasoft.pskotlinmaterial.adapter.feature.grid.wallpaper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.WallpaperItem
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_grid_wallpaper_photo_grid_3_item.view.*

/**
 * Created by Panacea-Soft on 19/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureGridWallpaperPhotoGrid3Adapter(private val wallpaperItemArrayList: List<WallpaperItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: WallpaperItem, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_grid_wallpaper_photo_grid_3_item, parent, false)

        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is ItemViewHolder) {

            val wallpaperItem = wallpaperItemArrayList[position]

            viewHolder.likeCountTextView.text = wallpaperItem.likeCount
            viewHolder.viewCountTextView.text = wallpaperItem.viewCount

            val context = viewHolder.holderCardView.context

            val id = Utils.getDrawableInt(context, wallpaperItem.imageName)
            Utils.setImageToImageView(context, viewHolder.itemImageView, id)


                viewHolder.holderCardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, wallpaperItemArrayList[position], position) }

        }
    }

    override fun getItemCount(): Int {
        return wallpaperItemArrayList.size
    }

    inner class ItemViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var itemImageView: ImageView = view.itemImageView
        internal var likeCountTextView: TextView = view.likeCountTextView
        internal var viewCountTextView: TextView = view.viewCountTextView
        internal var holderCardView: CardView = view.holderCardView

    }
}