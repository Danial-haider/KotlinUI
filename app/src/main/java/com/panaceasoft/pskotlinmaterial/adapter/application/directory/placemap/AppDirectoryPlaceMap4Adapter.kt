package com.panaceasoft.pskotlinmaterial.adapter.application.directory.placemap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_directory_place_map_4_item.view.*
import java.util.*

/**
 * Created by Panacea-Soft on 6/6/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class AppDirectoryPlaceMap4Adapter(private val placeArrayList: ArrayList<Place>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: Place, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_directory_place_map_4_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(reholder: RecyclerView.ViewHolder, position: Int) {

        if (reholder is PlaceViewHolder) {
            val place = placeArrayList[position]

            reholder.placeNameTextView.text = place.name

            val context = reholder.placeImageView.context

            val id = Utils.getDrawableInt(context, place.imageName)
            Utils.setImageToImageView(context, reholder.placeImageView, id)

            val info = place.ratingCount + "/" + place.ratingCount + " Ratings" + " - " + place.distance

            reholder.otherInfoTextView.text = info


            // Listeners

            reholder.placeCardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, place, position) }


        }

    }

    override fun getItemCount(): Int {
        return placeArrayList.size
    }

    inner class PlaceViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var placeImageView: ImageView = view.placeImageView
        internal var placeNameTextView: TextView = view.placeNameTextView
        internal var otherInfoTextView: TextView = view.otherInfoTextView
        internal var placeCardView: CardView = view.placeCardView

    }

}
