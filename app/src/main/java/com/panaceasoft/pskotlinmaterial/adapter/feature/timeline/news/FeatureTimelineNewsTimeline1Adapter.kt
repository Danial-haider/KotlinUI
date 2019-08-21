package com.panaceasoft.pskotlinmaterial.adapter.feature.timeline.news

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
import kotlinx.android.synthetic.main.feature_timeline_news_timeline_1_item.view.*

/**
 * Created by Panacea-Soft on 12/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureTimelineNewsTimeline1Adapter(private val newsList: List<News>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: FeatureTimelineNewsTimeline1Adapter.OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: News, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: FeatureTimelineNewsTimeline1Adapter.OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_timeline_news_timeline_1_item, parent, false)
        return GeneralTimelineViewHolder(itemView)

    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is FeatureTimelineNewsTimeline1Adapter.GeneralTimelineViewHolder) {
            val news = newsList[position]

            viewHolder.dateTextView.text = news.date
            viewHolder.newsTitleTextView.text = news.title
            viewHolder.agoTextView.text = news.ago

            val context = viewHolder.iconImageView.context

            if (context != null) {
                val id = Utils.getDrawableInt(context, news.newsImage)
                Utils.setCornerRadiusImageToImageView(context, viewHolder.iconImageView, id, 50, 0, 0)
            }


                viewHolder.constraintLayout.setOnClickListener { v: View -> itemClickListener.onItemClick(v, newsList[position], position) }

        }
    }


    override fun getItemCount(): Int {

        return newsList.size

    }

    inner class GeneralTimelineViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var dateTextView: TextView = view.dateTextView
        internal var newsTitleTextView: TextView = view.newsTitleTextView
        internal var agoTextView: TextView = view.agoTextView
        internal var constraintLayout: ConstraintLayout = view.constraintLayout
        internal var iconImageView: ImageView = view.iconImageView


    }
}


