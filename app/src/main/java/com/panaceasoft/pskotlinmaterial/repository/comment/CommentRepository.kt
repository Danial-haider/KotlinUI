package com.panaceasoft.pskotlinmaterial.repository.comment

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.CommentItem

/**
 * Created by Panacea-Soft on 22/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
object CommentRepository {

    val commentList: List<CommentItem>
        get() = Gson().fromJson<List<CommentItem>>(json, object : TypeToken<List<CommentItem>>() {

        }.type)

    private val json = "[\n" +
            "  {\n" +
            "    \"user_name\" : \"John\",\n" +
            "    \"total_rating\":\"5.0\",\n" +
            "    \"comment\":\"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\",\n" +
            "    \"region\":\"West University Cafe\",\n" +
            "    \"added\":\"Jan 1 2018\",\n" +
            "    \"ago\" : \"2 months ago\",\n" +
            "    \"user_image\" : \"profile1\",\n" +
            "    \"total_like\" : \"4\",\n" +
            "    \"total_share\" : \"3\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"user_name\" : \"Sam Sao\",\n" +
            "    \"total_rating\":\"4.5\",\n" +
            "    \"comment\":\"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\",\n" +
            "    \"region\":\"North Land Cafe\",\n" +
            "    \"added\":\"Feb 23 2018\",\n" +
            "    \"ago\" : \"1 month ago\",\n" +
            "    \"user_image\" : \"profile2\",\n" +
            "    \"total_like\" : \"43\",\n" +
            "    \"total_share\" : \"35\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"user_name\" : \"Rehha\",\n" +
            "    \"total_rating\":\"3.0\",\n" +
            "    \"comment\":\"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\",\n" +
            "    \"region\":\"East Junction\",\n" +
            "    \"added\":\"Mar 23 2018\",\n" +
            "    \"ago\" : \"1 month ago\",\n" +
            "    \"user_image\" : \"profile1\",\n" +
            "    \"total_like\" : \"33\",\n" +
            "    \"total_share\" : \"66\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"user_name\" : \"Thomas\",\n" +
            "    \"total_rating\":\"5.0\",\n" +
            "    \"comment\":\"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\",\n" +
            "    \"region\":\"East Junction\",\n" +
            "    \"added\":\"May 23 2018\",\n" +
            "    \"ago\" : \"4 minutes ago\",\n" +
            "    \"user_image\" : \"profile2\",\n" +
            "    \"total_like\" : \"34\",\n" +
            "    \"total_share\" : \"67\"\n" +
            "  }\n" +
            "]"

}
