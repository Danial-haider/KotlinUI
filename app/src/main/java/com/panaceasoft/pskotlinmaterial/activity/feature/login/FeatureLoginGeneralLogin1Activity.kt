package com.panaceasoft.pskotlinmaterial.activity.feature.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.feature_login_general_login_1_activity.*

class FeatureLoginGeneralLogin1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_login_general_login_1_activity)

        initActions()

    }

    private fun initActions() {
        needHelpTextView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Need Help?", Toast.LENGTH_SHORT).show() }

        createAccountButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Create Account", Toast.LENGTH_SHORT).show() }

        forgotButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Forgot Password?", Toast.LENGTH_SHORT).show() }

        loginButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Login", Toast.LENGTH_SHORT).show() }
    }
    //endregion
}
