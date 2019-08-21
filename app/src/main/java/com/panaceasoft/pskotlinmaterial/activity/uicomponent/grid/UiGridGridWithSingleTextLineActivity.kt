package com.panaceasoft.pskotlinmaterial.activity.uicomponent.grid

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Country
import com.panaceasoft.pskotlinmaterial.adapter.uicomponent.grid.UiGridGridWithSingleTextLineAdapter
import com.panaceasoft.pskotlinmaterial.repository.directory.CountryRepository
import kotlinx.android.synthetic.main.ui_grid_grid_with_single_text_line_activity.*
import java.util.*

class UiGridGridWithSingleTextLineActivity : AppCompatActivity() {

    // data and adapter
    internal lateinit var countryArrayList: ArrayList<Country>
    internal lateinit var adapter: UiGridGridWithSingleTextLineAdapter
    var numOfColumns = 2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_grid_grid_with_single_text_line_activity)

        initData()

        initUI()

        initDataBindings()

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

    private fun initData() {
        // get place list
        countryArrayList = CountryRepository.countryList
    }

    private fun initUI() {
        initToolbar()

        // get list adapter
        adapter = UiGridGridWithSingleTextLineAdapter(countryArrayList)


        countryListRecyclerView.layoutManager = GridLayoutManager(this, numOfColumns)
        countryListRecyclerView.itemAnimator = DefaultItemAnimator()
    }

    private fun initDataBindings() {
        // bind adapter to recycler
        countryListRecyclerView.adapter = adapter
    }

    private fun initActions() {
        adapter.setOnItemClickListener(object :UiGridGridWithSingleTextLineAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: Country, position: Int) {
                Toast.makeText(this@UiGridGridWithSingleTextLineActivity, "Selected : " + obj.name, Toast.LENGTH_LONG).show()
            }
        })
    }

    //region Init Toolbar
    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Grid with Single Text Line"

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
