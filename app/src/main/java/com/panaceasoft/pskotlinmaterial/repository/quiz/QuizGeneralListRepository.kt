package com.panaceasoft.pskotlinmaterial.repository.quiz

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.QuizGeneral

/**
 * Created by Panacea-Soft on 7/23/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


object QuizGeneralListRepository {
    val quizGeneralList: List<QuizGeneral>
        get() = Gson().fromJson<List<QuizGeneral>>(json, object : TypeToken<List<QuizGeneral>>() {

        }.type)

    private val json = "[\n" +
            "  {\n" +
            "    \"question\":\"Lorem ipsum adipiscing elit.  dolor sit amet, adipiscing elit.  consectetur adipiscing elit. Lorem ipsum adipiscing elit.  dolor sit amet, adipiscing elit.  consectetur adipiscing elit. \",\n" +
            "    \"answer1\":\"Lorem ipsum\",\n" +
            "    \"answer2\":\"Curabitur molestie\",\n" +
            "    \"answer3\":\"Etiam convallis\",\n" +
            "    \"answer4\":\"Proin auctor\",\n" +
            "    \"answer5\":\"Vivamus mattis\",\n" +
            "    \"correct_answer\":\"3\",\n" +
            "    \"image\":\"gallery_bird_6\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"question\":\"Morbi arcu sapien, pellentesque at consequat facilisis, ullamcorper ut quam. Praesent eget libero in nisi iaculis interdum. In eu ex mauris. Etiam vitae justo sed lorem consectetur viverra vitae eu velit. Donec vitae mi tellus.\",\n" +
            "    \"answer1\":\"Etiam non\",\n" +
            "    \"answer2\":\"Ut pretium\",\n" +
            "    \"answer3\":\"Sed fringilla\",\n" +
            "    \"answer4\":\"Nulla at dolor\",\n" +
            "    \"answer5\":\"Nam euismod\",\n" +
            "    \"correct_answer\":\"1\",\n" +
            "    \"image\":\"gallery_tiger_3\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"question\":\"Praesent justo turpis, placerat vitae lacus et, dignissim viverra est. Aliquam efficitur neque sit amet sapien congue egestas. Nulla quis mauris a risus lobortis blandit. \",\n" +
            "    \"answer1\":\"Cras maximus\",\n" +
            "    \"answer2\":\"Vivamus hendrerit\",\n" +
            "    \"answer3\":\"Phasellus\",\n" +
            "    \"answer4\":\"Etiam luctus\",\n" +
            "    \"answer5\":\"Nulla ornare\",\n" +
            "    \"correct_answer\":\"2\",\n" +
            "    \"image\":\"dir_cat_3\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"question\":\"Phasellus felis elit, condimentum eu felis sit amet, tincidunt congue erat. Praesent ipsum mi, aliquam at erat nec, aliquam ultrices orci. Curabitur maximus lobortis tincidunt.\",\n" +
            "    \"answer1\":\"Lorem ipsum\",\n" +
            "    \"answer2\":\"Curabitur molestie\",\n" +
            "    \"answer3\":\"Etiam convallis\",\n" +
            "    \"answer4\":\"Proin auctor\",\n" +
            "    \"answer5\":\"Vivamus mattis\",\n" +
            "    \"correct_answer\":\"5\",\n" +
            "    \"image\":\"cafe4\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"question\":\"Vestibulum sit amet tristique turpis, vel rhoncus purus. Aliquam erat volutpat. Suspendisse feugiat mi sed arcu pellentesque, ac accumsan neque tincidunt. Sed eget diam eget felis iaculis gravida eget.\",\n" +
            "    \"answer1\":\"Etiam non\",\n" +
            "    \"answer2\":\"Ut pretium\",\n" +
            "    \"answer3\":\"Sed fringilla\",\n" +
            "    \"answer4\":\"Nulla at dolor\",\n" +
            "    \"answer5\":\"Nam euismod\",\n" +
            "    \"correct_answer\":\"2\",\n" +
            "    \"image\":\"menu_restaurant_vintage_table\"\n" +
            "  }\n" +
            "]"
}
