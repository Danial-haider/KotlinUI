package com.panaceasoft.pskotlinmaterial.activity.uicomponent.videoview

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_video_view_video_view_basic_activity.*

class UiVideoViewVideoViewBasicActivity : AppCompatActivity() {

    private var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_video_view_video_view_basic_activity)

        initVideoView()
    }

    private fun initVideoView() {

        try {

            val mediaController = MediaController(this)
            mediaController.setMediaPlayer(videoView)
            mediaController.setAnchorView(videoView)
            videoView.setMediaController(mediaController)

            // Need to replace with own videoView
            //Uri uri = Uri.parse("http://abhiandroid-8fb4.kxcdn.com/ui/wp-content/uploads/2016/04/videoviewtestingvideo.mp4");
            val uri = Uri.parse("http://www.panacea-soft.com/awesome_material/video_view/big_buck_bunny.mp4")

            videoView.setVideoURI(uri)
            videoView.requestFocus()

            videoView.start()
            Log.d("TEAMPS", "Start Loading")


            // When the videoView file ready for playback.
            videoView.setOnPreparedListener { mediaPlayer ->

                Log.d("TEAMPS", "Ready Play")
                videoLoadingProgressBar.visibility = View.GONE
                videoView.seekTo(position)
                if (position == 0) {
                    videoView.start()
                }

                // When videoView Screen change size.
                mediaPlayer.setOnVideoSizeChangedListener { _, _, _ ->

                    // Re-Set the videoView that acts as the anchor for the MediaController
                    mediaController.setAnchorView(videoView)
                }
            }


        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    // When you change direction of phone, this method will be called.
    // It store the state of videoView (Current position)
    public override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)

        // Store current position.
        savedInstanceState.putInt("CurrentPosition", videoView.currentPosition)
        videoView.pause()
    }

    // After rotating the phone. This method is called.
    public override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        // Get saved position.
        position = savedInstanceState.getInt("CurrentPosition")
        videoView.seekTo(position)
    }


}
