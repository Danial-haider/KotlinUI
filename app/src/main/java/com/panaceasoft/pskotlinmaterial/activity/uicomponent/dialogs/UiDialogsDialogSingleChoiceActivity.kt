package com.panaceasoft.pskotlinmaterial.activity.uicomponent.dialogs

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_dialogs_dialog_single_choice_activity.*


class UiDialogsDialogSingleChoiceActivity : AppCompatActivity() {

    internal lateinit var fruits: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_dialogs_dialog_single_choice_activity)

        initToolbar()

        fruits = resources.getStringArray(R.array.fruits)

        chooseButton.setOnClickListener { singleChoiceDialog() }

        chooseStyleButton.setOnClickListener { singleChoiceDialogWithStyle() }
    }

    private fun singleChoiceDialog() {
        AlertDialog.Builder(this)
                .setSingleChoiceItems(fruits, 0, null)
                .setPositiveButton("CHOOSE") { dialog, _ ->

                    val selectedPosition = (dialog as AlertDialog).listView.checkedItemPosition

                    Toast.makeText(this, fruits[selectedPosition], Toast.LENGTH_SHORT).show()

                    dialog.dismiss()
                }
                .show()
    }

    private fun singleChoiceDialogWithStyle() {
        AlertDialog.Builder(ContextThemeWrapper(this, R.style.AlertDialogPrimary))
                .setSingleChoiceItems(fruits, 0, null)
                .setPositiveButton("CHOOSE") { dialog, _ ->

                    val selectedPosition = (dialog as AlertDialog).listView.checkedItemPosition

                    Toast.makeText(this, fruits[selectedPosition], Toast.LENGTH_SHORT).show()

                    dialog.dismiss()
                }
                .show()
    }

    //region Init Toolbar
    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Single Choice Dialog"

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