package com.panaceasoft.pskotlinmaterial.activity.application.education.category

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
import com.panaceasoft.pskotlinmaterial.`object`.Course
import com.panaceasoft.pskotlinmaterial.adapter.application.education.category.AppEducationCategoryGrid1Adapter
import com.panaceasoft.pskotlinmaterial.repository.education.CourseListRepository
import kotlinx.android.synthetic.main.app_education_category_grid_1_activity.*

class AppEducationCategoryGrid1Activity : AppCompatActivity() {

    // data and adapter
    internal lateinit var courseList: List<Course>
    internal lateinit var adapter: AppEducationCategoryGrid1Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_education_category_grid_1_activity)

        initData()

        initUI()

        initDataBindings()

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

    private fun initData() {
        // get place list
        courseList = CourseListRepository.courseList
    }

    private fun initUI() {
        initToolbar()

        // get list adapter
        adapter = AppEducationCategoryGrid1Adapter(courseList)

        // get recycler view
        val mLayoutManager = GridLayoutManager(applicationContext, 3)
        videoRecyclerView.layoutManager = mLayoutManager
        videoRecyclerView.itemAnimator = DefaultItemAnimator()
    }

    private fun initDataBindings() {
        // bind adapter to recycler
        videoRecyclerView.adapter = adapter
    }

    private fun initActions() {
        adapter.setOnItemClickListener(object : AppEducationCategoryGrid1Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: Course, position: Int) {
                Toast.makeText(applicationContext, "Clicked " + obj.title, Toast.LENGTH_SHORT).show()
            }
        })
    }


    //region Init Toolbar
    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Category Grid 1"

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
