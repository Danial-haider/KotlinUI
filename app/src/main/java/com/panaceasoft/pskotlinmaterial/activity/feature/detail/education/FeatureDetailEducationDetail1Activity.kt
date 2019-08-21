package com.panaceasoft.pskotlinmaterial.activity.feature.detail.education

import android.graphics.PorterDuff
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.viewpager.widget.ViewPager
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
import com.google.android.material.tabs.TabLayout
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.fragment.feature.detail.education.detail1.FeatureDetailEducationDetail1Fragment1
import com.panaceasoft.pskotlinmaterial.fragment.feature.detail.education.detail1.FeatureDetailEducationDetail1Fragment2
import com.panaceasoft.pskotlinmaterial.utils.Utils
import com.panaceasoft.pskotlinmaterial.utils.common_adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.app_education_detail_1_activity.*

class FeatureDetailEducationDetail1Activity : AppCompatActivity() {

    private lateinit var player: SimpleExoPlayer
    private lateinit var trackSelector: DefaultTrackSelector
    private var shouldAutoPlay: Boolean = false
    private lateinit var bandwidthMeter: BandwidthMeter
    private lateinit var progressBar: ProgressBar
    private lateinit var videoURL: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_education_detail_1_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()

    }

    private fun initData() {

    }

    private fun initUI() {

        initToolbar()

        videoURL = "http://www.panacea-soft.com/awesome_material/video_view/video_test2.mp4" //intent.getStringExtra("VIDEO");
        Log.d("TEAMPS", videoURL)

        shouldAutoPlay = true
        bandwidthMeter = DefaultBandwidthMeter()

        progressBar = findViewById(R.id.progressBar)

        val viewPager = findViewById<ViewPager>(R.id.viewPager)

        val index = setupViewPager(viewPager)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {

            tabLayout.layoutDirection = View.LAYOUT_DIRECTION_LTR

        } else {
            ViewCompat.setLayoutDirection(tabLayout, ViewCompat.LAYOUT_DIRECTION_LTR)
        }

        if (Utils.isRTL) {

            tabLayout.getTabAt(index - 1)?.select()
        }


    }

    private fun setupViewPager(viewPager: ViewPager): Int {
        val adapter = ViewPagerAdapter(supportFragmentManager)

        val fragment1 = FeatureDetailEducationDetail1Fragment1()

        val fragment2 = FeatureDetailEducationDetail1Fragment2()

        if (Utils.isRTL) {
            adapter.addFragment(fragment2, "CONTENTS")
            adapter.addFragment(fragment1, "OVERVIEW")
        } else {
            adapter.addFragment(fragment1, "OVERVIEW")
            adapter.addFragment(fragment2, "CONTENTS")

        }
        viewPager.adapter = adapter

        return adapter.count
    }

    private fun initDataBindings() {


    }

    private fun initActions() {

        bookmarkImageView.setOnClickListener {  Toast.makeText(this, "Clicked bookmark.", Toast.LENGTH_SHORT).show() }
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_share, menu)
        return super.onCreateOptionsMenu(menu)
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
//        if (player != null) {
            shouldAutoPlay = player.playWhenReady
            player.release()
//            player = null
//            trackSelector = null
//        }
    }

    public override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            initializePlayer()
        }
    }

    public override fun onResume() {
        super.onResume()
        if (Util.SDK_INT <= 23 ) {
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
        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Detail 1"

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