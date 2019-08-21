package com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.education

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.fragment.feature.dashboard.education.home3.FeatureDashboardEducationDashboard3Fragment1
import com.panaceasoft.pskotlinmaterial.fragment.feature.dashboard.education.home3.FeatureDashboardEducationDashboard3Fragment2
import com.panaceasoft.pskotlinmaterial.utils.common_adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.feature_dashboard_education_dashboard_3_activity.*

class FeatureDashboardEducationDashboard3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_dashboard_education_dashboard_3_activity)

        initData()

        initUI()

        initDataBinding()

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

    }

    private fun initUI() {

        // Init Toolbar
        initToolbar()

        setupViewPager(viewPager)

        tabLayout.setupWithViewPager(viewPager)

        try {

            // set icon color pre-selected
            val tab1 = tabLayout.getTabAt(0)
            if (tab1 != null) {
                tab1.setIcon(R.drawable.baseline_book_black_24)
                if (tab1.icon != null) {
                    tab1.icon?.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN)
                }
            }

            val tab2 = tabLayout.getTabAt(1)
            if (tab2 != null) {
                tab2.setIcon(R.drawable.baseline_badge_white_24)
                if (tab2.icon != null) {
                    tab2.icon?.setColorFilter(ContextCompat.getColor(this,R.color.md_grey_200), PorterDuff.Mode.SRC_IN)
                }
            }

            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    if (tab.icon != null) {
                        tab.icon?.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN)
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {
                    if (tab.icon != null) {
                        tab.icon?.setColorFilter(ContextCompat.getColor(this@FeatureDashboardEducationDashboard3Activity,R.color.md_grey_200), PorterDuff.Mode.SRC_IN)
                    }
                }

                override fun onTabReselected(tab: TabLayout.Tab) {
                    if (tab.icon != null) {
                        tab.icon?.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN)
                    }
                }
            })

        } catch (e: NullPointerException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

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

        toolbar.title = "Home 3"

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

        val fragment1 = FeatureDashboardEducationDashboard3Fragment1()

        val fragment2 = FeatureDashboardEducationDashboard3Fragment2()

        adapter.addFragment(fragment1, "My Courses")
        adapter.addFragment(fragment2, "Recommended")
        viewPager.adapter = adapter
    }

}
