package com.panaceasoft.pskotlinmaterial.activity.feature.forgotpassword.general

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.feature_forgotpassword_general_forgotpassword_1_activity.*

class FeatureForgotPasswordGeneralForgotPassword1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_forgotpassword_general_forgotpassword_1_activity)

        initActions()

    }

    private fun initActions() {
        helpButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Need Help?", Toast.LENGTH_SHORT).show() }

        loginButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Create Account", Toast.LENGTH_SHORT).show() }

        resetButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Reset", Toast.LENGTH_SHORT).show() }
    }
    //endregion

}
