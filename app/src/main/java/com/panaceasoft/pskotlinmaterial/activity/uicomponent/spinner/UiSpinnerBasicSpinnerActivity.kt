package com.panaceasoft.pskotlinmaterial.activity.uicomponent.spinner

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_spinner_basic_spinner_activity.*
import java.util.*

class UiSpinnerBasicSpinnerActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    internal lateinit var list: ArrayList<String>
    internal lateinit var adapter: ArrayAdapter<String>

    internal lateinit var fruits: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_spinner_basic_spinner_activity)

        initToolbar()

        fruits = resources.getStringArray(R.array.fruits)

        spinner.onItemSelectedListener = this


        list = ArrayList(Arrays.asList(*fruits))

        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter
    }

    //region Init Toolbar

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Basic Spinner"


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

    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

        val item = parent.getItemAtPosition(position).toString()

        textView.text = item
    }

    override fun onNothingSelected(parent: AdapterView<*>) {

    }
}
