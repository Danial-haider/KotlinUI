package com.panaceasoft.pskotlinmaterial.adapter.feature.list.directory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_list_directory_place_list_9_item.view.*
import java.util.*

/**
 * Created by Panacea-Soft on 17/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureListDirectoryPlaceList9Adapter(private val placeArrayList: ArrayList<Place>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: Place, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_list_directory_place_list_9_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is PlaceViewHolder) {
            val place = placeArrayList[position]

            viewHolder.placeNameTextView.text = place.name
            val context = viewHolder.placeHolderCardView.context

            val id = Utils.getDrawableInt(context, place.imageName)
            Utils.setImageToImageView(context, viewHolder.placeImageView, id)

            viewHolder.typeTextView.text = place.type
            viewHolder.cityTextView.text = place.city
            viewHolder.placeRatingBar.rating = java.lang.Float.parseFloat(place.totalRating)
            viewHolder.totalRatingTextView.text = place.totalRating
            viewHolder.ratingCountTextView.text = place.ratingCount

            if (Integer.parseInt(place.discount) > 0) {
                viewHolder.promoCardView.visibility = View.VISIBLE
                val discount = place.discount + " %"
                viewHolder.promoAmtTextView.text = discount
            } else {
                viewHolder.promoCardView.visibility = View.GONE
            }

                viewHolder.placeHolderCardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, placeArrayList[position], position) }

        }
    }

    override fun getItemCount(): Int {
        return placeArrayList.size
    }

    inner class PlaceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var placeImageView: ImageView = view.placeImageView
        var placeNameTextView: TextView = view.placeNameTextView
        var typeTextView: TextView = view.distanceTextView
        var cityTextView: TextView = view.cityTextView
        var totalRatingTextView: TextView = view.totalRatingTextView
        var ratingCountTextView: TextView = view.ratingCountTextView
        var placeRatingBar: RatingBar = view.placeRatingBar
        var promoAmtTextView: TextView = view.promoAmtTextView
        var promoCardView: CardView = view.promoCardView
        var placeHolderCardView: CardView = view.placeHolderCardView

    }
}