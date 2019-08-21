package com.panaceasoft.pskotlinmaterial.activity.uicomponent.appbarlayoutandtoolbar

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.ui_app_bar_layout_and_toolbar_collapse_and_pin_activity.*

class UiAppBarLayoutAndToolbarCollapseAndPinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_app_bar_layout_and_toolbar_collapse_and_pin_activity)

        initUI()

        initActions()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(this, "Clicked " + item.title, Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }


    private fun initUI() {

        initToolbar()
        val id1 = Utils.getDrawableInt(applicationContext, "cafe3")
        Utils.setImageToImageView(applicationContext, coverPhotoImageView, id1)

    }

    private fun initActions() {
        likeImageView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Like.", Toast.LENGTH_SHORT).show() }
        faceImageView.setOnClickListener {  Toast.makeText(applicationContext, "Clicked Happy.", Toast.LENGTH_SHORT).show() }
        commentImageView.setOnClickListener {  Toast.makeText(applicationContext, "Clicked Comment.", Toast.LENGTH_SHORT).show() }
        shareImageView.setOnClickListener {  Toast.makeText(applicationContext, "Clicked Share.", Toast.LENGTH_SHORT).show() }
        fab.setOnClickListener {  Toast.makeText(applicationContext, "Clicked Floating Action Button.", Toast.LENGTH_SHORT).show() }

    }

    private fun initToolbar() {

        toolbarbacklongarrow.setNavigationIcon(R.drawable.baseline_back_arrow_long_24)

        if (toolbarbacklongarrow.navigationIcon != null) {
            toolbarbacklongarrow.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)

        }

        toolbarbacklongarrow.title = "Lorem ipsum dolor sit amet."

        try {

            toolbarbacklongarrow.setTitleTextColor(ContextCompat.getColor(this,R.color.md_white_1000))

        } catch (e: Exception) {
            Log.e("TEAMPS", "Can't set color.")
        }

        try {
            setSupportActionBar(toolbarbacklongarrow)
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
            collapsing_toolbar.collapsedTitleGravity = Gravity.END
            collapsing_toolbar.expandedTitleGravity = Gravity.END or Gravity.BOTTOM
        } else {
            collapsing_toolbar.collapsedTitleGravity = Gravity.START
            collapsing_toolbar.expandedTitleGravity = Gravity.START or Gravity.BOTTOM
        }

    }
}
