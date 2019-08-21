package com.panaceasoft.pskotlinmaterial.activity.feature.detail.directory

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.repository.directory.PlaceRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_detail_directory_place_detail_3_activity.*

class FeatureDetailDirectoryPlaceDetail3Activity : AppCompatActivity(), OnMapReadyCallback {

    // data
    internal lateinit var place: Place
    internal lateinit var mapView: MapView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_detail_directory_place_detail_3_activity)

        initData()

        initUI(savedInstanceState)

        initDataBindings()

        initActions()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        googleMap.setMinZoomPreference(12f)
        val ny = LatLng(16.848728, 96.179651)

        val markerOptions = MarkerOptions()
        markerOptions.position(ny)
        googleMap.addMarker(markerOptions)

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(ny))
    }

    public override fun onResume() {
        mapView.onResume()
        super.onResume()
    }

    public override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    public override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    private fun initData() {

        // get place detail
        place = PlaceRepository.place
    }

    private fun initUI(savedInstanceState: Bundle?) {
        mapView = findViewById(R.id.placeMapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

    }

    private fun initDataBindings() {

        placeNameTextView.text = place.name
        phoneTextView.text = place.phone
        websiteTextView.text = place.website
        addressTextView.text = place.address
        openingTimeTextView.text = place.opening
        bookingTimeTextView.text = place.bookingTime

        val id = R.drawable.rider_bar_img
        Utils.setImageToImageView(applicationContext, placeImageView, id)

    }

    private fun initActions() {

        bookButton.setOnClickListener { Toast.makeText(this, "Clicked Book Now.", Toast.LENGTH_SHORT).show() }
        backImageView.setOnClickListener { this.finish() }
        moreImageView.setOnClickListener { Toast.makeText(this, "Clicked More.", Toast.LENGTH_SHORT).show() }
    }
}
