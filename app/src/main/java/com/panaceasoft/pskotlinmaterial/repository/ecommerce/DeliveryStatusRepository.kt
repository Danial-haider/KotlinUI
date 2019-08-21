package com.panaceasoft.pskotlinmaterial.repository.ecommerce

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.DeliveryStatus

import java.util.ArrayList

/**
 * Created by Panacea-Soft on 7/20/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


object DeliveryStatusRepository {

    val deliveryStatusList: ArrayList<DeliveryStatus>
        get() = Gson().fromJson<ArrayList<DeliveryStatus>>(json, object : TypeToken<ArrayList<DeliveryStatus>>() {

        }.type)

    internal var json = "[\n" +
            "  {\n" +
            "    \"date\":\"Aug14\",\n" +
            "    \"time\":\"09:00\",\n" +
            "    \"icon\":\"timeline_green_circle\",\n" +
            "    \"location\":\"Pathein\",\n" +
            "    \"remark\":\"Delivery Package On Courier\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"date\":\"Aug14\",\n" +
            "    \"time\":\"01:40\",\n" +
            "    \"icon\":\"timeline_blue_circle\",\n" +
            "    \"location\":\"Pathein\",\n" +
            "    \"remark\":\"On Process\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"date\":\"Aug13\",\n" +
            "    \"time\":\"19:05\",\n" +
            "    \"icon\":\"timeline_yellow_circle\",\n" +
            "    \"location\":\"Pathein\",\n" +
            "    \"remark\":\"Received On Destination\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"date\":\"Aug13\",\n" +
            "    \"time\":\"22:00\",\n" +
            "    \"icon\":\"timeline_yellow_circle\",\n" +
            "    \"location\":\"Yangon\",\n" +
            "    \"remark\":\"On Transit\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"date\":\"Aug12\",\n" +
            "    \"time\":\"03:05\",\n" +
            "    \"icon\":\"timeline_yellow_circle\",\n" +
            "    \"location\":\"Mandalay\",\n" +
            "    \"remark\":\"Manifested\"\n" +
            "  }\n" +
            "]"

}
