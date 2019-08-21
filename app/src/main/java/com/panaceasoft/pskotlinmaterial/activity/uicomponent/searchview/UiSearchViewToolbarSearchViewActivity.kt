package com.panaceasoft.pskotlinmaterial.activity.uicomponent.searchview

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.News
import com.panaceasoft.pskotlinmaterial.adapter.uicomponent.searchview.UiSearchViewToolbarSearchViewAdapter
import com.panaceasoft.pskotlinmaterial.repository.news.NewsRepository
import kotlinx.android.synthetic.main.ui_search_view_toolbar_search_view_activity.*
import java.util.*

class UiSearchViewToolbarSearchViewActivity : AppCompatActivity() {

    // data and adapter
    internal lateinit var newsArrayList: ArrayList<News>
    internal lateinit var adapter: UiSearchViewToolbarSearchViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_search_view_toolbar_search_view_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search_view, menu)

        val mSearch = menu.findItem(R.id.action_search_view)

        val mSearchView = mSearch.actionView as SearchView

        mSearchView.queryHint = "Search"
        mSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {

                adapter.filter.filter(query)
                return true
            }

            override fun onQueryTextChange(query: String): Boolean {
                //adapter.filter(newText);
                adapter.filter.filter(query)
                return true
            }
        })
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
        newsArrayList = NewsRepository.newsList
    }

    private fun initUI() {
        initToolbar()

        // get list adapter
        adapter = UiSearchViewToolbarSearchViewAdapter(newsArrayList)

        val mLayoutManager = LinearLayoutManager(applicationContext)
        placeList1RecyclerView.layoutManager = mLayoutManager
        placeList1RecyclerView.itemAnimator = DefaultItemAnimator()
    }

    private fun initDataBindings() {
        // bind adapter to recycler
        placeList1RecyclerView.adapter = adapter
    }

    private fun initActions() {
        adapter.setOnItemClickListener(object : UiSearchViewToolbarSearchViewAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: News, position: Int) {
                Toast.makeText(this@UiSearchViewToolbarSearchViewActivity, "Selected : " + obj.title, Toast.LENGTH_LONG).show()
            }
        })
    }

    //region Init Toolbar
    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Search View with Toolbar"

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
