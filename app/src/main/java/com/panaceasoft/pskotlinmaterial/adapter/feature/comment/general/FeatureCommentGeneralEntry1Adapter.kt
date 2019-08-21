package com.panaceasoft.pskotlinmaterial.adapter.feature.comment.general

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.RatingItem
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_comment_general_entry_1_item.view.*

/**
 * Created by Panacea-Soft on 22/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureCommentGeneralEntry1Adapter(private val ratingItemList: List<RatingItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener


    interface OnItemClickListener {
        fun onItemClick(view: View, obj: RatingItem, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_comment_general_entry_1_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is PlaceViewHolder) {

            val ratingItem = ratingItemList[position]

            val context = viewHolder.holderCardView.context

            val id = Utils.getDrawableInt(context, ratingItem.userImage)
            Utils.setImageToImageView(context, viewHolder.userImageView, id)
            Utils.setCircleImageToImageView(context, viewHolder.userImageView, id, 0, 0)

            viewHolder.userNameTextView.text = ratingItem.userName

            viewHolder.dateTextView.text = ratingItem.added

            viewHolder.messageTextView.text = ratingItem.comment

            viewHolder.holderCardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, ratingItemList[position], position) }

        }
    }

    override fun getItemCount(): Int {
        return ratingItemList.size
    }

    inner class PlaceViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var holderCardView: ConstraintLayout
        internal var userImageView: ImageView
        internal var dateTextView: TextView
        internal var userNameTextView: TextView
        internal var messageTextView: TextView

        init {

            holderCardView = view.holderCardView
            userImageView = view.userImageView
            dateTextView = view.dateTextView
            messageTextView = view.messageTextView
            userNameTextView = view.userNameTextView

        }
    }
}