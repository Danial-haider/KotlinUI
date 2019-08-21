package com.panaceasoft.pskotlinmaterial.utils

import android.content.Context
import androidx.viewpager.widget.ViewPager

import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by Panacea-Soft on 7/22/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class PSViewPager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {

    internal  var enabled: Boolean
//    internal lateinit var checkoutButton: Button
    init {
        this.enabled = true
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (this.enabled) {
            super.onTouchEvent(event)
        } else false

    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return if (this.enabled) {
            super.onInterceptTouchEvent(event)
        } else false

    }

    fun setPagingEnabled(enabled: Boolean) {
        this.enabled = enabled
    }
}
