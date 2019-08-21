package com.panaceasoft.pskotlinmaterial.repository.education

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.EducationVideo

/**
 * Created by Panacea-Soft on 8/19/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


object EducationVideoListRepository {

    val educationVideoList: List<EducationVideo>
        get() = Gson().fromJson<List<EducationVideo>>(videoJson, object : TypeToken<List<EducationVideo>>() {

        }.type)

    internal var videoJson = "[\n" +
            "  {\n" +
            "    \"title\":\"Getting started as an entrepreneur\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ut lectus eros. Quisque porta pretium commodo.\",\n" +
            "    \"length\":\"1m 24s\",\n" +
            "    \"image\":\"education_img_13\",\n" +
            "    \"category\":\"entrepreneur\",\n" +
            "    \"size\":\"20MB\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\":\"Finding focus\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ut lectus eros. Quisque porta pretium commodo.\",\n" +
            "    \"length\":\"1m 5s\",\n" +
            "    \"image\":\"education_img_12\",\n" +
            "    \"category\":\"entrepreneur\",\n" +
            "    \"size\":\"21MB\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\":\"Increasing product awareness\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ut lectus eros. Quisque porta pretium commodo.\",\n" +
            "    \"length\":\"1m 33s\",\n" +
            "    \"image\":\"education_img_11\",\n" +
            "    \"category\":\"entrepreneur\",\n" +
            "    \"size\":\"19MB\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\":\"Bringing in investors\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ut lectus eros. Quisque porta pretium commodo.\",\n" +
            "    \"length\":\"1m 42s\",\n" +
            "    \"image\":\"education_img_10\",\n" +
            "    \"category\":\"entrepreneur\",\n" +
            "    \"size\":\"18MB\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\":\"Pitching to investors\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ut lectus eros. Quisque porta pretium commodo.\",\n" +
            "    \"length\":\"2m 10s\",\n" +
            "    \"image\":\"education_img_9\",\n" +
            "    \"category\":\"entrepreneur\",\n" +
            "    \"size\":\"30MB\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\":\"Planning ahead\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ut lectus eros. Quisque porta pretium commodo.\",\n" +
            "    \"length\":\"1m 24s\",\n" +
            "    \"image\":\"education_img_8\",\n" +
            "    \"category\":\"entrepreneur\",\n" +
            "    \"size\":\"20MB\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\":\"The biggest mistake entrepreneurs make\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ut lectus eros. Quisque porta pretium commodo.\",\n" +
            "    \"length\":\"1m 27s\",\n" +
            "    \"image\":\"education_img_7\",\n" +
            "    \"category\":\"entrepreneur\",\n" +
            "    \"size\":\"22MB\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\":\"Understanding the importance of company culture\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ut lectus eros. Quisque porta pretium commodo.\",\n" +
            "    \"length\":\"1m 18s\",\n" +
            "    \"image\":\"education_img_6\",\n" +
            "    \"category\":\"entrepreneur\",\n" +
            "    \"size\":\"19MB\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\":\"Thinking about competition\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ut lectus eros. Quisque porta pretium commodo.\",\n" +
            "    \"length\":\"1m 8s\",\n" +
            "    \"image\":\"education_img_5\",\n" +
            "    \"category\":\"entrepreneur\",\n" +
            "    \"size\":\"18MB\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\":\"Exploring entrepreneurship fundamentals\",\n" +
            "    \"desc\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ut lectus eros. Quisque porta pretium commodo.\",\n" +
            "    \"length\":\"2m 40s\",\n" +
            "    \"image\":\"education_img_4\",\n" +
            "    \"category\":\"entrepreneur\",\n" +
            "    \"size\":\"33MB\"\n" +
            "  }\n" +
            "]"

}
