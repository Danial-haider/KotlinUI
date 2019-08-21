package com.panaceasoft.pskotlinmaterial.adapter.feature.comment.general

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.CommentItem
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_comment_general_list_1_item.view.*

/**
 * Created by Panacea-Soft on 22/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureCommentGeneralList1Adapter(private val commentItemList: List<CommentItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: CommentItem, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_comment_general_list_1_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is PlaceViewHolder) {

            val commentItem = commentItemList[position]


            val context = viewHolder.holderCardView.context

            val id = Utils.getDrawableInt(context, commentItem.userImage)
            Utils.setImageToImageView(context, viewHolder.userImageView, id)
            Utils.setCircleImageToImageView(context, viewHolder.userImageView, id, 0, 0)


            viewHolder.userNameTextView.text = commentItem.userName

            viewHolder.dateTextView.text = commentItem.added

            viewHolder.messageTextView.text = commentItem.comment

            viewHolder.likeTextView.text = commentItem.totalLike

            viewHolder.shareTextView.text = commentItem.totalShare

            viewHolder.regionTextView.text = commentItem.region


            viewHolder.holderCardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, commentItemList[position], position) }


        }
    }

    override fun getItemCount(): Int {
        return commentItemList.size
    }

    inner class PlaceViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var holderCardView: ConstraintLayout
        internal var userImageView: ImageView
        internal var userNameTextView: TextView
        internal var dateTextView: TextView
        internal var regionTextView: TextView
        internal var messageTextView: TextView
        internal var likeTextView: TextView
        internal var shareTextView: TextView


        init {

            holderCardView = view.holderCardView
            userImageView = view.userImageView
            userNameTextView = view.userNameTextView
            dateTextView = view.dateTextView
            messageTextView = view.messageTextView
            regionTextView = view.regionTextView
            likeTextView = view.likeTextView
            shareTextView = view.shareTextView


        }
    }
}
