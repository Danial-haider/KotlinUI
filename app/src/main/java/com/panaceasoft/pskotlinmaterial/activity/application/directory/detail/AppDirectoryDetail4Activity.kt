package com.panaceasoft.pskotlinmaterial.activity.application.directory.detail

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
import kotlinx.android.synthetic.main.app_directory_detail_4_activity.*

class AppDirectoryDetail4Activity : AppCompatActivity() {

    // data variables
    internal lateinit var place: Place

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_directory_detail_4_activity)

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

        val id = Utils.getDrawableInt(applicationContext, place.imageName)
        Utils.setImageToImageView(applicationContext, placeImageView, id)

        totalLikeTextView.text = place.totalLike
        totalCmtTextView.text = place.totalComment
        phoneTextView.text = place.phone
        websiteTextView.text = place.website
        openingTextView.text = place.opening
        addressTextView.text = place.address
        distanceTextView.text = place.distance
        placeDescTextView.text = place.desc
        totalReviewTextView.text = place.totalReview

        val rating = place.totalRating + " / " + place.ratingCount + " ratings"
        ratingTextView.text = rating

        Utils.setCircleImageToImageView(applicationContext, user1ImageView, R.drawable.man_profile, 5, R.color.md_white_1000)

        Utils.setCircleImageToImageView(applicationContext, user2ImageView, R.drawable.woman_profile, 5, R.color.md_white_1000)

    }

    private fun initActions() {

        favFloatingActionButton.setOnClickListener { Toast.makeText(this, "Clicked Fav Button.", Toast.LENGTH_SHORT).show() }

        writeReviewTextView.setOnClickListener { Toast.makeText(this, "Clicked Write Review Button.", Toast.LENGTH_SHORT).show() }

        viewAllTextView.setOnClickListener { Toast.makeText(this, "Clicked View All.", Toast.LENGTH_SHORT).show() }
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Place Detail 4"

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