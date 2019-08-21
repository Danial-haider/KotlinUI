package com.panaceasoft.pskotlinmaterial.activity.uicomponent.progress

import android.graphics.PorterDuff
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_progress_progress_bar_horizontal_activity.*


class UiProgressProgressBarHorizontalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_progress_progress_bar_horizontal_activity)

        initToolbar()


        initUI()
    }


    private fun initUI() {

        progressBar.progress = 10

        val mHandler = Handler()
        val runnable = object : Runnable {
            override fun run() {
                val progress = progressBar.progress + 10
                progressBar.progress = progress
                if (progress > 100) {
                    progressBar.progress = 0
                }
                mHandler.postDelayed(this, 100)
            }
        }
        mHandler.post(runnable)


        //final Handler mHandler2 = new Handler();
        val runnable2 = object : Runnable {

            var direction = 1

            override fun run() {

                val progress: Int
                if (direction == 1) {
                    progress = progressBar2.progress + 10
                } else {
                    progress = progressBar2.progress - 10
                }
                progressBar2.progress = progress
                if (progress > 100) {
                    direction = 0
                    //progressBar2.setProgress(0);
                } else if (progress <= 0) {
                    direction = 1
                }
                mHandler.postDelayed(this, 50)
            }
        }
        mHandler.post(runnable2)

    }


    //region Init Toolbar

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Horizontal Progress Bar"

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

    //endregion
}