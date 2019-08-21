package com.panaceasoft.pskotlinmaterial.repository.ecommerce


import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.UserReview

/**
 * Created by Panacea-Soft on 6/15/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


object UserReviewRepository {

    val userReviewList: List<UserReview>
        get() = Gson().fromJson<List<UserReview>>(json, object : TypeToken<List<UserReview>>() {

        }.type)

    internal var json = "[\n" +
            "  {\n" +
            "    \"user_name\" : \"John\",\n" +
            "    \"total_rating\":\"5.0\",\n" +
            "    \"comment\":\"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\",\n" +
            "    \"region\":\"West University Cafe\",\n" +
            "    \"added\":\"Jan 1 2018\",\n" +
            "    \"ago\" : \"2 months ago\",\n" +
            "    \"user_image\" : \"profile1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"user_name\" : \"Sam Sao\",\n" +
            "    \"total_rating\":\"4.5\",\n" +
            "    \"comment\":\"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\",\n" +
            "    \"region\":\"North Land Cafe\",\n" +
            "    \"added\":\"Feb 23 2018\",\n" +
            "    \"ago\" : \"1 month ago\",\n" +
            "    \"user_image\" : \"profile1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"user_name\" : \"Rehha\",\n" +
            "    \"total_rating\":\"3.0\",\n" +
            "    \"comment\":\"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\",\n" +
            "    \"region\":\"East Junction\",\n" +
            "    \"added\":\"Mar 23 2018\",\n" +
            "    \"ago\" : \"1 month ago\",\n" +
            "    \"user_image\" : \"profile1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"user_name\" : \"Thomas\",\n" +
            "    \"total_rating\":\"5.0\",\n" +
            "    \"comment\":\"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\",\n" +
            "    \"region\":\"East Junction\",\n" +
            "    \"added\":\"May 23 2018\",\n" +
            "    \"ago\" : \"4 minutes ago\",\n" +
            "    \"user_image\" : \"profile1\"\n" +
            "  }\n" +
            "]"
}
