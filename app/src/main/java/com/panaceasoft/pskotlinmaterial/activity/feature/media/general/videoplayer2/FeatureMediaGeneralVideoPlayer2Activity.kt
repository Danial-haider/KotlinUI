package com.panaceasoft.pskotlinmaterial.activity.feature.media.general.videoplayer2

import android.graphics.PorterDuff
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelectionArray
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.BandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_media_general_video_player_2_activity.*

class FeatureMediaGeneralVideoPlayer2Activity : AppCompatActivity() {

    private lateinit var player: SimpleExoPlayer
    private lateinit var trackSelector: DefaultTrackSelector
    private var shouldAutoPlay: Boolean = false
    private lateinit var bandwidthMeter: BandwidthMeter
    private lateinit var videoURL: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_media_general_video_player_2_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()

    }

    private fun initData() {

    }

    private fun initUI() {

        initToolbar()

        intent
        videoURL = "http://www.panacea-soft.com/awesome_material/video_view/video_test2.mp4" //intent.getStringExtra("VIDEO");
        Log.d("TEAMPS", videoURL)

        shouldAutoPlay = true
        bandwidthMeter = DefaultBandwidthMeter()

    }

    private fun initDataBindings() {

        Utils.setCircleImageToImageView(this, userImageView, R.drawable.profile2, 0, 0)
    }

    private fun initActions() {

        downloadImageButton.setOnClickListener {  Toast.makeText(this, "Clicked Download.", Toast.LENGTH_SHORT).show() }

        likeImageButton.setOnClickListener {  Toast.makeText(this, "Clicked Like.", Toast.LENGTH_SHORT).show() }

        shareImageButton.setOnClickListener {  Toast.makeText(this, "Clicked Share.", Toast.LENGTH_SHORT).show() }

        menuImageButton.setOnClickListener {  Toast.makeText(this, "Clicked Menu.", Toast.LENGTH_SHORT).show() }

        subscribedButton.setOnClickListener {  Toast.makeText(this, "Clicked subscribe.", Toast.LENGTH_SHORT).show() }

    }

    private fun initializePlayer() {

        try {
            val simpleExoPlayerView = findViewById<PlayerView>(R.id.player_view)
            simpleExoPlayerView.requestFocus()

            val videoTrackSelectionFactory = AdaptiveTrackSelection.Factory(bandwidthMeter)

            trackSelector = DefaultTrackSelector(videoTrackSelectionFactory)

            player = ExoPlayerFactory.newSimpleInstance(this, trackSelector)

            simpleExoPlayerView.player = player

            player.playWhenReady = shouldAutoPlay

            val uri = Uri.parse(videoURL)

            val bandwidthMeter = DefaultBandwidthMeter()

            // Produces DataSource instances through which media data is loaded.
            val dataSourceFactory = DefaultDataSourceFactory(this,
                    Util.getUserAgent(this, "awesomeMaterial"), bandwidthMeter)

            val mediaSource = ExtractorMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(uri)

            player.prepare(mediaSource)


            player.addListener(object : Player.EventListener {


                override fun onTimelineChanged(timeline: Timeline?, manifest: Any?, reason: Int) {

                }

                override fun onTracksChanged(trackGroups: TrackGroupArray, trackSelections: TrackSelectionArray) {
                    Log.d("TEAMPS", "onTracksChanged")
                }

                override fun onLoadingChanged(isLoading: Boolean) {
                    Log.d("TEAMPS", "onLoadingChanged")
                }

                override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
                    Log.d("TEAMPS", "onPlayerStateChanged")
                    if (playbackState == Player.STATE_BUFFERING) {
                        progressBar.visibility = View.VISIBLE
                    } else {
                        progressBar.visibility = View.INVISIBLE
                    }
                }

                override fun onRepeatModeChanged(repeatMode: Int) {
                    Log.d("TEAMPS", "onRepeatModeChanged")
                }

                override fun onShuffleModeEnabledChanged(shuffleModeEnabled: Boolean) {

                }

                override fun onPlayerError(error: ExoPlaybackException) {
                    Log.d("TEAMPS", "onPlayerError")
                }

                override fun onPositionDiscontinuity(reason: Int) {

                }

                override fun onPlaybackParametersChanged(playbackParameters: PlaybackParameters) {
                    Log.d("TEAMPS", "onPlaybackParametersChanged")
                }

                override fun onSeekProcessed() {

                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(this, "Clicked " + item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun releasePlayer() {

        shouldAutoPlay = player.playWhenReady
        player.release()
//            player = null
//            trackSelector = null

    }

    public override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            initializePlayer()
        }
    }

    public override fun onResume() {
        super.onResume()
        if (Util.SDK_INT <= 23) {
            initializePlayer()
        }
    }

    public override fun onPause() {
        super.onPause()
        if (Util.SDK_INT <= 23) {
            releasePlayer()
        }
    }

    public override fun onStop() {
        super.onStop()
        if (Util.SDK_INT > 23) {
            releasePlayer()
        }
    }

    private fun initToolbar() {

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {

            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this,R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)

        }

        toolbar.title = "Video Player 2"

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
