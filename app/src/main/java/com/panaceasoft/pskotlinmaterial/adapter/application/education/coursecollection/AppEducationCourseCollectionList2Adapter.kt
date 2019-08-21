package com.panaceasoft.pskotlinmaterial.adapter.application.education.coursecollection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.EducationCourseCollection
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_education_course_collection_2_item.view.*

/**
 * Created by Panacea-Soft on 8/25/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class AppEducationCourseCollectionList2Adapter(private val itemList: List<EducationCourseCollection>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: EducationCourseCollection, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_education_course_collection_2_item, parent, false)
        return CourseViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is CourseViewHolder) {

            val item = itemList[position]

            viewHolder.titleTextView.text = item.name
            viewHolder.statusTextView.text = item.type
            viewHolder.progressTextView.text = item.progress
            val context = viewHolder.courseImageView.context

            Utils.setImageToImageView(context, viewHolder.courseImageView, R.drawable.education_img_4)

            Utils.setImageToImageView(context, viewHolder.courseAlphaImageView, R.drawable.black_alpha_50)
            if (item.color == "green") {
                viewHolder.courseAlphaImageView.setColorFilter(ContextCompat.getColor(context,
                        R.color.md_green_500))
            } else if (item.color == "yellow") {
                viewHolder.courseAlphaImageView.setColorFilter(ContextCompat.getColor(context,
                        R.color.md_yellow_500))
            } else if (item.color == "blue") {
                viewHolder.courseAlphaImageView.setColorFilter(ContextCompat.getColor(context,
                        R.color.md_blue_500))
            } else if (item.color == "red") {
                viewHolder.courseAlphaImageView.setColorFilter(ContextCompat.getColor(context,
                        R.color.md_red_500))
            } else if (item.color == "orange") {
                viewHolder.courseAlphaImageView.setColorFilter(ContextCompat.getColor(context,
                        R.color.md_orange_500))
            }


            viewHolder.courseHolderView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, itemList[position], position) }


        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class CourseViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var courseImageView: ImageView = view.courseImageView
        internal var courseAlphaImageView: ImageView = view.courseAlphaImageView
        internal var titleTextView: TextView = view.titleTextView
        internal var statusTextView: TextView = view.statusTextView
        internal var progressTextView: TextView = view.progressTextView
        internal var courseHolderView: ConstraintLayout = view.courseHolderView

    }

}