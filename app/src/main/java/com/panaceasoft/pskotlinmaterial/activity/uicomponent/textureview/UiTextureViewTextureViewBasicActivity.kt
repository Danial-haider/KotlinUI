package com.panaceasoft.pskotlinmaterial.activity.uicomponent.textureview

import android.graphics.PorterDuff
import android.graphics.SurfaceTexture
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.Surface
import android.view.TextureView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_texture_view_texture_view_basic_activity.*
import java.io.IOException

class UiTextureViewTextureViewBasicActivity : AppCompatActivity(), TextureView.SurfaceTextureListener {

    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_texture_view_texture_view_basic_activity)

        initToolbar()



        textureView.surfaceTextureListener = this
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    override fun onSurfaceTextureAvailable(surfaceTexture: SurfaceTexture, width: Int, height: Int) {

        val surface = Surface(surfaceTexture)

        try {

            mediaPlayer = MediaPlayer()
            val afd = assets.openFd("playback.mp4")
            mediaPlayer.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)

            mediaPlayer.setSurface(surface)
            mediaPlayer.isLooping = true

            // don't forget to call MediaPlayer.prepareAsync() method when you use constructor for
            // creating MediaPlayer
            mediaPlayer.prepareAsync()

            // Play video when the media source is ready for playback.
            mediaPlayer.setOnPreparedListener(MediaPlayer.OnPreparedListener { it.start() })

        } catch (e: IllegalArgumentException) {

            Log.d("textureview", e.message)
        } catch (e: SecurityException) {

            Log.d("textureview", e.message)
        } catch (e: IllegalStateException) {

            Log.d("textureview", e.message)
        } catch (e: IOException) {

            Log.d("textureview", e.message)
        }

    }

    override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture, width: Int, height: Int) {

    }

    override fun onSurfaceTextureDestroyed(surface: SurfaceTexture): Boolean {
        return false
    }

    override fun onSurfaceTextureUpdated(surface: SurfaceTexture) {

    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
    }

    //region Init Toolbar

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Basic TextureView"

        try {
          toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.md_white_1000))
        } catch (e: Exception) {
            Log.e("TEAMPS", "Can't set color.")
        }

        try {
            setSupportActionBar(toolbar)
        } catch (e: Exception) {
            Log.e("TEAMPS", "Error in set support action bar.")
        }

        try {
            if (supportActionBar != null) {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
        } catch (e: Exception) {
            Log.e("TEAMPS", "Error in set display home as up enabled.")
        }

    }
}
