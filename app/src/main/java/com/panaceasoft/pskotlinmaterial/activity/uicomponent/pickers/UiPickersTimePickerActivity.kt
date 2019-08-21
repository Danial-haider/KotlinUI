package com.panaceasoft.pskotlinmaterial.activity.uicomponent.pickers

import android.app.TimePickerDialog
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_widget_calendar_time_picker_activity.*
import java.text.SimpleDateFormat
import java.util.*

class UiPickersTimePickerActivity : AppCompatActivity() {

    internal var dateTime = Calendar.getInstance()

    val timePickerDialog = (object : TimePickerDialog.OnTimeSetListener {
        override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
            dateTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
            dateTime.set(Calendar.MINUTE, minute)
            updateTime()
        }

    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_widget_calendar_time_picker_activity)

        initToolbar()

        initUI()
    }

    private fun initUI() {
        val button = findViewById<Button>(R.id.getTimeButton)
        button.setOnClickListener { openTimePicker() }
    }

    private fun openTimePicker() {
        TimePickerDialog(this, timePickerDialog, dateTime.get(Calendar.HOUR_OF_DAY), dateTime.get(Calendar.MINUTE), true).show()
    }

    private fun updateTime() {
        val sdf = SimpleDateFormat("HH:mm aa", Locale.US)
        val shortTimeStr = sdf.format(dateTime.time)
        timeTextView.text = shortTimeStr
    }

    //region Init Toolbar

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Time Picker"

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

