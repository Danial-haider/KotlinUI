package com.panaceasoft.pskotlinmaterial.activity.application.wallpaper.detail

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_wallpaper_detail_1_activity.*

class AppWallpaperDetail1Activity : AppCompatActivity() {

    private var twist = false

    //region override methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_wallpaper_detail_1_activity)

        initUI()

        initActions()

    }
    //endregion

    //region private functions
    private fun initUI() {
        val wallpaperImage = findViewById<ImageView>(R.id.wallpaperImageView)

        val id = Utils.getDrawableInt(this, "wallpaper")
        Utils.setImageToImageView(this, wallpaperImage, id)

        Utils.hideFirstFab(fab_like)
        Utils.hideFirstFab(fab_phone)
        Utils.hideFirstFab(fab_download)
        Utils.hideFirstFab(fab_share)
    }

    private fun initActions() {
        fab.setOnClickListener { v ->

            twist = Utils.twistFab(v, !twist)

            if (twist) {

                Utils.showFab(fab_like)
                Utils.showFab(fab_phone)
                Utils.showFab(fab_download)
                Utils.showFab(fab_share)

            } else {

                Utils.hideFab(fab_like)
                Utils.hideFab(fab_phone)
                Utils.hideFab(fab_download)
                Utils.hideFab(fab_share)

            }
        }

        fab_like.setOnClickListener { Toast.makeText(applicationContext, "Like clicked", Toast.LENGTH_SHORT).show() }

        fab_phone.setOnClickListener { Toast.makeText(applicationContext, "Phone clicked", Toast.LENGTH_SHORT).show() }

        fab_download.setOnClickListener { Toast.makeText(applicationContext, "Download clicked", Toast.LENGTH_SHORT).show() }

        fab_share.setOnClickListener { Toast.makeText(applicationContext, "Share clicked", Toast.LENGTH_SHORT).show() }

        backImageView.setOnClickListener { finish() }
    }

    //endregion
}
