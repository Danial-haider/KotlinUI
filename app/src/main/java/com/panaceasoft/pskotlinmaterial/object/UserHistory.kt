package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 9/6/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class UserHistory(@field:SerializedName("place_name")
                  var placeName: String, @field:SerializedName("place_image")
                  var placeImage: String, @field:SerializedName("comment")
                  var comment: String, @field:SerializedName("region")
                  var region: String, @field:SerializedName("added")
                  var added: String, @field:SerializedName("ago")
                  var ago: String, @field:SerializedName("action")
                  var action: String)
