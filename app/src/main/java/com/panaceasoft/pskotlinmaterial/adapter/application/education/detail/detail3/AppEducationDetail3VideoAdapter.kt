package com.panaceasoft.pskotlinmaterial.adapter.application.education.detail.detail3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.EducationVideo
import kotlinx.android.synthetic.main.app_education_detail_3_video_item.view.*

/**
 * Created by Panacea-Soft on 8/23/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class AppEducationDetail3VideoAdapter(private val educationVideoList: List<EducationVideo>?, private val limitCount: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener


    interface OnItemClickListener {
        fun onItemClick(view: View, obj: EducationVideo, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_education_detail_3_video_item, parent, false)

        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is ItemViewHolder) {

            val newsCategory = educationVideoList!![position]

            viewHolder.titleTextView.text = newsCategory.title
            viewHolder.lengthTextView.text = newsCategory.length
            if (position == 0) {
                viewHolder.constraintLayout.setBackgroundColor(ContextCompat.getColor(viewHolder.constraintLayout.context,R.color.md_green_600))
                viewHolder.titleTextView.setTextColor(ContextCompat.getColor(viewHolder.constraintLayout.context,R.color.md_white_1000))
                viewHolder.lengthTextView.setTextColor(ContextCompat.getColor(viewHolder.constraintLayout.context,R.color.md_white_1000))
                viewHolder.playImageView.setColorFilter(ContextCompat.getColor(viewHolder.constraintLayout.context,
                        R.color.md_white_1000))
                viewHolder.eyeImageView.setColorFilter(ContextCompat.getColor(viewHolder.constraintLayout.context,
                        R.color.md_white_1000))
            }

            if (position > 2) {
                viewHolder.eyeImageView.visibility = View.GONE
            }

            viewHolder.constraintLayout.setOnClickListener { v: View -> itemClickListener.onItemClick(v, educationVideoList[position], position) }

        }
    }

    override fun getItemCount(): Int {

        return if (educationVideoList != null) {

            if (limitCount > 0) {
                if (limitCount > educationVideoList.size) {
                    educationVideoList.size
                } else {
                    limitCount
                }
            } else {
                educationVideoList.size
            }

        } else {
            0
        }
    }

    inner class ItemViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var titleTextView: TextView = view.titleTextView
        internal var lengthTextView: TextView = view.lengthTextView
        internal var playImageView: ImageView = view.playImageView
        internal var eyeImageView: ImageView = view.eyeImageView
        internal var constraintLayout: ConstraintLayout = view.constraintLayout

    }
}



