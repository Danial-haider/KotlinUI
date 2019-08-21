package com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.News
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_dashboard_news_dashboard_2_item.view.*

/**
 * Created by Panacea-Soft on 12/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureDashboardNewsDashboard2NewsAdapter(private val newsList: List<News>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: FeatureDashboardNewsDashboard2NewsAdapter.OnItemClickListener


    interface OnItemClickListener {
        fun onItemClick(view: View, obj: News, position: Int)

    }

    fun setOnItemClickListener(mItemClickListener: FeatureDashboardNewsDashboard2NewsAdapter.OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_dashboard_news_dashboard_2_item, parent, false)

        return ItemViewHolder(itemView)

    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is FeatureDashboardNewsDashboard2NewsAdapter.ItemViewHolder) {

            val news = newsList[position]

            val context = viewHolder.itemImageView.context

            viewHolder.newsTitleTextView.text = news.title

            val id = Utils.getDrawableInt(context, news.newsImage)
            Utils.setImageToImageView(context, viewHolder.itemImageView, id)

            // Listeners

                viewHolder.containerLayout.setOnClickListener { v: View -> itemClickListener.onItemClick(v, newsList[position], position) }

        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class ItemViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var itemImageView: ImageView = view.itemImageView
        internal var newsTitleTextView: TextView = view.newsTitleTextView
        internal var containerLayout: ConstraintLayout = view.containerLayout

    }
}

