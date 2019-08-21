package com.panaceasoft.pskotlinmaterial.activity.uicomponent.layout.gridview

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Country
import com.panaceasoft.pskotlinmaterial.adapter.uicomponent.legacy.gridview.UiLegacyGridViewBasicAdapter
import com.panaceasoft.pskotlinmaterial.repository.directory.CountryRepository
import kotlinx.android.synthetic.main.ui_layout_grid_view_basic_activity.*
import java.util.*

class UiLayoutGridViewBasicActivity : AppCompatActivity() {

    internal lateinit var countryArrayList: ArrayList<Country>
    internal lateinit var adapter: UiLegacyGridViewBasicAdapter
    lateinit var gridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_layout_grid_view_basic_activity)

        initToolbar()

        countryArrayList = CountryRepository.countryList
        adapter = UiLegacyGridViewBasicAdapter(applicationContext, countryArrayList)

        gridView = findViewById(R.id.basicGridView)
        gridView.adapter = adapter
    }

    //region Init Toolbar

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Basic Grid View"

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