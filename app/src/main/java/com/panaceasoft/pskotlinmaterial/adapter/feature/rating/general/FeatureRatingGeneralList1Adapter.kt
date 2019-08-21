package com.panaceasoft.pskotlinmaterial.adapter.feature.rating.general

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.RatingItem
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_rating_general_list_1_item.view.*

/**
 * Created by Panacea-Soft on 22/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureRatingGeneralList1Adapter(private val ratingItemList: List<RatingItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener


    interface OnItemClickListener {
        fun onItemClick(view: View, obj: RatingItem, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_rating_general_list_1_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is PlaceViewHolder) {

            val ratingItem = ratingItemList[position]

            viewHolder.titleTextView.text = ratingItem.title

            val context = viewHolder.holderCardView.context

            val id = Utils.getDrawableInt(context, ratingItem.userImage)
            Utils.setImageToImageView(context, viewHolder.userImageView, id)
            Utils.setCircleImageToImageView(context, viewHolder.userImageView, id, 0, 0)

            val byUser = "By " + ratingItem.userName
            viewHolder.byUserTextView.text = byUser

            viewHolder.dateTextView.text = ratingItem.added

            viewHolder.messageTextView.text = ratingItem.comment

            viewHolder.ratingBar.rating = java.lang.Float.parseFloat(ratingItem.totalRating)

                viewHolder.holderCardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, ratingItemList[position], position) }

        }
    }

    override fun getItemCount(): Int {
        return ratingItemList.size
    }

    inner class PlaceViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var holderCardView: ConstraintLayout = view.holderCardView
        internal var userImageView: ImageView = view.userImageView
        internal var ratingBar: RatingBar = view.ratingBar
        internal var dateTextView: TextView = view.dateTextView
        internal var byUserTextView: TextView = view.byUserTextView
        internal var messageTextView: TextView = view.messageTextView
        internal var titleTextView: TextView = view.titleTextView


    }
}