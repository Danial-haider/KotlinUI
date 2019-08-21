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
import androidx.recyclerview.widget.GridLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.WallpaperCategory
import com.panaceasoft.pskotlinmaterial.adapter.feature.list.wallpaper.FeatureListWallpaperCategoryList2Adapter
import com.panaceasoft.pskotlinmaterial.repository.wallpaper.WallpaperCategoryRepository
import kotlinx.android.synthetic.main.feature_list_wallpaper_category_list_2_activity.*
import java.util.*

class FeatureListWallpaperCategoryList2Activity : AppCompatActivity() {

    private lateinit var itemArrayList: ArrayList<WallpaperCategory>
    private lateinit var mAdapter: FeatureListWallpaperCategoryList2Adapter
    internal var numberOfColumns = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_list_wallpaper_category_list_2_activity)

        initData()

        initUI()

        initDataBinding()

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
    //endregion

    //region Init Functions
    private fun initData() {
        itemArrayList = WallpaperCategoryRepository.wallpaperCategoryList
    }

    private fun initUI() {
        initToolbar()

        mAdapter = FeatureListWallpaperCategoryList2Adapter(itemArrayList)

        // get RecyclerView and bind
        photoRecyclerView.layoutManager = GridLayoutManager(this, numberOfColumns)
        photoRecyclerView.itemAnimator = DefaultItemAnimator()

    }

    private fun initDataBinding() {
        photoRecyclerView.adapter = mAdapter
    }

    private fun initActions() {
        mAdapter.setOnItemClickListener(object : FeatureListWallpaperCategoryList2Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: WallpaperCategory, position: Int) {
                Toast.makeText(this@FeatureListWallpaperCategoryList2Activity, "Selected : " + obj.name, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Category List 2"

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
