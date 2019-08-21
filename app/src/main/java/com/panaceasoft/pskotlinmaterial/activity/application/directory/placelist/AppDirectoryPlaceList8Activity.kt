package com.panaceasoft.pskotlinmaterial.activity.application.directory.placelist

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
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.adapter.application.directory.placelist.AppDirectoryPlaceList8Adapter
import com.panaceasoft.pskotlinmaterial.repository.directory.PlaceRepository
import kotlinx.android.synthetic.main.app_directory_place_list_8_activity.*
import java.util.*

class AppDirectoryPlaceList8Activity : AppCompatActivity() {

    // data and adapter
    internal lateinit var placeArrayList: ArrayList<Place>
    internal lateinit var adapter: AppDirectoryPlaceList8Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_directory_place_list_8_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_filter, menu)
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
        placeArrayList = PlaceRepository.placeList
    }

    private fun initUI() {
        initToolbar()

        // get list adapter
        adapter = AppDirectoryPlaceList8Adapter(placeArrayList)

        // get recycler view
        val mLayoutManager = LinearLayoutManager(applicationContext)
        placeList1RecyclerView.layoutManager = mLayoutManager
        placeList1RecyclerView.itemAnimator = DefaultItemAnimator()
    }

    private fun initDataBindings() {
        // bind adapter to recycler
        placeList1RecyclerView.adapter = adapter
    }

    private fun initActions() {
        adapter.setOnItemClickListener(object : AppDirectoryPlaceList8Adapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: Place, position: Int) {
                Toast.makeText(this@AppDirectoryPlaceList8Activity, "Selected : " + obj.name, Toast.LENGTH_LONG).show()
            }
        })
    }

    //region Init Toolbar
    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "List 8"

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
