package com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.home

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.DisplayMetrics
import android.view.View
import android.view.animation.Interpolator
import android.widget.ImageView

import com.panaceasoft.pskotlinmaterial.R

/**
 * [View.OnClickListener] used to translate the product grid sheet downward on
 * the Y-axis when the navigation icon in the toolbar is pressed.
 */
class NavigationIconClickListener internal constructor(
        private val context: Context, private val sheet: View, private val interpolator: Interpolator?,
        private val openIcon: Drawable?, private val closeIcon: Drawable?) : View.OnClickListener {

    private val animatorSet = AnimatorSet()
    private val height: Int
    private var backdropShown = false

    internal constructor(context: Context, sheet: View) : this(context, sheet, null) {}

    constructor(context: Context, sheet: View, interpolator: Interpolator?) : this(context, sheet, interpolator, null, null) {}

    init {

        val displayMetrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        height = displayMetrics.heightPixels
    }

    override fun onClick(view: View) {
        backdropShown = !backdropShown

        // Cancel the existing animations
        animatorSet.removeAllListeners()
        animatorSet.end()
        animatorSet.cancel()

        updateIcon(view)

        val translateY = height - context.resources.getDimensionPixelSize(R.dimen.shr_product_grid_reveal_height)
        val tran:Float = translateY.toFloat()

        val animator = ObjectAnimator.ofFloat(sheet, "translationY", if (backdropShown) tran else 0f)

        animator.setDuration(500)
        if (interpolator != null) {
            animator.setInterpolator(interpolator)
        }
        animatorSet.play(animator)
        animator.start()
    }

    private fun updateIcon(view: View) {
        if (openIcon != null && closeIcon != null) {
            if (view !is ImageView) {
                throw IllegalArgumentException("updateIcon() must be called on an ImageView")
            }
            if (backdropShown) {
                view.setImageDrawable(closeIcon)
            } else {
                view.setImageDrawable(openIcon)
            }
        }
    }
}
