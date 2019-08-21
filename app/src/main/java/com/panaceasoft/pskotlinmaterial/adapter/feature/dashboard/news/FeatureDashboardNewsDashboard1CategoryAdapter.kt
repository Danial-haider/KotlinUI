package com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.NewsCategory
import kotlinx.android.synthetic.main.feature_dashboard_news_dashboard_1_category_item.view.*

/**
 * Created by Panacea-Soft on 12/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureDashboardNewsDashboard1CategoryAdapter(private val WallpaperCategoryArrayList: List<NewsCategory>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: FeatureDashboardNewsDashboard1CategoryAdapter.OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: NewsCategory, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: FeatureDashboardNewsDashboard1CategoryAdapter.OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_dashboard_news_dashboard_1_category_item, parent, false)

        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is FeatureDashboardNewsDashboard1CategoryAdapter.ItemViewHolder) {

            val NewsCategory = WallpaperCategoryArrayList!![position]

            viewHolder.itemNameTextView.text = NewsCategory.category


                viewHolder.constraintLayout.setOnClickListener { v: View -> itemClickListener.onItemClick(v, WallpaperCategoryArrayList[position], position) }

        }
    }

    override fun getItemCount(): Int {

        return WallpaperCategoryArrayList?.size ?: 0
    }

    inner class ItemViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var itemNameTextView: TextView = view.itemNameTextView
        internal var constraintLayout: ConstraintLayout = view.constraintLayout

    }
}
