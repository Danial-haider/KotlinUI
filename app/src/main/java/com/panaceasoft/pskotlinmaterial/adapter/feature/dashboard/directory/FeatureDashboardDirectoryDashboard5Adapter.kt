package com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.directory

import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_dashboard_directory_dashboard_5_item.view.*

import java.util.ArrayList

/**
 * Created by Panacea-Soft on 15/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureDashboardDirectoryDashboard5Adapter(private val placeArrayList: ArrayList<Place>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: Place, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_dashboard_directory_dashboard_5_item, parent, false)

        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is ItemViewHolder) {

            val placeItem = placeArrayList[position]

            viewHolder.placeNameTextView.text = placeItem.name

            val context = viewHolder.holderCardView.context

            val id = Utils.getDrawableInt(context, placeItem.imageName)
            Utils.setImageToImageView(context, viewHolder.placeImageView, id)

            viewHolder.distanceTextView.text = placeItem.distance

            viewHolder.holderCardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, placeArrayList[position], position) }

        }
    }

    override fun getItemCount(): Int {
        return placeArrayList.size
    }

    inner class ItemViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var placeImageView: ImageView
        internal var placeNameTextView: TextView
        internal var distanceTextView: TextView
        internal var holderCardView: CardView

        init {

            placeImageView = view.placeImageView
            placeNameTextView = view.placeNameTextView
            distanceTextView = view.distanceTextView
            holderCardView = view.holderCardView

        }
    }
}
