package com.panaceasoft.pskotlinmaterial.repository.general

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.GeneralInboxList

import java.util.ArrayList

/**
 * Created by Panacea-Soft on 7/21/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


object GeneralInboxListRepository {
    val generalInboxList: ArrayList<GeneralInboxList>
        get() = Gson().fromJson<ArrayList<GeneralInboxList>>(json, object : TypeToken<ArrayList<GeneralInboxList>>() {

        }.type)

    internal var json = "[\n" +
            "  {\n" +
            "    \"name\":\"Lorem ipsum\",\n" +
            "    \"caption\":\"Aenean\",\n" +
            "    \"image\":\"profile1\",\n" +
            "    \"detail\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas eget elementum dui, at accumsan nunc.\",\n" +
            "    \"time\":\"11:00 PM\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Pellentesque nec\",\n" +
            "    \"caption\":\"Quisque\",\n" +
            "    \"image\":\"profile2\",\n" +
            "    \"detail\":\"Pellentesque aliquam magna at lobortis condimentum. In tempor dignissim sodales. \",\n" +
            "    \"time\":\"10:05 PM\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Duis id mauris\",\n" +
            "    \"caption\":\"Pellentesque\",\n" +
            "    \"image\":\"man_profile\",\n" +
            "    \"detail\":\"Aenean sed leo non magna efficitur dictum. Aenean vel turpis bibendum diam cursus bibendum. \",\n" +
            "    \"time\":\"07:00 PM\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Aenean tincidunt\",\n" +
            "    \"caption\":\"Donec\",\n" +
            "    \"image\":\"woman_profile\",\n" +
            "    \"detail\":\"Interdum et malesuada fames ac ante ipsum primis in faucibus. Nam ac vestibulum nulla. \",\n" +
            "    \"time\":\"01:00 PM\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Pellentesque eu\",\n" +
            "    \"caption\":\"Morbi\",\n" +
            "    \"image\":\"profile1\",\n" +
            "    \"detail\":\"Pellentesque sed sem luctus, efficitur elit ut, hendrerit leo. Sed tincidunt sit amet enim non tristique. \",\n" +
            "    \"time\":\"11:00 AM\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Nunc sed nulla\",\n" +
            "    \"caption\":\"Proin\",\n" +
            "    \"image\":\"profile2\",\n" +
            "    \"detail\":\"Curabitur tristique justo ut sapien cursus fermentum. Duis quis augue eros. Donec rhoncus ornare orci.\",\n" +
            "    \"time\":\"10:00 AM\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"In convallis mi\",\n" +
            "    \"caption\":\"Pellentesque\",\n" +
            "    \"image\":\"profile1\",\n" +
            "    \"detail\":\"Nunc sit amet vulputate erat. Curabitur ac turpis dolor. Duis tristique accumsan posuere. Morbi quam metus.\",\n" +
            "    \"time\":\"05:00 AM\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Vestibulum ac est\",\n" +
            "    \"caption\":\"Donec\",\n" +
            "    \"image\":\"woman_profile\",\n" +
            "    \"detail\":\"Fusce eu ex elementum, euismod nunc vel, lobortis neque. Integer imperdiet tortor suscipit egestas cursus.\",\n" +
            "    \"time\":\"04:00 AM\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Pellentesque pretium\",\n" +
            "    \"caption\":\"Vivamus\",\n" +
            "    \"image\":\"man_profile\",\n" +
            "    \"detail\":\"Duis hendrerit massa nec eros elementum, eget vestibulum arcu scelerisque. Vestibulum tincidunt interdum sapien nec sagittis.\",\n" +
            "    \"time\":\"03:30 AM\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Nunc aliquet purus\",\n" +
            "    \"caption\":\"Dignissim\",\n" +
            "    \"image\":\"profile1\",\n" +
            "    \"detail\":\"Donec facilisis tortor et dolor hendrerit, ac iaculis ipsum congue. Sed bibendum quam ut massa efficitur vestibulum.\",\n" +
            "    \"time\":\"03:20 AM\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Praesent scelerisque\",\n" +
            "    \"caption\":\"Finibus\",\n" +
            "    \"image\":\"profile2\",\n" +
            "    \"detail\":\"Mauris eget luctus massa. Integer et magna ut sem dictum semper sit amet scelerisque felis.\",\n" +
            "    \"time\":\"03:10 AM\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"Aliquam consectetur\",\n" +
            "    \"caption\":\"Porttitor\",\n" +
            "    \"image\":\"man_profile\",\n" +
            "    \"detail\":\"Sed vitae arcu quis enim rhoncus placerat in eu lacus. Sed non mollis magna, a venenatis nisi.\",\n" +
            "    \"time\":\"02:00 AM\"\n" +
            "  }\n" +
            "\n" +
            "]"
}
