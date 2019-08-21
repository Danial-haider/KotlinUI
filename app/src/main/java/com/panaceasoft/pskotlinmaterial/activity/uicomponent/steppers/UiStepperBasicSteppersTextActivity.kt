package com.panaceasoft.pskotlinmaterial.activity.uicomponent.steppers

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.fragment.feature.stepper.general.FeatureStepperGeneralStepper1Fragment
import kotlinx.android.synthetic.main.ui_stepper_general_basic_steppers_text_activity.*

class UiStepperBasicSteppersTextActivity : AppCompatActivity() {

    private var position = 1
    private val maxPosition = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_stepper_general_basic_steppers_text_activity)

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

        initToolbar()

        updatePositionTextView()
        setupFragment(FeatureStepperGeneralStepper1Fragment.newInstance(position))

    }

    private fun updatePositionTextView() {
        imageNoTextView.text = "$position of $maxPosition"
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

    private fun initActions() {
        nextButton.setOnClickListener {

            if (position < maxPosition) {
                position++

                updatePositionTextView()
                setupFragment(FeatureStepperGeneralStepper1Fragment.newInstance(position))
            } else {
                Toast.makeText(this, "No More Step.", Toast.LENGTH_SHORT).show()
            }
        }

        prevButton.setOnClickListener {

            if (position > 1) {
                position--

                updatePositionTextView()
                setupFragment(FeatureStepperGeneralStepper1Fragment.newInstance(position))
            } else {
                Toast.makeText(this, "No More Step.", Toast.LENGTH_SHORT).show()
            }
        }


    }

    //region Init Toolbar
    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Basic Stepper 1"

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

    //endregion
}
