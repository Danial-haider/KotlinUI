package com.panaceasoft.pskotlinmaterial.activity.uicomponent.fragment

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_fragment_basic_fragment_full_inside_activity.*

class UiFragmentBasicFragmentFullInsideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_fragment_basic_fragment_full_inside_activity)

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

    //region Init Functions
    private fun initData() {

    }

    private fun initUI() {
        initToolbar()
    }

    private fun initDataBinding() {

    }

    private fun initActions() {

        twitterImageView.setOnClickListener {  Toast.makeText(this, "Clicked Twitter.", Toast.LENGTH_SHORT).show() }
        facebookImageView.setOnClickListener {  Toast.makeText(this, "Clicked Facebook.", Toast.LENGTH_SHORT).show() }
        linkedinImageView.setOnClickListener {  Toast.makeText(this, "Clicked Linked In.", Toast.LENGTH_SHORT).show() }

    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Basic(Full Fragment Inside Activity)"

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
}

