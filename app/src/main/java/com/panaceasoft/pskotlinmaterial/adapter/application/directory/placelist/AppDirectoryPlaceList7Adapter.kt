package com.panaceasoft.pskotlinmaterial.adapter.application.directory.placelist

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
import kotlinx.android.synthetic.main.app_directory_place_list_7_item.view.*
import java.util.*

class AppDirectoryPlaceList7Adapter(private val placeArrayList: ArrayList<Place>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: Place, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_directory_place_list_7_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is PlaceViewHolder) {
            val place = placeArrayList[position]

            viewHolder.placeNameTextView.text = place.name

            val context = viewHolder.placeHolderCardView.context

            val id = Utils.getDrawableInt(context, place.imageName)
            Utils.setImageToImageView(context, viewHolder.placeImageView, id)

            viewHolder.totalRatingTextView.text = place.totalRating
            viewHolder.totalLikeTextView.text = place.totalLike
            viewHolder.totalCmtTextView.text = place.totalComment

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
        var totalRatingTextView: TextView = view.totalRatingTextView
        var promoAmtTextView: TextView = view.promoAmtTextView
        var promoCardView: CardView = view.promoCardView
        var placeHolderCardView: CardView = view.placeHolderCardView
        var totalLikeTextView: TextView = view.totalLikeTextView
        var totalCmtTextView: TextView = view.totalCmtTextView

    }
}