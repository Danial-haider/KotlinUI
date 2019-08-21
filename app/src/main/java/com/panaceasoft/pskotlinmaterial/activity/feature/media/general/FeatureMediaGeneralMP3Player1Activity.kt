package com.panaceasoft.pskotlinmaterial.activity.feature.media.general

import android.graphics.PorterDuff
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_media_general_mp3_player_1_activity.*
import java.io.IOException

class FeatureMediaGeneralMP3Player1Activity : AppCompatActivity(), MediaPlayer.OnCompletionListener, SeekBar.OnSeekBarChangeListener {

    // Media Player
    private lateinit var mp: MediaPlayer
    private val mHandler = Handler()


    /**
     * Background Runnable thread
     */
    private val mUpdateTimeTask = object : Runnable {
        override fun run() {
            val totalDuration = mp.duration.toLong()
            val currentDuration = mp.currentPosition.toLong()

            // Displaying Total Duration time
            songTotalLocationTextView.text = "" + Utils.milliSecondsToTimer(totalDuration)
            // Displaying time completed playing
            songCurrentLocationTextView.text = "" + Utils.milliSecondsToTimer(currentDuration)

            // Updating progress bar
            val progress = Utils.getProgressPercentage(currentDuration, totalDuration)
            //Log.d("Progress", ""+progress);
            seekBar.progress = progress

            // Running this thread after 100 milliseconds
            mHandler.postDelayed(this, 100)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_media_general_mp3_player_1_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()

    }

    private fun initData() {

    }

    private fun initUI() {

        // Media player
        mp = MediaPlayer()
        // Listeners
        seekBar.setOnSeekBarChangeListener(this) // Important
        mp.setOnCompletionListener(this) // Important
    }

    private fun initDataBindings() {
        // Play song
        try {
            mp.reset()
            val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.bensound_happyrock)
            mp.setDataSource(this, uri)
            mp.prepare()


            // set Progress bar values
            seekBar.progress = 0
            seekBar.max = 100

            // Updating progress bar
            updateProgressBar()
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        Utils.setImageToImageView(this, songBgImageView, R.drawable.media_img_1)
        Utils.setImageToImageView(this, songImageView, R.drawable.media_img_logo_1)
    }

    /**
     * Update timer on seekbar
     */
    fun updateProgressBar() {
        mHandler.postDelayed(mUpdateTimeTask, 100)
    }

    private fun play() {
        mp.start()
        // Changing button image to pause button
        playImageButton.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.baseline_pause_grey_24))
    }

    private fun pause() {
        mp.pause()
        // Changing button image to play button
        playImageButton.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.baseline_play_grey_24))
    }

    private fun closePlayer() {
        mHandler.removeCallbacks(mUpdateTimeTask)

        mp.stop()

//        mp = null

    }

    private fun reset() {
        mHandler.removeCallbacks(mUpdateTimeTask)
        val currentPosition = 0

        // forward or backward to certain seconds
        mp.seekTo(currentPosition)

        // update timer progress again
        updateProgressBar()
    }

    private fun initActions() {
        playImageButton.setOnClickListener {
            if (mp.isPlaying) {
                    pause()
            } else {
                // Resume song
                    play()

            }
        }

        nextImageButton.setOnClickListener {
            // need to replace to load next song
            reset()

            play()
        }

        previousImageButton.setOnClickListener {
            // need to replace to load previous song
            reset()

            play()
        }

        loopImageButton.setOnClickListener {v ->

            v.isSelected = !v.isSelected

            if (loopImageButton.isSelected) {
                loopImageButton.setColorFilter(ContextCompat.getColor(this,R.color.md_deep_orange_900),
                        PorterDuff.Mode.SRC_ATOP)
            } else {
                loopImageButton.setColorFilter(ContextCompat.getColor(this,R.color.trans),
                        PorterDuff.Mode.SRC_ATOP)
            }
        }

        shuffleImageButton.setOnClickListener {v ->

            v.isSelected = !v.isSelected

            if (shuffleImageButton.isSelected) {
                shuffleImageButton.setColorFilter(ContextCompat.getColor(this,R.color.md_deep_orange_900),
                        PorterDuff.Mode.SRC_ATOP)
            } else {
                shuffleImageButton.setColorFilter(ContextCompat.getColor(this,R.color.trans),
                        PorterDuff.Mode.SRC_ATOP)
            }
        }

        backImageButton.setOnClickListener {

            closePlayer()

            this.finish()
        }

        likeImageButton.setOnClickListener { Toast.makeText(this, "Clicked Like.", Toast.LENGTH_SHORT).show() }
    }

    override fun onBackPressed() {
        closePlayer()

        // code here to show dialog
        super.onBackPressed()  // optional depending on your needs
    }

    override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {

    }

    override fun onStartTrackingTouch(seekBar: SeekBar) {
        mHandler.removeCallbacks(mUpdateTimeTask)
    }

    override fun onStopTrackingTouch(seekBar: SeekBar) {
        mHandler.removeCallbacks(mUpdateTimeTask)
        val totalDuration = mp.duration
        val currentPosition = Utils.progressToTimer(seekBar.progress, totalDuration)

        // forward or backward to certain seconds
        mp.seekTo(currentPosition)

        // update timer progress again
        updateProgressBar()
    }

    override fun onCompletion(mediaPlayer: MediaPlayer) {

        playImageButton.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.baseline_play_grey_24))

        if (loopImageButton.isSelected) {
            play()
        }
    }
}
