package com.panaceasoft.pskotlinmaterial.repository.directory

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.DirectoryCategory

/**
 * Created by Panacea-Soft on 6/10/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


object CategoryRepository {

    val categoryList: List<DirectoryCategory>
        get() = Gson().fromJson<List<DirectoryCategory>>(json, object : TypeToken<List<DirectoryCategory>>() {

        }.type)

    private val json = "[\n" +
            "  {\n" +
            "    \"id\":\"Breakfast\",\n" +
            "    \"name\":\"Breakfast\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\",\n" +
            "    \"image\":\"dir_cat_1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\":\"Lunch\",\n" +
            "    \"name\":\"Lunch\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\",\n" +
            "    \"image\":\"dir_cat_2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\":\"Dinner\",\n" +
            "    \"name\":\"Dinner\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\",\n" +
            "    \"image\":\"dir_cat_3\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\":\"CoffeeAndTea\",\n" +
            "    \"name\":\"Coffee & Tea\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\",\n" +
            "    \"image\":\"dir_cat_4\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\":\"NightLife\",\n" +
            "    \"name\":\"Nightlife\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\",\n" +
            "    \"image\":\"dir_cat_5\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\":\"ThingsToDo\",\n" +
            "    \"name\":\"Things To Do\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\",\n" +
            "    \"image\":\"dir_cat_6\"\n" +
            "  }\n" +
            "]"


}
