package com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.directory

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.directory.FeatureDashboardDirectoryDashboard6Adapter
import com.panaceasoft.pskotlinmaterial.repository.directory.PlaceRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_dashboard_directory_dashboard_6_activity.*
import java.util.*

class FeatureDashboardDirectoryDashboard6Activity : AppCompatActivity() {


    private lateinit var itemArrayList: ArrayList<Place>
    private lateinit var mAdapter: FeatureDashboardDirectoryDashboard6Adapter
    internal var numberOfColumns = 2
    private val filterViewHeight = 50
    private var dyg = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_dashboard_directory_dashboard_6_activity)

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

        mAdapter = FeatureDashboardDirectoryDashboard6Adapter(itemArrayList, numberOfColumns)

        // Init Filter UI
        val cityCardView = findViewById<CardView>(R.id.cityFilterCardView)
        val categoryCardView = findViewById<CardView>(R.id.categoryFilterCardView)
        val sortCardView = findViewById<CardView>(R.id.sortCardView)

        cityCardView.setOnClickListener { Toast.makeText(this, "Clicked City Filter.", Toast.LENGTH_SHORT).show() }

        categoryCardView.setOnClickListener { Toast.makeText(this, "Clicked Category Filter.", Toast.LENGTH_SHORT).show() }

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
        mAdapter.setOnItemClickListener(object : FeatureDashboardDirectoryDashboard6Adapter.OnItemClickListener {
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

        toolbar.title = "Directory Dashboard 6"

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
