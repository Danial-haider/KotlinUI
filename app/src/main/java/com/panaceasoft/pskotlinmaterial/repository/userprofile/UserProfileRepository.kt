package com.panaceasoft.pskotlinmaterial.repository.userprofile

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.UserProfile

import java.util.ArrayList

/**
 * Created by Panacea-Soft on 7/4/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


object UserProfileRepository {
    val profileList: ArrayList<UserProfile>
        get() = Gson().fromJson<ArrayList<UserProfile>>(json, object : TypeToken<ArrayList<UserProfile>>() {

        }.type)

    internal var json = "[\n" +
            "  {\n" +
            "    \"image\":\"profile1\",\n" +
            "    \"name\":\"Oliver\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"image\":\"profile2\",\n" +
            "    \"name\":\"George\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"image\":\"man_profile\",\n" +
            "    \"name\":\"Harry\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"image\":\"woman_profile\",\n" +
            "    \"name\":\"Jack\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"image\":\"profile1\",\n" +
            "    \"name\":\"Jacob\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"image\":\"profile2\",\n" +
            "    \"name\":\"Charlie\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"image\":\"man_profile\",\n" +
            "    \"name\":\"Noah\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"image\":\"woman_profile\",\n" +
            "    \"name\":\"Joshua\"\n" +
            "  }\n" +
            "]"
}
