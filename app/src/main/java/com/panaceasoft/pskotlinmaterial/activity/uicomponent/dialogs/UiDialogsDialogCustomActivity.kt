package com.panaceasoft.pskotlinmaterial.activity.uicomponent.dialogs

import android.app.Dialog
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_dialogs_dialog_custom_activity.*


class UiDialogsDialogCustomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_dialogs_dialog_custom_activity)

        initToolbar()

        val customDialogButton = findViewById<Button>(R.id.customDialogButton)
        customDialogButton.setOnClickListener { getCustomLayoutDialog(R.layout.ui_widget_dialog_custom_layout_dialog_form, R.color.colorPrimary) }

    }

    private fun getCustomLayoutDialog(layoutId: Int, colorId: Int) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(layoutId)

        val lp = WindowManager.LayoutParams()
        if (dialog.window != null) {

            lp.copyFrom(dialog.window?.attributes)
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT

            val linearLayout = dialog.findViewById<LinearLayout>(R.id.customAlertTitleLayout)
            val image = dialog.findViewById<ImageView>(R.id.customAlertIconImageView)
            val nameEditText = dialog.findViewById<EditText>(R.id.nameEditText)
            val emailEditText = dialog.findViewById<EditText>(R.id.emailEditText)
            val addressEditText = dialog.findViewById<EditText>(R.id.addressEditText)

            val positiveButton = dialog.findViewById<Button>(R.id.customAlertPositiveButton)

            linearLayout.setBackgroundColor(ContextCompat.getColor(this,colorId))
            image.setImageResource(R.drawable.baseline_android_black_24)
            positiveButton.text = "OK"

            positiveButton.setBackgroundColor(ContextCompat.getColor(this,colorId))
            positiveButton.setOnClickListener {

                dialog.cancel()
                Toast.makeText(applicationContext, "Custom Layout Dialog Button is clicked", Toast.LENGTH_SHORT).show()

                nameTextView.text = "Name: " + nameEditText.text
                emailTextView.text = "Email: " + emailEditText.text
                addressTextView.text = "Address: " + addressEditText.text
            }

            dialog.show()

            dialog.window?.attributes = lp
        }
    }

    //region Init Toolbar

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Custom Dialog"

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