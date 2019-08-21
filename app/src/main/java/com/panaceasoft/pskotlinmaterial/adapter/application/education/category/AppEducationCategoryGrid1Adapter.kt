package com.panaceasoft.pskotlinmaterial.adapter.application.education.category

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
import kotlinx.android.synthetic.main.app_education_course_grid_1_item.view.*

/**
 * Created by Panacea-Soft on 24/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class AppEducationCategoryGrid1Adapter(private val itemList: List<Course>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener


    interface OnItemClickListener {
        fun onItemClick(view: View, obj: Course, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_education_course_grid_1_item, parent, false)
        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is PlaceViewHolder) {

            val item = itemList[position]

            viewHolder.titleTextView.text = item.title

            val context = viewHolder.courseHolderView.context

            val id = Utils.getDrawableInt(context, item.image)
            Utils.setCircleImageToImageView(context, viewHolder.courseImageView, id, 0, 0)

            viewHolder.courseHolderView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, itemList[position], position) }


        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class PlaceViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var courseHolderView: ConstraintLayout = view.courseHolderView
        internal var courseImageView: ImageView = view.courseImageView
        internal var titleTextView: TextView = view.titleTextView

    }
}
