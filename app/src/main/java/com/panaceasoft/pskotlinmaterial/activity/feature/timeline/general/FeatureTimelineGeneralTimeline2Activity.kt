package com.panaceasoft.pskotlinmaterial.activity.feature.timeline.general

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.widget.NestedScrollView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.tabs.TabLayout
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.fragment.feature.timeline.general.FeatureTimelineGeneralTimeline2Fragment
import com.panaceasoft.pskotlinmaterial.utils.Utils
import com.panaceasoft.pskotlinmaterial.utils.common_adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.feature_timeline_general_timeline_2_activity.*

class FeatureTimelineGeneralTimeline2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_timeline_general_timeline_2_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(this, "Clicked " + item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_edit_grey, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun initData() {

    }

    private fun initUI() {

        initToolbar()

        val collapsingToolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbar)
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this,android.R.color.transparent))

        val viewPager = findViewById<ViewPager>(R.id.viewPager)

        val index = setupViewPager(viewPager)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {

            tabLayout.layoutDirection = View.LAYOUT_DIRECTION_LTR

        } else {
            ViewCompat.setLayoutDirection(tabLayout, ViewCompat.LAYOUT_DIRECTION_LTR)
        }

        if (Utils.isRTL) {

            tabLayout.getTabAt(index - 1)?.select()
        }

        val nestedScrollView = findViewById<NestedScrollView>(R.id.nested_scroll_view)
        nestedScrollView.isFillViewport = true

        try {

            // set icon color pre-selected
            val tab1 = tabLayout.getTabAt(0)
            if (tab1 != null) {
                tab1.setIcon(R.drawable.baseline_play_list_red_24)
                if (tab1.icon != null) {
                    tab1.icon?.setColorFilter(ContextCompat.getColor(this,R.color.colorPrimary), PorterDuff.Mode.SRC_IN)
                }
            }

            val tab2 = tabLayout.getTabAt(1)
            if (tab2 != null) {
                tab2.setIcon(R.drawable.baseline_fill_clock_grey_24)
                if (tab2.icon != null) {
                    tab2.icon?.setColorFilter(ContextCompat.getColor(this,R.color.md_grey_600), PorterDuff.Mode.SRC_IN)
                }
            }

            val tab3 = tabLayout.getTabAt(2)
            if (tab3 != null) {
                tab3.setIcon(R.drawable.baseline_fill_setting_grey_24)
                if (tab3.icon != null) {
                    tab3.icon?.setColorFilter(ContextCompat.getColor(this,R.color.md_grey_600), PorterDuff.Mode.SRC_IN)
                }
            }

            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    if (tab.icon != null) {
                        tab.icon?.setColorFilter(ContextCompat.getColor(this@FeatureTimelineGeneralTimeline2Activity,R.color.colorPrimary), PorterDuff.Mode.SRC_IN)
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {
                    if (tab.icon != null) {
                        tab.icon?.setColorFilter(ContextCompat.getColor(this@FeatureTimelineGeneralTimeline2Activity,R.color.md_grey_600), PorterDuff.Mode.SRC_IN)
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

    private fun setupViewPager(viewPager: ViewPager): Int {
        val adapter = ViewPagerAdapter(supportFragmentManager)

        val fragment1 = FeatureTimelineGeneralTimeline2Fragment()

        val fragment2 = FeatureTimelineGeneralTimeline2Fragment()

        val fragment3 = FeatureTimelineGeneralTimeline2Fragment()

        if (Utils.isRTL) {
            adapter.addFragment(fragment3, "")
            adapter.addFragment(fragment2, "")
            adapter.addFragment(fragment1, "")
        } else {
            adapter.addFragment(fragment1, "")
            adapter.addFragment(fragment2, "")
            adapter.addFragment(fragment3, "")

        }
        viewPager.adapter = adapter

        return adapter.count
    }

    private fun initDataBindings() {

    }

    private fun initActions() {

    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this,R.color.md_grey_300), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "12 Tuesday"

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

        val collapsingToolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbar)

        if (Utils.isRTL) {
            collapsingToolbarLayout.collapsedTitleGravity = Gravity.END
        } else {
            collapsingToolbarLayout.collapsedTitleGravity = Gravity.START
        }
    }
}