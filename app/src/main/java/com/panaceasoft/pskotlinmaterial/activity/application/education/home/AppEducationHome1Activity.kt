package com.panaceasoft.pskotlinmaterial.activity.application.education.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.fragment.application.education.home.home1.AppEducationHome1Fragment
import kotlinx.android.synthetic.main.app_education_home_1_activity.*

class AppEducationHome1Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_education_home_1_activity)

        initData()

        initUI()

        initDataBinding()

        initActions()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
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


        bottomNavigationView.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.searchMenu -> loadFragment(AppEducationHome1Fragment())
            }

            true
        }

        loadFragment(AppEducationHome1Fragment())

    }

    private fun initDataBinding() {

    }

    private fun initActions() {

    }

    private fun loadFragment(fragment: Fragment) {
        this.supportFragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commitAllowingStateLoss()
    }

}
