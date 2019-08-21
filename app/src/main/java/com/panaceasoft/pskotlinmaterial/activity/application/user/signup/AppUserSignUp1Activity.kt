package com.panaceasoft.pskotlinmaterial.activity.application.user.signup

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.app_user_sign_up_1_activity.*

class AppUserSignUp1Activity : AppCompatActivity() {

    //region Override Functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_user_sign_up_1_activity)

        initActions()
    }
    //endregion

    //region Init Functions
    private fun initActions() {
        helpButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Need Help?", Toast.LENGTH_SHORT).show() }

        loginButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Login", Toast.LENGTH_SHORT).show() }

        registerButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Register", Toast.LENGTH_SHORT).show() }
    }
    //endregion
}
