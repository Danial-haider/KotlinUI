package com.panaceasoft.pskotlinmaterial.adapter.application.education.home.home1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Course
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_education_home_1_new_course_item.view.*

/**
 * Created by Panacea-Soft on 8/18/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class AppEducationHome1CoursesAdapter(private val WallpaperCategoryArrayList: List<Course>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: Course, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_education_home_1_new_course_item, parent, false)

        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is ItemViewHolder) {

            val newsCategory = WallpaperCategoryArrayList!![position]

            viewHolder.itemNameTextView.text = newsCategory.title

            val context = viewHolder.constraintLayout.context

            val id = Utils.getDrawableInt(context, newsCategory.image)
            Utils.setImageToImageView(context, viewHolder.itemImageView, id)

            viewHolder.constraintLayout.setOnClickListener { v: View -> itemClickListener.onItemClick(v, WallpaperCategoryArrayList[position], position) }

        }
    }

    override fun getItemCount(): Int {

        return WallpaperCategoryArrayList?.size ?: 0
    }

    inner class ItemViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var itemNameTextView: TextView = view.itemNameTextView
        internal var itemImageView: ImageView = view.itemImageView
        internal var constraintLayout: ConstraintLayout = view.constraintLayout

    }
}
