package com.panaceasoft.pskotlinmaterial.activity.feature.media.general.videoplayer1

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_media_general_video_player_1_activity.*

class FeatureMediaGeneralVideoPlayer1Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_media_general_video_player_1_activity)

        initData()

        initToolbar()

        initDataBindings()

        initActions()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(this, "Clicked " + item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initData() {

    }

    private fun initDataBindings() {

        Utils.setImageToImageView(this, posterImageView, R.drawable.video_player_1)

    }

    private fun initActions() {

        similarMoviesImageButton.setOnClickListener {  Toast.makeText(this, "Clicked Similar Movies.", Toast.LENGTH_SHORT).show() }

        playImageView.setOnClickListener {  openPlayer() }

        watchTrailerButton.setOnClickListener {  openPlayer() }

    }

    private fun openPlayer() {
        val intent = Intent(this, FeatureMediaGeneralVideoPlayer1PlayerActivity::class.java)
        val message = "http://www.panacea-soft.com/awesome_material/video_view/video_test2.mp4"
        intent.putExtra("VIDEO", message)
        startActivity(intent)
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this,R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Video Player 1"

        try {
            toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.md_white_1000))
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
