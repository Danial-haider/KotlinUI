package com.panaceasoft.pskotlinmaterial.activity.application.directory.home

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
import com.panaceasoft.pskotlinmaterial.fragment.application.directory.home.AppDirectoryHome10Fragment
import com.panaceasoft.pskotlinmaterial.utils.Utils
import com.panaceasoft.pskotlinmaterial.utils.common_adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.app_directory_home_10_activity.*

class AppDirectoryHome10Activity : AppCompatActivity() {

    private val tabIcons = intArrayOf(R.drawable.baseline_home_black_24, R.drawable.baseline_star_24, R.drawable.baseline_profile_card_black_24)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_directory_home_10_activity)

        initData()

        initUI()

        initDataBinding()

        initActions()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_info_more, menu)

        Utils.updateMenuIconColor(menu, ContextCompat.getColor(this,R.color.md_white_1000))

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
        initToolbar()

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        setupViewPager(viewPager)

        tab_layout.setupWithViewPager(viewPager)

        tab_layout.setTabTextColors(ContextCompat.getColor(this,R.color.md_white_1000), ContextCompat.getColor(this,R.color.md_white_1000))

        setupTabIcons()

        try {

            // set icon color pre-selected
            val tab1 = tab_layout.getTabAt(0)
            if (tab1 != null) {
                tab1.setIcon(R.drawable.baseline_home_black_24)
                if (tab1.icon != null) {
                    tab1.icon?.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN)
                }
            }

            val tab2 = tab_layout.getTabAt(1)
            if (tab2 != null) {
                tab2.setIcon(R.drawable.baseline_star_24)
                if (tab2.icon != null) {
                    tab2.icon?.setColorFilter(ContextCompat.getColor(this,R.color.md_grey_200), PorterDuff.Mode.SRC_IN)
                }
            }

            val tab3 = tab_layout.getTabAt(2)
            if (tab3 != null) {
                tab3.setIcon(R.drawable.baseline_profile_card_black_24)
                if (tab3.icon != null) {
                    tab3.icon?.setColorFilter(ContextCompat.getColor(this,R.color.md_grey_200), PorterDuff.Mode.SRC_IN)
                }
            }

            tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    if (tab.icon != null) {
                        tab.icon?.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN)
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {
                    if (tab.icon != null) {
                        tab.icon?.setColorFilter(ContextCompat.getColor(this@AppDirectoryHome10Activity,R.color.md_grey_200), PorterDuff.Mode.SRC_IN)
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

        toolbar.title = "Home 10"

        try {
            toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.md_white_1000))
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

    private fun setupTabIcons() {
        tab_layout.getTabAt(0)?.setIcon(tabIcons[0])
        tab_layout.getTabAt(1)?.setIcon(tabIcons[1])
        tab_layout.getTabAt(2)?.setIcon(tabIcons[2])


    }


    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)

        val fragment1 = AppDirectoryHome10Fragment()
        fragment1.setType("A")

        val fragment2 = AppDirectoryHome10Fragment()
        fragment2.setType("B")

        val fragment3 = AppDirectoryHome10Fragment()
        fragment3.setType("C")


        adapter.addFragment(fragment1, "Home")
        adapter.addFragment(fragment2, "Popular")
        adapter.addFragment(fragment3, "Profile")
        viewPager.adapter = adapter
    }


}
