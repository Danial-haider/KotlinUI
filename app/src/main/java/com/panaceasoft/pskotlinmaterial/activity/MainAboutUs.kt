package com.panaceasoft.pskotlinmaterial.activity

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.PorterDuff
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R

class MainAboutUs : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_about_us)

        initToolbar()

        val contactButton = findViewById<Button>(R.id.contactButton)
        contactButton.setOnClickListener {

            val mailto = "mailto:teamps.is.cool@gmail.com" +
                    "&subject=" + "AM : Contact (Feature & Issue)" +
                    "&body=" + ""

            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse(mailto)

            try {
                startActivity(emailIntent)
            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
            }


        }

        val app2CardView = findViewById<CardView>(R.id.app2CardView)
        app2CardView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://bit.ly/2Mp53at"))
            startActivity(browserIntent)
        }

        val app3CardView = findViewById<CardView>(R.id.app3CardView)
        app3CardView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/8h9gos"))
            startActivity(browserIntent)
        }

        val app4CardView = findViewById<CardView>(R.id.app4CardView)
        app4CardView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/sJKVfm"))
            startActivity(browserIntent)
        }

        val app5CardView = findViewById<CardView>(R.id.app5CardView)
        app5CardView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/Ar8Svi"))
            startActivity(browserIntent)
        }

        val app6CardView = findViewById<CardView>(R.id.app6CardView)
        app6CardView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/s5qPDn"))
            startActivity(browserIntent)
        }

        val app7CardView = findViewById<CardView>(R.id.app7CardView)
        app7CardView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/TQHvbm"))
            startActivity(browserIntent)
        }

        val app8CardView = findViewById<CardView>(R.id.app8CardView)
        app8CardView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/cV1nF3"))
            startActivity(browserIntent)
        }

        val app9CardView = findViewById<CardView>(R.id.app9CardView)
        app9CardView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/dnVW3h"))
            startActivity(browserIntent)
        }

        val app10CardView = findViewById<CardView>(R.id.app10CardView)
        app10CardView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/4K41Ne"))
            startActivity(browserIntent)
        }

        val app11CardView = findViewById<CardView>(R.id.app11CardView)
        app11CardView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/SH3fZn"))
            startActivity(browserIntent)
        }

        val app12CardView = findViewById<CardView>(R.id.app12CardView)
        app12CardView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/xeam29"))
            startActivity(browserIntent)
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    //region Init Toolbar
    private fun initToolbar() {

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "About Us"

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
