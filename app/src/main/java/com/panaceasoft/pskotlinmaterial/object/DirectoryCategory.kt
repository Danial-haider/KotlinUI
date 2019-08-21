package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 6/10/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class DirectoryCategory(@field:SerializedName("id")
                        var id: String, @field:SerializedName("name")
                        var name: String, @field:SerializedName("desc")
                        var desc: String, @field:SerializedName("image")
                        var image: String)
