package com.panaceasoft.pskotlinmaterial.repository.finance

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.FinanceTransferTransaction

/**
 * Created by Panacea-Soft on 7/18/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


object TransferTransactionRepository {
    val transferTransactionList: List<FinanceTransferTransaction>
        get() = Gson().fromJson<List<FinanceTransferTransaction>>(json, object : TypeToken<List<FinanceTransferTransaction>>() {

        }.type)

    private val json = "[\n" +
            "  {\n" +
            "    \"user_to\": \"George\",\n" +
            "    \"amount\": \"$50.00\",\n" +
            "    \"date\": \"30-Jun-2020\",\n" +
            "    \"type\": \"Lorem ipsum\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"user_to\": \"Oliver\",\n" +
            "    \"amount\": \"$1000.00\",\n" +
            "    \"date\": \"26-Jun-2020\",\n" +
            "    \"type\": \"Lorem ipsum\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"user_to\": \"Harry\",\n" +
            "    \"amount\": \"$500.00\",\n" +
            "    \"date\": \"24-Jun-2020\",\n" +
            "    \"type\": \"Lorem ipsum\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"user_to\": \"Jack\",\n" +
            "    \"amount\": \"$200.00\",\n" +
            "    \"date\": \"24-Jun-2020\",\n" +
            "    \"type\": \"Lorem ipsum\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"user_to\": \"Jacob\",\n" +
            "    \"amount\": \"$100.00\",\n" +
            "    \"date\": \"10-Jun-2020\",\n" +
            "    \"type\": \"Lorem ipsum\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"user_to\": \"Charlie\",\n" +
            "    \"amount\": \"$50.00\",\n" +
            "    \"date\": \"06-Jun-2020\",\n" +
            "    \"type\": \"Lorem ipsum\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"user_to\": \"Joshua\",\n" +
            "    \"amount\": \"$10.00\",\n" +
            "    \"date\": \"04-Jun-2020\",\n" +
            "    \"type\": \"Lorem ipsum\"\n" +
            "  }\n" +
            "]"

}
