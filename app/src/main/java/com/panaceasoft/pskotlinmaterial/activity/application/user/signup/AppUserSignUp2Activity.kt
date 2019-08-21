package com.panaceasoft.pskotlinmaterial.activity.application.user.signup

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_user_sign_up_2_activity.*

class AppUserSignUp2Activity : AppCompatActivity() {

    //region override functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_user_sign_up_2_activity)

        initDataBindings()

        initActions()

    }
    //endregion


    private fun initDataBindings() {
        val id = R.drawable.login_background
        Utils.setImageToImageView(applicationContext, bgImageView, id)
    }

    private fun initActions() {
        forgotButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Forgot Password", Toast.LENGTH_SHORT).show() }

        createTextView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Create Account", Toast.LENGTH_SHORT).show() }

        facebookLinearLayout.setOnClickListener { Toast.makeText(applicationContext, "Clicked Facebook", Toast.LENGTH_SHORT).show() }

        twitterLinearLayout.setOnClickListener { Toast.makeText(applicationContext, "Clicked Twitter", Toast.LENGTH_SHORT).show() }

        googlePlusLinearLayout.setOnClickListener { Toast.makeText(applicationContext, "Clicked Google Plus", Toast.LENGTH_SHORT).show() }

        registerButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Sign Up", Toast.LENGTH_SHORT).show() }

    }
    //endregion
}
