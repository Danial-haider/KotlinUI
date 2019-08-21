package com.panaceasoft.pskotlinmaterial.activity.uicomponent.fab

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.ui_fab_submenu_fab_activity.*

class UiFabSubMenuFabActivity : AppCompatActivity() {

    private var twist = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_fab_submenu_fab_activity)

        initToolbar()

        Utils.hideFirstFab(fab_video)
        Utils.hideFirstFab(fab_camera)
        Utils.hideFirstFab(fab_photo)

        fab.setOnClickListener { v ->

            twist = Utils.twistFab(v, !twist)

            if (twist) {

                Utils.showFab(fab_video)
                Utils.showFab(fab_camera)
                Utils.showFab(fab_photo)

            } else {

                Utils.hideFab(fab_video)
                Utils.hideFab(fab_camera)
                Utils.hideFab(fab_photo)

            }
        }

        fab_video.setOnClickListener { Toast.makeText(applicationContext, "Open Video clicked", Toast.LENGTH_SHORT).show() }

        fab_camera.setOnClickListener { Toast.makeText(applicationContext, "Open Camera clicked", Toast.LENGTH_SHORT).show() }

        fab_photo.setOnClickListener { Toast.makeText(applicationContext, "View Photos clicked", Toast.LENGTH_SHORT).show() }
    }

    //region Init Toolbar
    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "SubMenu FAB without Text"

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

    //endregion

}
