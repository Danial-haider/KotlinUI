package com.panaceasoft.pskotlinmaterial.repository.directory

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.UserHistory

import java.util.ArrayList

/**
 * Created by Panacea-Soft on 9/6/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
object UserHistoryRepository {

    val historyList: ArrayList<UserHistory>
        get() = Gson().fromJson<ArrayList<UserHistory>>(json, object : TypeToken<ArrayList<UserHistory>>() {

        }.type)

    internal var json = "[\n" +
            "  {\n" +
            "    \"place_name\":\"Rider Cafe\",\n" +
            "    \"place_image\" : \"cafe1\",\n" +
            "    \"comment\":\"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\",\n" +
            "    \"region\":\"West University Cafe\",\n" +
            "    \"added\":\"Jan 1 2018\",\n" +
            "    \"ago\" : \"2 months ago\",\n" +
            "    \"action\" : \"Liked\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"place_name\":\"Golden Duck\",\n" +
            "    \"place_image\" : \"cafe2\",\n" +
            "    \"comment\":\"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\",\n" +
            "    \"region\":\"North Land Cafe\",\n" +
            "    \"added\":\"Feb 23 2018\",\n" +
            "    \"ago\" : \"1 month ago\",\n" +
            "    \"action\" : \"Commented\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"place_name\":\"Bager Queen\",\n" +
            "    \"place_image\" : \"cafe3\",\n" +
            "    \"comment\":\"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\",\n" +
            "    \"region\":\"East Junction\",\n" +
            "    \"added\":\"Mar 23 2018\",\n" +
            "    \"ago\" : \"1 month ago\",\n" +
            "    \"action\" : \"Liked\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"place_name\":\"Chicken Rice\",\n" +
            "    \"place_image\" : \"cafe4\",\n" +
            "    \"comment\":\"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\",\n" +
            "    \"region\":\"East Junction\",\n" +
            "    \"added\":\"May 23 2018\",\n" +
            "    \"ago\" : \"4 minutes ago\",\n" +
            "    \"action\" : \"Liked\"\n" +
            "  }\n" +
            "]"

}
