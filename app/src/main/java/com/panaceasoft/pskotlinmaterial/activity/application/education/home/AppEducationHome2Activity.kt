package com.panaceasoft.pskotlinmaterial.activity.application.education.home

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_education_home_2_activity.*

class AppEducationHome2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_education_home_2_activity)

        initData()

        initToolbar()

        initDataBinding()

        initActions()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_basket, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    //region Init Functions
    private fun initData() {

    }


    private fun initDataBinding() {

        Utils.setImageToImageView(this, promotionImageView, R.drawable.education_img_9)
        Utils.setImageToImageView(this, gradientImageView, R.drawable.black_alpha_70)

        Utils.setImageToImageView(this, stationaryImageView, R.drawable.education_home2_img_1)
        Utils.setImageToImageView(this, booksImageView, R.drawable.education_home2_img_2)
        Utils.setImageToImageView(this, tutorImageView, R.drawable.education_home2_img_3)
        Utils.setImageToImageView(this, institutionImageView, R.drawable.education_home2_img_4)

    }

    private fun initActions() {

        gradientImageView.setOnClickListener { Toast.makeText(this, "Clicked Promotion.", Toast.LENGTH_SHORT).show() }

        stationaryImageView.setOnClickListener { Toast.makeText(this, "Clicked Stationary.", Toast.LENGTH_SHORT).show() }

        booksImageView.setOnClickListener { Toast.makeText(this, "Clicked Books.", Toast.LENGTH_SHORT).show() }

        tutorImageView.setOnClickListener {Toast.makeText(this, "Clicked Private Tutor.", Toast.LENGTH_SHORT).show() }

        institutionImageView.setOnClickListener { Toast.makeText(this, "Clicked Private Institution.", Toast.LENGTH_SHORT).show() }

        filterTextView.setOnClickListener { Toast.makeText(this, "Clicked Filter.", Toast.LENGTH_SHORT).show() }

    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Home 2"

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

