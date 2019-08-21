package com.panaceasoft.pskotlinmaterial.activity.feature.menu.general

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_menu_general_menu_7_activity.*

class FeatureMenuGeneralMenu7Activity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    internal lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_menu_general_menu_7_activity)

        initUI()
    }

    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.nav_home) {
            Toast.makeText(this, "Clicked Home.", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.nav_category) {
            Toast.makeText(this, "Clicked Category.", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.nav_feature) {
            Toast.makeText(this, "Clicked Feature.", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.nav_popular) {
            Toast.makeText(this, "Clicked Popular.", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.nav_recent) {
            Toast.makeText(this, "Clicked Recent.", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.nav_search) {
            Toast.makeText(this, "Clicked Search.", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.nav_profile) {
            Toast.makeText(this, "Clicked Profile.", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.nav_favourite) {
            Toast.makeText(this, "Clicked Favourite.", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.nav_logout) {
            Toast.makeText(this, "Clicked Logout.", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.nav_about_us) {
            Toast.makeText(this, "Clicked About Us.", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.nav_contact_us) {
            Toast.makeText(this, "Clicked Contact Us.", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.nav_setting) {
            Toast.makeText(this, "Clicked Setting.", Toast.LENGTH_SHORT).show()
        }

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true

    }

    private fun initUI() {
        initToolbar()

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()


        nav_view.setNavigationItemSelectedListener(this)
        if (Utils.isRTL) {
            nav_view.textDirection = View.TEXT_DIRECTION_RTL
        } else {
            nav_view.textDirection = View.TEXT_DIRECTION_LTR
        }

        val headerLayout = nav_view.getHeaderView(0)
        val userImageView = headerLayout.findViewById<ImageView>(R.id.userImageView)
        Utils.setCircleImageToImageView(this, userImageView, R.drawable.profile1, 0, 0)
    }

    private fun initToolbar() {

        toolbar = findViewById(R.id.toolbar)

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Menu 7"

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
