package com.panaceasoft.pskotlinmaterial.activity.feature.loadmore.general

import android.graphics.PorterDuff
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.WallpaperItem
import com.panaceasoft.pskotlinmaterial.adapter.feature.loadmore.FeatureLoadMoreGeneralOnScrollAdapter
import com.panaceasoft.pskotlinmaterial.repository.wallpaper.WallpaperItemRepository
import kotlinx.android.synthetic.main.feature_load_more_general_on_scroll_activity.*

class FeatureLoadMoreGeneralOnScroll : AppCompatActivity() {

    // data and wallpaperHome2CategoryAdapter
    internal lateinit var itemArrayList: MutableList<WallpaperItem>

    internal lateinit var itemAdapter: FeatureLoadMoreGeneralOnScrollAdapter

    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.feature_load_more_general_on_scroll_activity)

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

        itemAdapter = FeatureLoadMoreGeneralOnScrollAdapter(itemArrayList)

        // get Item recycler view

        val mLayoutManagerForItems = GridLayoutManager(applicationContext, 1)

        photoRecyclerView.layoutManager = mLayoutManagerForItems
        photoRecyclerView.itemAnimator = DefaultItemAnimator()
        photoRecyclerView.isNestedScrollingEnabled = false


    }

    private fun initDataBinding() {
        // bind items
        photoRecyclerView.adapter = itemAdapter

        progressBar.visibility = View.GONE
    }

    private fun initActions() {

        itemAdapter.setOnItemClickListener(object : FeatureLoadMoreGeneralOnScrollAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: WallpaperItem, position: Int) {
                Toast.makeText(applicationContext, "Selected : " + obj.imageName, Toast.LENGTH_SHORT).show()
            }
        })

        photoRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager?
                val lastPosition = layoutManager!!
                        .findLastVisibleItemPosition()
                if (lastPosition == itemAdapter.itemCount - 1) {

                    if (!isLoading) {
                        isLoading = true
                        progressBar.visibility = View.VISIBLE
                        Handler().postDelayed({

                            val itemArrayList = WallpaperItemRepository.wallpaperItemList

                            itemAdapter.insertItems(itemArrayList)

                            progressBar.visibility = View.GONE

                            isLoading = false

                        }, 2000)
                    }

                }
            }
        })

    }


    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "On Scroll"

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