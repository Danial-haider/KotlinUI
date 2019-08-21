package com.panaceasoft.pskotlinmaterial.adapter.application.news.grid

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
import kotlinx.android.synthetic.main.app_news_grid_5_item.view.*
import java.util.*

/**
 * Created by Panacea-Soft on 11/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class AppNewsGrid5Adapter(private val newsArrayList: ArrayList<News>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: AppNewsGrid5Adapter.OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: News, position: Int)
        fun onBookMarkClick(view: View, obj: News, position: Int)
        fun onShareClick(view: View, obj: News, position: Int)
        fun onMoreClick(view: View, obj: News, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: AppNewsGrid5Adapter.OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_news_grid_5_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is AppNewsGrid5Adapter.PlaceViewHolder) {

            val news = newsArrayList[position]

            val context = viewHolder.newsHolderCardView.context

            val id = Utils.getDrawableInt(context, news.newsImage)
            Utils.setImageToImageView(context, viewHolder.newsImageView, id)

            viewHolder.titleTextView.text = news.title


                viewHolder.newsHolderCardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, newsArrayList[position], position) }
                viewHolder.bookmarkImageView.setOnClickListener { v: View -> itemClickListener.onBookMarkClick(v, newsArrayList[position], position) }
                viewHolder.shareImageView.setOnClickListener { v: View -> itemClickListener.onShareClick(v, newsArrayList[position], position) }
                viewHolder.moreImageView.setOnClickListener { v: View -> itemClickListener.onMoreClick(v, newsArrayList[position], position) }

        }
    }

    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    inner class PlaceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var newsImageView: ImageView = view.newsImageView
        var newsHolderCardView: CardView = view.newsHolderCardView
        var titleTextView: TextView = view.titleTextView
        var bookmarkImageView: ImageView = view.bookmarkImageView
        var shareImageView: ImageView = view.shareImageView
        var moreImageView: ImageView = view.moreImageView

    }
}


