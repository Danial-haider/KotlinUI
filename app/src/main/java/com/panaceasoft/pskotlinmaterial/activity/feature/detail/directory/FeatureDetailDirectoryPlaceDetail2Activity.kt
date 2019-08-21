package com.panaceasoft.pskotlinmaterial.activity.feature.detail.directory


import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.adapter.feature.detail.directory.FeatureDetailDirectoryPlaceDetail2PagerAdapter
import com.panaceasoft.pskotlinmaterial.repository.directory.PlaceRepository
import kotlinx.android.synthetic.main.feature_detail_directory_place_detail_2_activity.*
import java.util.*

class FeatureDetailDirectoryPlaceDetail2Activity : AppCompatActivity(), OnMapReadyCallback {

    // data variables
    internal lateinit var place: Place

    // ui lateinit variables

    internal lateinit var mapView: MapView
    internal lateinit var pagerAdapter: FeatureDetailDirectoryPlaceDetail2PagerAdapter
    internal lateinit var imageViewPager: ViewPager
    internal lateinit var pager_indicator: LinearLayout
    private lateinit var dots: Array<ImageView?>
    private var dotsCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_detail_directory_place_detail_2_activity)

        initData()

        initUI(savedInstanceState)

        initDataBindings()

        initActions()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_more, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(this, "Clicked " + item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
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

        val imageList = ArrayList<String>()

        for (i in place.imageList.indices) {

            imageList.add(place.imageList[i].imageName)
        }
        pagerAdapter = FeatureDetailDirectoryPlaceDetail2PagerAdapter(this, imageList)

    }

    private fun initUI(savedInstanceState: Bundle?) {

        initToolbar()

        val toolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbar)
        toolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this,android.R.color.transparent))

        imageViewPager = findViewById(R.id.imageViewPager)
        pager_indicator = findViewById(R.id.viewPagerCountDots)

        mapView = findViewById(R.id.placeMapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

    }


    private fun initDataBindings() {

        imageViewPager.adapter = pagerAdapter
        setupSliderPagination()

        likeCountTextView.text = place.totalLike
        cmtCountTextView.text = place.totalComment
        distanceTextView.text = place.distance
        placeDescTextView.text = place.desc
        ratingTextView.text = place.totalRating
        placeRatingBar.rating = java.lang.Float.parseFloat(place.totalRating)
        reviewCountTextView.text = place.totalReview
        addressTextView.text = place.address
        phoneTextView.text = place.phone
        websiteTextView.text = place.website
        emailTextView.text = place.email
    }

    private fun initActions() {
        imageViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {


                setupSliderPagination()


                for (i in 0 until dotsCount) {
                    dots[i]?.setImageDrawable(ContextCompat.getDrawable(this@FeatureDetailDirectoryPlaceDetail2Activity,R.drawable.nonselecteditem_dot))
                }

                dots[position]?.setImageDrawable(ContextCompat.getDrawable(this@FeatureDetailDirectoryPlaceDetail2Activity,R.drawable.selecteditem_dot))
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        directionLayout.setOnClickListener { Toast.makeText(this, "Clicked Direction.", Toast.LENGTH_SHORT).show() }
        callLayout.setOnClickListener { Toast.makeText(this, "Clicked Call.", Toast.LENGTH_SHORT).show() }
        websiteLayout.setOnClickListener {  Toast.makeText(this, "Clicked Website.", Toast.LENGTH_SHORT).show() }

        phoneTextView.setOnClickListener { Toast.makeText(this, "Clicked Phone.", Toast.LENGTH_SHORT).show() }
        emailTextView.setOnClickListener {  Toast.makeText(this, "Clicked Email.", Toast.LENGTH_SHORT).show() }
        websiteTextView.setOnClickListener { Toast.makeText(this, "Clicked Website.", Toast.LENGTH_SHORT).show() }

    }

    fun setupSliderPagination() {

        dotsCount = pagerAdapter.count

        if (dotsCount > 0) {

            dots = arrayOfNulls(dotsCount)


            if (pager_indicator.childCount > 0) {
                pager_indicator.removeAllViewsInLayout()

            }

            for (i in 0 until dotsCount) {
                dots[i] = ImageView(this)
                dots[i]?.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.nonselecteditem_dot))

                val params = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )

                params.setMargins(4, 0, 4, 0)

                pager_indicator.addView(dots[i], params)
            }

            dots[0]?.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.selecteditem_dot))

        }
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = ""

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
}
