package com.panaceasoft.pskotlinmaterial.repository.finance

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.FinancePersonalLog

/**
 * Created by Panacea-Soft on 7/17/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


object TransactionRepository {
    val transactionList: List<FinancePersonalLog>
        get() = Gson().fromJson<List<FinancePersonalLog>>(json, object : TypeToken<List<FinancePersonalLog>>() {

        }.type)

    private val json = "[\n" +
            "  {\n" +
            "    \"title\": \"Lunch with friend\",\n" +
            "    \"amount\": \"$50.00\",\n" +
            "    \"date\": \"30-Jun-2020\",\n" +
            "    \"type\": \"Cash\",\n" +
            "    \"icon\": \"finance_img_1\",\n" +
            "    \"percentage\": \"20\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Shopping\",\n" +
            "    \"amount\": \"$600.00\",\n" +
            "    \"date\": \"30-Jun-2020\",\n" +
            "    \"type\": \"Payment\",\n" +
            "    \"icon\": \"finance_img_2\",\n" +
            "    \"percentage\": \"30\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Dinner\",\n" +
            "    \"amount\": \"$100.00\",\n" +
            "    \"date\": \"28-Jun-2020\",\n" +
            "    \"type\": \"Payment\",\n" +
            "    \"icon\": \"finance_img_3\",\n" +
            "    \"percentage\": \"5\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Taxi Bill\",\n" +
            "    \"amount\": \"$2000.00\",\n" +
            "    \"date\": \"01-Jun-2020\",\n" +
            "    \"type\": \"Debit\",\n" +
            "    \"icon\": \"finance_img_4\",\n" +
            "    \"percentage\": \"60\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Train Ticket\",\n" +
            "    \"amount\": \"$20.00\",\n" +
            "    \"date\": \"30-May-2020\",\n" +
            "    \"type\": \"Cash\",\n" +
            "    \"icon\": \"finance_img_5\",\n" +
            "    \"percentage\": \"70\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Gym\",\n" +
            "    \"amount\": \"$300\",\n" +
            "    \"date\": \"30-May-2020\",\n" +
            "    \"type\": \"Payment\",\n" +
            "    \"icon\": \"finance_img_6\",\n" +
            "    \"percentage\": \"90\"\n" +
            "  }\n" +
            "]"
}
