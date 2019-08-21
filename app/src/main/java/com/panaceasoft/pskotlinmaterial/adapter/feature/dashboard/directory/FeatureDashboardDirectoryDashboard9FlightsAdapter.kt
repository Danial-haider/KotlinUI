package com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.directory

import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.DirectoryHome9FlightsVO
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_dashboard_directory_dashboard_9_flights_item.view.*

class FeatureDashboardDirectoryDashboard9FlightsAdapter(private val flightsList: List<DirectoryHome9FlightsVO>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, flight: DirectoryHome9FlightsVO, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val flightsView = LayoutInflater.from(parent.context).inflate(R.layout.feature_dashboard_directory_dashboard_9_flights_item, parent, false)
        return FlightsViewHolder(flightsView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FlightsViewHolder) {
            val flightsVO = flightsList[position]
            val context = holder.flightsImageView.context

            holder.flightsTitleTextView.text = flightsVO.country
            holder.flightsDescTextView.text = flightsVO.description
            holder.flightsPeriodTextView.text = "Travel Period- " + flightsVO.duration
            holder.flightsPriceTextView.text = flightsVO.price

            val flightImageId = Utils.getDrawableInt(context, flightsVO.image)
            Utils.setImageToImageView(context, holder.flightsImageView, flightImageId)

                holder.flightsCardView.setOnClickListener { view -> itemClickListener.onItemClick(view, flightsList[position], position) }

        }
    }

    override fun getItemCount(): Int {
        return flightsList.size
    }

    inner class FlightsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var flightsCardView: CardView
        internal var flightsImageView: ImageView
        internal var flightsTitleTextView: TextView
        internal var flightsDescTextView: TextView
        internal var flightsPriceTextView: TextView
        internal var flightsPeriodTextView: TextView

        init {

            flightsCardView = itemView.flightCardView
            flightsImageView = itemView.flightsImageView
            flightsTitleTextView = itemView.flightsTitleTextView
            flightsDescTextView = itemView.flightsDescTextView
            flightsPriceTextView = itemView.flightsPriceTextView
            flightsPeriodTextView = itemView.flightsPeriodTextView
        }
    }
}
