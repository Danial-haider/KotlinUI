package com.panaceasoft.pskotlinmaterial.`object`

/**
 * Created by Panacea-Soft on 6/30/18.
 * Contact Email : teamps.is.cool@gmail.com
 */

class SectionGalleryListHolder {
    var id: String
    var name: String
    var isSectionTitle: Boolean = false
    var image: SectionGallery.Image
    var isLastPhoto = false

    constructor(id: String, name: String, isSectionTitle: Boolean, image: SectionGallery.Image?) {
        this.id = id
        this.name = name
        this.isSectionTitle = isSectionTitle
        this.image = image!!
    }

    constructor(id: String, name: String, isSectionTitle: Boolean, image: SectionGallery.Image?, isLastPhoto: Boolean) {
        this.id = id
        this.name = name
        this.isSectionTitle = isSectionTitle
        this.image = image!!
        this.isLastPhoto = isLastPhoto
    }
}
