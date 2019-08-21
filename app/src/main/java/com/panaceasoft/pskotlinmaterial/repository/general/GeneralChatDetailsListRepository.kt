package com.panaceasoft.pskotlinmaterial.repository.general

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.ChatDetailsVO

import java.util.ArrayList

/**
 * Created by Panacea-Soft on 9/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


object GeneralChatDetailsListRepository {
    val generalChatDetailsList: ArrayList<ChatDetailsVO>
        get() = Gson().fromJson<ArrayList<ChatDetailsVO>>(json, object : TypeToken<ArrayList<ChatDetailsVO>>() {

        }.type)

    internal var json = "[\n" +
            "  {\n" +
            "    \"id\": \"message1\",\n" +
            "    \"by_user\": \"user1\",\n" +
            "    \"profile_image\": \"woman_profile\",\n" +
            "    \"msg\": \"Hello, thank you for calling Provide Support. How may I help you?\",\n" +
            "    \"timestamp\": \"9:56 AM\",\n" +
            "    \"state\": \"read\",\n" +
            "    \"type\": \"other\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"message2\",\n" +
            "    \"by_user\": \"user2\",\n" +
            "    \"profile_image\": \"user_profile_man\",\n" +
            "    \"msg\": \"Okay, No problem\",\n" +
            "    \"timestamp\": \"9:56 AM\",\n" +
            "    \"state\": \"read\",\n" +
            "    \"type\": \"owner\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"time1\",\n" +
            "    \"by_user\": \"none\",\n" +
            "    \"profile_image\": \"user_profile_man\",\n" +
            "    \"msg\": \"September 9\",\n" +
            "    \"timestamp\": \"none\",\n" +
            "    \"state\": \"none\",\n" +
            "    \"type\": \"time\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"message3\",\n" +
            "    \"by_user\": \"user1\",\n" +
            "    \"profile_image\": \"woman_profile\",\n" +
            "    \"msg\": \"Hello! How was the party?\",\n" +
            "    \"timestamp\": \"9:56 AM\",\n" +
            "    \"state\": \"read\",\n" +
            "    \"type\": \"other\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"message4\",\n" +
            "    \"by_user\": \"user2\",\n" +
            "    \"profile_image\": \"user_profile_man\",\n" +
            "    \"msg\": \"It's really good, thanks.\",\n" +
            "    \"timestamp\": \"9:56 AM\",\n" +
            "    \"state\": \"read\",\n" +
            "    \"type\": \"owner\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"message5\",\n" +
            "    \"by_user\": \"user2\",\n" +
            "    \"profile_image\": \"user_profile_man\",\n" +
            "    \"msg\": \"Jedd was there\",\n" +
            "    \"timestamp\": \"9:56 AM\",\n" +
            "    \"state\": \"sent\",\n" +
            "    \"type\": \"owner\"\n" +
            "  }\n" +
            "]"
}
