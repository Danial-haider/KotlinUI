package com.panaceasoft.pskotlinmaterial.activity.feature.map.directory

import android.graphics.*
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.fragment.feature.map.directory.FeatureMapDirectoryMap1Fragment
import com.panaceasoft.pskotlinmaterial.repository.directory.PlaceRepository
import kotlinx.android.synthetic.main.feature_map_directory_map_1_activity.*
import java.util.*

class FeatureMapDirectoryMap1Activity : AppCompatActivity(), GoogleMap.OnMarkerClickListener, OnMapReadyCallback {

    private lateinit var mapView: MapView
    private lateinit var mMap: GoogleMap
    private lateinit var placeArrayList: ArrayList<Place>
    private  val bottomSheetFragment = FeatureMapDirectoryMap1Fragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_map_directory_map_1_activity)

        //Init Functions
        initData()

        initUI(savedInstanceState)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        initDataBinding(googleMap)
        initActions()
    }

    override fun onMarkerClick(marker: Marker): Boolean {

        val selectedIndex = marker.tag as Int?

        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        bottomSheetFragment.replaceData(placeArrayList[selectedIndex!!].name,
                placeArrayList[selectedIndex].ratingCount,
                placeArrayList[selectedIndex].totalRating,
                placeArrayList[selectedIndex].distance,
                placeArrayList[selectedIndex].imageName)

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

    //region Init Functions
    private fun initData() {
        placeArrayList = PlaceRepository.placeList
    }

    private fun initUI(savedInstanceState: Bundle?) {
        //initToolbar();

        // Gets the MapView from the XML layout and creates it
        mapView = findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)


        menuImageView.setOnClickListener { finish() }
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


            mMap.addMarker(MarkerOptions()
                    .position(LatLng(java.lang.Double.parseDouble(placeArrayList[i].lat), java.lang.Double.parseDouble(placeArrayList[i].lng)))
                    .anchor(0.5f, 0.5f)
                    .icon(BitmapDescriptorFactory.fromBitmap(obm))
            ).tag = i

        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(region))

    }


    private fun initActions() {

        mMap.setOnMarkerClickListener(this)

        clearImageView.setOnClickListener { searchEditText.setText("") }

        micImageView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Mic", Toast.LENGTH_SHORT).show() }
    }

    //endregion
}
