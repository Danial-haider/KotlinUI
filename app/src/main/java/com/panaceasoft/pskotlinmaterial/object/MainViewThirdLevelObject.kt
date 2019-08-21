package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 5/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class MainViewThirdLevelObject {

    @SerializedName("id")
    lateinit var id: String

    @SerializedName("name")
    lateinit var name: String

    @SerializedName("image_name")
    var imageName: String? = null

    @SerializedName("is_new")
    var isNew: String? = null

    constructor() {}
    constructor(id: String, name: String) {
        this.id = id
        this.name = name
    }
}
