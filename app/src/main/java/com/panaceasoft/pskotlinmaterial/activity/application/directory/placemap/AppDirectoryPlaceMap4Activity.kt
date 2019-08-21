package com.panaceasoft.pskotlinmaterial.activity.application.directory.placemap

import android.graphics.*
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.adapter.application.directory.placemap.AppDirectoryPlaceMap4Adapter
import com.panaceasoft.pskotlinmaterial.repository.directory.PlaceRepository
import java.util.*

class AppDirectoryPlaceMap4Activity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mapView: MapView
    private lateinit var mMap: GoogleMap
    private lateinit var placeArrayList: ArrayList<Place>
    internal lateinit var recyclerView: RecyclerView
    internal lateinit var mAdapter: AppDirectoryPlaceMap4Adapter
    private lateinit var searchEditText: EditText

    //region Override Functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_directory_place_map_4_activity)

        //Init Functions
        initData()

        initUI(savedInstanceState)

    }


    override fun onMapReady(googleMap: GoogleMap) {
        initDataBinding(googleMap)
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
    //endregion

    //region Init Functions
    private fun initData() {
        placeArrayList = PlaceRepository.placeList
    }

    private fun initUI(savedInstanceState: Bundle?) {

        // Gets the MapView from the XML layout and creates it
        mapView = findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
        mapView.isFocusable = true

        mAdapter = AppDirectoryPlaceMap4Adapter(placeArrayList)

        // get recycler view
        recyclerView = findViewById(R.id.placeList1RecyclerView)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.isFocusable = false

        searchEditText = findViewById(R.id.searchEditText)
        searchEditText.isFocusable = false

        mAdapter.setOnItemClickListener(object : AppDirectoryPlaceMap4Adapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: Place, position: Int) {
                Toast.makeText(applicationContext, "Selected " + obj.name, Toast.LENGTH_SHORT).show()
            }
        })

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

        // bind adapter to recycler
        recyclerView.adapter = mAdapter

    }

    //endregion
}

