package com.panaceasoft.pskotlinmaterial.activity.application.user.forgotpassword

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_user_forgot_password_3_activity.*

class AppUserForgotPassword3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_user_forgot_password_3_activity)

        initDataBindings()

        initActions()
    }


    private fun initDataBindings() {
        val id = R.drawable.login_background_3
        Utils.setImageToImageView(applicationContext, bgImageView, id)
    }

    private fun initActions() {

        signinTextView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Sign In", Toast.LENGTH_SHORT).show() }


        resetButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Reset.", Toast.LENGTH_SHORT).show() }

    }
    //endregion

}
