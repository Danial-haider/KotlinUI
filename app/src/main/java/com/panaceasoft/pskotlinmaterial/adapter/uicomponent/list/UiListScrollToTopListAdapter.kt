package com.panaceasoft.pskotlinmaterial.adapter.uicomponent.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.WallpaperItem
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.ui_list_scroll_to_top_list_item.view.*

class UiListScrollToTopListAdapter(private val itemList: List<WallpaperItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: UiListScrollToTopListAdapter.OnItemClickListener


    interface OnItemClickListener {
        fun onItemClick(view: View, obj: WallpaperItem, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: UiListScrollToTopListAdapter.OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.ui_list_scroll_to_top_list_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is UiListScrollToTopListAdapter.PlaceViewHolder) {

            val item = itemList[position]

            viewHolder.likeCountTextView.text = item.likeCount
            viewHolder.viewCountTextView.text = item.viewCount
            viewHolder.nameTextView.text = item.user.nameName
            viewHolder.agoTextView.text = item.user.ago

            val context = viewHolder.holderCardView.context

            val id = Utils.getDrawableInt(context, item.imageName)
            Utils.setImageToImageView(context, viewHolder.itemImageView, id)

            val userImg = Utils.getDrawableInt(context, item.user.user_image!!)
            Utils.setCircleImageToImageView(context, viewHolder.userImageView, userImg, 0, 0)


                viewHolder.holderCardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, itemList[position], position) }


        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class PlaceViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var itemImageView: ImageView = view.itemImageView
        internal var likeCountTextView: TextView = view.likeCountTextView
        internal var viewCountTextView: TextView = view.viewCountTextView
        internal var holderCardView: CardView = view.holderCardView
        internal var nameTextView: TextView = view.nameTextView
        internal var agoTextView: TextView = view.agoTextView
        internal var userImageView: ImageView = view.userImageView


    }
}

