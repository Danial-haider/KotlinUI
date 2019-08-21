package com.panaceasoft.pskotlinmaterial.activity.feature.signup.general

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.feature_signup_general_signup_1_activity.*

class FeatureSignUpGeneralSignUp1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_signup_general_signup_1_activity)

        initActions()

    }

    private fun initActions() {
        helpButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Need Help?", Toast.LENGTH_SHORT).show() }

        loginButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Login", Toast.LENGTH_SHORT).show() }

        registerButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Register", Toast.LENGTH_SHORT).show() }
    }
    //endregion
}
