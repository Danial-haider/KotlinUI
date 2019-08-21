package com.panaceasoft.pskotlinmaterial.activity.feature.list.general

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
import com.panaceasoft.pskotlinmaterial.`object`.SectionGalleryListHolder
import com.panaceasoft.pskotlinmaterial.adapter.feature.list.general.FeatureListGeneralStickyHeaderListAdapter
import com.panaceasoft.pskotlinmaterial.repository.directory.SectionGalleryRepository
import com.panaceasoft.pskotlinmaterial.utils.HeaderItemDecoration
import kotlinx.android.synthetic.main.feature_list_general_sticky_header_list_activity.*
import java.util.*

class FeatureListGeneralStickyHeaderListActivity : AppCompatActivity() {

    private lateinit var mAdapter: FeatureListGeneralStickyHeaderListAdapter
    private lateinit var holderList: MutableList<SectionGalleryListHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_list_general_sticky_header_list_activity)

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

        mAdapter = FeatureListGeneralStickyHeaderListAdapter(holderList)

        // get RecyclerView and bind
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
        mAdapter.setOnItemClickListener(object : FeatureListGeneralStickyHeaderListAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: SectionGalleryListHolder, position: Int) {
                Toast.makeText(this@FeatureListGeneralStickyHeaderListActivity, "Selected : " + obj.name, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun initToolbar() {

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