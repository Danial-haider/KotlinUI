package com.panaceasoft.pskotlinmaterial.activity.feature.expandable.ecommerce

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.feature_expandable_ecommerce_expandable_2_activity.*

class FeatureExpandableECommerceExpandable2Activity : AppCompatActivity() {

    private var isOpen1: Boolean = false
    private var isOpen2: Boolean = false

    //region override methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_expandable_ecommerce_expandable_2_activity)

        initUI()

        initActions()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(applicationContext, item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
    //endregion

    //region Init Functions

    private fun initUI() {
        initToolbar()
        detailsLinearLayout.visibility = View.GONE
        detailsLinearLayout1.visibility = View.GONE

    }

    private fun initActions() {

        toggleTextView.setOnClickListener {
            if ((isOpen1)) {
                detailsLinearLayout.visibility = View.VISIBLE
                toggleTextView.text = "Hide Details"
                isOpen1 = true
            } else {
                detailsLinearLayout.visibility = View.GONE
                isOpen1 = false
                toggleTextView.text = "Show Details"
            }
        }

        toggleTextView1.setOnClickListener {
            if ((isOpen2)) {
                detailsLinearLayout1.visibility = View.VISIBLE
                isOpen2 = true
                toggleTextView1.text = "Hide Details"
            } else {
                detailsLinearLayout1.visibility = View.GONE
                isOpen2 = false
                toggleTextView1.text = "Show Details"
            }
        }

        copyImageView1.setOnClickListener {
            val cManager = applicationContext.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val cData = ClipData.newPlainText("text", transactionNoTextView1.text)
            cManager.primaryClip = cData
            Toast.makeText(applicationContext, "Copied to clipboard.", Toast.LENGTH_SHORT).show()
        }

        copyImageView2.setOnClickListener {
            val cManager = applicationContext.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val cData = ClipData.newPlainText("text", transactionNoTextView2.text)
            cManager.primaryClip = cData
            Toast.makeText(applicationContext, "Copied to clipboard.", Toast.LENGTH_SHORT).show()
        }

    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this,R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)

        }

        toolbar.title = "Expandable 2"

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
    //endregion
}
