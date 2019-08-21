package com.panaceasoft.pskotlinmaterial.activity.feature.splash.general.splash1

import android.animation.Animator
import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_splash_general_splash_screen_1_layout_activity.*

class FeatureSplashGeneralSplashScreen1LayoutActivity : AppCompatActivity() {

    var isRunning: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_splash_general_splash_screen_1_layout_activity)

        initDataBindings()

        initActions()
    }

    private fun initDataBindings() {
        Utils.setImageToImageView(this, s1bgImageVIew, R.drawable.star_bg)
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
            val width = Resources.getSystem().displayMetrics.widthPixels
            val height = Resources.getSystem().displayMetrics.heightPixels

            val halfWidth = width / 2
            val halfHeight = height / 2

            val px50 = Utils.dpToPx(this, 50)
            val px20 = Utils.dpToPx(this, 20)
            val px90 = Utils.dpToPx(this, 90)

            val iconToX = halfWidth - px50
            val iconToY = halfHeight - px90


            iconImageView.animate().alpha(1f).translationX(iconToX.toFloat()).translationY(iconToY.toFloat()).setDuration(1500).setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animator: Animator?) {

                }

                override fun onAnimationEnd(animator: Animator?) {

                    exploreButton.animate().translationY(height.toFloat()).setDuration(0).setListener(object : Animator.AnimatorListener {
                        override fun onAnimationStart(animator: Animator?) {

                        }

                        override fun onAnimationEnd(animator: Animator?) {
                            exploreButton.animate().translationY((halfHeight + px90).toFloat()).alpha(1f).setDuration(800).start()
                        }

                        override fun onAnimationCancel(animator: Animator?) {

                        }

                        override fun onAnimationRepeat(animator: Animator?) {

                        }
                    }).start()


                }

                override fun onAnimationCancel(animator: Animator?) {

                }

                override fun onAnimationRepeat(animator: Animator?) {

                }
            }).start()

            val textToX = halfWidth - nameTextView.width / 2
            val textToY = halfHeight + px20


            nameTextView.animate().alpha(0f).translationY(height.toFloat()).translationX(width.toFloat()).setDuration(0).setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animator: Animator?) {

                }

                override fun onAnimationEnd(animator: Animator?) {
                    nameTextView.animate().alpha(1f).translationX(textToX.toFloat()).translationY(textToY.toFloat()).setDuration(1500).start()
                }

                override fun onAnimationCancel(animator: Animator?) {

                }

                override fun onAnimationRepeat(animator: Animator?) {

                }
            }).start()

        }
    }


}
