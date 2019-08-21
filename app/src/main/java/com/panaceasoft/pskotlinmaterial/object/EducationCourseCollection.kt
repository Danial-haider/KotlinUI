package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 8/25/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class EducationCourseCollection(@field:SerializedName("name")
                                var name: String, @field:SerializedName("status")
                                var status: String, @field:SerializedName("image")
                                var image: String, @field:SerializedName("progress")
                                var progress: String, @field:SerializedName("type")
                                var type: String, @field:SerializedName("color")
                                var color: String)
