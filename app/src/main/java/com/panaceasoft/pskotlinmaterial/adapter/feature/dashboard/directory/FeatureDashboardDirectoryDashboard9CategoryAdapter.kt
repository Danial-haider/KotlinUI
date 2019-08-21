package com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.directory

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.DirectoryHome9CategoryVO
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_dashboard_directory_dashboard_9_category_item.view.*

class FeatureDashboardDirectoryDashboard9CategoryAdapter(private val categoryList: List<DirectoryHome9CategoryVO>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, category: DirectoryHome9CategoryVO, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val categoryView = LayoutInflater.from(parent.context).inflate(R.layout.feature_dashboard_directory_dashboard_9_category_item, parent, false)
        return CategoryViewHolder(categoryView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CategoryViewHolder) {
            val categoryVO = categoryList[position]
            val context = holder.categoryImageView.context

            holder.categoryTextView.text = categoryVO.name

            val categoryImageId = Utils.getDrawableInt(context, categoryVO.icon)
            Utils.setImageToImageView(context, holder.categoryImageView, categoryImageId)


            holder.categoryConstarint.setOnClickListener { view -> itemClickListener.onItemClick(view, categoryList[position], position) }

        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var categoryConstarint: ConstraintLayout
        internal var categoryImageView: ImageView
        internal var categoryTextView: TextView

        init {

            categoryConstarint = itemView.categoryConstraint
            categoryImageView = itemView.categoryImageView
            categoryTextView = itemView.categoryTextView
        }
    }
}
