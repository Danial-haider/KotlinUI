package com.panaceasoft.pskotlinmaterial.activity.feature.filter.ecommerce

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_filter_ecommerce_filter_1_activity.*

class FeatureFilterECommerceFilter1Activity : AppCompatActivity() {

    private var selectedList: Drawable? = null
    private lateinit var resetFilterTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_filter_ecommerce_filter_1_activity)

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

    private fun initData() {

    }

    private fun initUI() {

        // Init Toolbar
        initToolbar()

        selectedList = ContextCompat.getDrawable(this,R.drawable.baseline_selected_list_24)
        selectedList?.setColorFilter(ContextCompat.getColor(this,R.color.colorPrimary), PorterDuff.Mode.SRC_IN)

        resetFilterTextView = findViewById(R.id.resetFilterTextView)

    }

    private fun initDataBinding() {

    }

    private fun initActions() {
        popularButton.setOnClickListener {

            unSelectAll()

            setDrawable(popularButton, selectedList)

        }

        recentButton.setOnClickListener {

            unSelectAll()

            setDrawable(recentButton, selectedList)

        }

        lowestPriceButton.setOnClickListener {

            unSelectAll()

            setDrawable(lowestPriceButton, selectedList)

        }

        highestPriceButton.setOnClickListener {

            unSelectAll()

            setDrawable(highestPriceButton, selectedList)

        }

        nearestButton.setOnClickListener {

            unSelectAll()

            setDrawable(nearestButton, selectedList)

        }

        resetFilterTextView.setOnClickListener { Toast.makeText(this, "Clicked reset filter.", Toast.LENGTH_SHORT).show() }
    }

    private fun setDrawable(button: Button?) {
        if (Utils.isRTL) {
            val drawable = button!!.compoundDrawables[2]
            button.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null)
        } else {
            val drawable = button!!.compoundDrawables[0]
            button.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
        }
    }

    private fun setDrawable(button: Button?, drawable2: Drawable?) {
        if (Utils.isRTL) {
            val drawable = button!!.compoundDrawables[2]
            button.setCompoundDrawablesWithIntrinsicBounds(drawable2, null, drawable, null)
        } else {
            val drawable = button!!.compoundDrawables[0]
            button.setCompoundDrawablesWithIntrinsicBounds(drawable, null, drawable2, null)
        }
    }

    private fun unSelectAll() {

        // Popular
        setDrawable(popularButton)

        // Recent
        setDrawable(recentButton)

        // Lowest Price Range
        setDrawable(lowestPriceButton)

        // Highest Price Range
        setDrawable(highestPriceButton)

        // Nearest
        setDrawable(nearestButton)

    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Filter 1"

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
