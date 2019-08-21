package com.panaceasoft.pskotlinmaterial.repository.directory

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.Country

import java.util.ArrayList

object CountryRepository {

    val countryList: ArrayList<Country>
        get() = Gson().fromJson(json, object : TypeToken<ArrayList<Country>>() {

        }.type)

    private val json = "[\n" +
            "  {\n" +
            "    \"id\":\"Japan\",\n" +
            "    \"name\":\"Japan\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\",\n" +
            "    \"image\":\"city_japan\",\n" +
            "    \"flag\":\"flag_japan\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\":\"China\",\n" +
            "    \"name\":\"China\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\",\n" +
            "    \"image\":\"city_china\",\n" +
            "    \"flag\":\"flag_china\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\":\"Singapore\",\n" +
            "    \"name\":\"Singapore\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\",\n" +
            "    \"image\":\"city_singapore\",\n" +
            "    \"flag\":\"flag_singapore\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\":\"Korea\",\n" +
            "    \"name\":\"Korea\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\",\n" +
            "    \"image\":\"city_korea\",\n" +
            "    \"flag\":\"flag_korea\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\":\"Myanmar\",\n" +
            "    \"name\":\"Myanmar\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\",\n" +
            "    \"image\":\"city_myanmar\",\n" +
            "    \"flag\":\"flag_myanmar\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\":\"Thailand\",\n" +
            "    \"name\":\"Thailand\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\",\n" +
            "    \"image\":\"city_thailand\",\n" +
            "    \"flag\":\"flag_thailand\"\n" +
            "  }\n" +
            "]"
}