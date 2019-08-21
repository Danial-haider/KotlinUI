package com.panaceasoft.pskotlinmaterial.repository.education

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.EducationCourseCollection

/**
 * Created by Panacea-Soft on 8/25/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


object EducationCourseCollectionRepository {
    val courseCollection: List<EducationCourseCollection>
        get() = Gson().fromJson<List<EducationCourseCollection>>(json, object : TypeToken<List<EducationCourseCollection>>() {

        }.type)

    internal var json = "[\n" +
            "  {\n" +
            "    \"name\":\"Linear Regression\",\n" +
            "    \"status\":\"In-Progress\",\n" +
            "    \"image\":\"education_course_1_img\",\n" +
            "    \"progress\":\"20\",\n" +
            "    \"type\":\"NANO-DEGREE PROGRAM\",\n" +
            "    \"color\":\"green\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Logistic Regression\",\n" +
            "    \"status\":\"Not Started\",\n" +
            "    \"image\":\"education_course_2_img\",\n" +
            "    \"progress\":\"0\",\n" +
            "    \"type\":\"NANO-DEGREE PROGRAM\",\n" +
            "    \"color\":\"yellow\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Decision Trees\",\n" +
            "    \"status\":\"Not Started\",\n" +
            "    \"image\":\"education_course_3_img\",\n" +
            "    \"progress\":\"0\",\n" +
            "    \"type\":\"NANO-DEGREE PROGRAM\",\n" +
            "    \"color\":\"blue\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Naive Bayes\",\n" +
            "    \"status\":\"Not Started\",\n" +
            "    \"image\":\"education_course_4_img\",\n" +
            "    \"progress\":\"0\",\n" +
            "    \"type\":\"NANO-DEGREE PROGRAM\",\n" +
            "    \"color\":\"red\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Support Vector Machines\",\n" +
            "    \"status\":\"Not Started\",\n" +
            "    \"image\":\"education_course_5_img\",\n" +
            "    \"progress\":\"0\",\n" +
            "    \"type\":\"NANO-DEGREE PROGRAM\",\n" +
            "    \"color\":\"orange\"\n" +
            "  }\n" +
            "]"
}
