package com.panaceasoft.pskotlinmaterial.adapter.uicomponent.grid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.SectionGalleryListHolder
import com.panaceasoft.pskotlinmaterial.utils.Utils

class UiGridSectionedGridAdapter(private val sectionGalleryListHolderList: List<SectionGalleryListHolder>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private val SECTION = 0
    private val ITEM = 1
    private lateinit var itemClickListener: UiGridSectionedGridAdapter.OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: SectionGalleryListHolder, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: UiGridSectionedGridAdapter.OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == SECTION) {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.ui_grid_sectioned_grid_section, parent, false)

            return SectionViewHolder(itemView)
        } else {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.ui_grid_sectioned_grid_item, parent, false)

            return PlaceViewHolder(itemView)
        }
    }

    override fun onBindViewHolder(reholder: RecyclerView.ViewHolder, position: Int) {

        if (sectionGalleryListHolderList[position].isSectionTitle) {
            if (reholder is UiGridSectionedGridAdapter.SectionViewHolder) {

                val layoutParams = reholder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
                reholder.sectionTitleTextView.text = sectionGalleryListHolderList[position].name
                layoutParams.isFullSpan = true
            }

        } else {
            if (reholder is UiGridSectionedGridAdapter.PlaceViewHolder) {
                val section = sectionGalleryListHolderList[position]
                val context = reholder.placeImageView.context
                val id = Utils.getDrawableInt(context, section.image.image)
                Utils.setImageToImageView(context, reholder.placeImageView, id)

                reholder.placeImageView.setOnClickListener { view ->

                        itemClickListener.onItemClick(view, sectionGalleryListHolderList[position], position)

                }
                val layoutParams = reholder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
                layoutParams.isFullSpan = false
            }
        }

    }

    override fun getItemCount(): Int {
        return sectionGalleryListHolderList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (sectionGalleryListHolderList[position].isSectionTitle) {
            SECTION
        } else {
            ITEM
        }
    }

    inner class PlaceViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var placeImageView: ImageView = view.findViewById(R.id.itemImageView)

    }

    inner class SectionViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var sectionTitleTextView: TextView = view.findViewById(R.id.sectionTitleTextView)

    }

}
