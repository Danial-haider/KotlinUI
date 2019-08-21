package com.panaceasoft.pskotlinmaterial.activity.uicomponent.font

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_font_custom_font_activity.*

class UiFontCustomFontActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_font_custom_font_activity)

        initToolbar()
        initActions()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()

        return super.onOptionsItemSelected(item)
    }

    private fun initActions() {
        robotoFontTextView.setOnClickListener { Toast.makeText(this@UiFontCustomFontActivity, "Roboto Font.", Toast.LENGTH_LONG).show() }
        spaceMonoFontTextView.setOnClickListener { Toast.makeText(this@UiFontCustomFontActivity, "SpaceMono Font.", Toast.LENGTH_LONG).show() }
        inknutAntiquaFontTextView.setOnClickListener { Toast.makeText(this@UiFontCustomFontActivity, "InknutAntiqua Font.", Toast.LENGTH_LONG).show() }
        dancingScriptFontTextView.setOnClickListener { Toast.makeText(this@UiFontCustomFontActivity, "DancingScript Font.", Toast.LENGTH_LONG).show() }
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Custom Font"

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
