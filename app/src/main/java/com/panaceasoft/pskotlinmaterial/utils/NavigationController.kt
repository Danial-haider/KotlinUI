package com.panaceasoft.pskotlinmaterial.utils

import android.app.Activity
import android.content.Intent

/**
 * Created by Panacea-Soft on 5/10/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


object NavigationController {

    fun openActivity(activity: Activity?, intent: Intent) {
        activity?.startActivity(intent)
    }

}
