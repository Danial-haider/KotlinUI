package com.panaceasoft.pskotlinmaterial.activity.feature.profile.education

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_profile_education_profile_1_activity.*

class FeatureProfileEducationProfile1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_profile_education_profile_1_activity)

        initUI()

        initActions()

    }

    private fun initUI() {
        val id = Utils.getDrawableInt(applicationContext, "profile1")
        Utils.setCircleImageToImageView(applicationContext, profileImageView, id, 0, 0)
    }

    private fun initActions() {

        closeImageButton.setOnClickListener {  this.finish() }
        sendButton.setOnClickListener {  Toast.makeText(this, "Clicked Send Message.", Toast.LENGTH_SHORT).show() }

    }
}