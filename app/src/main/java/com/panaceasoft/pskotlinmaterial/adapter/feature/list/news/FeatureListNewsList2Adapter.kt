package com.panaceasoft.pskotlinmaterial.adapter.feature.list.news

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.News
import com.panaceasoft.pskotlinmaterial.utils.Utils

import java.util.ArrayList

/**
 * Created by Panacea-Soft on 12/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureListNewsList2Adapter(private val newsArrayList: ArrayList<News>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: FeatureListNewsList2Adapter.OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: News, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: FeatureListNewsList2Adapter.OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_list_news_list_2_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is FeatureListNewsList2Adapter.PlaceViewHolder) {

            val news = newsArrayList[position]

            viewHolder.agoTextView.text = news.ago


            val context = viewHolder.newsContainer.context

            val id = Utils.getDrawableInt(context, news.newsImage)
            //Utils.setImageToImageView(context, holder.newsImageView, id);
            Utils.setCornerRadiusImageToImageView(context, viewHolder.newsImageView, id, 20, 2, R.color.md_grey_200)


            viewHolder.titleTextView.text = news.title

            viewHolder.categoryTextView.text = news.category




                viewHolder.newsContainer.setOnClickListener { v: View -> itemClickListener.onItemClick(v, newsArrayList[position], position) }

        }
    }

    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    inner class PlaceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var newsImageView: ImageView
        var agoTextView: TextView
        var titleTextView: TextView
        var categoryTextView: TextView
        var newsContainer: ConstraintLayout


        init {

            newsImageView = view.findViewById(R.id.newsImageView)
            agoTextView = view.findViewById(R.id.agoTextView)
            titleTextView = view.findViewById(R.id.titleTextView)
            categoryTextView = view.findViewById(R.id.categoryTextView)
            newsContainer = view.findViewById(R.id.newsContainer)

        }
    }
}

