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
import kotlinx.android.synthetic.main.app_news_list_4_item.view.*
import java.util.*

/**
 * Created by Panacea-Soft on 11/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureListNewsList4Adapter(private val newsArrayList: ArrayList<News>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: FeatureListNewsList4Adapter.OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: News, position: Int)
        fun onLikeClick(view: View, obj: News, position: Int)
        fun onReadMoreClick(view: View, obj: News, position: Int)
        //void onMoreClick(View view, News obj, int position);
    }

    fun setOnItemClickListener(mItemClickListener: FeatureListNewsList4Adapter.OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_news_list_4_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is FeatureListNewsList4Adapter.PlaceViewHolder) {

            val news = newsArrayList[position]

            viewHolder.agoTextView.text = news.ago

            val context = viewHolder.newsContainer.context

            val id = Utils.getDrawableInt(context, news.newsImage)
            Utils.setImageToImageView(context, viewHolder.newsImageView, id)

            val id2 = Utils.getDrawableInt(context, news.publisherImage)
            Utils.setImageToImageView(context, viewHolder.publisherImageView, id2)

            viewHolder.titleTextView.text = news.title

            viewHolder.publisherTextView.text = news.publisher

            viewHolder.likeCountTextView.text = news.totalLike


                viewHolder.newsContainer.setOnClickListener { v: View -> itemClickListener.onItemClick(v, newsArrayList[position], position) }
                viewHolder.likeCountTextView.setOnClickListener { v: View -> itemClickListener.onLikeClick(v, newsArrayList[position], position) }
                viewHolder.readMoreTextView.setOnClickListener { v: View -> itemClickListener.onReadMoreClick(v, newsArrayList[position], position) }
                //              holder.moreImageView.setOnClickListener((View v) -> itemClickListener.onMoreClick(v, newsArrayList.get(position), position));

        }
    }

    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    inner class PlaceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var newsImageView: ImageView = view.newsImageView
        var agoTextView: TextView = view.agoTextView
        var titleTextView: TextView = view.titleTextView
        var newsContainer: ConstraintLayout = view.newsContainer
        var publisherTextView: TextView = view.publisherTextView
        var publisherImageView: ImageView = view.publisherImageView
        var likeCountTextView: TextView = view.likeCountTextView
        var readMoreTextView: TextView = view.readMoreTextView
//        lateinit var moreImageView: ImageView

//        init {

            // moreImageView = view.moreImageView;
//        }
    }
}
