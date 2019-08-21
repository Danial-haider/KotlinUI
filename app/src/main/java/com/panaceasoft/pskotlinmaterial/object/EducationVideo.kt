package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 8/19/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class EducationVideo(@field:SerializedName("title")
                     var title: String, @field:SerializedName("desc")
                     var desc: String, @field:SerializedName("image")
                     var image: String, @field:SerializedName("category")
                     var category: String, @field:SerializedName("length")
                     var length: String, @field:SerializedName("size")
                     var size: String)
