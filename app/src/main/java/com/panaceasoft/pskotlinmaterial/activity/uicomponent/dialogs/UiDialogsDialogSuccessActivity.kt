package com.panaceasoft.pskotlinmaterial.activity.uicomponent.dialogs

import android.app.Dialog
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.Window
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_dialogs_dialog_success_activity.*


class UiDialogsDialogSuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_dialogs_dialog_success_activity)

        initToolbar()

        basicButton.setOnClickListener { getBasicDialog() }
        fullscreenButton.setOnClickListener { getFullScreenDialog() }
        customPrimaryButton.setOnClickListener { getCustomStyleDialog(R.style.AlertDialogPrimary) }
        customAccentButton.setOnClickListener { getCustomStyleDialog(R.style.AlertDialogAccent) }
        customLayoutPrimaryButton.setOnClickListener { getCustomLayoutDialog(R.layout.ui_widget_dialog_success_custom_layout, R.color.colorPrimary) }
        customLayoutAccentButton.setOnClickListener { getCustomLayoutDialog(R.layout.ui_widget_dialog_success_custom_layout, R.color.colorAccent) }
    }

    private fun getBasicDialog() {
        AlertDialog.Builder(this)
                .setTitle("Success")
                .setMessage("Your application is successfully uploaded.")
                .setPositiveButton("OK") { dialog, _ ->

                    dialog.cancel()
                    Toast.makeText(applicationContext, "Clicked 'OK'.", Toast.LENGTH_SHORT).show()
                }
                .setIcon(R.drawable.baseline_check_black_24)
                .show()
    }

    private fun getFullScreenDialog() {
        AlertDialog.Builder(this, R.style.AlertDialogFullScreen)
                .setTitle("Success")
                .setMessage("Your application is successfully uploaded.")
                .setPositiveButton("OK") { dialog, _ ->

                    dialog.cancel()
                    Toast.makeText(applicationContext, "Clicked 'OK'.", Toast.LENGTH_SHORT).show()
                }
                .setIcon(R.drawable.baseline_check_black_24)
                .show()
    }

    private fun getCustomStyleDialog(styleId: Int) {
        AlertDialog.Builder(ContextThemeWrapper(this, styleId))
                .setTitle("Success")
                .setMessage("Your application is successfully uploaded.")
                .setPositiveButton("OK") { dialog, _ ->

                    dialog.cancel()
                    Toast.makeText(applicationContext, "Clicked 'OK'.", Toast.LENGTH_SHORT).show()
                }
                .setIcon(R.drawable.baseline_check_white_24)
                .show()
    }

    private fun getCustomLayoutDialog(layoutId: Int, colorId: Int) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(layoutId)

        val linearLayout = dialog.findViewById<LinearLayout>(R.id.customSuccessTitleLayout)
        linearLayout.setBackgroundColor(ContextCompat.getColor(this,colorId))

        val image = dialog.findViewById<ImageView>(R.id.customSuccessIconImageView)
        image.setImageResource(R.drawable.baseline_check_white_24)

        val titleTextView = dialog.findViewById<TextView>(R.id.customSuccessTitleTextView)
        titleTextView.text = "Success"

        val msgTextView = dialog.findViewById<TextView>(R.id.customSuccessMessageTextView)
        msgTextView.text = "Your application is successfully uploaded."

        val positiveButton = dialog.findViewById<Button>(R.id.customSuccessPositiveButton)
        positiveButton.text = "OK"
        positiveButton.setTextColor(ContextCompat.getColor(this,colorId))

        positiveButton.setOnClickListener {
            dialog.cancel()
            Toast.makeText(applicationContext, "Clicked 'OK'.", Toast.LENGTH_SHORT).show()
        }

        dialog.show()
    }

    //region Init Toolbar

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Success Dialog"

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
