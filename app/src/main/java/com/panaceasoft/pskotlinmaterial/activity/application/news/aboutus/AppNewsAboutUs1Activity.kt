package com.panaceasoft.pskotlinmaterial.activity.application.news.aboutus

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.PorterDuff
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.app_news_about_us_1_activity.*

class AppNewsAboutUs1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_news_about_us_1_activity)

        initData()

        initToolbar()

        initDataBinding()

        initActions()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    //region Init Functions
    private fun initData() {

    }

    private fun initDataBinding() {

    }

    private fun initActions() {
        contactButton.setOnClickListener {

            val mailto = "mailto:teamps.is.cool@gmail.com" +
                    "&subject=" + "PS News Contact from App!" +
                    "&body=" + ""

            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse(mailto)

            try {
                startActivity(emailIntent)
            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
            }


        }

        facebookTextView.setOnClickListener { Toast.makeText(this, "Clicked Facebook.", Toast.LENGTH_SHORT).show() }
        twitterTextView.setOnClickListener { Toast.makeText(this, "Clicked Twitter.", Toast.LENGTH_SHORT).show() }
        linkedinTextView.setOnClickListener { Toast.makeText(this, "Clicked Linked In.", Toast.LENGTH_SHORT).show() }
        googlePlusTextView.setOnClickListener { Toast.makeText(this, "Clicked Google Plus.", Toast.LENGTH_SHORT).show() }

    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "About Us 1"

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
