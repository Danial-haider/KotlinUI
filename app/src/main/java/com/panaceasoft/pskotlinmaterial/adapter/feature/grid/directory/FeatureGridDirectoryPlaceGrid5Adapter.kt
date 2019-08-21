package com.panaceasoft.pskotlinmaterial.adapter.feature.grid.directory

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
import kotlinx.android.synthetic.main.feature_grid_directory_place_grid_5_item.view.*
import java.util.*

/**
 * Created by Panacea-Soft on 18/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureGridDirectoryPlaceGrid5Adapter(private val placeArrayList: ArrayList<Place>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: Place, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_grid_directory_place_grid_5_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(reholder: RecyclerView.ViewHolder, position: Int) {

        if (reholder is PlaceViewHolder) {
            val place = placeArrayList[position]

            reholder.placeNameTextView.text = place.name

            val context = reholder.placeHolderCardView.context

            val id = Utils.getDrawableInt(context, place.imageName)
            Utils.setImageToImageView(context, reholder.placeImageView, id)

            reholder.percentTextView.text = place.discount
            reholder.ratingTextView.text = place.totalRating
            reholder.likeTextView.text = place.totalLike
            reholder.commentTextView.text = place.totalComment

            if (Integer.parseInt(place.discount) > 0) {
                reholder.discountCardView.visibility = View.VISIBLE
                val discount = place.discount + "%"
                reholder.percentTextView.text = discount
            } else {
                reholder.discountCardView.visibility = View.GONE
            }

            reholder.placeHolderCardView.setOnClickListener { view ->

                    itemClickListener.onItemClick(view, placeArrayList[position], position)

            }

        }

    }

    override fun getItemCount(): Int {
        return placeArrayList.size
    }

    inner class PlaceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var placeImageView: ImageView = view.placeImageView
        var placeNameTextView: TextView = view.placeNameTextView
        var percentTextView: TextView = view.percentTextView
        var ratingTextView: TextView = view.ratingTextView
        var discountCardView: CardView = view.discountCardView
        var placeHolderCardView: CardView = view.placeHolderCardView
        var likeTextView: TextView = view.likeTextView
        var commentTextView: TextView = view.commentTextView

    }

}
