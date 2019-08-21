package com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.directory

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.fragment.feature.dashboard.directory.FeatureDashboardDirectoryDashboard1Fragment
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_dashboard_directory_dashboard_1_activity.*

class FeatureDashboardDirectoryDashboard1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_dashboard_directory_dashboard_1_activity)

        initData()

        initUI()

        initDataBinding()

        initActions()

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initData() {

    }

    private fun initUI() {

        // Init Toolbar
        initToolbar()

        Utils.removeShiftMode(bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.searchMenu -> loadFragment(FeatureDashboardDirectoryDashboard1Fragment())
                //                case R.id.listMenu:
                //                    loadFragment(new AppDirectoryHome2Fragment());
                //                    break;
                //                case R.id.historyMenu:
                //                    loadFragment(new AppDirectoryHome3Fragment());
                //                    break;
                //                case R.id.profileMenu:
                //                    loadFragment(new AppDirectoryHome4Fragment());
                //                    break;
                else -> loadFragment(FeatureDashboardDirectoryDashboard1Fragment())
            }

            Toast.makeText(applicationContext, "Clicked " + item.title, Toast.LENGTH_SHORT).show()

            false
        }

        loadFragment(FeatureDashboardDirectoryDashboard1Fragment())

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

        toolbar.title = "Directory Dashboard 1"

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
