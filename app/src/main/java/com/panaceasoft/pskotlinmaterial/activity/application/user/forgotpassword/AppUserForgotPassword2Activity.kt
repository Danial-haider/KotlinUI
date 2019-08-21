package com.panaceasoft.pskotlinmaterial.activity.application.user.forgotpassword

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_user_forgot_password_2_activity.*

class AppUserForgotPassword2Activity : AppCompatActivity() {

    //region Override Functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_user_forgot_password_2_activity)

        initDataBindings()

        initActions()
    }
    //endregion

    //region Init Functions
    private fun initDataBindings() {
        val id = R.drawable.login_background
        Utils.setImageToImageView(applicationContext, bgImageView, id)
    }

    private fun initActions() {

        loginTextView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Login", Toast.LENGTH_SHORT).show() }


        resetButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Reset", Toast.LENGTH_SHORT).show() }


    }
    //endregion
}
