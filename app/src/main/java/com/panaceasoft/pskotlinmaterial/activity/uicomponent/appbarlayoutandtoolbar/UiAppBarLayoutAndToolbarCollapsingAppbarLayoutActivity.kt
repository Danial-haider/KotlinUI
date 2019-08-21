package com.panaceasoft.pskotlinmaterial.activity.uicomponent.appbarlayoutandtoolbar

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.ui_app_bar_layout_and_toolbar_collapsing_appbar_layout_activity.*

class UiAppBarLayoutAndToolbarCollapsingAppbarLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_app_bar_layout_and_toolbar_collapsing_appbar_layout_activity)

        initToolbar()

        Utils.setImageToImageView(applicationContext, image1ImageView, R.drawable.cafe1)

    }


    //region Init Toolbar
    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Collapsing Appbar Layout"

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


        if (Utils.isRTL) {
            collapsingToolbar.collapsedTitleGravity = Gravity.END
            collapsingToolbar.expandedTitleGravity = Gravity.END or Gravity.BOTTOM
        } else {
            collapsingToolbar.collapsedTitleGravity = Gravity.START
            collapsingToolbar.expandedTitleGravity = Gravity.START or Gravity.BOTTOM
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    //endregion

}

