package com.panaceasoft.pskotlinmaterial.activity.application.user.forgotpassword

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.app_user_forgot_password_1_activity.*

class AppUserForgotPassword1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_user_forgot_password_1_activity)

        initActions()
    }


    private fun initActions() {
        helpButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Need Help?", Toast.LENGTH_SHORT).show() }

        loginButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Create Account", Toast.LENGTH_SHORT).show() }

        resetButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Reset", Toast.LENGTH_SHORT).show() }
    }
    //endregion
}
