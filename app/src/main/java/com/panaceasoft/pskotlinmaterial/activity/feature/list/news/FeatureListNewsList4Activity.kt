package com.panaceasoft.pskotlinmaterial.activity.feature.list.news

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
import com.panaceasoft.pskotlinmaterial.adapter.feature.list.news.FeatureListNewsList4Adapter
import com.panaceasoft.pskotlinmaterial.repository.news.NewsRepository
import kotlinx.android.synthetic.main.app_news_list_4_activity.*
import java.util.*

class FeatureListNewsList4Activity : AppCompatActivity() {

    // data and adapter
    internal lateinit var newsArrayList: ArrayList<News>
    internal lateinit var adapter: FeatureListNewsList4Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_news_list_4_activity)

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
        newsArrayList = NewsRepository.newsList
    }

    private fun initUI() {
        initToolbar()

        // get list adapter
        adapter = FeatureListNewsList4Adapter(newsArrayList)

        val mLayoutManager = LinearLayoutManager(applicationContext)
        placeList1RecyclerView.layoutManager = mLayoutManager
        placeList1RecyclerView.itemAnimator = DefaultItemAnimator()
    }

    private fun initDataBindings() {
        // bind adapter to recycler
        placeList1RecyclerView.adapter = adapter
    }

    private fun initActions() {
        //adapter.setOnItemClickListener((view, obj, position) -> Toast.makeText(this , "Selected : " + obj.title , Toast.LENGTH_LONG).show());

        adapter.setOnItemClickListener(object : FeatureListNewsList4Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: News, position: Int) {
                Toast.makeText(applicationContext, "Selected : " + obj.title, Toast.LENGTH_LONG).show()
            }

            override fun onLikeClick(view: View, obj: News, position: Int) {
                Toast.makeText(applicationContext, "Clicked Like.", Toast.LENGTH_SHORT).show()
            }

            override fun onReadMoreClick(view: View, obj: News, position: Int) {
                Toast.makeText(applicationContext, "Clicked Read More.", Toast.LENGTH_SHORT).show()
            }

            /* @Override
            public void onMoreClick(View view, News obj, int position) {
                Toast.makeText(getApplicationContext(), "Clicked More.", Toast.LENGTH_SHORT).show();
            }*/

        })


    }

    //region Init Toolbar
    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "List 4"

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
