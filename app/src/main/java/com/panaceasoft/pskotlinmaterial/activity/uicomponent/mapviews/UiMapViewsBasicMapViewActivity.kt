package com.panaceasoft.pskotlinmaterial.activity.uicomponent.mapviews

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_map_views_basic_map_view_basic_activity.*


class UiMapViewsBasicMapViewActivity : AppCompatActivity(), OnMapReadyCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_map_views_basic_map_view_basic_activity)

        initToolbar()

        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
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


    //region Init Toolbar

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Basic MapView"

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        googleMap.setMinZoomPreference(12f)
        val ny = LatLng(16.848728, 96.179651)

        val markerOptions = MarkerOptions()
        markerOptions.position(ny).title("User Pin ")
        googleMap.addMarker(markerOptions)
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(ny))
    }
}
