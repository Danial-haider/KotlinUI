package com.panaceasoft.pskotlinmaterial.adapter.application.news.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.News
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_news_gallery_2_item.view.*

/**
 * Created by Panacea-Soft on 8/11/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class AppNewsGallery2Adapter(private val newsList: List<News>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener


    interface OnItemClickListener {
        fun onItemClick(view: View, obj: News, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_news_gallery_2_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(reholder: RecyclerView.ViewHolder, position: Int) {

        if (reholder is PlaceViewHolder) {
            val place = newsList[position]
            val context = reholder.placeImageView.context
            val id = Utils.getDrawableInt(context, place.newsImage)
            Utils.setImageToImageView(context, reholder.placeImageView, id)

            reholder.placeImageView.setOnClickListener { view ->


                    itemClickListener.onItemClick(view, newsList[position], position)

            }
        }

    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class PlaceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var placeImageView: ImageView = view.itemImageView

    }

}
