package com.panaceasoft.pskotlinmaterial.activity.feature.map.directory

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.adapter.feature.map.FeatureMapDirectoryMap4Adapter
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.repository.directory.PlaceRepository
import kotlinx.android.synthetic.main.feature_map_directory_map_4_activity.*

import java.util.ArrayList

class FeatureMapDirectoryMap4Activity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var placeArrayList: ArrayList<Place>
    internal lateinit var mAdapter: FeatureMapDirectoryMap4Adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_map_directory_map_4_activity)

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
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
        mapView.isFocusable = true

        mAdapter = FeatureMapDirectoryMap4Adapter(placeArrayList)

        // get recycler view
        val mLayoutManager = LinearLayoutManager(applicationContext)
        placeList1RecyclerView.layoutManager = mLayoutManager
        placeList1RecyclerView.itemAnimator = DefaultItemAnimator()
        placeList1RecyclerView.isFocusable = false

        searchEditText.isFocusable = false


        mAdapter.setOnItemClickListener(object : FeatureMapDirectoryMap4Adapter.OnItemClickListener{
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
        placeList1RecyclerView.adapter = mAdapter

    }

    //endregion
}
