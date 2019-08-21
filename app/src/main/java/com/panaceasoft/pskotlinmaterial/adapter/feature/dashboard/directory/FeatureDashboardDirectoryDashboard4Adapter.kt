package com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.directory

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.UserHistory
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_dashboard_directory_dashboard_4_item.view.*

/**
 * Created by Panacea-Soft on 15/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureDashboardDirectoryDashboard4Adapter(private val userHistoryList: List<UserHistory>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
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
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_dashboard_directory_dashboard_4_item, parent, false)

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
        internal var constraintLayout: ConstraintLayout
        internal var placeImageView: ImageView
        internal var placeNameTextView: TextView
        internal var regionTextView: TextView
        internal var commentTextView: TextView
        internal var saveImageView: ImageView
        internal var saveTextView: TextView
        internal var shareImageView: ImageView
        internal var shareTextView: TextView
        internal var likeImageView: ImageView
        internal var likeTextView: TextView
        internal var dateTextView: TextView

        init {

            placeImageView = view.placeImageView
            placeNameTextView = view.placeNameTextView
            regionTextView = view.regionTextView
            constraintLayout = view.constraintLayout
            commentTextView = view.commentTextView
            saveImageView = view.saveImageView
            saveTextView = view.saveTextView
            shareImageView = view.shareImageView
            shareTextView = view.shareTextView
            likeImageView = view.likeImageView
            likeTextView = view.likeTextView
            dateTextView = view.dateTextView

        }
    }
}
