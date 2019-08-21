package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 8/18/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class Course(@field:SerializedName("title")
             var title: String, @field:SerializedName("desc")
             var desc: String, @field:SerializedName("category")
             var category: String, @field:SerializedName("length")
             var length: String, @field:SerializedName("image")
             var image: String, @field:SerializedName("viewCount")
             var viewCount: String, @field:SerializedName("status")
             var status: String, @field:SerializedName("percent")
             var percent: String)
