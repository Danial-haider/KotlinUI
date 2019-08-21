package com.panaceasoft.pskotlinmaterial.activity.uicomponent.bottomappbar

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_bottom_app_bar_with_fab_activity.*

class UiBottomAppBarWithFabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_bottom_app_bar_with_fab_activity)

        initToolbar()

        bottomAppBar.replaceMenu(R.menu.menu_bottom_app_bar)

        floatingActionButton.setOnClickListener {  Toast.makeText(this@UiBottomAppBarWithFabActivity, "Clicked fab.", Toast.LENGTH_SHORT).show() }

        bottomAppBar.setOnMenuItemClickListener { item ->
            if (item.itemId == android.R.id.home) {
                finish()
            } else {
                val id = item.itemId
                when (id) {
                    R.id.calendar -> Toast.makeText(this@UiBottomAppBarWithFabActivity, "Clicked calendar.", Toast.LENGTH_SHORT).show()
                    R.id.share -> Toast.makeText(this@UiBottomAppBarWithFabActivity, "Clicked share.", Toast.LENGTH_SHORT).show()
                    R.id.pie -> Toast.makeText(this@UiBottomAppBarWithFabActivity, "Clicked pie.", Toast.LENGTH_SHORT).show()
                }
            }
            false
        }

        bottomAppBar.setNavigationOnClickListener {  Toast.makeText(this@UiBottomAppBarWithFabActivity, "Clicked menu.", Toast.LENGTH_SHORT).show() }
    }

    //region Init Toolbar

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "BottomAppBar with Icon"

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
