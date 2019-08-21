package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 7/17/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class FinancePersonalLog(@field:SerializedName("title")
                         var title: String, @field:SerializedName("amount")
                         var amount: String, @field:SerializedName("date")
                         var date: String, @field:SerializedName("type")
                         var type: String, @field:SerializedName("icon")
                         var icon: String, @field:SerializedName("percentage")
                         var percentage: String)
