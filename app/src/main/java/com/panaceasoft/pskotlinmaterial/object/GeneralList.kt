package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 7/17/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class GeneralList(@field:SerializedName("name")
                  var name: String, @field:SerializedName("caption")
                  var caption: String, @field:SerializedName("image")
                  var image: String, @field:SerializedName("detail")
                  var detail: String) {

    var isOpened = false
}
