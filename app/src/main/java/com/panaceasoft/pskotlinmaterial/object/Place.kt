package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

class Place {

    @SerializedName("name")
    var name: String

    @SerializedName("image")
    var imageName: String

    @SerializedName("logo_image")
    var logoImage: String? = null

    @SerializedName("type")
    lateinit var type: String

    @SerializedName("city")
    lateinit var city: String

    @SerializedName("rating_count")
    var ratingCount: String

    @SerializedName("total_rating")
    var totalRating: String

    @SerializedName("distance")
    lateinit var distance: String

    @SerializedName("discount")
    lateinit var discount: String

    @SerializedName("total_like")
    lateinit var totalLike: String

    @SerializedName("total_comment")
    lateinit var totalComment: String

    @SerializedName("lat")
    lateinit var lat: String

    @SerializedName("lng")
    lateinit var lng: String

    @SerializedName("total_review")
    lateinit var totalReview: String

    @SerializedName("opening")
    lateinit var opening: String

    @SerializedName("booking_time")
    lateinit var bookingTime: String

    @SerializedName("address")
    lateinit var address: String

    @SerializedName("website")
    lateinit var website: String

    @SerializedName("phone")
    lateinit var phone: String

    @SerializedName("email")
    lateinit var email: String

    @SerializedName("desc")
    lateinit var desc: String

    @SerializedName("marker_color")
    lateinit var markerColor: String

    @SerializedName("image_list")
    lateinit var imageList: List<Image>

    constructor(name: String, imageName: String, type: String, city: String, ratingCount: String, totalRating: String, distance: String, discount: String, totalLike: String, totalComment: String, lat: String, lng: String, totalReview: String, opening: String, bookingTime: String, address: String, website: String, phone: String, email: String, desc: String, markerColor: String, imageList: List<Image>) {
        this.name = name
        this.imageName = imageName
        this.type = type
        this.city = city
        this.ratingCount = ratingCount
        this.totalRating = totalRating
        this.distance = distance
        this.discount = discount
        this.totalLike = totalLike
        this.totalComment = totalComment
        this.lat = lat
        this.lng = lng
        this.totalReview = totalReview
        this.opening = opening
        this.bookingTime = bookingTime
        this.address = address
        this.website = website
        this.phone = phone
        this.email = email
        this.desc = desc
        this.markerColor = markerColor
        this.imageList = imageList
    }

    constructor(name: String, imageName: String, ratingCount: String, totalRating: String) {
        this.name = name
        this.imageName = imageName
        this.ratingCount = ratingCount
        this.totalRating = totalRating
    }

    inner class Image {
        @SerializedName("image_name")
        lateinit var imageName: String
    }

    //    public void setName(String name) {
    //        this.name = name;
    //    }
    //
    //    public void setImageName(String imageName) {
    //        this.imageName = imageName;
    //    }
    //
    //    public void setRatingCount(String ratingCount) {
    //        this.ratingCount = ratingCount;
    //    }
    //
    //    public void setTotalRating(String totalRating) {
    //        this.totalRating = totalRating;
    //    }
}
