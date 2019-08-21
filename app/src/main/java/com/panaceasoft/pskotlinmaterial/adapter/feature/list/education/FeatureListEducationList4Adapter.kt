package com.panaceasoft.pskotlinmaterial.adapter.feature.list.education

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.EducationVideo
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_list_education_video_list_4_item.view.*

/**
 * Created by Panacea-Soft on 24/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureListEducationList4Adapter(private val itemList: List<EducationVideo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener


    interface OnItemClickListener {
        fun onItemClick(view: View, obj: EducationVideo, position: Int)
        fun onDownloadClick(view: View, obj: EducationVideo, position: Int)
        fun onPlayClick(view: View, obj: EducationVideo, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_list_education_video_list_4_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is PlaceViewHolder) {

            val item = itemList[position]

            viewHolder.titleTextView.text = item.title
            viewHolder.categoryTextView.text = item.category
            viewHolder.timeTextView.text = item.length
            viewHolder.sizeTextView.text = item.size

            val context = viewHolder.videoHolderView.context

            val id = Utils.getDrawableInt(context, item.image)
            Utils.setCornerRadiusImageToImageView(context, viewHolder.videoImageView, id, 10, 0, 0)


                viewHolder.videoHolderView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, itemList[position], position) }
                viewHolder.downloadImageView.setOnClickListener { v: View -> itemClickListener.onDownloadClick(v, itemList[position], position) }
                viewHolder.playImageView.setOnClickListener { v: View -> itemClickListener.onPlayClick(v, itemList[position], position) }

        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class PlaceViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {


        internal var videoHolderView: CardView = view.videoCardView
        internal var playImageView: ImageView = view.playImageView
        internal var downloadImageView: ImageView = view.downloadImageView
        internal var videoImageView: ImageView = view.videoImageView
        internal var titleTextView: TextView = view.titleTextView
        internal var categoryTextView: TextView = view.categoryTextView
        internal var timeTextView: TextView = view.timeTextView
        internal var sizeTextView: TextView = view.sizeTextView


    }
}