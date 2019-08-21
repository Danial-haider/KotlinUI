package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 9/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class News(@field:SerializedName("title")
           var title: String, @field:SerializedName("desc")
           var desc: String, @field:SerializedName("date")
           var date: String, @field:SerializedName("category")
           var category: String, @field:SerializedName("ago")
           var ago: String, @field:SerializedName("news_image")
           var newsImage: String, @field:SerializedName("publisher")
           var publisher: String, @field:SerializedName("publisher_image")
           var publisherImage: String, @field:SerializedName("total_like")
           var totalLike: String)
