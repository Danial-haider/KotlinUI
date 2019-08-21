package com.panaceasoft.pskotlinmaterial.activity.feature.list.wallpaper

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.WallpaperItem
import com.panaceasoft.pskotlinmaterial.adapter.feature.list.wallpaper.FeatureListWallpaperPhotoList1Adapter
import com.panaceasoft.pskotlinmaterial.repository.wallpaper.WallpaperItemRepository
import kotlinx.android.synthetic.main.feature_list_wallpaper_photo_list_1_activity.*

class FeatureListWallpaperPhotoList1Activity : AppCompatActivity() {

    // data and adapter
    internal lateinit var itemList: List<WallpaperItem>
    internal lateinit var adapter: FeatureListWallpaperPhotoList1Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_list_wallpaper_photo_list_1_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(applicationContext, item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initData() {
        // get place list
        itemList = WallpaperItemRepository.wallpaperItemList
    }

    private fun initUI() {
        initToolbar()

        // get list adapter
        adapter = FeatureListWallpaperPhotoList1Adapter(itemList)

        // get recycler view
        val mLayoutManager = LinearLayoutManager(applicationContext)
        photoRecyclerView.layoutManager = mLayoutManager
        photoRecyclerView.itemAnimator = DefaultItemAnimator()
    }

    private fun initDataBindings() {
        // bind adapter to recycler
        photoRecyclerView.adapter = adapter
    }

    private fun initActions() {
        adapter.setOnItemClickListener(object : FeatureListWallpaperPhotoList1Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: WallpaperItem, position: Int) {
                Toast.makeText(applicationContext, "Selected " + obj.name, Toast.LENGTH_SHORT).show()
            }
        })
    }

    //region Init Toolbar
    private fun initToolbar() {
        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Photo List 1"

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
