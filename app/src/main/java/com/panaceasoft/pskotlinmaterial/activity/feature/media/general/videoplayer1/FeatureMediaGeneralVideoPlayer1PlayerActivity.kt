package com.panaceasoft.pskotlinmaterial.activity.feature.media.general.videoplayer1

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.View

import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.PlaybackParameters
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.Timeline
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelectionArray
import com.google.android.exoplayer2.upstream.BandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.feature_media_general_video_player_1_player_activity.*

/**
 * Created by Panacea-Soft on 7/20/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class FeatureMediaGeneralVideoPlayer1PlayerActivity : AppCompatActivity() {

    private lateinit var player: SimpleExoPlayer
    private lateinit var trackSelector: DefaultTrackSelector
    private  var shouldAutoPlay: Boolean = false
    private lateinit var bandwidthMeter: BandwidthMeter
    private lateinit var videoURL: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_media_general_video_player_1_player_activity)

        val intent = intent
        videoURL = intent.getStringExtra("VIDEO")
        Log.d("TEAMPS", videoURL)

        shouldAutoPlay = true
        bandwidthMeter = DefaultBandwidthMeter()

    }

    private fun initializePlayer() {

        try {
            val simpleExoPlayerView = player_view
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
}
