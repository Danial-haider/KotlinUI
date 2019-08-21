package com.panaceasoft.pskotlinmaterial.activity.feature.stepper.ecommerce

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.fragment.feature.stepper.ecommerce.FeatureStepperECommerceStepper1Fragment
import com.panaceasoft.pskotlinmaterial.fragment.feature.stepper.ecommerce.FeatureStepperECommerceStepper1Fragment2
import com.panaceasoft.pskotlinmaterial.fragment.feature.stepper.ecommerce.FeatureStepperECommerceStepper1Fragment3
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_stepper_ecommerce_stepper_1_activity.*

class FeatureStepperECommerceStepper1Activity : AppCompatActivity(), FeatureStepperECommerceStepper1Fragment2.OnPaymentItemClickListener, FeatureStepperECommerceStepper1Fragment.OnInfoListener {

    private var position = 1
    private val maxPosition = 3
    private var paymentType = 0
    private var name: String = ""
    private var email: String = ""
    private var phone: String = ""
    private var address: String = ""
    private var city: String = ""
    private var state: String = ""
    private var country: String = ""
    private var zip: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_stepper_ecommerce_stepper_1_activity)

        initData()

        initUI()

        initDataBinding()

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


    //region Init Functions
    private fun initData() {

    }

    private fun initUI() {
        updateCheckoutUI()
        navigateFragment(position)

    }

    private fun updateCheckoutUI() {
        if (position == 1) {
            Utils.setImageToImageView(this, shippingImageView, R.drawable.baseline_circle_line_uncheck_24)
            Utils.setImageToImageView(this, paymentImageView, R.drawable.baseline_circle_black_uncheck_24)
            Utils.setImageToImageView(this, successImageView, R.drawable.baseline_circle_black_uncheck_24)
            step2View.setBackgroundColor(ContextCompat.getColor(this,R.color.md_grey_600))
            step3View.setBackgroundColor(ContextCompat.getColor(this,R.color.md_grey_600))
            prevButton.visibility = View.GONE
            nextButton.visibility = View.VISIBLE
            keepShoppingButton.visibility = View.GONE
        } else if (position == 2) {
            Utils.setImageToImageView(this, shippingImageView, R.drawable.baseline_circle_line_check_24)
            Utils.setImageToImageView(this, paymentImageView, R.drawable.baseline_circle_line_uncheck_24)
            Utils.setImageToImageView(this, successImageView, R.drawable.baseline_circle_black_uncheck_24)
            step2View.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimary))
            step3View.setBackgroundColor(ContextCompat.getColor(this,R.color.md_grey_600))
            prevButton.visibility = View.VISIBLE
            nextButton.visibility = View.VISIBLE
            keepShoppingButton.visibility = View.GONE

        } else if (position == 3) {
            Utils.setImageToImageView(this, shippingImageView, R.drawable.baseline_circle_line_check_24)
            Utils.setImageToImageView(this, paymentImageView, R.drawable.baseline_circle_line_check_24)
            Utils.setImageToImageView(this, successImageView, R.drawable.baseline_circle_line_uncheck_24)
            step2View.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimary))
            step3View.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimary))
            prevButton.visibility = View.GONE
            nextButton.visibility = View.GONE
            keepShoppingButton.visibility = View.VISIBLE
        }
    }

    private fun setupFragment(fragment: Fragment) {
        try {
            this.supportFragmentManager.beginTransaction()
                    .replace(R.id.contentLayout, fragment)
                    .commitAllowingStateLoss()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun initDataBinding() {

    }

    private fun navigateFragment(position: Int) {

        updateCheckoutUI()
        if (position == 1) {
            setupFragment(FeatureStepperECommerceStepper1Fragment.newInstance(name, email, phone, address, city, state, country, zip))
        } else if (position == 2) {
            setupFragment(FeatureStepperECommerceStepper1Fragment2.newInstance(paymentType))
        } else if (position == 3) {
            setupFragment(FeatureStepperECommerceStepper1Fragment3.newInstance())
        }
    }

    private fun initActions() {
        nextButton.setOnClickListener {

            if (position < maxPosition) {
                position++

                navigateFragment(position)
            }
        }

        prevButton.setOnClickListener {

            if (position > 1) {
                position--

                navigateFragment(position)
            }
        }

        keepShoppingButton.setOnClickListener { this.finish() }

        closeImageButton.setOnClickListener { this.finish() }
    }

    override fun onItemClick(type: Int) {
        paymentType = type
    }

    override fun onInfoChange(name: String, email: String, phone: String, address: String, city: String, state: String, country: String, zip: String) {
        this.name = name
        this.email = email
        this.phone = phone
        this.address = address
        this.city = city
        this.state = state
        this.country = country
        this.zip = zip
    }
}


