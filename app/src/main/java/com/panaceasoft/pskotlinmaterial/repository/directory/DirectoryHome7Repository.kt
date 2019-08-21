package com.panaceasoft.pskotlinmaterial.repository.directory

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.DirectoryHome7Category

import java.util.ArrayList

/**
 * Created by Panacea-Soft on 14/6/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
object DirectoryHome7Repository {

    val categoryList: ArrayList<DirectoryHome7Category>
        get() = Gson().fromJson<ArrayList<DirectoryHome7Category>>(json, object : TypeToken<ArrayList<DirectoryHome7Category>>() {

        }.type)

    private val json = "[\n" +
            "  {\n" +
            "    \"name\" : \"ATMs\",\n" +
            "    \"image\" : \"atm\",\n" +
            "    \"color\" : \"#c42e2e\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\" : \"Banks\",\n" +
            "    \"image\" : \"bank\",\n" +
            "    \"color\" : \"#b50b5c\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\" : \"Books\",\n" +
            "    \"image\" : \"book\",\n" +
            "    \"color\" : \"#7800a5\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\" : \"Bus Stops\",\n" +
            "    \"image\" : \"bus_stop\",\n" +
            "    \"color\" : \"#5618ab\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\" : \"Cafes\",\n" +
            "    \"image\" : \"cafe\",\n" +
            "    \"color\" : \"#3e35a2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\" : \"Car Wash\",\n" +
            "    \"image\" : \"car_wash\",\n" +
            "    \"color\" : \"#466fd5\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\" : \"Dentists\",\n" +
            "    \"image\" : \"dentists\",\n" +
            "    \"color\" : \"#4683d4\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\" : \"Doctors\",\n" +
            "    \"image\" : \"doctor\",\n" +
            "    \"color\" : \"#4196a8\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\" : \"Restaurant\",\n" +
            "    \"image\" : \"restaurant\",\n" +
            "    \"color\" : \"#2e7a6a\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\" : \"Petrol Pumps\",\n" +
            "    \"image\" : \"petrol\",\n" +
            "    \"color\" : \"#2b6559\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\" : \"Groceries\",\n" +
            "    \"image\" : \"grocery\",\n" +
            "    \"color\" : \"#abb710\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\" : \"Gyms\",\n" +
            "    \"image\" : \"gym\",\n" +
            "    \"color\" : \"#e67e00\"\n" +
            "  }\n" +
            "]"

}
