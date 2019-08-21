package com.panaceasoft.pskotlinmaterial.adapter.application.ecommerce.home.home5

import android.graphics.Rect
import android.view.View

import androidx.recyclerview.widget.RecyclerView

class ProductGridItemDecoration(private val largePadding: Int, private val smallPadding: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView, state: RecyclerView.State) {
        outRect.left = smallPadding
        outRect.right = largePadding
    }
}
