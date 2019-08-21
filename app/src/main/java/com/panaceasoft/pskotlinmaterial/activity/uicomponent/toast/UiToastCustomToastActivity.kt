package com.panaceasoft.pskotlinmaterial.activity.uicomponent.toast

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.ui_toast_custom_toast_activity.*

class UiToastCustomToastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_toast_custom_toast_activity)

        initToolbar()
        initActions()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()

        return super.onOptionsItemSelected(item)
    }

    private fun initActions() {

        toastCard.setOnClickListener {
            val inflater = layoutInflater
            val view = inflater.inflate(R.layout.ui_toast_custom_toast_toast_card_layout,
                    findViewById<ViewGroup>(R.id.linearLayoutWithToastCard))

            val toast = Toast(this@UiToastCustomToastActivity)
            toast.view = view
            toast.show()
        }
        toastCardWithMultilineText.setOnClickListener {
            val inflater = layoutInflater
            val view = inflater.inflate(R.layout.ui_toast_custom_toast_card_with_multi_line_text_layout,
                    findViewById<ViewGroup>(R.id.linearLayoutMultilineText))

            val toast = Toast(this@UiToastCustomToastActivity)
            toast.view = view
            toast.show()
        }
        toastCardWithImageAndText.setOnClickListener {
            val inflater = layoutInflater
            val view = inflater.inflate(R.layout.ui_toast_custom_toast_card_with_image_and_text_layout,
                    findViewById<ViewGroup>(R.id.constraintLayoutForImageAndText))

            val circleImage = view.findViewById<ImageView>(R.id.rowImageView)
            Utils.setCircleImageToImageView(applicationContext, circleImage, R.drawable.profile1, 0, 0)
            val toast = Toast(this@UiToastCustomToastActivity)
            toast.view = view
            toast.show()
        }

        toastIconError.setOnClickListener {
            val inflater = layoutInflater
            val view = inflater.inflate(R.layout.ui_toast_custom_toast_error_toast_layout,
                    findViewById<ViewGroup>(R.id.constraintLayoutForError))

            val toast = Toast(this)
            toast.view = view
            toast.show()
        }

        toastIconSuccess.setOnClickListener {
            val inflater = layoutInflater
            val view = inflater.inflate(R.layout.ui_toast_custom_toast_success_toast_layout,
                    findViewById<ViewGroup>(R.id.constraintLayoutForSuccess))

            val toast = Toast(this)
            toast.view = view
            toast.show()
        }

        toastIconInfo.setOnClickListener {
            val inflater = layoutInflater
            val view = inflater.inflate(R.layout.ui_toast_custom_toast_info_toast_layout,
                    findViewById<ViewGroup>(R.id.constraintLayoutForInfo))

            val toast = Toast(this)
            toast.view = view
            toast.show()
        }

        toastIconWarning.setOnClickListener {
            val inflater = layoutInflater
            val view = inflater.inflate(R.layout.ui_toast_custom_toast_warning_toast_layout,
                    findViewById<ViewGroup>(R.id.constraintLayoutForWarning))

            val toast = Toast(this)
            toast.view = view
            toast.show()
        }
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Custom Toasts"

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
