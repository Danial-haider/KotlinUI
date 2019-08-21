package com.panaceasoft.pskotlinmaterial.adapter.application.directory.placelist

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
import java.util.*

class AppDirectoryPlaceList1Adapter(private val placeArrayList: ArrayList<Place>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: Place, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_directory_place_list_1_item, parent, false)

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


                if ( Integer.parseInt(place.discount) > 0) {
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
        var placeImageView: ImageView = view.findViewById(R.id.placeImageView)
        var placeNameTextView: TextView = view.findViewById(R.id.placeNameTextView)
        var typeTextView: TextView = view.findViewById(R.id.distanceTextView)
        var cityTextView: TextView = view.findViewById(R.id.cityTextView)
        var totalRatingTextView: TextView = view.findViewById(R.id.totalRatingTextView)
        var ratingCountTextView: TextView = view.findViewById(R.id.ratingCountTextView)
        var placeRatingBar: RatingBar = view.findViewById(R.id.placeRatingBar)
        var promoAmtTextView: TextView = view.findViewById(R.id.promoAmtTextView)
        var promoCardView: CardView = view.findViewById(R.id.promoCardView)
        var placeHolderCardView: CardView = view.findViewById(R.id.placeHolderCardView)

    }
}