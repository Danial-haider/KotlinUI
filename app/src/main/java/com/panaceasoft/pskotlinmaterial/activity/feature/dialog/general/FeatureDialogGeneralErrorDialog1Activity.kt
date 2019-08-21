package com.panaceasoft.pskotlinmaterial.activity.feature.dialog.general

import android.app.Dialog
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R


class FeatureDialogGeneralErrorDialog1Activity : AppCompatActivity() {

    internal lateinit var dialog: Dialog
    internal lateinit var titleTextView: TextView
    internal lateinit var msgTextView: TextView
    internal lateinit var image: ImageView
    internal lateinit var okButton: Button
    internal lateinit var retryButton: Button
    internal lateinit var closeButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_dialog_general_errordialog_1_activity)

        initUI()

        initActions()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initUI() {
        initToolbar()
        getCustomLayoutDialog(R.layout.feature_dialog_general_errordialog_1_layout)
    }

    private fun getCustomLayoutDialog(layoutId: Int) {
        dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(layoutId)


        titleTextView = dialog.findViewById(R.id.titleTextView)
        titleTextView.text = "Error !"

        msgTextView = dialog.findViewById(R.id.messageTextView)
        msgTextView.text = "Ut enim ad minim veniam, quis nostrud exercitation.Ut enim ad minim veniam, quis nostrud exercitation."

        image = dialog.findViewById(R.id.dialogImageView)
        image.setImageResource(R.drawable.error)

        okButton = dialog.findViewById(R.id.okButton)
        okButton.text = "OK"

        retryButton = dialog.findViewById(R.id.retryButton)
        retryButton.text = "RETRY"

        closeButton = dialog.findViewById(R.id.closeButton)

        if (dialog.window != null) {
            dialog.window?.attributes = getLayoutParams(dialog)
        }

        dialog.show()
    }

    private fun initActions() {

        okButton.setOnClickListener {

            dialog.cancel()
            Toast.makeText(applicationContext, "Clicked OK.", Toast.LENGTH_SHORT).show()
        }

        retryButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Retry.", Toast.LENGTH_SHORT).show() }

        closeButton.setOnClickListener {

            dialog.cancel()
            Toast.makeText(applicationContext, "Clicked Close.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initToolbar() {

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Error Dialog"

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

    private fun getLayoutParams(dialog: Dialog): WindowManager.LayoutParams {
        val layoutParams = WindowManager.LayoutParams()
        if (dialog.window != null) {
            layoutParams.copyFrom(dialog.window?.attributes)
        }
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT

        return layoutParams
    }
}
