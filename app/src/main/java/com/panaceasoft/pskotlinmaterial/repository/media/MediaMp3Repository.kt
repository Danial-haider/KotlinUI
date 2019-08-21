package com.panaceasoft.pskotlinmaterial.repository.media

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.MediaMp3Obj

/**
 * Created by Panacea-Soft on 7/19/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


object MediaMp3Repository {
    val categoryList: List<MediaMp3Obj>
        get() = Gson().fromJson<List<MediaMp3Obj>>(json, object : TypeToken<List<MediaMp3Obj>>() {

        }.type)

    private val json = "[\n" +
            "  {\n" +
            "    \"title\":\"Sweet Child O'Mine\",\n" +
            "    \"image\":\"media_img_1\",\n" +
            "    \"singer\":\"Guns N'Roses\",\n" +
            "    \"song\":\"bensound_happyrock\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\":\"Back in Black\",\n" +
            "    \"image\":\"media_img_2\",\n" +
            "    \"singer\":\"AC/DC\",\n" +
            "    \"song\":\"bensound_highoctane\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\":\"November Rain\",\n" +
            "    \"image\":\"media_img_3\",\n" +
            "    \"singer\":\"Guns N'Roses\",\n" +
            "    \"song\":\"bensound_rumble\"\n" +
            "  }\n" +
            "]"
}
