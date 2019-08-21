package com.panaceasoft.pskotlinmaterial.activity.uicomponent.snackbars

import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.ui_snack_bars_custom_bar_activity.*

class UiSnackBarsCustomSnackBarActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_snack_bars_custom_bar_activity)

        initToolbar()

        initUiAction()

    }


    fun initUiAction() {

        normalSnackBarButton.setOnClickListener {
            val normalSnackBar = Snackbar.make(constraintLayout, "Awesome Material is one of the featured item of Panacea-Soft.", Snackbar.LENGTH_SHORT)
            val normalSnackBarView = normalSnackBar.view
            normalSnackBarView.setBackgroundColor(ContextCompat.getColor(this,R.color.md_green_900))
            normalSnackBar.show()
        }

        normalTextAlignMiddleSnackBarButton.setOnClickListener {
            val normalTextAlignMiddleSnackBar = Snackbar.make(constraintLayout, "Your Message!", Snackbar.LENGTH_SHORT)
            val normalTextAlignMiddleSnackBarView = normalTextAlignMiddleSnackBar.view
            normalTextAlignMiddleSnackBarView.setBackgroundColor(ContextCompat.getColor(this,R.color.md_green_900))

            val normalTextAlignMiddleSnackBarTextView = normalTextAlignMiddleSnackBarView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            normalTextAlignMiddleSnackBarTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
            normalTextAlignMiddleSnackBar.show()
        }

        normalWithActionSnackBarButton.setOnClickListener {
            val normalWithActionSnackBar = Snackbar.make(constraintLayout, "", Snackbar.LENGTH_LONG)
            val layout = normalWithActionSnackBar.view as Snackbar.SnackbarLayout
            val textView = layout.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            textView.visibility = View.INVISIBLE
            val inflater = layoutInflater
            @SuppressLint("InflateParams") val snackView = inflater.inflate(R.layout.ui_snack_bars_custom_snack_bar_open_snack_bar_and_normal_with_action_layout, null)

            val undoTextView = snackView.findViewById<TextView>(R.id.textView407)
            undoTextView.setOnClickListener { Toast.makeText(this@UiSnackBarsCustomSnackBarActivity, "Clicked UNDO", Toast.LENGTH_SHORT).show() }
            layout.setPadding(0, 0, 0, 0)
            layout.addView(snackView, 0)
            normalWithActionSnackBar.show()
        }


        cardSnackBarButton.setOnClickListener {
            val normalTextAlignMiddleSnackBar = Snackbar.make(constraintLayout, "", Snackbar.LENGTH_LONG)
            val layout = normalTextAlignMiddleSnackBar.view as Snackbar.SnackbarLayout
            val textView = layout.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            textView.visibility = View.INVISIBLE
            val inflater = layoutInflater
            @SuppressLint("InflateParams") val snackView = inflater.inflate(R.layout.ui_snack_bars_custom_snack_bar_open_snack_bar_and_card_layout, null)

            layout.setPadding(0, 0, 0, 0)
            layout.addView(snackView, 0)
            normalTextAlignMiddleSnackBar.show()
        }

        cardWithActionSnackBarButton.setOnClickListener {
            val cardWithActionSnackBar = Snackbar.make(constraintLayout, "", Snackbar.LENGTH_LONG)
            val layout = cardWithActionSnackBar.view as Snackbar.SnackbarLayout
            val textView = layout.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            textView.visibility = View.INVISIBLE
            val inflater = layoutInflater
            @SuppressLint("InflateParams") val snackView = inflater.inflate(R.layout.ui_snack_bars_custom_snack_bar_open_snack_bar_and_card_with_action_layout, null)

            val retryTextView = snackView.findViewById<TextView>(R.id.textView415)
            retryTextView.setOnClickListener { Toast.makeText(this@UiSnackBarsCustomSnackBarActivity, "Clicked RETRY", Toast.LENGTH_SHORT).show() }
            layout.setPadding(0, 0, 0, 0)
            layout.addView(snackView, 0)
            cardWithActionSnackBar.show()
        }

        cardWithImageSnackBarButton.setOnClickListener {
            val cardWithImageSnackBar = Snackbar.make(constraintLayout, "", Snackbar.LENGTH_LONG)
            val layout = cardWithImageSnackBar.view as Snackbar.SnackbarLayout
            val textView = layout.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            textView.visibility = View.INVISIBLE
            val inflater = layoutInflater
            @SuppressLint("InflateParams") val snackView = inflater.inflate(R.layout.ui_snack_bars_custom_snack_bar_open_snack_bar_and_card_with_image_layout, null)


            val circleImage = snackView.findViewById<ImageView>(R.id.rowImageView)
            Utils.setCircleImageToImageView(applicationContext, circleImage, R.drawable.profile1, 0, 0)

            val viewTextView = snackView.findViewById<TextView>(R.id.textView416)
            viewTextView.setOnClickListener { Toast.makeText(this@UiSnackBarsCustomSnackBarActivity, "Clicked VIEW", Toast.LENGTH_SHORT).show() }
            layout.setPadding(0, 0, 0, 0)
            layout.addView(snackView, 0)
            cardWithImageSnackBar.show()
        }

        successSnackBarButton.setOnClickListener {
            val successSnackBar = Snackbar.make(constraintLayout, "YOUR ACTION IS SUCCESS!", Snackbar.LENGTH_LONG)
            val successSnackBarView = successSnackBar.view
            successSnackBarView.setBackgroundColor(ContextCompat.getColor(this,R.color.md_success_color))

            val successSnackBarTextView = successSnackBarView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            successSnackBarTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_check_circle_black_24dp, 0, 0, 0)
            successSnackBarTextView.compoundDrawablePadding = resources.getDimensionPixelOffset(R.dimen.space_16)
            successSnackBar.show()
        }

        warningSnackBarButton.setOnClickListener {
            val warningSnackBar = Snackbar.make(constraintLayout, "YOUR GOT WARNING!", Snackbar.LENGTH_LONG)
            val warningSnackBarView = warningSnackBar.view
            warningSnackBarView.setBackgroundColor(ContextCompat.getColor(this,R.color.md_warning_color))

            val warningSnackBarTextView = warningSnackBarView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            warningSnackBarTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_warning_black_24dp, 0, 0, 0)
            warningSnackBarTextView.compoundDrawablePadding = resources.getDimensionPixelOffset(R.dimen.space_16)
            warningSnackBar.show()
        }

        errorSnackBarButton.setOnClickListener {
            val errorSnackBar = Snackbar.make(constraintLayout, "YOUR GOT ERROR!", Snackbar.LENGTH_LONG)
            val errorSnackBarView = errorSnackBar.view
            errorSnackBarView.setBackgroundColor(ContextCompat.getColor(this,R.color.md_error_color))

            val errorSnackBarTextView = errorSnackBarView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            errorSnackBarTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_clear_black_24dp, 0, 0, 0)
            errorSnackBarTextView.compoundDrawablePadding = resources.getDimensionPixelOffset(R.dimen.space_16)
            errorSnackBar.show()
        }

        infoSnackBarButton.setOnClickListener {
            val infoSnackBar = Snackbar.make(constraintLayout, "SOME INFORMATION FOR YOU!", Snackbar.LENGTH_LONG)
            val infoSnackBarView = infoSnackBar.view
            infoSnackBarView.setBackgroundColor(ContextCompat.getColor(this,R.color.md_info_color))

            val infoSnackBarTextView = infoSnackBarView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            infoSnackBarTextView.textAlignment = View.TEXT_ALIGNMENT_GRAVITY
            infoSnackBarTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_info_outline_black_24dp, 0, 0, 0)
            infoSnackBarTextView.compoundDrawablePadding = resources.getDimensionPixelOffset(R.dimen.space_16)

            infoSnackBar.show()
        }
    }
    //region Init Toolbar

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Custom SnackBar"

        try {
           toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.md_white_1000)) }catch (e: Exception) {
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
