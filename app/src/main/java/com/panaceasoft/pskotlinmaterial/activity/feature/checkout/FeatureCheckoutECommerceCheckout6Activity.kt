package com.panaceasoft.pskotlinmaterial.activity.feature.checkout

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.feature_checkout_ecommerce_checkout_6_activity.*

class FeatureCheckoutECommerceCheckout6Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_checkout_ecommerce_checkout_6_activity)

        initData()

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


    private fun initDataBinding() {

    }

    private fun initActions() {
        nextButton.setOnClickListener { Toast.makeText(this, "Clicked Keep Shopping.", Toast.LENGTH_SHORT).show() }

    }
}
