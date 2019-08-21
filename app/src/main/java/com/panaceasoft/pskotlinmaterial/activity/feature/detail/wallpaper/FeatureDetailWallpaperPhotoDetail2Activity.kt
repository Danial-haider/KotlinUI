package com.panaceasoft.pskotlinmaterial.activity.feature.detail.wallpaper

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_detail_wallpaper_photo_detail_2_activity.*

class FeatureDetailWallpaperPhotoDetail2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_detail_wallpaper_photo_detail_2_activity)

        initUI()

        initActions()

    }

    //region private functions
    private fun initUI() {
        val wallpaperImage = findViewById<ImageView>(R.id.wallpaperImageView)
        val id = Utils.getDrawableInt(this, "wallpaper")
        Utils.setImageToImageView(this, wallpaperImage, id)
    }

    private fun initActions() {
        backImageView.setOnClickListener { finish() }

        likeLinearLayout.setOnClickListener { Toast.makeText(applicationContext, "Clicked Like", Toast.LENGTH_SHORT).show() }

        phoneLinearLayout.setOnClickListener { Toast.makeText(applicationContext, "Clicked Phone", Toast.LENGTH_SHORT).show() }

        downloadLinearLayout.setOnClickListener { Toast.makeText(applicationContext, "Clicked Download", Toast.LENGTH_SHORT).show() }

        shareLinearLayout.setOnClickListener { Toast.makeText(applicationContext, "Clicked Share", Toast.LENGTH_SHORT).show() }

    }
    //endregion
}
