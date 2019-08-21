package com.panaceasoft.pskotlinmaterial.activity.uicomponent.snackbars

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_snack_bars_snack_bar_and_lift_fab_activity.*

class UiSnackBarsSnackBarAndLiftFabActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_snack_bars_snack_bar_and_lift_fab_activity)

        initToolbar()

        snackBarButton.setOnClickListener {

            val snackbar = Snackbar
                    .make(linearLayout, "Awesome Material is one of the featured item of Panacea-Soft.", Snackbar.LENGTH_LONG)

            snackbar.show()
        }
        floatingActionBtn.setOnClickListener {  Toast.makeText(this@UiSnackBarsSnackBarAndLiftFabActivity, "Clicked FloatingActionButton", Toast.LENGTH_SHORT).show() }
    }

    //region Init Toolbar

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "SnackBar and Lift FAB"

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