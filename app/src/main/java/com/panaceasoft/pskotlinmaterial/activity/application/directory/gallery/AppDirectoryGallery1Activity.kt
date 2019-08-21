package com.panaceasoft.pskotlinmaterial.activity.application.directory.gallery

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
import androidx.recyclerview.widget.GridLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.adapter.application.directory.gallery.AppDirectoryGallery1Adapter
import com.panaceasoft.pskotlinmaterial.repository.directory.PlaceRepository
import kotlinx.android.synthetic.main.app_directory_gallery_1_activity.*
import java.util.*

class AppDirectoryGallery1Activity : AppCompatActivity() {

    private lateinit var placeArrayList: ArrayList<Place>
    private lateinit var mAdapter: AppDirectoryGallery1Adapter
    internal var numberOfColumns = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_directory_gallery_1_activity)

        //Init Functions
        initData()

        initUI()

        initDataBinding()

        initActions()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_delete_more, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(applicationContext, item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }


    //region Init Functions
    private fun initData() {
        placeArrayList = PlaceRepository.placeList
    }

    private fun initUI() {
        initToolbar()

        mAdapter = AppDirectoryGallery1Adapter(placeArrayList)

        // get RecyclerView and bind
        recyclerView.layoutManager = GridLayoutManager(this, numberOfColumns)
        recyclerView.itemAnimator = DefaultItemAnimator()
    }

    private fun initDataBinding() {
        // get data and adapter
        recyclerView.adapter = mAdapter
    }

    private fun initActions() {
        mAdapter.setOnItemClickListener(object : AppDirectoryGallery1Adapter.OnItemClickListener {
            override fun onItemSelect(view: View, obj: Place, position: Int) {
                Toast.makeText(applicationContext, "Selected " + obj.name, Toast.LENGTH_SHORT).show()
            }

            override fun onItemUnSelect(view: View, obj: Place, position: Int) {
                Toast.makeText(applicationContext, "Unselected " + obj.name, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Gallery 1"

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
    //endregion
}
