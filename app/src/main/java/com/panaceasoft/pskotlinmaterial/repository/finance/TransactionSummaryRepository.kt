package com.panaceasoft.pskotlinmaterial.repository.finance

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.FinanceSummary

/**
 * Created by Panacea-Soft on 7/17/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


object TransactionSummaryRepository {
    val summaryList: List<FinanceSummary>?
        get() = Gson().fromJson<List<FinanceSummary>>(json, object : TypeToken<List<FinanceSummary>>() {

        }.type)

    private val json = "[\n" +
            "  {\n" +
            "    \"title\": \"Savings\",\n" +
            "    \"amount\": \"$5300.00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Budget\",\n" +
            "    \"amount\": \"$6000.00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"title\": \"Expense\",\n" +
            "    \"amount\": \"$4300.00\"\n" +
            "  }\n" +
            "]"
}
