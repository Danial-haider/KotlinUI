package com.panaceasoft.pskotlinmaterial.adapter.feature.grid.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.News
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_grid_news_grid_3_item.view.*
import java.util.*

/**
 * Created by Panacea-Soft on 12/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureGridNewsGrid3Adapter(private val newsArrayList: ArrayList<News>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: FeatureGridNewsGrid3Adapter.OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: News, position: Int)
        fun onMoreClick(view: View, obj: News, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: FeatureGridNewsGrid3Adapter.OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_grid_news_grid_3_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is FeatureGridNewsGrid3Adapter.PlaceViewHolder) {

            val news = newsArrayList[position]

            viewHolder.agoTextView.text = news.ago


            val context = viewHolder.newsHolderCardView.context

            val id1 = Utils.getDrawableInt(context, news.newsImage)
            Utils.setImageToImageView(context, viewHolder.newsImageView, id1)

            val id2 = Utils.getDrawableInt(context, news.publisherImage)
            Utils.setImageToImageView(context, viewHolder.publisherImageView, id2)

            viewHolder.titleTextView.text = news.title



                viewHolder.newsHolderCardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, newsArrayList[position], position) }
                viewHolder.moreImageView.setOnClickListener { v: View -> itemClickListener.onMoreClick(v, newsArrayList[position], position) }

        }
    }

    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    inner class PlaceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var newsImageView: ImageView = view.newsImageView
        var publisherImageView: ImageView = view.publisherImageView
        var moreImageView: ImageView = view.moreImageView
        var newsHolderCardView: CardView = view.newsHolderCardView
        var titleTextView: TextView = view.titleTextView
        var agoTextView: TextView = view.agoTextView


    }
}

