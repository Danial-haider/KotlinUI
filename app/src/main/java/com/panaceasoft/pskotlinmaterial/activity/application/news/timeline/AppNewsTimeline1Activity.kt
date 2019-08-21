package com.panaceasoft.pskotlinmaterial.activity.application.news.timeline

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
import com.panaceasoft.pskotlinmaterial.`object`.News
import com.panaceasoft.pskotlinmaterial.adapter.application.news.timeline.AppNewsTimeline1Adapter
import com.panaceasoft.pskotlinmaterial.repository.news.NewsRepository
import kotlinx.android.synthetic.main.app_news_timeline_1_activity.*

class AppNewsTimeline1Activity : AppCompatActivity() {

    private lateinit var newsList: List<News>

    // ui variables
    private lateinit var adapter: AppNewsTimeline1Adapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.app_news_timeline_1_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
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
        newsList = NewsRepository.newsList

    }

    private fun initUI() {

        initToolbar()

        // get list adapter
        adapter = AppNewsTimeline1Adapter(newsList)

        // get recycler view
        val mLayoutManager = LinearLayoutManager(applicationContext)
        reviewRecyclerView.layoutManager = mLayoutManager
        reviewRecyclerView.itemAnimator = DefaultItemAnimator()
        reviewRecyclerView.isNestedScrollingEnabled = false

    }

    private fun initDataBindings() {

        // bind adapter to recycler
        reviewRecyclerView.adapter = adapter
    }

    private fun initActions() {

        adapter.setOnItemClickListener(object : AppNewsTimeline1Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: News, position: Int) {
                Toast.makeText(this@AppNewsTimeline1Activity, "Selected : " + obj.title, Toast.LENGTH_LONG).show()
            }
        })

    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Timeline 1"

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
