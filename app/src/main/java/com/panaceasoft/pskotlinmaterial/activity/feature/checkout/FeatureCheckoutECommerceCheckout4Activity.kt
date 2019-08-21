package com.panaceasoft.pskotlinmaterial.activity.feature.checkout

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.feature_checkout_ecommerce_checkout_4_activity.*


class FeatureCheckoutECommerceCheckout4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_checkout_ecommerce_checkout_4_activity)

        initData()

        initUI()

        initDataBinding()

        initActions()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initData() {

    }

    private fun initUI() {

        // Init Toolbar
        initToolbar()
    }

    private fun initDataBinding() {

    }

    private fun initActions() {

        bankButton.setOnClickListener { Toast.makeText(this, "Clicked Pay with Bank.", Toast.LENGTH_SHORT).show() }
        stripeButton.setOnClickListener { Toast.makeText(this, "Clicked Pay with Stripe.", Toast.LENGTH_SHORT).show() }
        paypalButton.setOnClickListener { Toast.makeText(this, "Clicked Pay with Paypal.", Toast.LENGTH_SHORT).show() }
        cashButton.setOnClickListener { Toast.makeText(this, "Clicked Pay with Cash On Delivery.", Toast.LENGTH_SHORT).show() }
    }

    private fun initToolbar() {

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Checkout 4"

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
