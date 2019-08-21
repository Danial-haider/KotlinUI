package com.panaceasoft.pskotlinmaterial.adapter.application.directory.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_directory_home_6_item.view.*
import java.util.*

/**
 * Created by Panacea-Soft on 13/6/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class AppDirectoryHome6ItemAdapter(private val placeItemArrayList: ArrayList<Place>, private val numberOfColumns: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener
    private val topEmptyCellHeight = 47

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: Place, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 0) {
            val relativeLayout = RelativeLayout(parent.context)

            // SET THE SIZE
            relativeLayout.layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, Utils.dpToPx(parent.context, topEmptyCellHeight))

            return ItemView(relativeLayout)
        } else {

            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_directory_home_6_item, parent, false)

            return ItemViewHolder(itemView)
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is ItemViewHolder && position > 1) {

            val actualDataPosition = position - numberOfColumns

            // Get Shop Item
            val placeItem = placeItemArrayList[actualDataPosition]

            // Convert Item Holder

            // Get Context
            val context = viewHolder.holderCardView.context

            // Set Data to UI
            viewHolder.placeNameTextView.text = placeItem.name

            viewHolder.ratingTextView.text = placeItem.totalRating

            viewHolder.distanceTextView.text = placeItem.distance

            // Set Image
            val id = Utils.getDrawableInt(context, placeItem.imageName)
            Utils.setImageToImageView(context, viewHolder.placeImageView, id)

            // Listeners

                viewHolder.holderCardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, placeItemArrayList[actualDataPosition], actualDataPosition) }

        }
    }

    override fun getItemCount(): Int {
        return placeItemArrayList.size + numberOfColumns
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0 || position == 1) {
            0
        } else {
            1
        }
    }

    inner class ItemView internal  constructor(view: View):RecyclerView.ViewHolder(view)

    inner class ItemViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var placeImageView: ImageView = view.placeImageView
        internal var placeNameTextView: TextView = view.placeNameTextView
        internal var ratingTextView: TextView = view.ratingTextView
        internal var distanceTextView: TextView = view.distanceTextView
        internal var holderCardView: CardView = view.placeHolderCardView


    }
}