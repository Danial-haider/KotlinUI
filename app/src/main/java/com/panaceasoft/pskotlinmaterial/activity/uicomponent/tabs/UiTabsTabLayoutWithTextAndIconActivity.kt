package com.panaceasoft.pskotlinmaterial.activity.uicomponent.tabs

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.fragment.uicomponent.container.tablayoutwithtextandicon.UiContainerTabLayoutWithTextAndIconExploreFragment
import com.panaceasoft.pskotlinmaterial.fragment.uicomponent.container.tablayoutwithtextandicon.UiContainerTabLayoutWithTextAndIconFlightFragment
import com.panaceasoft.pskotlinmaterial.fragment.uicomponent.container.tablayoutwithtextandicon.UiContainerTabLayoutWithTextAndIconTripFragment
import kotlinx.android.synthetic.main.ui_tabs_tab_layout_with_text_and_icon_activity.*
import java.util.*

class UiTabsTabLayoutWithTextAndIconActivity : AppCompatActivity() {

    private val tabIcons = intArrayOf(R.drawable.baseline_explore_white_24, R.drawable.baseline_flight_white_24, R.drawable.baseline_trips_white_24)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_tabs_tab_layout_with_text_and_icon_activity)

        initToolbar()

        //      setupTabIcons();  val viewPager = findViewById<ViewPager>(R.id.viewPager)
        setupViewPager(viewPager)

        tabLayout.setupWithViewPager(viewPager)
        setupTabIcons()

    }

    private fun setupTabIcons() {
        if (tabLayout.getTabAt(0) != null) {
            tabLayout.getTabAt(0)?.setIcon(tabIcons[0])

        }
        if (tabLayout.getTabAt(1) != null) {
            tabLayout.getTabAt(1)?.setIcon(tabIcons[1])
        }
        if (tabLayout.getTabAt(2) != null) {
            tabLayout.getTabAt(2)?.setIcon(tabIcons[2])
        }


        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val tabIconColor = ContextCompat.getColor(this@UiTabsTabLayoutWithTextAndIconActivity, R.color.md_white_1000)
                if (tab.icon != null) {
                    tab.icon?.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val tabIconColor = ContextCompat.getColor(this@UiTabsTabLayoutWithTextAndIconActivity, R.color.md_grey_300)
                if (tab.icon != null) {
                    tab.icon?.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFrag(UiContainerTabLayoutWithTextAndIconExploreFragment(), "EXPLORE")
        adapter.addFrag(UiContainerTabLayoutWithTextAndIconFlightFragment(), "FLIGHT")
        adapter.addFrag(UiContainerTabLayoutWithTextAndIconTripFragment(), "TRIP")
        viewPager.adapter = adapter
    }

    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFrag(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList[position]
        }

    }
    //region Init Toolbar

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Tab Layout with Icon and Text"

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_for_tab_layout_text_and_icon, menu)
        return true
    }
}
