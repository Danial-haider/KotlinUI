package com.panaceasoft.pskotlinmaterial.activity.uicomponent.grid

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
import com.panaceasoft.pskotlinmaterial.`object`.EducationVideo
import com.panaceasoft.pskotlinmaterial.adapter.uicomponent.grid.UiGridGridWithMultipleTextLinesAdapter
import com.panaceasoft.pskotlinmaterial.repository.education.EducationVideoListRepository
import kotlinx.android.synthetic.main.ui_grid_grid_with_multiple_text_lines_activity.*

class UiGridGridWithMultipleTextLinesActivity : AppCompatActivity() {


    // data and adapter
    internal lateinit var videoList: List<EducationVideo>
    internal lateinit var adapter: UiGridGridWithMultipleTextLinesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_grid_grid_with_multiple_text_lines_activity)

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
        videoList = EducationVideoListRepository.educationVideoList
    }

    private fun initUI() {
        initToolbar()

        // get list adapter
        adapter = UiGridGridWithMultipleTextLinesAdapter(videoList)

        // get recycler view
        val mLayoutManager = GridLayoutManager(applicationContext, 2)

        videoRecyclerView.layoutManager = mLayoutManager
        videoRecyclerView.itemAnimator = DefaultItemAnimator()
    }

    private fun initDataBindings() {
        // bind adapter to recycler
        videoRecyclerView.adapter = adapter
    }

    private fun initActions() {
        adapter.setOnItemClickListener(object : UiGridGridWithMultipleTextLinesAdapter.OnItemClickListener {

            override fun onItemClick(view: View, obj: EducationVideo, position: Int) {
                Toast.makeText(applicationContext, "Clicked " + obj.title, Toast.LENGTH_SHORT).show()

            }

            override fun onMoreClick(view: View, obj: EducationVideo, position: Int) {
                Toast.makeText(applicationContext, "Clicked More ", Toast.LENGTH_SHORT).show()
            }

            override fun onPlayClick(view: View, obj: EducationVideo, position: Int) {
                Toast.makeText(applicationContext, "Clicked Play ", Toast.LENGTH_SHORT).show()
            }
        })
    }


    //region Init Toolbar
    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Grid with Multiple Text Lines"

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