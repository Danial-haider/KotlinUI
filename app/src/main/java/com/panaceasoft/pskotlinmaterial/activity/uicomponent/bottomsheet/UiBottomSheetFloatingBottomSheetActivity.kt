package com.panaceasoft.pskotlinmaterial.activity.uicomponent.bottomsheet

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.custom_layout_bottom_sheet_basic.*
import kotlinx.android.synthetic.main.ui_bottom_sheet_floating_bottom_sheet_activity.*


class UiBottomSheetFloatingBottomSheetActivity : AppCompatActivity() {

    lateinit var bottomSheetBehavior: BottomSheetBehavior<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_bottom_sheet_floating_bottom_sheet_activity)

        initToolbar()

        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)

        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {

                    BottomSheetBehavior.STATE_COLLAPSED -> openBSButton.text = "Expand Bottom Sheet"

                    BottomSheetBehavior.STATE_EXPANDED -> openBSButton.text = "Close Bottom Sheet"
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
        })

        openBSButton.setOnClickListener {
            if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                openBSButton.text = "Close Bottom Sheet"
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                openBSButton.text = "Expand Bottom Sheet"
            }
        }
    }

    //region Init Toolbar

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Floating Bottom Sheet"

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
