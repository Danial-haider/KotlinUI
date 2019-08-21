package com.panaceasoft.pskotlinmaterial.adapter.application.ecommerce.detail.detail4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.UserReview
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_ecommerce_detail_4_review_item.view.*

/**
 * Created by Panacea-Soft on 6/23/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class AppECommerceDetail4ReviewAdapter(private val userReviewList: List<UserReview>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: UserReview, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_ecommerce_detail_4_review_item, parent, false)

        return UserReviewViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is UserReviewViewHolder) {
            val userReview = userReviewList[position]

            val name = "By " + userReview.userName
            viewHolder.userNameTextView.text = name

            viewHolder.dateTextView.text = userReview.added
            viewHolder.reviewDetailTextView.text = userReview.comment

            viewHolder.ratingBar.rating = java.lang.Float.parseFloat(userReview.totalRating)

            val context = viewHolder.userImageView.context
            if (context != null) {
                val id = Utils.getDrawableInt(context, userReview.userImage)
                Utils.setCircleImageToImageView(context, viewHolder.userImageView, id, 0, 0)
            }

            viewHolder.holderCardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, userReviewList[position], position) }

        }
    }

    override fun getItemCount(): Int {

        return if (userReviewList.size > 3) {
            3
        } else {
            userReviewList.size
        }
    }

    inner class UserReviewViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var userNameTextView: TextView = view.userNameTextView
        internal var dateTextView: TextView = view.dateTextView
        internal var reviewDetailTextView: TextView = view.reviewDetailTextView
        internal var ratingBar: RatingBar = view.ratingBar
        internal var userImageView: ImageView = view.userImageView
        internal var holderCardView: CardView = view.holderCardView

    }
}