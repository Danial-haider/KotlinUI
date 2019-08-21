package com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.education.home3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.EducationVideo
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_dashboard_education_dashboard_3_video_item.view.*

/**
 * Created by Panacea-Soft on 8/25/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class FeatureDashboardEducationDashboard3VideoAdapter(private val educationVideoList: List<EducationVideo>?, private val limitCount: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: EducationVideo, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_dashboard_education_dashboard_3_video_item, parent, false)

        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is ItemViewHolder) {

            val newsCategory = educationVideoList!![position]

            viewHolder.titleTextView.text = newsCategory.title
            viewHolder.lengthTextView.text = "Video - " + newsCategory.length

            val context = viewHolder.constraintLayout.context

            val id = Utils.getDrawableInt(context, newsCategory.image)
            Utils.setImageToImageView(context, viewHolder.courseImageView, id)

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

        internal var titleTextView: TextView
        internal var lengthTextView: TextView
        internal var courseImageView: ImageView
        internal var constraintLayout: ConstraintLayout

        init {

            titleTextView = view.titleTextView
            lengthTextView = view.lengthTextView
            courseImageView = view.courseImageView
            constraintLayout = view.constraintLayout

        }
    }
}

