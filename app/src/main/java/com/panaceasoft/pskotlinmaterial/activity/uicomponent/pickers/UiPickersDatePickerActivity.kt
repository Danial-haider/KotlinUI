package com.panaceasoft.pskotlinmaterial.activity.uicomponent.pickers

import android.app.DatePickerDialog
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_widget_calendar_date_picker_activity.*
import java.text.SimpleDateFormat
import java.util.*

class UiPickersDatePickerActivity : AppCompatActivity() {

    internal var dateTime = Calendar.getInstance()

    val datePickerDialog = (object : DatePickerDialog.OnDateSetListener{
        override fun onDateSet(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
            dateTime.set(Calendar.YEAR, year)
            dateTime.set(Calendar.MONTH, monthOfYear)
            dateTime.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateDate()
        }
    })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_widget_calendar_date_picker_activity)

        initToolbar()

        initUI()
    }

    private fun initUI() {
        val button = findViewById<Button>(R.id.getDateButton)
        button.setOnClickListener { openDatePicker() }
    }

    private fun openDatePicker() {
        DatePickerDialog(this, datePickerDialog, dateTime.get(Calendar.YEAR), dateTime.get(Calendar.MONTH), dateTime.get(Calendar.DAY_OF_MONTH)).show()
    }

    private fun updateDate() {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val shortTimeStr = sdf.format(dateTime.time)
        dateTextView.text = shortTimeStr
    }

    //region Init Toolbar

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Date Picker"

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

