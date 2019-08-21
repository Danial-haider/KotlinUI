package com.panaceasoft.pskotlinmaterial.adapter.feature.gallery.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.News
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_gallery_news_gallery_2_item.view.*

/**
 * Created by Panacea-Soft on 13/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureGalleryNewsGallery2Adapter(private val newsList: List<News>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: FeatureGalleryNewsGallery2Adapter.OnItemClickListener


    interface OnItemClickListener {
        fun onItemClick(view: View, obj: News, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: FeatureGalleryNewsGallery2Adapter.OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_gallery_news_gallery_2_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(reholder: RecyclerView.ViewHolder, position: Int) {

        if (reholder is FeatureGalleryNewsGallery2Adapter.PlaceViewHolder) {
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

