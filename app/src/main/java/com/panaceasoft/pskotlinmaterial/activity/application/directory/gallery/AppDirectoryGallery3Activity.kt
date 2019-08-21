package com.panaceasoft.pskotlinmaterial.activity.application.directory.gallery

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
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.SectionGalleryListHolder
import com.panaceasoft.pskotlinmaterial.adapter.application.directory.gallery.AppDirectoryGallery3Adapter
import com.panaceasoft.pskotlinmaterial.repository.directory.SectionGalleryRepository
import kotlinx.android.synthetic.main.app_directory_gallery_3_activity.*
import java.util.*

class AppDirectoryGallery3Activity : AppCompatActivity() {

    private lateinit var mAdapter: AppDirectoryGallery3Adapter
    internal var numberOfColumns = 3
    private lateinit var holderList: MutableList<SectionGalleryListHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_directory_gallery_3_activity)

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

        mAdapter = AppDirectoryGallery3Adapter(holderList)

        // get RecyclerView and bind
        recyclerView.layoutManager = StaggeredGridLayoutManager(numberOfColumns, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.itemAnimator = DefaultItemAnimator()
    }

    private fun initDataBinding() {
        // get data and adapter
        recyclerView.adapter = mAdapter
    }

    private fun initActions() {
        mAdapter.setOnItemClickListener(object: AppDirectoryGallery3Adapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: SectionGalleryListHolder, position: Int) {
                Toast.makeText(this@AppDirectoryGallery3Activity,"Selected : "+ obj.name,Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Gallery UI 3"

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
