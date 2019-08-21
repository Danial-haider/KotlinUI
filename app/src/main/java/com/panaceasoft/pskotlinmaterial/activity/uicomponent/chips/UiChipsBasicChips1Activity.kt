package com.panaceasoft.pskotlinmaterial.activity.uicomponent.chips

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_chips_basic_chips_1_activity.*

class UiChipsBasicChips1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_chips_basic_chips_1_activity)

        initToolbar()
        etValue.setOnEditorActionListener { v, actionId, _ ->

            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val txtVal = v.text

                if (txtVal != "") {
                    this@UiChipsBasicChips1Activity.addChildToGroup(txtVal.toString(), chipGroup2)
                    etValue.setText("")
                }
//                return@etValue.setOnEditorActionListener true
            }
            false
        }

    }

    private fun addChildToGroup(txt: String, chipGroup: ChipGroup) {

        val chip = Chip(this@UiChipsBasicChips1Activity, null, R.style.Widget_MaterialComponents_Chip_Entry)
        chip.text = txt
        chip.isCloseIconVisible = true
        chip.setCloseIconTintResource(R.color.md_white_1000)
        chip.setChipBackgroundColorResource(R.color.md_blue_500)
        chip.setTextColor(ContextCompat.getColor(this,R.color.md_white_1000))
        chipGroup.addView(chip)
        chip.setOnCloseIconClickListener {
            chipGroup.removeView(chip)
            printChipsValue(chipGroup)
        }
    }


    private fun printChipsValue(chipGroup: ChipGroup) {

        for (i in 0 until chipGroup.childCount) {
            chipGroup.getChildAt(i)
        }
    }

    //region Init Toolbar

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Basic Chips Input 1"

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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_edit, menu)
        return super.onCreateOptionsMenu(menu)
    }
}