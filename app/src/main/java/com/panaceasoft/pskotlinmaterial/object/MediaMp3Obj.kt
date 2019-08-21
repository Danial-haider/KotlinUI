package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 7/19/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class MediaMp3Obj(@field:SerializedName("title")
                  var title: String, @field:SerializedName("image")
                  var image: String, @field:SerializedName("singer")
                  var singer: String, @field:SerializedName("song")
                  var song: String)
