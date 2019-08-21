package com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.directory

import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.UserHistory
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_dashboard_directory_dashboard_3_item.view.*

/**
 * Created by Panacea-Soft on 15/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureDashboardDirectoryDashboard3Adapter(private val userHistoryList: List<UserHistory>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
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
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_dashboard_directory_dashboard_3_item, parent, false)

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
        internal var cardView: CardView
        internal var placeImageView: ImageView
        internal var placeNameTextView: TextView
        internal var regionTextView: TextView
        internal var likeImageView: ImageView
        internal var addImageView: ImageView

        init {

            placeImageView = view.placeImageView
            placeNameTextView = view.placeNameTextView
            regionTextView = view.regionTextView
            likeImageView = view.likeImageView
            addImageView = view.addImageView
            cardView = view.placeHolderCardView
        }
    }
}
