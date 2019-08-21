package com.panaceasoft.pskotlinmaterial.activity.feature.detail.directory

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.repository.directory.PlaceRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_detail_directory_place_detail_1_activity.*

class FeatureDetailDirectoryPlaceDetail1Activity : AppCompatActivity() {

    internal lateinit var place: Place

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_detail_directory_place_detail_1_activity)

        initData()

        initToolbar()

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

    private fun initData() {

        // get place detail
        place = PlaceRepository.place
    }


    private fun initDataBindings() {

        try {
            val id = Utils.getDrawableInt(applicationContext, place.imageName)
            Utils.setImageToImageView(applicationContext, placeImageView, id)

            likeCountTextView.text = place.totalLike
            cmtCountTextView.text = place.totalComment
            distanceTextView.text = place.distance
            placeDescTextView.text = place.desc
            val rating = place.totalRating + " / " + place.totalReview + " ratings"
            ratingTextView.text = rating
            reviewCountTextView.text = place.totalReview
            addressTextView.text = place.address
            phoneTextView.text = place.phone
            websiteTextView.text = place.website
            emailTextView.text = place.email
            placeRatingBar.rating = java.lang.Float.parseFloat(place.totalRating)

            val gradientImg = R.drawable.black_alpha_70
            Utils.setImageToImageView(applicationContext, gradientImageView, gradientImg)

        } catch (e: Exception) {
            Log.e("TEAMPS", "initDataBindings: ", e)
        }

    }

    private fun initActions() {

        viewAllReviewsTextView.setOnClickListener { Toast.makeText(this, "View All is clicked", Toast.LENGTH_SHORT).show() }

        writeReviewTextView.setOnClickListener {  Toast.makeText(this, "Write Review is clicked", Toast.LENGTH_SHORT).show() }

        phoneTextView.setOnClickListener {  Toast.makeText(this, "Phone is clicked", Toast.LENGTH_SHORT).show() }

        websiteTextView.setOnClickListener { Toast.makeText(this, "Website is clicked", Toast.LENGTH_SHORT).show() }

        emailTextView.setOnClickListener {  Toast.makeText(this, "Email is clicked", Toast.LENGTH_SHORT).show() }
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = place.name

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

        val collapsingToolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbar)

        if (Utils.isRTL) {
            collapsingToolbarLayout.collapsedTitleGravity = Gravity.END
            collapsingToolbarLayout.expandedTitleGravity = Gravity.END or Gravity.BOTTOM
        } else {
            collapsingToolbarLayout.collapsedTitleGravity = Gravity.START
            collapsingToolbarLayout.expandedTitleGravity = Gravity.START or Gravity.BOTTOM
        }

    }
}
