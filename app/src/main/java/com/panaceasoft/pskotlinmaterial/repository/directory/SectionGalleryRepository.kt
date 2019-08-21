package com.panaceasoft.pskotlinmaterial.repository.directory

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.SectionGallery

import java.util.ArrayList

/**
 * Created by Panacea-Soft on 6/29/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


object SectionGalleryRepository {

    internal var sectionGallery = "[\n" +
            "\n" +
            "  {\n" +
            "    \"id\":\"p2\",\n" +
            "    \"name\":\"Birds\",\n" +
            "    \"images\": [\n" +
            "      {\n" +
            "        \"image_id\":\"i7\",\n" +
            "        \"image\":\"gallery_bird_1\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"image_id\":\"i8\",\n" +
            "        \"image\":\"gallery_bird_2\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"image_id\":\"i9\",\n" +
            "        \"image\":\"gallery_bird_3\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"image_id\":\"i10\",\n" +
            "        \"image\":\"gallery_bird_4\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"image_id\":\"i11\",\n" +
            "        \"image\":\"gallery_bird_5\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"image_id\":\"i12\",\n" +
            "        \"image\":\"gallery_bird_6\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"image_id\":\"i13\",\n" +
            "        \"image\":\"gallery_bird_7\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"image_id\":\"i19\",\n" +
            "        \"image\":\"gallery_bird_8\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\":\"p3\",\n" +
            "    \"name\":\"Fishes\",\n" +
            "    \"images\": [\n" +
            "      {\n" +
            "        \"image_id\":\"i14\",\n" +
            "        \"image\":\"gallery_fish_1\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"image_id\":\"i15\",\n" +
            "        \"image\":\"gallery_fish_2\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"image_id\":\"i16\",\n" +
            "        \"image\":\"gallery_fish_3\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"image_id\":\"i17\",\n" +
            "        \"image\":\"gallery_fish_4\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"image_id\":\"i18\",\n" +
            "        \"image\":\"gallery_fish_5\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\":\"p1\",\n" +
            "    \"name\":\"Tigers\",\n" +
            "    \"images\": [\n" +
            "      {\n" +
            "        \"image_id\":\"i1\",\n" +
            "        \"image\":\"gallery_tiger_1\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"image_id\":\"i2\",\n" +
            "        \"image\":\"gallery_tiger_2\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"image_id\":\"i3\",\n" +
            "        \"image\":\"gallery_tiger_3\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"image_id\":\"i4\",\n" +
            "        \"image\":\"gallery_tiger_4\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"image_id\":\"i5\",\n" +
            "        \"image\":\"gallery_tiger_5\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"image_id\":\"i6\",\n" +
            "        \"image\":\"gallery_tiger_6\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "\n" +
            "]"

    fun getSectionGallery(): ArrayList<SectionGallery>? {
        return Gson().fromJson<ArrayList<SectionGallery>>(sectionGallery, object : TypeToken<ArrayList<SectionGallery>>() {

        }.type)
    }
}
