package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 7/17/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class FinanceSummary(@field:SerializedName("title")
                     var title: String, @field:SerializedName("amount")
                     var amount: String)
