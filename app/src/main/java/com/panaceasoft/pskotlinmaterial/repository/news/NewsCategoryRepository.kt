package com.panaceasoft.pskotlinmaterial.repository.news

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.NewsCategory

import java.util.Collections

/**
 * Created by Panacea-Soft on 8/9/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


object NewsCategoryRepository {

    val newsCategoryList: List<NewsCategory>
        get() {

            val categoryList = Gson().fromJson<List<NewsCategory>>(json, object : TypeToken<List<NewsCategory>>() {

            }.type)

            Collections.shuffle(categoryList)
            return categoryList
        }

    internal var json = "[\n" +
            "\t{\n" +
            "\t\t\"category\":\"Sports\",\n" +
            "\t\t\"category_image\":\"news_category_1\",\n" +
            "\t\t\"is_check\":\"true\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"category\":\"Travel\",\n" +
            "\t\t\"category_image\":\"news_category_2\",\n" +
            "\t\t\"is_check\":\"true\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"category\":\"Style\",\n" +
            "\t\t\"category_image\":\"news_category_3\",\n" +
            "\t\t\"is_check\":\"false\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"category\":\"TV & Movies\",\n" +
            "\t\t\"category_image\":\"news_category_4\",\n" +
            "\t\t\"is_check\":\"true\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"category\":\"Politics\",\n" +
            "\t\t\"category_image\":\"news_category_5\",\n" +
            "\t\t\"is_check\":\"false\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"category\":\"Music\",\n" +
            "\t\t\"category_image\":\"news_category_6\",\n" +
            "\t\t\"is_check\":\"false\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"category\":\"Health & Fitness\",\n" +
            "\t\t\"category_image\":\"news_category_7\",\n" +
            "\t\t\"is_check\":\"false\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"category\":\"Food\",\n" +
            "\t\t\"category_image\":\"dir_cat_4\",\n" +
            "\t\t\"is_check\":\"true\"\n" +
            "\t}\n" +
            "]"

}
