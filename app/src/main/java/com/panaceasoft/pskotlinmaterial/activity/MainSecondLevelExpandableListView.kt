package com.panaceasoft.pskotlinmaterial.activity

import android.content.Context
import android.view.View
import android.widget.ExpandableListView
import java.io.Serializable

/**
 * Created by Panacea-Soft on 5/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


@Suppress("NAME_SHADOWING")
class MainSecondLevelExpandableListView(context: Context?) : ExpandableListView(context) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val heightMeasureSpec: Serializable
        heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(999999, View.MeasureSpec.AT_MOST)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}
