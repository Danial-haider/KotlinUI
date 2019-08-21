package com.panaceasoft.pskotlinmaterial.fragment.feature.map.directory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils


/**
 * Created by Panacea-Soft on 20/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureMapDirectoryMap1Fragment : BottomSheetDialogFragment() {


    lateinit var placeView: View
    private lateinit var placeName: String
    private lateinit var ratingValue: String
    private lateinit var distanceValue: String
    private lateinit var placeImage: String
    private lateinit var placeNameTextView: TextView
    private lateinit var ratingTextView: TextView
    private lateinit var distanceTextView: TextView
    private lateinit var placeImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        placeView = inflater.inflate(R.layout.feature_map_directory_map_1_fragment, container, false)

        placeNameTextView = placeView.findViewById(R.id.placeNameTextView)

        ratingTextView = placeView.findViewById(R.id.ratingTextView)

        distanceTextView = placeView.findViewById(R.id.distanceTextView)

        placeImageView = placeView.findViewById(R.id.placeImageView)

        val directionButton = placeView.findViewById<Button>(R.id.directionButton)

        directionButton.setOnClickListener {  Toast.makeText(context, "Clicked Direction", Toast.LENGTH_SHORT).show() }

        val moreTextView = placeView.findViewById<TextView>(R.id.moreTextView)

        moreTextView.setOnClickListener {  Toast.makeText(context, "Clicked More", Toast.LENGTH_SHORT).show() }


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

    fun bindData() {

            placeNameTextView.text = placeName
            ratingTextView.text = ratingValue
            distanceTextView.text = distanceValue



            if (context != null) {
                val id = Utils.getDrawableInt(context, placeImage)
                Utils.setImageToImageView(context!!, placeImageView, id)


        }

    }


}// Required empty public constructor