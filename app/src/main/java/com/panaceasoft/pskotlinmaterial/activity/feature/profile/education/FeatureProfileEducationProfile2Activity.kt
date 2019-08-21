package com.panaceasoft.pskotlinmaterial.activity.feature.profile.education

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
import kotlinx.android.synthetic.main.feature_profile_education_profile_2_activity.*

class FeatureProfileEducationProfile2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_profile_education_profile_2_activity)

        initUI()


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_setting, menu)
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

    private fun initUI() {
        initToolbar()

        val id1 = Utils.getDrawableInt(applicationContext, "badge_1")
        Utils.setCircleImageToImageView(applicationContext, badge1ImageView, id1, 0, 0)

        val id2 = Utils.getDrawableInt(applicationContext, "badge_2")
        Utils.setCircleImageToImageView(applicationContext, badge2ImageView, id2, 0, 0)

        val id3 = Utils.getDrawableInt(applicationContext, "badge_3")
        Utils.setCircleImageToImageView(applicationContext, badge3ImageView, id3, 0, 0)

        val id4 = Utils.getDrawableInt(applicationContext, "badge_4")
        Utils.setCircleImageToImageView(applicationContext, badge4ImageView, id4, 0, 0)

        val id5 = Utils.getDrawableInt(applicationContext, "badge_5")
        Utils.setCircleImageToImageView(applicationContext, badge5ImageView, id5, 0, 0)

        val id6 = Utils.getDrawableInt(applicationContext, "badge_6")
        Utils.setCircleImageToImageView(applicationContext, badge6ImageView, id6, 0, 0)

        val id7 = Utils.getDrawableInt(applicationContext, "profile1")
        Utils.setCircleImageToImageView(applicationContext, profileImageView, id7, 10, R.color.md_grey_200)

        Utils.setImageToImageView(applicationContext, bgImageView, R.drawable.edu_profile_2_bg)

    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Profile 2"

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
