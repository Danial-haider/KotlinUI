package com.panaceasoft.pskotlinmaterial.activity.uicomponent.text

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.MultiAutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_text_text_view_advanced_activity.*


class UiTextTextViewAdvancedActivity : AppCompatActivity() {

    internal lateinit var fruits: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_text_text_view_advanced_activity)

        initToolbar()

        fruits = resources.getStringArray(R.array.fruits)

        setDataToAutoCompleteTextView()

        setDataToMultiAutoCompleteTextView()

        setCheckedTextView()
    }

    private fun setDataToAutoCompleteTextView() {
        val adapter = ArrayAdapter(this, android.R.layout.select_dialog_item, fruits)

        val actv = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)

        actv.threshold = 1//will start working from first character

        actv.setAdapter(adapter)//setting the adapter data into the AutoCompleteTextView

        val autoCompleteLeftIconTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteLeftIconTextView)

        autoCompleteLeftIconTextView.threshold = 1//will start working from first character

        autoCompleteLeftIconTextView.setAdapter(adapter)//setting the adapter data into the AutoCompleteTextView

        val autoCompleteRightIconTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteRightIconTextView)

        autoCompleteRightIconTextView.threshold = 1//will start working from first character

        autoCompleteRightIconTextView.setAdapter(adapter)//setting the adapter data into the AutoCompleteTextView
    }

    private fun setDataToMultiAutoCompleteTextView() {
        val TopicName = ArrayAdapter(this, android.R.layout.select_dialog_item, fruits)

        val actv = findViewById<MultiAutoCompleteTextView>(R.id.multiAutoCompleteTextView)

        actv.setAdapter<ArrayAdapter<String>>(TopicName)

        actv.threshold = 1

        actv.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

        val multiAutoCompleteLeftIconTextView = findViewById<MultiAutoCompleteTextView>(R.id.multiAutoCompleteLeftIconTextView)

        multiAutoCompleteLeftIconTextView.setAdapter<ArrayAdapter<String>>(TopicName)

        multiAutoCompleteLeftIconTextView.threshold = 1

        multiAutoCompleteLeftIconTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

        val multiAutoCompleteRightIconTextView = findViewById<MultiAutoCompleteTextView>(R.id.multiAutoCompleteRightIconTextView)

        multiAutoCompleteRightIconTextView.setAdapter<ArrayAdapter<String>>(TopicName)

        multiAutoCompleteRightIconTextView.threshold = 1

        multiAutoCompleteRightIconTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
    }

    private fun setCheckedTextView() {

        checkedTextView.setOnClickListener {

            if (checkedTextView.isChecked) {

                checkedTextView.setCheckMarkDrawable(R.drawable.baseline_check_box_outline_blank_black_24)
                checkedTextView.isChecked = false
            } else {

                checkedTextView.setCheckMarkDrawable(R.drawable.baseline_check_box_black_24)
                checkedTextView.isChecked = true
            }
        }
    }

    //region Init Toolbar

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Advanced TextView"

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
}

