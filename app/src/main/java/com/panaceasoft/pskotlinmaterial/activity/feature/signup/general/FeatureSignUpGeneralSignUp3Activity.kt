package com.panaceasoft.pskotlinmaterial.activity.feature.signup.general

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_signup_general_signup_3_activity.*

class FeatureSignUpGeneralSignUp3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_signup_general_signup_3_activity)

        initDataBindings()

        initActions()

    }
    private fun initDataBindings() {
        val id = R.drawable.login_background_3
        Utils.setImageToImageView(applicationContext, bgImageView, id)
    }

    private fun initActions() {
        forgotTextView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Forgot Password.", Toast.LENGTH_SHORT).show() }

        signuptTextView.setOnClickListener {  Toast.makeText(applicationContext, "Clicked Sign In.", Toast.LENGTH_SHORT).show() }

        registerButton.setOnClickListener {  Toast.makeText(applicationContext, "Clicked Register.", Toast.LENGTH_SHORT).show() }

    }


    //endregion
}
