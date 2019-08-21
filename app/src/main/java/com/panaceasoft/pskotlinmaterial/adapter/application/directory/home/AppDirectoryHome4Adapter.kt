package com.panaceasoft.pskotlinmaterial.adapter.application.directory.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.UserHistory
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_directory_home_4_item.view.*

/**
 * Created by Panacea-Soft on 6/12/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class AppDirectoryHome4Adapter(private val userHistoryList: List<UserHistory>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: UserHistory, position: Int)

        fun onSaveClick(view: View, obj: UserHistory, position: Int)

        fun onShareClick(view: View, obj: UserHistory, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_directory_home_4_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is PlaceViewHolder) {

            val userHistory = userHistoryList[position]

            viewHolder.placeNameTextView.text = userHistory.placeName

            val context = viewHolder.placeImageView.context

            val id = Utils.getDrawableInt(context, userHistory.placeImage)
            Utils.setImageToImageView(context, viewHolder.placeImageView, id)

            viewHolder.regionTextView.text = userHistory.region
            viewHolder.commentTextView.text = userHistory.comment
            viewHolder.dateTextView.text = userHistory.added





                viewHolder.constraintLayout.setOnClickListener { v: View -> itemClickListener.onItemClick(v, userHistoryList[position], position) }

                viewHolder.saveImageView.setOnClickListener { v: View -> itemClickListener.onSaveClick(v, userHistoryList[position], position) }
                viewHolder.saveTextView.setOnClickListener { v: View -> itemClickListener.onSaveClick(v, userHistoryList[position], position) }

                viewHolder.shareImageView.setOnClickListener { v: View -> itemClickListener.onShareClick(v, userHistoryList[position], position) }
                viewHolder.shareTextView.setOnClickListener { v: View -> itemClickListener.onShareClick(v, userHistoryList[position], position) }

        }
    }

    override fun getItemCount(): Int {
        return userHistoryList.size
    }

    inner class PlaceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal var constraintLayout: ConstraintLayout = view.constraintLayout
        internal var placeImageView: ImageView = view.placeImageView
        internal var placeNameTextView: TextView = view.placeNameTextView
        internal var regionTextView: TextView = view.regionTextView
        internal var commentTextView: TextView = view.commentTextView
        internal var saveImageView: ImageView = view.saveImageView
        internal var saveTextView: TextView = view.saveTextView
        internal var shareImageView: ImageView = view.shareImageView
        internal var shareTextView: TextView = view.shareTextView
        internal var likeImageView: ImageView = view.likeImageView
        internal var likeTextView: TextView = view.likeTextView
        internal var dateTextView: TextView = view.dateTextView

    }
}