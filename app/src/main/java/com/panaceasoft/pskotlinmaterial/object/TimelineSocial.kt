package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 7/21/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class TimelineSocial(@field:SerializedName("date")
                     var date: String, @field:SerializedName("name")
                     var name: String, @field:SerializedName("user_image")
                     var user_image: String, @field:SerializedName("detail")
                     var detail: String, @field:SerializedName("icon")
                     var icon: String, @field:SerializedName("image")
                     var image: String, @field:SerializedName("type")
                     var type: String)
