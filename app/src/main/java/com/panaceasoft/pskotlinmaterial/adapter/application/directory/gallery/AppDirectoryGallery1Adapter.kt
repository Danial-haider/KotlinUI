package com.panaceasoft.pskotlinmaterial.adapter.application.directory.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_directory_gallery_1_item.view.*
import java.util.*

/**
 * Created by Panacea-Soft on 9/6/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class AppDirectoryGallery1Adapter(private val placeArrayList: ArrayList<Place>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemSelect(view: View, obj: Place, position: Int)
        fun onItemUnSelect(view: View, obj: Place, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_directory_gallery_1_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(reholder: RecyclerView.ViewHolder, position: Int) {

        if (reholder is PlaceViewHolder) {
            val place = placeArrayList[position]
            val context = reholder.placeImageView.context
            val id = Utils.getDrawableInt(context, place.imageName)
            Utils.setImageToImageView(context, reholder.placeImageView, id)

            reholder.selectedImageView.visibility = View.INVISIBLE

            reholder.placeImageView.setOnClickListener { view ->

                if (reholder.selectedImageView.visibility == View.INVISIBLE) {
                    reholder.selectedImageView.visibility = View.VISIBLE

                    itemClickListener.onItemSelect(view, placeArrayList[position], position)

                } else {
                    reholder.selectedImageView.visibility = View.INVISIBLE

                    itemClickListener.onItemUnSelect(view, placeArrayList[position], position)

                }

            }
        }

    }

    override fun getItemCount(): Int {
        return placeArrayList.size
    }

    inner class PlaceViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var placeImageView: ImageView = view.placeImageView
        internal var selectedImageView: ImageView = view.selectedImageView

    }

}
