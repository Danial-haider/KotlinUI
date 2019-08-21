package com.panaceasoft.pskotlinmaterial.activity.uicomponent.bottomappbar

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_bottom_app_bar_bottom_navigation_view_with_icon_activity.*

class UiBottomAppBarBottomNavigationViewWithIconActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_bottom_app_bar_bottom_navigation_view_with_icon_activity)

        initToolbar()

        bottomNavigationViewWithIcon.setOnNavigationItemSelectedListener { item ->
            if (item.itemId == android.R.id.home) {
                finish()
            } else {
                when (item.itemId) {
                    R.id.homeMenu -> {
                    }
                    R.id.shopCatMenu -> {
                    }
                    R.id.trendingMenu -> {
                    }
                    R.id.announceMenu -> {
                    }
                    R.id.favMenu -> {
                    }
                }
            }

            true
        }

    }

    //region Init Toolbar

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Bottom Navigation View with Icon"

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

}
