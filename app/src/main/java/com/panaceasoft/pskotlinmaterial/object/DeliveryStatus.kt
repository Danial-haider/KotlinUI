package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 7/20/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class DeliveryStatus(@field:SerializedName("date")
                     var date: String, @field:SerializedName("time")
                     var time: String, @field:SerializedName("icon")
                     var icon: String, @field:SerializedName("location")
                     var location: String, @field:SerializedName("remark")
                     var remark: String)
