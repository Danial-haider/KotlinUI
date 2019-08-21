package com.panaceasoft.pskotlinmaterial.adapter.feature.timeline.social

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.TimelineSocial
import com.panaceasoft.pskotlinmaterial.utils.Utils

/**
 * Created by Panacea-Soft on 7/21/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class FeatureTimelineSocialTimeline1Adapter(private val timelineSocialList: List<TimelineSocial>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: TimelineSocial, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == 0) {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_timeline_social_timeline_1_item, parent, false)
            return SocialTimeLinePostViewHolder(itemView)
        } else if (viewType == 1) {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_timeline_social_timeline_1_item_image, parent, false)
            return SocialTimeLineImageViewHolder(itemView)
        } else {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_timeline_social_timeline_1_item_status, parent, false)
            return SocialTimeLineStatusViewHolder(itemView)
        }

    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is SocialTimeLinePostViewHolder) {
            val timelineSocial = timelineSocialList[position]

            viewHolder.nameTextView.text = timelineSocial.name
            viewHolder.detailTextView.text = timelineSocial.detail
            viewHolder.dateTextView.text = timelineSocial.date
            val context = viewHolder.iconImageView.context

            if (context != null) {
                val id = Utils.getDrawableInt(context, timelineSocial.icon)
                Utils.setImageToImageView(context, viewHolder.iconImageView, id)
            }
                viewHolder.constraintLayout.setOnClickListener { v: View -> itemClickListener.onItemClick(v, timelineSocialList[position], position) }

        } else if (viewHolder is SocialTimeLineImageViewHolder) {
            val timelineSocial = timelineSocialList[position]

            viewHolder.detailTextView.text = timelineSocial.detail
            viewHolder.dateTextView.text = timelineSocial.date
            val context = viewHolder.iconImageView.context

            if (context != null) {
                val id = Utils.getDrawableInt(context, timelineSocial.icon)
                Utils.setImageToImageView(context, viewHolder.iconImageView, id)

                val imgId = Utils.getDrawableInt(context, timelineSocial.image)
                Utils.setImageToImageView(context, viewHolder.postImageView, imgId)
            }

                viewHolder.constraintLayout.setOnClickListener { v: View -> itemClickListener.onItemClick(v, timelineSocialList[position], position) }

        } else if (viewHolder is SocialTimeLineStatusViewHolder) {
            val timelineSocial = timelineSocialList[position]

            viewHolder.nameTextView.text = timelineSocial.name
            viewHolder.detailTextView.text = timelineSocial.detail
            viewHolder.dateTextView.text = timelineSocial.date
            val context = viewHolder.iconImageView.context

            if (context != null) {
                val id = Utils.getDrawableInt(context, timelineSocial.icon)
                Utils.setImageToImageView(context, viewHolder.iconImageView, id)

                val userId = Utils.getDrawableInt(context, timelineSocial.user_image)
                Utils.setImageToImageView(context, viewHolder.userImageView, userId)
            }

                viewHolder.constraintLayout.setOnClickListener { v: View -> itemClickListener.onItemClick(v, timelineSocialList[position], position) }

        }
    }

    override fun getItemViewType(position: Int): Int {

        val timelineSocial = timelineSocialList[position]

        return if (timelineSocial.type == "post") {
            0
        } else if (timelineSocial.type == "image") {
            1
        } else {
            2
        }

    }

    override fun getItemCount(): Int {

        return timelineSocialList.size

    }

    inner class SocialTimeLinePostViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var nameTextView: TextView = view.findViewById(R.id.nameTextView)
        internal var detailTextView: TextView = view.findViewById(R.id.detailTextView)
        internal var constraintLayout: ConstraintLayout = view.findViewById(R.id.constraintLayout)
        internal var iconImageView: ImageView = view.findViewById(R.id.iconImageView)
        internal var dateTextView: TextView = view.findViewById(R.id.dateTextView)

    }

    inner class SocialTimeLineImageViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var postImageView: ImageView = view.findViewById(R.id.postImageView)
        internal var detailTextView: TextView = view.findViewById(R.id.detailTextView)
        internal var constraintLayout: ConstraintLayout = view.findViewById(R.id.constraintLayout)
        internal var iconImageView: ImageView = view.findViewById(R.id.iconImageView)
        internal var dateTextView: TextView = view.findViewById(R.id.dateTextView)

    }

    inner class SocialTimeLineStatusViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var nameTextView: TextView = view.findViewById(R.id.nameTextView)
        internal var detailTextView: TextView = view.findViewById(R.id.detailTextView)
        internal var constraintLayout: ConstraintLayout = view.findViewById(R.id.constraintLayout)
        internal var userImageView: ImageView = view.findViewById(R.id.userImageView)
        internal var iconImageView: ImageView = view.findViewById(R.id.iconImageView)
        internal var dateTextView: TextView = view.findViewById(R.id.dateTextView)

    }
}
