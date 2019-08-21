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
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.MediaMp3Obj
import com.panaceasoft.pskotlinmaterial.adapter.feature.media.FeatureMediaGeneralMp3Player2PagerAdapter
import com.panaceasoft.pskotlinmaterial.repository.media.MediaMp3Repository
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_media_general_mp3_player_2_activity.*
import java.io.IOException

class FeatureMediaGeneralMP3Player2Activity : AppCompatActivity(), MediaPlayer.OnCompletionListener, SeekBar.OnSeekBarChangeListener {

    // Media Player
    private lateinit var mp: MediaPlayer
//    private lateinit var seekBar: SeekBar
//    private lateinit var playImageButton: ImageButton
//    private lateinit var nextImageButton: ImageButton
//    private lateinit var previousImageButton: ImageButton
//    private lateinit var loopImageButton: ImageButton
//    private lateinit var shuffleImageButton: ImageButton
    private val mHandler = Handler()
//    private lateinit var songCurrentLocationTextView: TextView
//    private lateinit var songTotalLocationTextView: TextView
//    private lateinit var backImageButton: ImageButton
//    private lateinit var likeImageButton: ImageButton
    private lateinit var pagerAdapter: FeatureMediaGeneralMp3Player2PagerAdapter
    private lateinit var mediaMp3ObjList: List<MediaMp3Obj>
//    private lateinit var imageViewPager: ViewPager
//    private lateinit var titleTextView: TextView
//    private lateinit var singerTextView: TextView
    private var currentIndex = 0

    /**
     * Background Runnable thread
     */
    private val mUpdateTimeTask = object : Runnable {
        override fun run() {
            val totalDuration = mp.duration.toLong()
            val currentDuration = mp.currentPosition.toLong()

            // Displaying Total Duration time
            songTotalLocationTextView.text = Utils.milliSecondsToTimer(totalDuration)
            // Displaying time completed playing
            songCurrentLocationTextView.text = Utils.milliSecondsToTimer(currentDuration)

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
        setContentView(R.layout.feature_media_general_mp3_player_2_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()

    }

    override fun onBackPressed() {
        closePlayer()

        // code here to show dialog
        super.onBackPressed()  // optional depending on your needs
    }

    private fun initData() {
        mediaMp3ObjList = MediaMp3Repository.categoryList
        pagerAdapter = FeatureMediaGeneralMp3Player2PagerAdapter(this, mediaMp3ObjList)
    }

    private fun initUI() {

        // Media player
        mp = MediaPlayer()

        // Listeners
        seekBar.setOnSeekBarChangeListener(this) // Important
        mp.setOnCompletionListener(this) // Important
        imageViewPager.setPadding(60, 0, 60, 0)
        imageViewPager.clipToPadding = false
        imageViewPager.pageMargin = 15

    }

    private fun initDataBindings() {

        setSong(currentIndex)

        imageViewPager.adapter = pagerAdapter
    }

    /**
     * Update timer on seekbar
     */
    fun updateProgressBar() {
        mHandler.postDelayed(mUpdateTimeTask, 100)
    }

    private fun setSong(index: Int) {
        // Play song
        try {
            mp.reset()

            val id = resources.getIdentifier(mediaMp3ObjList[index].song, "raw", packageName)
            val uri = Uri.parse("android.resource://$packageName/$id")
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

    private fun reset() {
        mHandler.removeCallbacks(mUpdateTimeTask)
        val currentPosition = 0

        // forward or backward to certain seconds
        mp.seekTo(currentPosition)

        // update timer progress again
        updateProgressBar()
    }

    private fun closePlayer() {
        mHandler.removeCallbacks(mUpdateTimeTask)

        mp.stop()

//        mp = null

    }


    private fun initActions() {
        playImageButton.setOnClickListener {
            if (mp.isPlaying) {
//                if (mp != null) {
                    pause()
//                }
            }
            else {
                // Resume song
//                if (mp != null) {
                    play()
//                }
            }
        }

        nextImageButton.setOnClickListener {

            if (currentIndex < mediaMp3ObjList.size - 1) {

                currentIndex++

                imageViewPager.currentItem = currentIndex

                setSong(currentIndex)

                play()

            } else {
                Toast.makeText(this, "No more songs.", Toast.LENGTH_SHORT).show()
            }
        }

        previousImageButton.setOnClickListener {
            if (currentIndex > 0) {

                currentIndex--

                imageViewPager.currentItem = currentIndex

                setSong(currentIndex)

                play()

            } else {
                Toast.makeText(this, "No more songs.", Toast.LENGTH_SHORT).show()
            }
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

        likeImageButton.setOnClickListener {  Toast.makeText(this, "Clicked More.", Toast.LENGTH_SHORT).show() }

        imageViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                currentIndex = position

                titleTextView.text = mediaMp3ObjList[position].title
                singerTextView.text = mediaMp3ObjList[position].singer

                reset()

                setSong(position)

                play()
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

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

            if (currentIndex < mediaMp3ObjList.size - 1) {
                currentIndex++
            } else {
                currentIndex = 0
            }

            imageViewPager.currentItem = currentIndex

            setSong(currentIndex)

            play()

        } else {

            if (currentIndex < mediaMp3ObjList.size - 1) {
                currentIndex++

                imageViewPager.currentItem = currentIndex

                setSong(currentIndex)

                play()
            }

        }
    }
}

