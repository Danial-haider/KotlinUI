package com.panaceasoft.pskotlinmaterial.adapter.feature.chat.general

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ChatDetailsVO
import com.panaceasoft.pskotlinmaterial.utils.Utils

class FeatureChatGeneralChat2Adapter(private val chatDetailsList: List<ChatDetailsVO>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val OWNER = 0
    private val OTHER = 1
    private val TIME = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == OWNER) {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_chat_general_chat2_item_owner, parent, false)

            return ChatDetailsOwnerViewHolder(itemView)
        } else if (viewType == OTHER) {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_chat_general_chat2_item_other, parent, false)

            return ChatDetailsOtherViewHolder(itemView)
        } else {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_chat_general_chat2_time, parent, false)

            return ChatDetailTimeViewHolder(itemView)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (chatDetailsList[position].type == "owner") {
            if (holder is ChatDetailsOwnerViewHolder) {

                val chatDetails = chatDetailsList[position]
                val context = holder.profileImageView.context

                val imageId = Utils.getDrawableInt(context, chatDetails.profileImage)
                val sentImageId = Utils.getDrawableInt(context, "baseline_done_black_24")
                val readImageId = Utils.getDrawableInt(context, "baseline_done_all_blue_24")

                Utils.setCircleImageToImageView(context, holder.profileImageView, imageId, 0, 0)
                holder.messageTextView.text = chatDetails.message
                holder.timeTextView.text = chatDetails.timestamp

                if (chatDetails.state == "sent") {
                    Utils.setImageToImageView(context, holder.stateImageView, sentImageId)
                } else if (chatDetails.state == "read") {
                    Utils.setImageToImageView(context, holder.stateImageView, readImageId)
                }
            }

        } else if (chatDetailsList[position].type == "other") {
            if (holder is ChatDetailsOtherViewHolder) {

                val chatDetails = chatDetailsList[position]
                val context = holder.profileImageView.context

                val imageId = Utils.getDrawableInt(context, chatDetails.profileImage)

                Utils.setCircleImageToImageView(context, holder.profileImageView, imageId, 0, 0)
                holder.messageTextView.text = chatDetails.message
                holder.timeTextView.text = chatDetails.timestamp
            }

        } else if (chatDetailsList[position].type == "time") {
            if (holder is ChatDetailTimeViewHolder) {
                holder.timeTextView.text = chatDetailsList[position].message
            }
        }
    }

    override fun getItemCount(): Int {
        return chatDetailsList.size
    }

    override fun getItemViewType(position: Int): Int {
        when (chatDetailsList[position].type) {
            "owner" -> return OWNER
            "other" -> return OTHER
            else -> return TIME
        }
    }

    inner class ChatDetailsOwnerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var profileImageView: ImageView
        internal var messageTextView: TextView
        internal var timeTextView: TextView
        internal var stateImageView: ImageView

        init {

            profileImageView = itemView.findViewById(R.id.profileImageView)
            messageTextView = itemView.findViewById(R.id.messageTextView)
            timeTextView = itemView.findViewById(R.id.timeTextView)
            stateImageView = itemView.findViewById(R.id.stateImageView)
        }
    }

    inner class ChatDetailsOtherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var profileImageView: ImageView
        internal var messageTextView: TextView
        internal var timeTextView: TextView

        init {

            profileImageView = itemView.findViewById(R.id.profileImageView)
            messageTextView = itemView.findViewById(R.id.messageTextView)
            timeTextView = itemView.findViewById(R.id.timeTextView)
        }
    }

    inner class ChatDetailTimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var timeTextView: TextView

        init {

            timeTextView = itemView.findViewById(R.id.dateTextView)
        }
    }
}
