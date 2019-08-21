package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 6/30/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class WallpaperCategory(@field:SerializedName("name")
                        var name: String, @field:SerializedName("image")
                        var imageName: String, @field:SerializedName("count")
                        var count: String)

