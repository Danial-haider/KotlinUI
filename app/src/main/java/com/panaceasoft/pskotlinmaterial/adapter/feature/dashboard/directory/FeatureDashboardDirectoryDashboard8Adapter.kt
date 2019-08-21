package com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.directory

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.utils.Utils

/**
 * Created by Panacea-Soft on 7/29/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class FeatureDashboardDirectoryDashboard8Adapter(private val context: Context) : GoogleMap.InfoWindowAdapter {

    override fun getInfoWindow(marker: Marker): View? {
        return null
    }

    override fun getInfoContents(marker: Marker): View {
        val view = (context as Activity).layoutInflater
                .inflate(R.layout.feature_dashboard_directory_dashboard_8_item, null)

        val placeNameTextView = view.findViewById<TextView>(R.id.placeNameTextView)
        val ratingTextView = view.findViewById<TextView>(R.id.ratingTextView)
        val placeImageView = view.findViewById<ImageView>(R.id.placeImageView)

        val place = marker.tag as Place?

        if (place != null) {
            placeNameTextView.text = place.name
            val ratingStr = place.totalRating + " / " + place.ratingCount + " Ratings"
            ratingTextView.text = ratingStr

            Log.d("TEAMPS >> ", place.imageName)

            val id = Utils.getDrawableInt(context, place.imageName)

            Glide.with(view.context)
                    .asBitmap()
                    .load(id)
                    .listener(object : RequestListener<Bitmap> {
                        override fun onResourceReady(resource: Bitmap, model: Any, target: Target<Bitmap>, dataSource: DataSource, isFirstResource: Boolean): Boolean {
                            if (marker.isInfoWindowShown) {
                                marker.hideInfoWindow()
                                marker.showInfoWindow()
                            }
                            return false
                        }

                        override fun onLoadFailed(e: GlideException?, model: Any, target: Target<Bitmap>, isFirstResource: Boolean): Boolean {
                            return false
                        }

                    })
                    .into(placeImageView)


        }
        return view
    }
}
