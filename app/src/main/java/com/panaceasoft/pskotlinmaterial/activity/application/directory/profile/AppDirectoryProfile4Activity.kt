package com.panaceasoft.pskotlinmaterial.activity.application.directory.profile

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_directory_profile_4_activity.*

class AppDirectoryProfile4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_directory_profile_4_activity)

        initDataBinding()

        initActions()
    }


    private fun initDataBinding() {
        val id = R.drawable.profile1
        Utils.setImageToImageView(applicationContext, userImageView, id)

    }

    private fun initActions() {
        backImageView.setOnClickListener { finish() }

        followButton.setOnClickListener { Toast.makeText(this, "Clicked Follow.", Toast.LENGTH_SHORT).show() }
    }
    //endregion

}
