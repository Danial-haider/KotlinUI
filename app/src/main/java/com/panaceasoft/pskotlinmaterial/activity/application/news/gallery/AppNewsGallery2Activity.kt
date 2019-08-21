package com.panaceasoft.pskotlinmaterial.activity.application.news.gallery

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
import com.panaceasoft.pskotlinmaterial.`object`.News
import com.panaceasoft.pskotlinmaterial.adapter.application.news.gallery.AppNewsGallery2Adapter
import com.panaceasoft.pskotlinmaterial.repository.news.NewsRepository
import kotlinx.android.synthetic.main.app_news_gallery_2_activity.*

class AppNewsGallery2Activity : AppCompatActivity() {

    private lateinit var newsList: List<News>
    private lateinit var mAdapter: AppNewsGallery2Adapter
    internal var numberOfColumns = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_news_gallery_2_activity)

        //Init Functions
        initData()

        initUI()

        initDataBinding()

        initActions()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
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
        newsList = NewsRepository.newsList
    }

    private fun initUI() {
        initToolbar()

        mAdapter = AppNewsGallery2Adapter(newsList)

        // get RecyclerView and bind
        recyclerView.layoutManager = GridLayoutManager(this, numberOfColumns)
        recyclerView.itemAnimator = DefaultItemAnimator()
    }

    private fun initDataBinding() {
        // get data and adapter
        recyclerView.adapter = mAdapter
    }

    private fun initActions() {
        mAdapter.setOnItemClickListener(object : AppNewsGallery2Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: News, position: Int) {
                Toast.makeText(this@AppNewsGallery2Activity, "Selected : " + obj.title, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun initToolbar() {
        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Gallery 2"

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
