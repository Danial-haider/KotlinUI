package com.panaceasoft.pskotlinmaterial.adapter.application.education.outline

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.EducationCourseOutlineHolder

/**
 * Created by Panacea-Soft on 8/24/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class AppEducationOutline1Adapter(private val itemList: List<EducationCourseOutlineHolder>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: EducationCourseOutlineHolder, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 0) {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_education_outline_1_title, parent, false)
            return TitleViewHolder(itemView)
        } else if (viewType == 1) {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_education_outline_1_top_item, parent, false)
            return VideoViewHolder(itemView)
        } else if (viewType == 2) {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_education_outline_1_bottom_item, parent, false)
            return VideoViewHolder(itemView)
        } else {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_education_outline_1_item, parent, false)
            return VideoViewHolder(itemView)
        }

    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is VideoViewHolder) {

            val item = itemList[position]

            viewHolder.titleTextView.text = item.course.videoName

            if (item.course.status == "done") {
                viewHolder.statusImageView.setColorFilter(ContextCompat.getColor(viewHolder.statusImageView.context,
                        R.color.md_green_800))
            } else if (item.course.status == "progress") {
                viewHolder.statusImageView.setColorFilter(ContextCompat.getColor(viewHolder.statusImageView.context,
                        R.color.md_green_500))
            }

            viewHolder.titleTextView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, itemList[position], position) }


        } else if (viewHolder is TitleViewHolder) {
            val item = itemList[position]

            viewHolder.titleTextView.text = item.courseName
        }
    }

    override fun getItemViewType(position: Int): Int {

        return if (itemList[position].isHeader) {
            0
        } else {
            if (itemList[position].isTop) {
                1
            } else if (itemList[position].isBottom) {
                2
            } else {
                3
            }
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class VideoViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var statusImageView: ImageView = view.findViewById(R.id.statusImageView)
        internal var titleTextView: TextView = view.findViewById(R.id.titleTextView)

    }

    inner class TitleViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var titleTextView: TextView = view.findViewById(R.id.titleTextView)

    }
}