package com.panaceasoft.pskotlinmaterial.adapter.feature.timeline.ecommerce

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.DeliveryStatus
import com.panaceasoft.pskotlinmaterial.utils.Utils

/**
 * Created by Panacea-Soft on 7/20/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class FeatureTimelineECommerceTimeline1Adapter(private val deliveryStatusList: List<DeliveryStatus>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: DeliveryStatus, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == 0) {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_timeline_ecommerce_timeline_1_item, parent, false)
            return DeliveryStatusViewHolder(itemView)
        } else if (viewType == 1) {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_timeline_ecommerce_timeline_1_item_2, parent, false)
            return DeliveryStatusViewHolder(itemView)
        } else {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_timeline_ecommerce_timeline_1_item_3, parent, false)
            return DeliveryStatusViewHolder(itemView)
        }

    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is DeliveryStatusViewHolder) {
            val deliveryStatus = deliveryStatusList[position]

            viewHolder.locationTextView.text = deliveryStatus.location
            viewHolder.remarkTextView.text = deliveryStatus.remark
            viewHolder.dateTextView.text = deliveryStatus.date
            viewHolder.timeTextView.text = deliveryStatus.time

            val context = viewHolder.iconImageView.context

            if (context != null) {
                val id = Utils.getDrawableInt(context, deliveryStatus.icon)
                Utils.setImageToImageView(context, viewHolder.iconImageView, id)
            }

                viewHolder.constraintLayout.setOnClickListener { v: View -> itemClickListener.onItemClick(v, deliveryStatusList[position], position) }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position < 2) {
            0
        } else if (deliveryStatusList.size - 1 == position) {
            2
        } else {
            1
        }
    }

    override fun getItemCount(): Int {

        return deliveryStatusList.size

    }

    inner class DeliveryStatusViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var locationTextView: TextView = view.findViewById(R.id.locationTextView)
        internal var remarkTextView: TextView = view.findViewById(R.id.remarkTextView)
        internal var dateTextView: TextView = view.findViewById(R.id.dateTextView)
        internal var constraintLayout: ConstraintLayout = view.findViewById(R.id.constraintLayout)
        internal var timeTextView: TextView = view.findViewById(R.id.timeTextView)
        internal var iconImageView: ImageView = view.findViewById(R.id.iconImageView)


    }
}

