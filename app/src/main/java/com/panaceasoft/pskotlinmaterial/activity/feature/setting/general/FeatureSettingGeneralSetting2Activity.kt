package com.panaceasoft.pskotlinmaterial.activity.feature.setting.general

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.RangeSeekBar
import kotlinx.android.synthetic.main.feature_setting_general_setting_2_activity.*

class FeatureSettingGeneralSetting2Activity : AppCompatActivity() {

    private lateinit var seekBar: RangeSeekBar<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_setting_general_setting_2_activity)

        initUI()

        initActions()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initUI() {

        initToolbar()

        val maxValue2 = 100
        seekBar = RangeSeekBar(0, maxValue2, this)

        seekBar.selectedMinValue = 0
        seekBar.setAbsoluteMaxValue(100)

        price_range_bar_container.addView(seekBar)

    }

    private fun initActions() {
        maleSwitch.setOnClickListener { Toast.makeText(applicationContext, "Clicked Male.", Toast.LENGTH_SHORT).show() }

        femaleSwitch.setOnClickListener { Toast.makeText(applicationContext, "Clicked Female.", Toast.LENGTH_SHORT).show() }

        matchesSwitch.setOnClickListener { Toast.makeText(applicationContext, "Clicked Matches.", Toast.LENGTH_SHORT).show() }

        messageSwitch.setOnClickListener { Toast.makeText(applicationContext, "Clicked Message.", Toast.LENGTH_SHORT).show() }

        saveButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Save.", Toast.LENGTH_SHORT).show() }


        seekBar.setOnRangeSeekBarChangeListener(object : RangeSeekBar.OnRangeSeekBarChangeListener<Int> {
            override fun onRangeSeekBarValuesChanged(bar: RangeSeekBar<*>, minValue: Int, maxValue: Int) {
                Log.d("TEAMPS", "initUI: $minValue : $maxValue")
                val age = "$minValue - $maxValue"
                ageTextView.setText(age)
            }
        })

        distanceSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                Log.d("TEAMPS", "" + i)
                val result = "$i km"
                distanceTextView.text = result
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })


    }

    private fun initToolbar() {
        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this,R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Setting 2"

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
}
