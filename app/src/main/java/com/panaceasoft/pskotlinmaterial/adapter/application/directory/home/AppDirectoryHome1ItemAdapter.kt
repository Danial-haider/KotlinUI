package com.panaceasoft.pskotlinmaterial.adapter.application.directory.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.DirectoryCategory
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_directory_home_1_item.view.*

/**
 * Created by Panacea-Soft on 6/10/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class AppDirectoryHome1ItemAdapter(private val placeList: List<DirectoryCategory>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener


    interface OnItemClickListener {
        fun onItemClick(view: View, obj: DirectoryCategory, position: Int)

    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_directory_home_1_item, parent, false)

        return ItemViewHolder(itemView)

    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is ItemViewHolder) {

            // Get Shop Item
            val directoryCategory = placeList[position]

            // Convert Item Holder

            // Get Context
            val context = viewHolder.itemImageView.context

            // Set Data to UI
            viewHolder.itemNameTextView.text = directoryCategory.name

            // Set Image
            val id = Utils.getDrawableInt(context, directoryCategory.image)
            Utils.setCircleImageToImageView(context, viewHolder.itemImageView, id, 8, R.color.md_grey_300)

            // Listeners

                viewHolder.itemImageView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, placeList[position], position) }
                viewHolder.itemNameTextView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, placeList[position], position) }

        }
    }

    override fun getItemCount(): Int {
        return placeList.size
    }

    inner class ItemViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var itemImageView: ImageView = view.itemImageView
        internal var itemNameTextView: TextView = view.itemNameTextView


    }
}
