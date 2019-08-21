package com.panaceasoft.pskotlinmaterial.activity.feature.forgotpassword.general

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_forgotpassword_general_forgotpassword_2_activity.*

class FeatureForgotPasswordGeneralForgotPassword2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_forgotpassword_general_forgotpassword_2_activity)

        initDataBindings()

        initActions()

    }

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
