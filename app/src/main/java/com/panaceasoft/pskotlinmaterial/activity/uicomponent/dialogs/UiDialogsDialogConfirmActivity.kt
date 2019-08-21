package com.panaceasoft.pskotlinmaterial.activity.uicomponent.dialogs

import android.app.Dialog
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_dialogs_dialog_confirm_activity.*


class UiDialogsDialogConfirmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_dialogs_dialog_confirm_activity)

        initToolbar()

        basicButton.setOnClickListener { getBasicDialog() }
        fullscreenButton.setOnClickListener { getFullScreenDialog() }
        customPrimaryButton.setOnClickListener { getCustomStyleDialog(R.style.AlertDialogPrimary) }
        customAccentButton.setOnClickListener { getCustomStyleDialog(R.style.AlertDialogAccent) }
        customLayoutPrimaryButton.setOnClickListener { getCustomLayoutDialog(R.layout.ui_widget_dialog_confirm_custom_layout, R.color.colorPrimary) }
        customLayoutAccentButton.setOnClickListener { getCustomLayoutDialog(R.layout.ui_widget_dialog_confirm_custom_layout, R.color.colorAccent) }
    }

    private fun getBasicDialog() {
        AlertDialog.Builder(this)
                .setTitle("Are you sure you want to delete?")
                .setMessage("Selected item and all related information will be deleted.")
                .setPositiveButton("OK") { dialog, _ ->

                    dialog.cancel()
                    Toast.makeText(applicationContext, "Basic Dialog Positive Button is clicked", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { dialog, _ ->

                    dialog.cancel()
                    Toast.makeText(applicationContext, "Basic Dialog Negative Button is clicked", Toast.LENGTH_SHORT).show()
                }
                .setIcon(R.drawable.baseline_warning_black_24)
                .show()


    }

    private fun getFullScreenDialog() {
        AlertDialog.Builder(this, R.style.AlertDialogFullScreen)
                .setTitle("Are you sure you want to delete?")
                .setMessage("Selected item and all related information will be deleted.")
                .setPositiveButton("OK") { dialog, _ ->

                    dialog.cancel()
                    Toast.makeText(applicationContext, "Fullscreen Dialog Positive Button is clicked", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { dialog, _ ->

                    dialog.cancel()
                    Toast.makeText(applicationContext, "Fullscreen Dialog Negative Button is clicked", Toast.LENGTH_SHORT).show()
                }
                .setIcon(R.drawable.baseline_warning_black_24)
                .show()
    }

    private fun getCustomStyleDialog(styleId: Int) {
        AlertDialog.Builder(ContextThemeWrapper(this, styleId))
                .setTitle("Are you sure you want to delete?")
                .setMessage("Selected item and all related information will be deleted.")
                .setPositiveButton("OK") { dialog, _ ->

                    dialog.cancel()
                    Toast.makeText(applicationContext, "Custom Style Dialog Positive Button is clicked", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { dialog, _ ->

                    dialog.cancel()
                    Toast.makeText(applicationContext, "Custom Style Dialog Negative Button is clicked", Toast.LENGTH_SHORT).show()
                }
                .setIcon(R.drawable.baseline_access_alarm_black_24)
                .show()
    }

    private fun getCustomLayoutDialog(layoutId: Int, colorId: Int) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(layoutId)

        val linearLayout = dialog.findViewById<LinearLayout>(R.id.customConfirmTitleLayout)
        linearLayout.setBackgroundColor(ContextCompat.getColor(this,colorId))

        val image = dialog.findViewById<ImageView>(R.id.customConfirmIconImageView)
        image.setImageResource(R.drawable.baseline_warning_white_24)

        val titleTextView = dialog.findViewById<TextView>(R.id.customConfirmTitleTextView)
        titleTextView.text = "Are you sure you want to delete?"

        val msgTextView = dialog.findViewById<TextView>(R.id.customConfirmMessageTextView)
        msgTextView.text = "Selected item and all related information will be deleted."

        val positiveButton = dialog.findViewById<Button>(R.id.customConfirmPositiveButton)
        positiveButton.text = "OK"
        positiveButton.setTextColor(ContextCompat.getColor(this,colorId))

        positiveButton.setOnClickListener {

            dialog.cancel()
            Toast.makeText(applicationContext, "Custom Layout Dialog Positive Button is clicked", Toast.LENGTH_SHORT).show()
        }

        val negativeButton = dialog.findViewById<Button>(R.id.customConfirmNegativeButton)
        negativeButton.text = "Cancel"
        negativeButton.setTextColor(ContextCompat.getColor(this,colorId))

        negativeButton.setOnClickListener {

            dialog.cancel()
            Toast.makeText(applicationContext, "Custom Layout Dialog Negative Button is clicked", Toast.LENGTH_SHORT).show()
        }

        if (dialog.window != null) {
            dialog.window?.attributes = getLayoutParams(dialog)
        }
        dialog.show()
    }

    private fun getLayoutParams(dialog: Dialog): WindowManager.LayoutParams {
        val layoutParams = WindowManager.LayoutParams()
        if (dialog.window != null) {
            layoutParams.copyFrom(dialog.window?.attributes)
        }
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT

        return layoutParams
    }

    //region Init Toolbar

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Confirm Dialog"

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

