package com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.directory

import android.graphics.*
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.directory.FeatureDashboardDirectoryDashboard8Adapter
import com.panaceasoft.pskotlinmaterial.repository.directory.PlaceRepository
import kotlinx.android.synthetic.main.feature_dashboard_directory_dashboard_8_activity.*
import java.util.*

class FeatureDashboardDirectoryDashboard8Activity : AppCompatActivity(), GoogleMap.OnMarkerClickListener, OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var placeArrayList: ArrayList<Place>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_dashboard_directory_dashboard_8_activity)

        initData()

        initUI(savedInstanceState)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        initDataBinding(googleMap)
        initActions()
    }

    override fun onMarkerClick(marker: Marker): Boolean {

        return false
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_map, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(applicationContext, item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    //endregion

    //region Init Functions
    private fun initData() {
        placeArrayList = PlaceRepository.placeList
    }

    private fun initUI(savedInstanceState: Bundle?) {
        initToolbar()


        // Gets the MapView from the XML layout and creates it
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Directory Dashboard 8"

        try {
           toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.md_white_1000))
        } catch (e: Exception) {
            Log.e("TEAMPS", "Can't set color.")
        }

        try {
            setSupportActionBar(toolbar)
        } catch (e: Exception) {
            Log.e("TEAMPS", "Error in set support action bar.")
        }

        try {
            if (supportActionBar != null) {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
        } catch (e: Exception) {
            Log.e("TEAMPS", "Error in set display home as up enabled.")
        }

    }

    private fun initDataBinding(googleMap: GoogleMap) {

        mMap = googleMap
        mMap.setMinZoomPreference(12f)
        val region = LatLng(1.290270, 103.851959)

        for (i in placeArrayList.indices) {

            val markerColor = placeArrayList[i].markerColor
            val ob = BitmapFactory.decodeResource(this.resources, R.drawable.baseline_map_marker_24)
            val obm = Bitmap.createBitmap(ob.width, ob.height, ob.config)
            val canvas = Canvas(obm)
            val paint = Paint()
            paint.colorFilter = PorterDuffColorFilter(Color.parseColor(markerColor), PorterDuff.Mode.SRC_ATOP)
            canvas.drawBitmap(ob, 0f, 0f, paint)

            val onePlace = Place(placeArrayList[i].name, placeArrayList[i].imageName, placeArrayList[i].ratingCount, placeArrayList[i].totalRating)

            val customInfoWindow = FeatureDashboardDirectoryDashboard8Adapter(this)
            mMap.setInfoWindowAdapter(customInfoWindow)

            val markerOptions = MarkerOptions()
            markerOptions.position(LatLng(java.lang.Double.parseDouble(placeArrayList[i].lat), java.lang.Double.parseDouble(placeArrayList[i].lng)))
                    .anchor(0.5f, 0.5f)
                    .icon(BitmapDescriptorFactory.fromBitmap(obm))

            val m = mMap.addMarker(markerOptions)
            m.tag = onePlace
            m.showInfoWindow()
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(region))

    }


    private fun initActions() {
        mMap.setOnMarkerClickListener(this)
    }

    //endregion
}
