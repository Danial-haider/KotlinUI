package com.panaceasoft.pskotlinmaterial.adapter.application.directory.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.UserHistory
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_directory_home_3_item.view.*

/**
 * Created by Panacea-Soft on 6/12/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class AppDirectoryHome3Adapter(private val userHistoryList: List<UserHistory>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: UserHistory, position: Int)

        fun onLikeClick(view: View, obj: UserHistory, position: Int)

        fun onAddClick(view: View, obj: UserHistory, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_directory_home_3_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is PlaceViewHolder) {

            val userHistory = userHistoryList[position]

            viewHolder.placeNameTextView.text = userHistory.placeName

            val context = viewHolder.cardView.context

            val id = Utils.getDrawableInt(context, userHistory.placeImage)
            Utils.setImageToImageView(context, viewHolder.placeImageView, id)

            viewHolder.regionTextView.text = userHistory.region


                viewHolder.cardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, userHistoryList[position], position) }

                viewHolder.likeImageView.setOnClickListener { v: View -> itemClickListener.onLikeClick(v, userHistoryList[position], position) }

                viewHolder.addImageView.setOnClickListener { v: View -> itemClickListener.onAddClick(v, userHistoryList[position], position) }

        }
    }

    override fun getItemCount(): Int {
        return userHistoryList.size
    }

    inner class PlaceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal var cardView: CardView = view.placeHolderCardView
        internal var placeImageView: ImageView = view.placeImageView
        internal var placeNameTextView: TextView = view.placeNameTextView
        internal var regionTextView: TextView = view.regionTextView
        internal var likeImageView: ImageView = view.likeImageView
        internal var addImageView: ImageView = view.addImageView

    }
}