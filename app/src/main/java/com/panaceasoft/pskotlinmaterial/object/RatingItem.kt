package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 22/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class RatingItem(@field:SerializedName("user_name")
                 var userName: String, @field:SerializedName("total_rating")
                 var totalRating: String, @field:SerializedName("title")
                 var title: String, @field:SerializedName("comment")
                 var comment: String, @field:SerializedName("region")
                 var region: String, @field:SerializedName("added")
                 var added: String, @field:SerializedName("ago")
                 var ago: String, @field:SerializedName("user_image")
                 var userImage: String)
