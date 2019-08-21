package com.panaceasoft.pskotlinmaterial.activity.feature.login

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_login_general_login_4_activity.*

class FeatureLoginGeneralLogin4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_login_general_login_4_activity)

        initToolbar()

        initDataBindings()

        initActions()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(applicationContext, item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
    //endregion


    //region Init Functions

    private fun initDataBindings() {
        val id = R.drawable.login4_background
        Utils.setImageToImageView(applicationContext, bgImageView, id)
    }

    private fun initActions() {
        loginButton.setOnClickListener {  Toast.makeText(applicationContext, "Clicked Login", Toast.LENGTH_SHORT).show() }

        signUpCardView.setOnClickListener {  Toast.makeText(applicationContext, "Clicked Sign Up", Toast.LENGTH_SHORT).show() }

        forgotTextView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Forgot Password", Toast.LENGTH_SHORT).show() }
    }

    private fun initToolbar() {
        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this,R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)

        }

        toolbar.title = "Login 4"

        try {
            toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.md_white_1000))
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

    //endregion
}
