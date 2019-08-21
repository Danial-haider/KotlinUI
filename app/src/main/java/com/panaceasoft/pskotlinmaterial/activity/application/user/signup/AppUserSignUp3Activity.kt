package com.panaceasoft.pskotlinmaterial.activity.application.user.signup

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_user_sign_up_3_activity.*

class AppUserSignUp3Activity : AppCompatActivity() {

    //region override functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_user_sign_up_3_activity)

        initDataBindings()

        initActions()
    }
    //endregion

    //region Init Functions


    private fun initDataBindings() {
        val id = R.drawable.login_background_3
        Utils.setImageToImageView(applicationContext, bgImageView, id)
    }

    private fun initActions() {
        forgotTextView.setOnClickListener {   Toast.makeText(applicationContext, "Clicked Forgot Password.", Toast.LENGTH_SHORT).show() }

        signuptTextView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Sign In.", Toast.LENGTH_SHORT).show() }

        registerButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Register.", Toast.LENGTH_SHORT).show() }

    }


    //endregion
}
