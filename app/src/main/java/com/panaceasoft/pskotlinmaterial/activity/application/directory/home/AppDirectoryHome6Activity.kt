package com.panaceasoft.pskotlinmaterial.activity.application.directory.home

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.adapter.application.directory.home.AppDirectoryHome6ItemAdapter
import com.panaceasoft.pskotlinmaterial.repository.directory.PlaceRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_directory_home_6_activity.*
import java.util.*

class AppDirectoryHome6Activity : AppCompatActivity() {

    private lateinit var itemArrayList: ArrayList<Place>
    private lateinit var mAdapter: AppDirectoryHome6ItemAdapter
    internal var numberOfColumns = 2
//    private lateinit var filterLayout: ConstraintLayout
    private val filterViewHeight = 50
    private var dyg = 0
//    private lateinit var searchFAB: FloatingActionButton

    //region override methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_directory_home_6_activity)

        initData()

        initUI()

        initDataBinding()

        initActions()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_map_filter_more, menu)
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
        itemArrayList = PlaceRepository.placeList
    }

    private fun initUI() {

        initToolbar()

        mAdapter = AppDirectoryHome6ItemAdapter(itemArrayList, numberOfColumns)

        cityFilterCardView.setOnClickListener { Toast.makeText(this, "Clicked City Filter.", Toast.LENGTH_SHORT).show() }

        categoryFilterCardView.setOnClickListener { Toast.makeText(this, "Clicked Category Filter.", Toast.LENGTH_SHORT).show() }

        sortCardView.setOnClickListener { Toast.makeText(this, "Clicked Sort/Filter.", Toast.LENGTH_SHORT).show() }

        // get RecyclerView and bind
        recyclerView.layoutManager = GridLayoutManager(this, numberOfColumns)
        recyclerView.itemAnimator = DefaultItemAnimator()

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 1) {

                    dyg -= dy

                    if (dyg < -filterViewHeight) {
                        dyg = -filterViewHeight
                    }

                    filterConstraintLayout.animate()
                            .translationY(Utils.dpToPx(applicationContext, dyg).toFloat())
                            .alpha(1f).setDuration(100).interpolator = DecelerateInterpolator()
                } else if (dy < 0) {

                    dyg -= dy

                    if (dyg > 0) {
                        dyg = 0
                    }

                    filterConstraintLayout.animate()
                            .translationY(dyg.toFloat())
                            .alpha(1f).setDuration(100).interpolator = DecelerateInterpolator()
                }
            }
        })


        searchFAB
    }

    private fun initDataBinding() {
        // get data and adapter
        recyclerView.adapter = mAdapter
    }

    private fun initActions() {
        mAdapter.setOnItemClickListener(object: AppDirectoryHome6ItemAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: Place, position: Int) {
                Toast.makeText(applicationContext, "Clicked " + obj.name, Toast.LENGTH_SHORT).show()
            }

        })
        searchFAB.setOnClickListener { Toast.makeText(applicationContext, "Click FAB", Toast.LENGTH_SHORT).show() }
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Home 6"

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
