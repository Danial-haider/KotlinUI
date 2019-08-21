package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 6/29/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class SectionGallery(@field:SerializedName("id")
                     var id: String, @field:SerializedName("name")
                     var name: String, @field:SerializedName("images")
                     var imageList: List<Image>) {

    inner class Image {

        @SerializedName("image_id")
        lateinit var imageId: String

        @SerializedName("image")
        lateinit var image: String
    }


}


