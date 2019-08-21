package com.panaceasoft.pskotlinmaterial.adapter.application.directory.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.UserHistory
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_directory_profile_1_item.view.*
import java.util.*

/**
 * Created by Panacea-Soft on 10/6/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class AppDirectoryProfile1Adapter(private val historyArrayList: ArrayList<UserHistory>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: UserHistory, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_directory_profile_1_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is PlaceViewHolder) {

            val history = historyArrayList[position]

            viewHolder.placeNameTextView.text = history.placeName
            viewHolder.regionTextView.text = history.region
            viewHolder.commentTextView.text = history.comment
            viewHolder.dateTextView.text = history.added

            val context = viewHolder.placeImageView.context

            val id = Utils.getDrawableInt(context, history.placeImage)
            Utils.setCircleImageToImageView(context, viewHolder.placeImageView, id, 20, R.color.md_white_1000)

            viewHolder.commentLayout.setOnClickListener { v: View -> itemClickListener.onItemClick(v, history, position) }
        }
    }

    override fun getItemCount(): Int {
        return historyArrayList.size
    }

    inner class PlaceViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var placeImageView: ImageView = view.placeImageView
        internal var placeNameTextView: TextView = view.placeNameTextView
        internal var regionTextView: TextView = view.regionTextView
        internal var commentTextView: TextView = view.commentTextView
        internal var dateTextView: TextView = view.dateTextView
        internal var commentLayout: ConstraintLayout = view.commentLayout

    }
}