package com.panaceasoft.pskotlinmaterial.adapter.application.wallpaper.home.home1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.WallpaperCategory
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_wallpaper_home_1_category_item.view.*

/**
 * Created by Panacea-Soft on 6/30/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class AppWallpaperHome1CategoryAdapter(private val WallpaperCategoryArrayList: List<WallpaperCategory>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: WallpaperCategory, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_wallpaper_home_1_category_item, parent, false)

        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is ItemViewHolder) {

            val WallpaperCategory = WallpaperCategoryArrayList!![position]

            viewHolder.itemNameTextView.text = WallpaperCategory.name

            val context = viewHolder.constraintLayout.context

            val id = Utils.getDrawableInt(context, WallpaperCategory.imageName)
            Utils.setCircleImageToImageView(context, viewHolder.itemImageView, id, 2, R.color.md_grey_200)

            viewHolder.constraintLayout.setOnClickListener { v: View -> itemClickListener.onItemClick(v, WallpaperCategoryArrayList[position], position) }

        }
    }

    override fun getItemCount(): Int {

        return WallpaperCategoryArrayList?.size ?: 0
    }

    inner class ItemViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var itemImageView: ImageView = view.itemImageView
        internal var itemNameTextView: TextView = view.itemNameTextView
        internal var constraintLayout: ConstraintLayout = view.constraintLayout

    }
}
