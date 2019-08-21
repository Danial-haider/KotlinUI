package com.panaceasoft.pskotlinmaterial.adapter.feature.gallery.directory

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

/**
 * Created by Panacea-Soft on 20/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureGalleryDirectoryGallery4Adapter(private val sectionGalleryListHolderList: List<SectionGalleryListHolder>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private val SECTION = 0
    private val ITEM = 1
    private val LAST_ITEM = 2
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: SectionGalleryListHolder, position: Int)
        fun onLastItemClick(view: View, obj: SectionGalleryListHolder, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == SECTION) {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_gallery_directory_gallery_4_section, parent, false)

            return SectionViewHolder(itemView)
        } else if (viewType == ITEM) {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_gallery_directory_gallery_4_item, parent, false)

            return PlaceViewHolder(itemView)
        } else {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_gallery_directory_gallery_4_last_item, parent, false)

            return LastItemViewHolder(itemView)
        }
    }

    override fun onBindViewHolder(reholder: RecyclerView.ViewHolder, position: Int) {

        if (sectionGalleryListHolderList[position].isSectionTitle) {
            if (reholder is SectionViewHolder) {

                val layoutParams = reholder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
                reholder.sectionTitleTextView.text = sectionGalleryListHolderList[position].name
                layoutParams.isFullSpan = true
            }

        } else {

            if (sectionGalleryListHolderList[position].isLastPhoto) {
                if (reholder is LastItemViewHolder) {
                    val section = sectionGalleryListHolderList[position]
                    val context = reholder.placeImageView.context
                    val id = Utils.getDrawableInt(context, section.image.image)
                    Utils.setImageToImageView(context, reholder.placeImageView, id)

                    reholder.placeImageView.setOnClickListener { view ->
                            itemClickListener.onLastItemClick(view, sectionGalleryListHolderList[position], position)

                    }
                    val layoutParams = reholder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
                    layoutParams.isFullSpan = false
                }
            } else {
                if (reholder is PlaceViewHolder) {
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

    }

    override fun getItemCount(): Int {
        return sectionGalleryListHolderList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (sectionGalleryListHolderList[position].isSectionTitle) {
            SECTION
        } else {

            if (sectionGalleryListHolderList[position].isLastPhoto) {
                LAST_ITEM
            } else {
                ITEM
            }
        }
    }

    inner class PlaceViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var placeImageView: ImageView = view.findViewById(R.id.itemImageView)

    }

    inner class LastItemViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var placeImageView: ImageView = view.findViewById(R.id.itemImageView)

    }

    inner class SectionViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var sectionTitleTextView: TextView = view.findViewById(R.id.sectionTitleTextView)

    }

}


