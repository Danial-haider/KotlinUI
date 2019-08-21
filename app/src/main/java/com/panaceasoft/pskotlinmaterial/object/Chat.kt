package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 9/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class Chat(@field:SerializedName("id")
           var ID: String, @field:SerializedName("name")
           var Name: String, @field:SerializedName("text")
           var Message: String, @field:SerializedName("image")
           var Image: String, @field:SerializedName("count")
           var Count: String, @field:SerializedName("time")
           var Time: String)
