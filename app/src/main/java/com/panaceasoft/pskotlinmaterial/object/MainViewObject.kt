package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 5/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class MainViewObject(@field:SerializedName("id")
                     var id: String, @field:SerializedName("name")
                     var name: String, @field:SerializedName("second_level_objects")
                     var secondLevelObjectList: List<MainViewSecondLevelObject>?) {

    @SerializedName("image_name")
    lateinit var imageName: String

    @SerializedName("is_new")
    lateinit var isNew: String

}
