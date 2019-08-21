package com.panaceasoft.pskotlinmaterial.adapter.feature.list.news

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
import kotlinx.android.synthetic.main.feature_news_list_list_5_item.view.*
import java.util.*

/**
 * Created by Panacea-Soft on 11/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureListNewsList5Adapter(private val newsArrayList: ArrayList<News>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: FeatureListNewsList5Adapter.OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: News, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: FeatureListNewsList5Adapter.OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_news_list_list_5_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is FeatureListNewsList5Adapter.PlaceViewHolder) {

            val news = newsArrayList[position]

            viewHolder.agoTextView.text = news.ago

            val context = viewHolder.newsContainer.context

            val id = Utils.getDrawableInt(context, news.newsImage)
            Utils.setCornerRadiusImageToImageView(context, viewHolder.newsImageView, id, 10, 2, R.color.md_grey_200)

            val id2 = Utils.getDrawableInt(context, news.publisherImage)
            Utils.setCornerRadiusImageToImageView(context, viewHolder.publisherImageView, id2, 4, 2, R.color.md_grey_200)

            viewHolder.titleTextView.text = news.title

            viewHolder.categoryTextView.text = news.category


                viewHolder.newsContainer.setOnClickListener { v: View -> itemClickListener.onItemClick(v, newsArrayList[position], position) }

        }
    }

    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    inner class PlaceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var newsImageView: ImageView = view.newsImageView
        var agoTextView: TextView = view.agoTextView
        var titleTextView: TextView = view.titleTextView
        var categoryTextView: TextView = view.categoryTextView
        var newsContainer: ConstraintLayout = view.newsContainer
        var publisherImageView: ImageView = view.publisherImageView


    }
}
