package com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.ecommerce

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.fragment.feature.dashboard.ecommerce.FeatureDashboardECommerceDashboard3Fragment
import com.panaceasoft.pskotlinmaterial.utils.common_adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.feature_dashboard_ecommerce_dashboard_3_activity.*

class FeatureDashboardECommerceDashboard3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_dashboard_ecommerce_dashboard_3_activity)

        initData()

        initUI()

        initDataBinding()

        initActions()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search_basket, menu)
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

    }

    private fun initUI() {

        // Init Toolbar
        initToolbar()

        setupViewPager(viewPager)

        tabLayout.setupWithViewPager(viewPager)
    }

    private fun initDataBinding() {

    }

    private fun initActions() {

    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "ECommerce Dashboard 3"

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

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)

        val fragment1 = FeatureDashboardECommerceDashboard3Fragment()
        fragment1.setType("F")

        val fragment2 = FeatureDashboardECommerceDashboard3Fragment()
        fragment2.setType("M")

        val fragment3 = FeatureDashboardECommerceDashboard3Fragment()
        fragment3.setType("K")

        adapter.addFragment(fragment1, "WOMEN")
        adapter.addFragment(fragment2, "MEN")
        adapter.addFragment(fragment3, "KIDS")
        viewPager.adapter = adapter
    }
}
