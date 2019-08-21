package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 8/9/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class NewsCategory(@field:SerializedName("category")
                   var category: String, @field:SerializedName("category_image")
                   var categoryImage: String, @field:SerializedName("is_check")
                   var isCheck: String)
