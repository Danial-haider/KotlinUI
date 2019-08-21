package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 7/4/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class UserProfile(@field:SerializedName("name")
                  var name: String, @field:SerializedName("image")
                  var imageName: String)
