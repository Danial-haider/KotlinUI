package com.panaceasoft.pskotlinmaterial.activity.uicomponent.list

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.SectionGalleryListHolder
import com.panaceasoft.pskotlinmaterial.adapter.uicomponent.list.UiListStickyHeaderListAdapter
import com.panaceasoft.pskotlinmaterial.repository.directory.SectionGalleryRepository
import com.panaceasoft.pskotlinmaterial.utils.HeaderItemDecoration
import java.util.*

class UiListStickyHeaderListActivity : AppCompatActivity() {

    private lateinit var mAdapter: UiListStickyHeaderListAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var holderList: MutableList<SectionGalleryListHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_list_sticky_header_list_activity)

        //Init Functions
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


    //region Init Functions
    private fun initData() {
        val sectionGalleryList = SectionGalleryRepository.getSectionGallery()

        if (sectionGalleryList != null && sectionGalleryList.size > 0) {
            holderList = ArrayList()

            for (i in sectionGalleryList.indices) {

                val gallery = sectionGalleryList[i]
                holderList.add(SectionGalleryListHolder(gallery.id, gallery.name, true, gallery.imageList[i]))

                for (j in gallery.imageList.indices) {
                    holderList.add(SectionGalleryListHolder(gallery.id, gallery.name, false, gallery.imageList[j]))
                }
            }

        }

    }

    private fun initUI() {
        initToolbar()

        mAdapter = UiListStickyHeaderListAdapter(holderList)

        // get RecyclerView and bind
        recyclerView = findViewById(R.id.recyclerView)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()

        recyclerView.addItemDecoration(HeaderItemDecoration(recyclerView, mAdapter))
    }

    private fun initDataBinding() {
        // get data and adapter
        recyclerView.adapter = mAdapter
    }

    private fun initActions() {
        mAdapter.setOnItemClickListener(object : UiListStickyHeaderListAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: SectionGalleryListHolder, position: Int) {
                Toast.makeText(this@UiListStickyHeaderListActivity, "Selected : " + obj.name, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun initToolbar() {

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Sticky Header List"

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