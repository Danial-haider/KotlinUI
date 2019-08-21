package com.panaceasoft.pskotlinmaterial.activity.uicomponent.bottomappbar

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_bottom_app_bar_bottom_navigation_view_fab_activity.*


class UiBottomAppBarBottomNavigationViewFabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_bottom_app_bar_bottom_navigation_view_fab_activity)

        initToolbar()

        bottomNavigationView.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.favoriteMenu ->
                    //bnvTextView.setText("Favorite Menu is selected");
                    Toast.makeText(applicationContext, "Favourite Menu is selected.",
                            Toast.LENGTH_LONG).show()
                R.id.bookmarkMenu ->
                    //bnvTextView.setText("Dashboard Menu is selected");
                    Toast.makeText(applicationContext, "Bookmark Menu is selected.",
                            Toast.LENGTH_LONG).show()
            }
            false
        }

        floatingActionButton.setOnClickListener {
            Toast.makeText(applicationContext, "Home Menu is selected.",
                    Toast.LENGTH_LONG).show()
        }
    }

    //region Init Toolbar

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Bottom Navigation View with FAB"

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