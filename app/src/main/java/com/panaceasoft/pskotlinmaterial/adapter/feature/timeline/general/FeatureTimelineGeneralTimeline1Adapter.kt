package com.panaceasoft.pskotlinmaterial.adapter.feature.timeline.general

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.GeneralInboxList
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_timeline_general_timeline_1_item.view.*

/**
 * Created by Panacea-Soft on 7/21/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class FeatureTimelineGeneralTimeline1Adapter(private val generalLists: List<GeneralInboxList>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: GeneralInboxList, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_timeline_general_timeline_1_item, parent, false)
        return GeneralTimelineViewHolder(itemView)

    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is GeneralTimelineViewHolder) {
            val generalInboxList = generalLists[position]

            viewHolder.titleTextView.text = generalInboxList.name
            viewHolder.detailTextView.text = generalInboxList.detail
            viewHolder.dateTextView.text = generalInboxList.time

            val context = viewHolder.iconImageView.context

            if (context != null) {
                val id = Utils.getDrawableInt(context, generalInboxList.image)
                Utils.setCircleImageToImageView(context, viewHolder.iconImageView, id, 0, 0)
            }

                viewHolder.constraintLayout.setOnClickListener { v: View -> itemClickListener.onItemClick(v, generalLists[position], position) }

        }
    }


    override fun getItemCount(): Int {

        return generalLists.size

    }

    inner class GeneralTimelineViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var titleTextView: TextView = view.titleTextView
        internal var detailTextView: TextView = view.detailTextView
        internal var dateTextView: TextView = view.dateTextView
        internal var constraintLayout: ConstraintLayout = view.constraintLayout
        internal var iconImageView: ImageView = view.iconImageView


    }
}
