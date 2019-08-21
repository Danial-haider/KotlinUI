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
import kotlinx.android.synthetic.main.ui_dialogs_dialog_multi_choice_activity.*
import java.util.*

class UiDialogsDialogMultiChoiceActivity : AppCompatActivity() {

    // String array for alert dialog multi choice items
    internal var colors = arrayOf("Red", "Green", "Blue", "Purple", "Olive")

    // Boolean array for initial selected items
    internal val checkedColors = booleanArrayOf(false, // Red
            true, // Green
            false, // Blue
            true, // Purple
            false // Olive
    )

    // Convert the color array to list
    internal val colorsList = Arrays.asList(*colors)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_dialogs_dialog_multi_choice_activity)

        initToolbar()

        chooseButton.setOnClickListener {

            multiChoiceDialog()
        }
        chooseStyleButton.setOnClickListener {

            multiChoiceDialogWithStyle()
        }
    }

    private fun multiChoiceDialog() {

        AlertDialog.Builder(this)
                .setMultiChoiceItems(colors, checkedColors) { _, which, isChecked ->

                    // Update the current focused item's checked status
                    checkedColors[which] = isChecked

                    // Get the current focused item
                    val currentItem = colorsList[which]

                    // Notify the current action
                    Toast.makeText(applicationContext,
                            "$currentItem $isChecked", Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("CHOOSE") { _, _ ->

                    var selectedItems = ""
                    for (i in checkedColors.indices) {
                        val checked = checkedColors[i]
                        if (checked) {
                            selectedItems += colorsList[i] + "\n"
                        }
                    }

                    Toast.makeText(this, selectedItems, Toast.LENGTH_SHORT).show()
                }
                .show()
    }

    private fun multiChoiceDialogWithStyle() {
        AlertDialog.Builder(ContextThemeWrapper(this, R.style.AlertDialogPrimary))
                .setMultiChoiceItems(colors, checkedColors) { _, which, isChecked ->

                    // Update the current focused item's checked status
                    checkedColors[which] = isChecked

                    // Get the current focused item
                    val currentItem = colorsList[which]

                    // Notify the current action
                    Toast.makeText(applicationContext,
                            "$currentItem $isChecked", Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("CHOOSE") { _, _ ->

                    var selectedItems = ""
                    for (i in checkedColors.indices) {
                        val checked = checkedColors[i]
                        if (checked) {
                            selectedItems += colorsList[i] + "\n"
                        }
                    }

                    Toast.makeText(this, selectedItems, Toast.LENGTH_SHORT).show()
                }
                .show()
    }

    //region Init Toolbar
    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Multi Choice Dialog"

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