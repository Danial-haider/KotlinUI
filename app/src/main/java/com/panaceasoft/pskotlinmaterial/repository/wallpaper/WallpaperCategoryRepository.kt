package com.panaceasoft.pskotlinmaterial.repository.wallpaper

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.WallpaperCategory

import java.util.ArrayList

/**
 * Created by Panacea-Soft on 6/30/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


object WallpaperCategoryRepository {

    val wallpaperCategoryList: ArrayList<WallpaperCategory>
        get() = Gson().fromJson<ArrayList<WallpaperCategory>>(wallpaperCategories, object : TypeToken<ArrayList<WallpaperCategory>>() {

        }.type)

    internal var wallpaperCategories = "[\n" +
            "  {\n" +
            "    \"name\":\"All\",\n" +
            "    \"image\":\"gallery_bird_2\",\n" +
            "    \"count\":\"200\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"3D\",\n" +
            "    \"image\":\"i3d_1\",\n" +
            "    \"count\":\"300\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Abstract\",\n" +
            "    \"image\":\"abstract_1\",\n" +
            "    \"count\":\"240\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Animals\",\n" +
            "    \"image\":\"gallery_bird_3\",\n" +
            "    \"count\":\"250\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Anime\",\n" +
            "    \"image\":\"anime_1\",\n" +
            "    \"count\":\"500\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Cars\",\n" +
            "    \"image\":\"car_1\",\n" +
            "    \"count\":\"305\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"City\",\n" +
            "    \"image\":\"sg_clarke_quay\",\n" +
            "    \"count\":\"450\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Fantasy\",\n" +
            "    \"image\":\"fantasy_1\",\n" +
            "    \"count\":\"1000\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Flowers\",\n" +
            "    \"image\":\"flower_1\",\n" +
            "    \"count\":\"700\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Food\",\n" +
            "    \"image\":\"dir_cat_1\",\n" +
            "    \"count\":\"300\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Games\",\n" +
            "    \"image\":\"game_1\",\n" +
            "    \"count\":\"420\"\n" +
            "  }\n" +
            "]"
}
