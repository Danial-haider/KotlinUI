package com.panaceasoft.pskotlinmaterial.activity.feature.profile.ecommerce

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.*
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
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
import com.panaceasoft.pskotlinmaterial.adapter.feature.profile.ecommerce.FeatureProfileECommerceProfile2Adapter
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_profile_ecommerce_profile_2_activity.*

class FeatureProfileECommerceProfile2Activity : AppCompatActivity(), GoogleMap.OnMarkerClickListener, OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_profile_ecommerce_profile_2_activity)

        initData()

        initUI(savedInstanceState)

        initDataBindings()

    }

    override fun onMapReady(googleMap: GoogleMap) {
        try {
            initDataBinding(googleMap)
            initActions()
        } catch (ignored: Exception) {
        }

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

    }

    private fun initDataBinding(googleMap: GoogleMap) {

        mMap = googleMap
        mMap.setMinZoomPreference(12f)

        val region = LatLng(1.290270, 103.851959)

        val markerColor = "#BD10E0"
        val ob = BitmapFactory.decodeResource(this.resources, R.drawable.baseline_map_marker_24)
        val obm = Bitmap.createBitmap(ob.width, ob.height, ob.config)
        val canvas = Canvas(obm)
        val paint = Paint()
        paint.colorFilter = PorterDuffColorFilter(Color.parseColor(markerColor), PorterDuff.Mode.SRC_ATOP)
        canvas.drawBitmap(ob, 0f, 0f, paint)

        val onePlace = Place("MM Fashion Store", "shop_info_1", "40", "5.0")

        val customInfoWindow = FeatureProfileECommerceProfile2Adapter(this)
        mMap.setInfoWindowAdapter(customInfoWindow)

        val markerOptions = MarkerOptions()
        markerOptions.position(LatLng(java.lang.Double.parseDouble("1.290270"), java.lang.Double.parseDouble("103.851959")))
                .anchor(0.5f, 0.5f)
                .icon(BitmapDescriptorFactory.fromBitmap(obm))

        val m = mMap.addMarker(markerOptions)
        m.tag = onePlace
        m.showInfoWindow()

        mMap.moveCamera(CameraUpdateFactory.newLatLng(region))

    }

    private fun initUI(savedInstanceState: Bundle?) {
        initToolbar()

        val shopImageVIew = findViewById<ImageView>(R.id.shopImageVIew)
        val id = R.drawable.shop_info_1
        Utils.setImageToImageView(applicationContext, shopImageVIew, id)

        // Gets the MapView from the XML layout and creates it
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

    }

    private fun initDataBindings() {

    }

    private fun initActions() {
        emailTextView.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_VIEW)
                val data = Uri.parse("mailto:?subject=" + "Hello" + "&body=" + "About Awesome Material App")
                intent.data = data
                intent.putExtra(Intent.EXTRA_EMAIL, emailTextView.text.toString())
                startActivity(intent)

            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
            }
        }

        phoneTextView.setOnClickListener {
            try {

                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneTextView.text.toString()))
                startActivity(intent)

            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
            }
        }

        websiteTextView.setOnClickListener {
            try {
                val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse(websiteTextView.text.toString()))
                startActivity(myIntent)
            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
            }
        }

        mMap.setOnMarkerClickListener(this)

    }

    private fun initToolbar() {
        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Profile 2 (For Shop)"

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
    //endregion
}
