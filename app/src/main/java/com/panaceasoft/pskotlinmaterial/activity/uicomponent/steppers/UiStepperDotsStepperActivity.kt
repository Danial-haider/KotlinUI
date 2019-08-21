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
import com.panaceasoft.pskotlinmaterial.fragment.uicomponent.container.stepper.UiStepperDotsStepperFragment
import kotlinx.android.synthetic.main.ui_stepper_dots_stepper_activity.*

class UiStepperDotsStepperActivity : AppCompatActivity() {

    private var position = 1
    private val maxPosition = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_stepper_dots_stepper_activity)

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
        setupFragment(UiStepperDotsStepperFragment.newInstance(position))

    }

    private fun updatePositionTextView() {
        when (position) {
            1 -> {
                imageView1.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_selected_circle_1_black_24dp))
                imageView2.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_unselected_circle_1_black_24dp))
                imageView3.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_unselected_circle_1_black_24dp))
                imageView4.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_unselected_circle_1_black_24dp))
                imageView5.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_unselected_circle_1_black_24dp))
            }
            2 -> {
                imageView1.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_unselected_circle_1_black_24dp))
                imageView2.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_selected_circle_1_black_24dp))
                imageView3.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_unselected_circle_1_black_24dp))
                imageView4.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_unselected_circle_1_black_24dp))
                imageView5.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_unselected_circle_1_black_24dp))
            }
            3 -> {
                imageView1.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_unselected_circle_1_black_24dp))
                imageView2.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_unselected_circle_1_black_24dp))
                imageView3.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_selected_circle_1_black_24dp))
                imageView4.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_unselected_circle_1_black_24dp))
                imageView5.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_unselected_circle_1_black_24dp))
            }
            4 -> {
                imageView1.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_unselected_circle_1_black_24dp))
                imageView2.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_unselected_circle_1_black_24dp))
                imageView3.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_unselected_circle_1_black_24dp))
                imageView4.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_selected_circle_1_black_24dp))
                imageView5.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_unselected_circle_1_black_24dp))
            }
            else -> {
                imageView1.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_unselected_circle_1_black_24dp))
                imageView2.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_unselected_circle_1_black_24dp))
                imageView3.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_unselected_circle_1_black_24dp))
                imageView4.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_unselected_circle_1_black_24dp))
                imageView5.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_selected_circle_1_black_24dp))
            }
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

    private fun initActions() {
        nextButton.setOnClickListener {

            if (position < maxPosition) {
                position++

                updatePositionTextView()
                setupFragment(UiStepperDotsStepperFragment.newInstance(position))
            } else {
                Toast.makeText(this, "No More Step.", Toast.LENGTH_SHORT).show()
            }
        }

        prevButton.setOnClickListener {

            if (position > 1) {
                position--

                updatePositionTextView()
                setupFragment(UiStepperDotsStepperFragment.newInstance(position))
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

        toolbar.title = "Dots Stepper"

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

