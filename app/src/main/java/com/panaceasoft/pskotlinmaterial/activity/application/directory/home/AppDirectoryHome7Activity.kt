package com.panaceasoft.pskotlinmaterial.activity.application.directory.home

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
import com.panaceasoft.pskotlinmaterial.`object`.DirectoryHome7Category
import com.panaceasoft.pskotlinmaterial.adapter.application.directory.home.AppDirectoryHome7ItemAdapter
import com.panaceasoft.pskotlinmaterial.repository.directory.DirectoryHome7Repository
import kotlinx.android.synthetic.main.app_directory_home_7_activity.*
import java.util.*

class AppDirectoryHome7Activity : AppCompatActivity() {

    private lateinit var catArrayList: ArrayList<DirectoryHome7Category>
    private lateinit var mAdapter: AppDirectoryHome7ItemAdapter
    internal var numberOfColumns = 3

    //region override methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_directory_home_7_activity)

        //Init Functions
        initData()

        initUI()

        initDataBinding()

        initActions()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_map_more, menu)
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

        catArrayList = DirectoryHome7Repository.categoryList

    }

    private fun initUI() {

        initToolbar()

        mAdapter = AppDirectoryHome7ItemAdapter(catArrayList)

        recyclerView.layoutManager = GridLayoutManager(this, numberOfColumns)
        recyclerView.itemAnimator = DefaultItemAnimator()


    }

    private fun initDataBinding() {
        // get data and adapter
        recyclerView.adapter = mAdapter
    }

    private fun initActions() {

        mAdapter.setOnItemClickListener(object : AppDirectoryHome7ItemAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: DirectoryHome7Category, position: Int) {
                Toast.makeText(this@AppDirectoryHome7Activity, "Selected : " + obj.name, Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Home 7"

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
