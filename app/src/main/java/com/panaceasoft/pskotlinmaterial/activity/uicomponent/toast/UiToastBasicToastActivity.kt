package com.panaceasoft.pskotlinmaterial.activity.uicomponent.toast

import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_toast_basic_toast_activity.*

class UiToastBasicToastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_toast_basic_toast_activity)

        initToolbar()
        initActions()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()

        return super.onOptionsItemSelected(item)
    }


    @SuppressLint("RtlHardcoded")
    private fun initActions() {
        simpleToastButton.setOnClickListener { Toast.makeText(this@UiToastBasicToastActivity, "Clicked Simple Toast.", Toast.LENGTH_SHORT).show() }
        topToastButton.setOnClickListener {
            val toast = Toast.makeText(this@UiToastBasicToastActivity, "Clicked Top Toast.", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.TOP, 0, 0)
            toast.show()
        }
        bottomToastButton.setOnClickListener {
            val toast = Toast.makeText(this@UiToastBasicToastActivity, "Clicked Bottom Toast.", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.BOTTOM, 0, 0)
            toast.show()
        }
        leftToastButtom.setOnClickListener {
            val toast = Toast.makeText(this@UiToastBasicToastActivity, "Clicked Left Toast.", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.LEFT, 0, 0)
            toast.show()
        }
        rightToastButtom.setOnClickListener {
            val toast = Toast.makeText(this@UiToastBasicToastActivity, "Clicked Right Toast.", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.RIGHT, 0, 0)
            toast.show()
        }
        centerToastButtom.setOnClickListener {
            val toast = Toast.makeText(this@UiToastBasicToastActivity, "Clicked Center Toast.", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
        centerHorizontalToastButtom.setOnClickListener {
            val toast = Toast.makeText(this@UiToastBasicToastActivity, "Clicked Center Horizontal Toast.", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0)
            toast.show()
        }
        centerVerticalToastButtom.setOnClickListener {
            val toast = Toast.makeText(this@UiToastBasicToastActivity, "Clicked Center Vertical Toast.", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            toast.show()
        }
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Basic Toasts"

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
