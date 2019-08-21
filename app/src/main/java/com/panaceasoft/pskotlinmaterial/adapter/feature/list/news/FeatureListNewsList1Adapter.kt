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
import kotlinx.android.synthetic.main.feature_list_news_list_1_item.view.*
import java.util.*

/**
 * Created by Panacea-Soft on 12/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureListNewsList1Adapter(private val newsArrayList: ArrayList<News>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: FeatureListNewsList1Adapter.OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: News, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: FeatureListNewsList1Adapter.OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_list_news_list_1_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is FeatureListNewsList1Adapter.PlaceViewHolder) {

            val news = newsArrayList[position]

            viewHolder.dateTextView.text = news.date


            val context = viewHolder.newsContainer.context

            val id = Utils.getDrawableInt(context, news.newsImage)
            Utils.setImageToImageView(context, viewHolder.newsImageView, id)

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
        var dateTextView: TextView = view.dateTextView
        var titleTextView: TextView = view.titleTextView
        var categoryTextView: TextView = view.categoryTextView
        var newsContainer: ConstraintLayout = view.newsContainer


    }
}
