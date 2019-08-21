package com.panaceasoft.pskotlinmaterial.activity.feature.setting.general

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.feature_setting_general_setting_1_activity.*


class FeatureSettingGeneralSetting1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_setting_general_setting_1_activity)

        initToolbar()

        initActions()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


    private fun initActions() {
        policyButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Policy.", Toast.LENGTH_SHORT).show() }

        legalButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Legal.", Toast.LENGTH_SHORT).show() }

        timeSwitch.setOnClickListener { Toast.makeText(applicationContext, "Clicked Timestamp.", Toast.LENGTH_SHORT).show() }

        messageSwitch.setOnClickListener { Toast.makeText(applicationContext, "Clicked Message Preview.", Toast.LENGTH_SHORT).show() }

        syncSwitch.setOnClickListener { Toast.makeText(applicationContext, "Clicked Sync.", Toast.LENGTH_SHORT).show() }

        facebookView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Facebook.", Toast.LENGTH_SHORT).show() }

        twitterView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Twitter.", Toast.LENGTH_SHORT).show() }

        keyboardImageView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Keyboard.", Toast.LENGTH_SHORT).show() }

        notiImageView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Notification.", Toast.LENGTH_SHORT).show() }
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Setting 1"

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
