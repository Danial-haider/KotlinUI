package com.panaceasoft.pskotlinmaterial.activity.application.directory.home

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.fragment.application.directory.home.AppDirectoryHome4Fragment
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_directory_home_4_activity.*

class AppDirectoryHome4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_directory_home_4_activity)

        initData()

        initUI()

        initDataBinding()

        initActions()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_more, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(this, "Clicked " + item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initData() {

    }

    private fun initUI() {

        // Init Toolbar
        initToolbar()
        Utils.removeShiftMode(bottomNavigationView)

        bottomNavigationView.selectedItemId = R.id.profileMenu
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                //                case R.id.searchMenu:
                //                    loadFragment(new AppDirectoryHome1Fragment());
                //                    break;
                //                case R.id.listMenu:
                //                    loadFragment(new AppDirectoryHome2Fragment());
                //                    break;
                //                case R.id.historyMenu:
                //                    loadFragment(new AppDirectoryHome3Fragment());
                //                    break;
                R.id.profileMenu -> loadFragment(AppDirectoryHome4Fragment())
                else -> Toast.makeText(applicationContext, "Clicked " + item.title, Toast.LENGTH_SHORT).show()
            }

            false
        }

        loadFragment(AppDirectoryHome4Fragment())

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

        toolbar.title = "Home 4"

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
                .replace(R.id.content_frame, fragment)
                .commitAllowingStateLoss()
    }

}
