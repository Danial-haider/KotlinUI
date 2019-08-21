package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 9/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class ChatDetailsVO(@field:SerializedName("id")
                    val id: String, @field:SerializedName("by_user")
                    val user: String, @field:SerializedName("profile_image")
                    val profileImage: String, @field:SerializedName("msg")
                    val message: String, @field:SerializedName("timestamp")
                    val timestamp: String, @field:SerializedName("state")
                    val state: String, @field:SerializedName("type")
                    val type: String)
