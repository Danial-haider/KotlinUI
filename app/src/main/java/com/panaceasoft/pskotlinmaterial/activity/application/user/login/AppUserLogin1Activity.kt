package com.panaceasoft.pskotlinmaterial.activity.application.user.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.app_user_login_1_activity.*

class AppUserLogin1Activity : AppCompatActivity() {


    //region Override Functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_user_login_1_activity)

        initActions()
    }
    //endregion


    private fun initActions() {
        needHelpTextView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Need Help?", Toast.LENGTH_SHORT).show() }

        createAccountButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Create Account", Toast.LENGTH_SHORT).show() }

        forgotButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Forgot Password?", Toast.LENGTH_SHORT).show() }

        loginButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Login", Toast.LENGTH_SHORT).show() }
    }
    //endregion
}
