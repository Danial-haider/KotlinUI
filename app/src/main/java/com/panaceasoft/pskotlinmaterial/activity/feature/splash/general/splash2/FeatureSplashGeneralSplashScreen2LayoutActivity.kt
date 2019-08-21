package com.panaceasoft.pskotlinmaterial.activity.feature.splash.general.splash2

import android.animation.Animator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_splash_general_splash_screen_2_layout_activity.*

class FeatureSplashGeneralSplashScreen2LayoutActivity : AppCompatActivity() {


    private var isRunning: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_splash_general_splash_screen_2_layout_activity)

        initDataBindings()

        initActions()

    }


    private fun initDataBindings() {
        Utils.setImageToImageView(this, s2bgImageView, R.drawable.star_bg)
    }

    private fun initActions() {
        exploreButton.setOnClickListener {  this.finish() }
    }

    override fun onBackPressed() {

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        //Here you can get the size!

        if (!isRunning) {
            isRunning = true

            iconImageView.animate().scaleX(4f).scaleY(4f).alpha(0f).setDuration(0).setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animator: Animator) {

                }

                override fun onAnimationEnd(animator: Animator) {

                    iconImageView.animate().scaleX(1f).scaleY(1f).alpha(1f).setDuration(1500).setListener(object : Animator.AnimatorListener {
                        override fun onAnimationStart(animator: Animator) {

                        }

                        override fun onAnimationEnd(animator: Animator) {
                            nameTextView.animate().alpha(1f).setDuration(800).setListener(object : Animator.AnimatorListener {
                                override fun onAnimationStart(animator: Animator) {

                                }

                                override fun onAnimationEnd(animator: Animator) {
                                    exploreButton.animate().alpha(1f).setDuration(400).start()
                                }

                                override fun onAnimationCancel(animator: Animator) {

                                }

                                override fun onAnimationRepeat(animator: Animator) {

                                }
                            }).start()

                        }

                        override fun onAnimationCancel(animator: Animator) {

                        }

                        override fun onAnimationRepeat(animator: Animator) {

                        }
                    }).start()

                }

                override fun onAnimationCancel(animator: Animator) {

                }

                override fun onAnimationRepeat(animator: Animator) {

                }
            }).start()

        }
    }


}

