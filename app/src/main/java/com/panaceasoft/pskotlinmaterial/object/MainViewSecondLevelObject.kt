package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 5/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class MainViewSecondLevelObject(@field:SerializedName("id")
                                var id: String, @field:SerializedName("name")
                                var name: String, @field:SerializedName("third_level_objects")
                                var thirdLevelObjectList: List<MainViewThirdLevelObject>) {

    @SerializedName("image_name")
    var imageName: String? = null

    @SerializedName("is_new")
    var isNew: String? = null

}
