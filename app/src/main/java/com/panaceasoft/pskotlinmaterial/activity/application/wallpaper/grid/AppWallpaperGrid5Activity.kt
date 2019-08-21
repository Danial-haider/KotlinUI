package com.panaceasoft.pskotlinmaterial.activity.application.wallpaper.grid

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
import com.panaceasoft.pskotlinmaterial.`object`.WallpaperItem
import com.panaceasoft.pskotlinmaterial.adapter.application.wallpaper.grid.AppWallpaperGrid5ItemAdapter
import com.panaceasoft.pskotlinmaterial.repository.wallpaper.WallpaperItemRepository
import kotlinx.android.synthetic.main.app_wallpaper_grid_5_activity.*

class AppWallpaperGrid5Activity : AppCompatActivity() {

    // data and wallpaperHome2CategoryAdapter
    internal lateinit var itemArrayList: List<WallpaperItem>

    internal lateinit var itemAdapter: AppWallpaperGrid5ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.app_wallpaper_grid_5_activity)

        initData()

        initUI()

        initDataBinding()

        initActions()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_more, menu)
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

    //endregion


    //region Init Functions

    private fun initData() {

        // get data
        itemArrayList = WallpaperItemRepository.wallpaperItemList

    }

    private fun initUI() {

        initToolbar()

        itemAdapter = AppWallpaperGrid5ItemAdapter(itemArrayList)

        // get Item recycler view
        val mLayoutManagerForItems = GridLayoutManager(applicationContext, 2)

        photoRecyclerView.layoutManager = mLayoutManagerForItems
        photoRecyclerView.itemAnimator = DefaultItemAnimator()
        photoRecyclerView.isNestedScrollingEnabled = false

    }

    private fun initDataBinding() {
        // bind items
        photoRecyclerView.adapter = itemAdapter
    }

    private fun initActions() {

        itemAdapter.setOnItemClickListener(object : AppWallpaperGrid5ItemAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: WallpaperItem, position: Int) {
                Toast.makeText(applicationContext, "Selected : " + obj.imageName, Toast.LENGTH_SHORT).show()
            }
        })

    }


    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Grid 5"

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
