package com.panaceasoft.pskotlinmaterial.activity.application.user.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_user_login_3_activity.*

class AppUserLogin3Activity : AppCompatActivity() {

    //region override functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_user_login_3_activity)

        initDataBindings()

        initActions()
    }
    //endregion


    private fun initDataBindings() {
        val id = R.drawable.login_background_3
        Utils.setImageToImageView(applicationContext, bgImageView, id)
    }

    private fun initActions() {
        forgotTextView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Forgot Password.", Toast.LENGTH_SHORT).show() }

        signuptTextView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Sign Up.", Toast.LENGTH_SHORT).show() }

        loginButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Login.", Toast.LENGTH_SHORT).show() }

        facebookCardView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Facebook.", Toast.LENGTH_SHORT).show() }

        twitterCardView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Twitter.", Toast.LENGTH_SHORT).show() }
    }


    //endregion
}
