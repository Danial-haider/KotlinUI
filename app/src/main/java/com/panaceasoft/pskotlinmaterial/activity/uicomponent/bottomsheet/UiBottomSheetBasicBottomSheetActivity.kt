package com.panaceasoft.pskotlinmaterial.activity.uicomponent.bottomsheet

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_bottom_sheet_basic_bottom_sheet_activity.*
import kotlinx.android.synthetic.main.ui_bottom_sheet_basic_bottom_sheet_list.*

class UiBottomSheetBasicBottomSheetActivity : AppCompatActivity() {

    internal lateinit var dialog: BottomSheetDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_bottom_sheet_basic_bottom_sheet_activity)

        initToolbar()
        initActions()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()

        return super.onOptionsItemSelected(item)
    }

    private fun initActions() {

        itemImageView.setOnClickListener {  MyCustomerBottomSheetDialog() }

        itemImageView2.setOnClickListener {  MyCustomerBottomSheetDialog() }
        itemImageView3.setOnClickListener {  MyCustomerBottomSheetDialog() }
        itemImageView24.setOnClickListener {  MyCustomerBottomSheetDialog() }
        itemImageView35.setOnClickListener {  MyCustomerBottomSheetDialog() }
        itemImageView246.setOnClickListener {  MyCustomerBottomSheetDialog() }
        itemImageView357.setOnClickListener {  MyCustomerBottomSheetDialog() }
        itemImageView2468.setOnClickListener {  MyCustomerBottomSheetDialog() }

    }

    fun MyCustomerBottomSheetDialog() {
        dialog = BottomSheetDialog(this@UiBottomSheetBasicBottomSheetActivity)

        dialog.setContentView(R.layout.ui_bottom_sheet_basic_bottom_sheet_list)

        val shareTextView = dialog.shareUiBottomSheet
        shareTextView.setOnClickListener {  Toast.makeText(this@UiBottomSheetBasicBottomSheetActivity, "Clicked Shared.", Toast.LENGTH_SHORT).show() }

        val getLinkTextView = dialog.getLinkUiBottomSheet
        getLinkTextView.setOnClickListener {  Toast.makeText(this@UiBottomSheetBasicBottomSheetActivity, "Clicked Get Link.", Toast.LENGTH_SHORT).show() }
        dialog.show()

        val downloadTextView = dialog.downloadUiBottomSheet
        downloadTextView.setOnClickListener {  Toast.makeText(this@UiBottomSheetBasicBottomSheetActivity, "Clicked Download.", Toast.LENGTH_SHORT).show() }
        dialog.show()

        val viewDetailTextView = dialog.viewDetailUiBottomSheet
        viewDetailTextView.setOnClickListener {  Toast.makeText(this@UiBottomSheetBasicBottomSheetActivity, "Clicked View Detail.", Toast.LENGTH_SHORT).show() }
        dialog.show()
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Basic Bottom Sheet"

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
