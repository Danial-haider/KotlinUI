package com.panaceasoft.pskotlinmaterial.activity.feature.gdpr.general

import android.app.Dialog
import android.graphics.PorterDuff
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.feature_gdpr_general_gdpr_1_activity.*
import kotlinx.android.synthetic.main.feature_gdpr_general_gdpr_1_layout.*


@Suppress("DEPRECATION")
class FeatureGdprGeneralGdpr1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_gdpr_general_gdpr_1_activity)

        initToolbar()

        getCustomLayoutDialog(R.layout.feature_gdpr_general_gdpr_1_layout, R.color.colorPrimary)

        val iconImageView = findViewById<ImageView>(R.id.iconImageView)
        iconImageView.setOnClickListener {  getCustomLayoutDialog(R.layout.feature_gdpr_general_gdpr_1_layout, R.color.colorPrimary) }
    }

    private fun getCustomLayoutDialog(layoutId: Int, colorId: Int) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(layoutId)

        val linearLayout = dialog.customAlertTitleLayout
        linearLayout.setBackgroundColor(ContextCompat.getColor(this,colorId))

        val titleTextView = dialog.titleTextView
        titleTextView.text = "Legal & Privacy!"


        val msgTextView = dialog.messageTextView
        msgTextView.text = Html.fromHtml("By using this app, you agree to the <a href=\"http://www.panacea-soft.com/awesome_material/gdpr/terms.html\">Terms</a>, <a href=\"http://www.panacea-soft.com/awesome_material/gdpr/policy.html\">Cookie Policy</a>, <a href=\"http://www.panacea-soft.com/awesome_material/gdpr/license.html\">Privacy policy</a> and consent to having your personal information transferred to and processed in the USA.")
        msgTextView.movementMethod = LinkMovementMethod.getInstance()

        val policiesButton = dialog.policiesButton
        policiesButton.text = "POLICIES"
        policiesButton.setTextColor(ContextCompat.getColor(this,colorId))

        policiesButton.setOnClickListener {

            Toast.makeText(applicationContext, "Clicked POLICIES.", Toast.LENGTH_SHORT).show()
        }

        val acceptButton = dialog.acceptButton
        acceptButton.text = "ACCEPT"
        acceptButton.setTextColor(ContextCompat.getColor(this,colorId))

        acceptButton.setOnClickListener {

            dialog.cancel()
            Toast.makeText(applicationContext, "Clicked ACCEPT.", Toast.LENGTH_SHORT).show()
        }

        val declineButton = dialog.declineButton
        declineButton.text = "DECLINE"
        declineButton.setTextColor(ContextCompat.getColor(this,colorId))

        declineButton.setOnClickListener {

            dialog.cancel()
            Toast.makeText(applicationContext, "Clicked DECLINE.", Toast.LENGTH_SHORT).show()
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

        toolbar.title = "GDPR 1"

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
