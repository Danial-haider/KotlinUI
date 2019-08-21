package com.panaceasoft.pskotlinmaterial.repository.ecommerce

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.CreditCard

import java.util.ArrayList

/**
 * Created by Panacea-Soft on 7/18/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


object CreditCardRepository {
    val creditCardList: ArrayList<CreditCard>?
        get() = Gson().fromJson<ArrayList<CreditCard>>(json, object : TypeToken<ArrayList<CreditCard>>() {

        }.type)

    internal var json = "[\n" +
            "  {\n" +
            "    \"card_name\":\"******* John\",\n" +
            "    \"card_number\":\"**** **** **** 3535\",\n" +
            "    \"card_expiry_date\":\"*1/*0\",\n" +
            "    \"card_cvv\":\"**2\",\n" +
            "    \"card_type\":\"bank_master_card\",\n" +
            "    \"card_bg\":\"bank_card_1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"card_name\":\"******* John\",\n" +
            "    \"card_number\":\"**** **** **** 8385\",\n" +
            "    \"card_expiry_date\":\"*1/*0\",\n" +
            "    \"card_cvv\":\"**0\",\n" +
            "    \"card_type\":\"bank_union_pay\",\n" +
            "    \"card_bg\":\"bank_card_3\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"card_name\":\"******* John\",\n" +
            "    \"card_number\":\"**** **** **** 5293\",\n" +
            "    \"card_expiry_date\":\"*1/*0\",\n" +
            "    \"card_cvv\":\"**7\",\n" +
            "    \"card_type\":\"bank_visa_white\",\n" +
            "    \"card_bg\":\"bank_card_4\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"card_name\":\"******* John\",\n" +
            "    \"card_number\":\"**** **** **** 1123\",\n" +
            "    \"card_expiry_date\":\"*1/*0\",\n" +
            "    \"card_cvv\":\"**3\",\n" +
            "    \"card_type\":\"bank_american_express\",\n" +
            "    \"card_bg\":\"bank_card_2\"\n" +
            "  }\n" +
            "]"
}
