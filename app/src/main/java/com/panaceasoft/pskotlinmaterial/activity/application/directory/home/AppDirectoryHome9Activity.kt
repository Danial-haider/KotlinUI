package com.panaceasoft.pskotlinmaterial.activity.application.directory.home

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.fragment.application.directory.home.AppDirectoryHome9Fragment
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_directory_home_9_activity.*

class AppDirectoryHome9Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_directory_home_9_activity)

        initData()

        initUI()

        initDataBinding()

        initAction()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_more, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initData() {}

    private fun initUI() {
        initToolbar()


        Utils.removeShiftMode(home9BottomNavigation)

        val bottomNavigationMenuView = home9BottomNavigation.getChildAt(0) as BottomNavigationMenuView
        val v = bottomNavigationMenuView.getChildAt(2)
        val itemView = v as BottomNavigationItemView

        val badge = LayoutInflater.from(this)
                .inflate(R.layout.app_directory_home_9_notification_item, bottomNavigationMenuView, false)
        val tv = badge.findViewById<TextView>(R.id.notification_badge)
        tv.text = "8+"
        itemView.addView(badge)

        home9BottomNavigation.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.searchMenu -> loadFragment(AppDirectoryHome9Fragment())
                //                case R.id.listMenu:
                //                    loadFragment(new AppDirectoryHome2Fragment());
                //                    break;
                //                case R.id.historyMenu:
                //                    loadFragment(new AppDirectoryHome3Fragment());
                //                    break;
                //                case R.id.profileMenu:
                //                    loadFragment(new AppDirectoryHome4Fragment());
                //                    break;
                else -> loadFragment(AppDirectoryHome9Fragment())
            }

            Toast.makeText(applicationContext, "Clicked " + item.title, Toast.LENGTH_SHORT).show()

            false
        }

        loadFragment(AppDirectoryHome9Fragment())

    }

    private fun initDataBinding() {}

    private fun initAction() {}

    private fun initToolbar() {
        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Home 9"

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

    private fun loadFragment(fragment: Fragment) {
        this.supportFragmentManager.beginTransaction()
                .replace(R.id.home9Frame, fragment)
                .commitAllowingStateLoss()
    }
}
