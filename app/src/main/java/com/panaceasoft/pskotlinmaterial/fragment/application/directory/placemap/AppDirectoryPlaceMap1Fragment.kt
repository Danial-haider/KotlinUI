package com.panaceasoft.pskotlinmaterial.fragment.application.directory.placemap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_directory_place_map_1_fragment.view.*


/**
 * Created by Panacea-Soft on 2/6/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class AppDirectoryPlaceMap1Fragment : BottomSheetDialogFragment() {


    private lateinit var placeView: View
    private lateinit var placeName: String
    private lateinit var ratingValue: String
    private lateinit var distanceValue: String
    private lateinit var placeImage: String
    private lateinit var placeNameTextView: TextView
    private lateinit var ratingTextView: TextView
    private lateinit var distanceTextView: TextView
    private lateinit var placeImageView: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        placeView = inflater.inflate(R.layout.app_directory_place_map_1_fragment, container, false)

        placeNameTextView = placeView.placeNameTextView

        ratingTextView = placeView.ratingTextView

        distanceTextView = placeView.distanceTextView

        placeImageView = placeView.placeImageView

        val directionButton = placeView.directionButton

        directionButton.setOnClickListener { Toast.makeText(context, "Clicked Direction", Toast.LENGTH_SHORT).show() }

        val moreTextView = placeView.moreTextView

        moreTextView.setOnClickListener { Toast.makeText(context, "Clicked More", Toast.LENGTH_SHORT).show() }

        bindData()

        return placeView
    }

    fun replaceData(placeName: String, ratingCount: String, totalRating: String, distanceValue: String, placeImage: String) {
        this.placeName = placeName
        this.ratingValue = "$totalRating / $ratingCount Ratings"
        this.distanceValue = distanceValue
        this.placeImage = placeImage

        bindData()
    }

    private fun bindData() {
        placeView.placeNameTextView.text = placeName
        placeView.ratingTextView.text = ratingValue
        placeView.distanceTextView.text = distanceValue

        if (context != null) {
            val id = Utils.getDrawableInt(context, placeImage)
            Utils.setImageToImageView(context!!, placeImageView, id)
        }
    }
}