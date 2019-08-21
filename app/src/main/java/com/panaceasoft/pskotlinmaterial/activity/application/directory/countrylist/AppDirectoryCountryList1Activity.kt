package com.panaceasoft.pskotlinmaterial.activity.application.directory.countrylist

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Country
import com.panaceasoft.pskotlinmaterial.adapter.application.directory.countrylist.AppDirectoryCountryList1Adapter
import com.panaceasoft.pskotlinmaterial.repository.directory.CountryRepository
import kotlinx.android.synthetic.main.app_directory_country_list_1_activity.*
import java.util.*

class AppDirectoryCountryList1Activity : AppCompatActivity() {

    // data and adapter
    internal lateinit var countryArrayList: ArrayList<Country>
    internal lateinit var adapter: AppDirectoryCountryList1Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_directory_country_list_1_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_sort, menu)
        return super.onCreateOptionsMenu(menu)
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
        adapter = AppDirectoryCountryList1Adapter(countryArrayList)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        countryListRecyclerView.layoutManager = mLayoutManager
        countryListRecyclerView.itemAnimator = DefaultItemAnimator()
    }

    private fun initDataBindings() {
        // bind adapter to recycler
        countryListRecyclerView.adapter = adapter
    }

    private fun initActions() {
        adapter.setOnItemClickListener(object : AppDirectoryCountryList1Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: Country, position: Int) {
                Toast.makeText(this@AppDirectoryCountryList1Activity, "Selected : " + obj.name, Toast.LENGTH_LONG).show()
            }
        })
    }


    //region Init Toolbar
    private fun initToolbar() {
        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Country List 1"

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
