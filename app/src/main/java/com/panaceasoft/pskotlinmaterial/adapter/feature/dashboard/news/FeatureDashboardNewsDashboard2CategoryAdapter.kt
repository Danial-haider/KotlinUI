package com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.NewsCategory
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_dashboard_news_dashboard_2_category_item.view.*

/**
 * Created by Panacea-Soft on 12/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureDashboardNewsDashboard2CategoryAdapter(private val WallpaperCategoryArrayList: List<NewsCategory>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: FeatureDashboardNewsDashboard2CategoryAdapter.OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: NewsCategory, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: FeatureDashboardNewsDashboard2CategoryAdapter.OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_dashboard_news_dashboard_2_category_item, parent, false)

        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is FeatureDashboardNewsDashboard2CategoryAdapter.ItemViewHolder) {

            val newsCategory = WallpaperCategoryArrayList!![position]

            viewHolder.itemNameTextView.text = newsCategory.category

            val context = viewHolder.itemNameTextView.context

            if (newsCategory.isCheck == "true") {
                viewHolder.checkImageView.visibility = View.VISIBLE
            } else {
                viewHolder.checkImageView.visibility = View.GONE
            }

            val id = Utils.getDrawableInt(context, newsCategory.categoryImage)
            Utils.setCircleImageToImageView(context, viewHolder.itemImageView, id, 0, 0)

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
        internal var checkImageView: ImageView = view.checkImageView

    }
}

