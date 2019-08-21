package com.panaceasoft.pskotlinmaterial.adapter.feature.list.education

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.EducationCourseCollection
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_list_education_course_collection_list_1_item.view.*

/**
 * Created by Panacea-Soft on 8/26/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class FeatureListEducationCourseCollectionList1Adapter(private val itemList: List<EducationCourseCollection>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: EducationCourseCollection, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_list_education_course_collection_list_1_item, parent, false)
        return CourseViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is CourseViewHolder) {

            val item = itemList[position]

            viewHolder.titleTextView.text = item.name
            viewHolder.statusTextView.text = item.status

            val context = viewHolder.courseImageView.context
            val id = Utils.getDrawableInt(context, item.image)
            Utils.setImageToImageView(context, viewHolder.courseImageView, id)

                viewHolder.titleTextView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, itemList[position], position) }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class CourseViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var courseImageView: ImageView = view.courseImageView
        internal var titleTextView: TextView = view.titleTextView
        internal var statusTextView: TextView = view.statusTextView

    }

}