package com.panaceasoft.pskotlinmaterial.activity.application.user.profile

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_user_profile_4_activity.*

class AppUserProfile4Activity : AppCompatActivity() {

    //region override functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_user_profile_4_activity)

        initData()

        initUI()

        initActions()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(applicationContext, item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    //endregion

    //region Init Functions
    private fun initData() {

    }

    private fun initUI() {

        val id = R.drawable.profile2
        val coverUserImageView = findViewById<ImageView>(R.id.coverUserImageView)
        Utils.setImageToImageView(applicationContext, coverUserImageView, id)

    }

    private fun initActions() {
        menuImageView.setOnClickListener { this.finish() }

        followButton.setOnClickListener { Toast.makeText(this, "Clicked Follow.", Toast.LENGTH_SHORT).show() }
    }

    //endregion

}