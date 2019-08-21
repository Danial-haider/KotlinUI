package com.panaceasoft.pskotlinmaterial.adapter.feature.gallery.ecommerce

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_gallery_ecommerce_gallery_3_item.view.*

/**
 * Created by Panacea-Soft on 20/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureGalleryECommerceGallery3PagerAdapter(private val placeArrayList: List<ShopItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener


    interface OnItemClickListener {
        fun onItemClick(view: View, obj: ShopItem, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_gallery_ecommerce_gallery_3_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(reholder: RecyclerView.ViewHolder, position: Int) {

        if (reholder is PlaceViewHolder) {
            val place = placeArrayList[position]
            val context = reholder.placeImageView.context
            val id = Utils.getDrawableInt(context, place.imageName)
            Utils.setImageToImageView(context, reholder.placeImageView, id)

            reholder.placeImageView.setOnClickListener { view ->
                    itemClickListener.onItemClick(view, placeArrayList[position], position)

            }
        }

    }

    override fun getItemCount(): Int {
        return placeArrayList.size
    }

    inner class PlaceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var placeImageView: ImageView = view.itemImageView

    }

}


