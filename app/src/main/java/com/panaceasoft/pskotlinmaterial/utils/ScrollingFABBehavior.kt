package com.panaceasoft.pskotlinmaterial.utils

import android.content.Context
import android.util.AttributeSet
import android.view.View

import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.panaceasoft.pskotlinmaterial.R

import androidx.coordinatorlayout.widget.CoordinatorLayout

class ScrollingFABBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<FloatingActionButton>(context, attrs) {
    private var toolbarHeight: Int = 0
    private var showHeight: Int = 0
    private var hideHeight: Int = 0

    init {
        try {
            this.toolbarHeight = getToolbarHeight(context)

            showHeight = -256 + (toolbarHeight + toolbarHeight / 2)
            hideHeight = -(toolbarHeight * 2)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun layoutDependsOn(parent: CoordinatorLayout, fab: FloatingActionButton, dependency: View): Boolean {
        return dependency is AppBarLayout
    }


    override fun onDependentViewChanged(parent: CoordinatorLayout, fab: FloatingActionButton, dependency: View): Boolean {
        try {
            if (dependency is AppBarLayout) {

                // Show on Top
                val showOnTop = true

                if (showOnTop) {
                    val currentapiVersion = android.os.Build.VERSION.SDK_INT
                    if (currentapiVersion >= android.os.Build.VERSION_CODES.HONEYCOMB) {

                        if (dependency.getY() < showHeight) {
                            fab.visibility = View.VISIBLE
                        } else if (dependency.getY() > hideHeight) {
                            if (fab.visibility == View.VISIBLE) {
                                fab.visibility = View.GONE
                            }
                        }

                    } else {
                        fab.visibility = View.VISIBLE
                    }
                } else {
                    val currentapiVersion = android.os.Build.VERSION.SDK_INT
                    if (currentapiVersion >= android.os.Build.VERSION_CODES.HONEYCOMB) {

                        if (dependency.getY() > showHeight) {
                            fab.visibility = View.VISIBLE
                        } else if (dependency.getY() <= hideHeight) {
                            if (fab.visibility == View.VISIBLE) {
                                fab.visibility = View.GONE
                            }
                        }

                    } else {
                        fab.visibility = View.VISIBLE
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return true
    }

    companion object {
        fun getToolbarHeight(context: Context): Int {
            val styledAttributes = context.theme.obtainStyledAttributes(
                    intArrayOf(R.attr.actionBarSize))
            val toolbarHeight = styledAttributes.getDimension(0, 0f).toInt()
            styledAttributes.recycle()

            return toolbarHeight
        }
    }
}

