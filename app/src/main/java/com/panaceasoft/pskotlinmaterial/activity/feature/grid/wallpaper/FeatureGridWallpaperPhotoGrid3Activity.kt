package com.panaceasoft.pskotlinmaterial.activity.feature.grid.wallpaper

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
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.WallpaperItem
import com.panaceasoft.pskotlinmaterial.adapter.feature.grid.wallpaper.FeatureGridWallpaperPhotoGrid3Adapter
import com.panaceasoft.pskotlinmaterial.repository.wallpaper.WallpaperItemRepository
import kotlinx.android.synthetic.main.feature_grid_wallpaper_photo_grid_3_activity.*

class FeatureGridWallpaperPhotoGrid3Activity : AppCompatActivity() {

    internal lateinit var itemArrayList: List<WallpaperItem>

    internal lateinit var itemAdapter: FeatureGridWallpaperPhotoGrid3Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_grid_wallpaper_photo_grid_3_activity)

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

        itemAdapter = FeatureGridWallpaperPhotoGrid3Adapter(itemArrayList)

        // get Item recycler view
        val mLayoutManagerForItems = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        photoRecyclerView.layoutManager = mLayoutManagerForItems
        photoRecyclerView.itemAnimator = DefaultItemAnimator()
        photoRecyclerView.isNestedScrollingEnabled = false

    }

    private fun initDataBinding() {
        // bind items
        photoRecyclerView.adapter = itemAdapter
    }

    private fun initActions() {

        itemAdapter.setOnItemClickListener(object : FeatureGridWallpaperPhotoGrid3Adapter.OnItemClickListener {
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

        toolbar.title = "Photo Grid 3"

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
