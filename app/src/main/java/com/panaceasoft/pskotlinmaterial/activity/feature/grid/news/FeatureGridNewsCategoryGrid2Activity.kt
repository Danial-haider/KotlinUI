package com.panaceasoft.pskotlinmaterial.activity.feature.grid.news

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
import com.panaceasoft.pskotlinmaterial.`object`.NewsCategory
import com.panaceasoft.pskotlinmaterial.adapter.feature.grid.news.FeatureGridNewsCategoryGrid2Adapter
import com.panaceasoft.pskotlinmaterial.repository.news.NewsCategoryRepository
import kotlinx.android.synthetic.main.feature_grid_news_category_grid_2_activity.*

class FeatureGridNewsCategoryGrid2Activity : AppCompatActivity() {

    private lateinit var itemArrayList: List<NewsCategory>
    private lateinit var mAdapter: FeatureGridNewsCategoryGrid2Adapter
    internal var numberOfColumns = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_grid_news_category_grid_2_activity)

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
        itemArrayList = NewsCategoryRepository.newsCategoryList
    }

    private fun initUI() {
        initToolbar()

        mAdapter = FeatureGridNewsCategoryGrid2Adapter(itemArrayList)

        // get RecyclerView and bind
        recyclerView.layoutManager = GridLayoutManager(this, numberOfColumns)
        recyclerView.itemAnimator = DefaultItemAnimator()

    }

    private fun initDataBinding() {
        recyclerView.adapter = mAdapter
    }

    private fun initActions() {
        mAdapter.setOnItemClickListener(object : FeatureGridNewsCategoryGrid2Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: NewsCategory, position: Int) {
                Toast.makeText(this@FeatureGridNewsCategoryGrid2Activity, "Selected : " + obj.category, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun initToolbar() {
        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "News Category Grid 2"

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
