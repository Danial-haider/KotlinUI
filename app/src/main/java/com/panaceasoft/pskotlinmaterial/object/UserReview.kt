package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 6/15/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class UserReview(@field:SerializedName("user_image")
                 var userImage: String, @field:SerializedName("user_name")
                 var userName: String, @field:SerializedName("total_rating")
                 var totalRating: String, @field:SerializedName("comment")
                 var comment: String, @field:SerializedName("region")
                 var region: String, @field:SerializedName("added")
                 var added: String, @field:SerializedName("ago")
                 var ago: String)
