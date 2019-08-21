package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 7/18/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class FinanceTransferTransaction(@field:SerializedName("user_to")
                                 var userTo: String, @field:SerializedName("amount")
                                 var amount: String, @field:SerializedName("date")
                                 var date: String, @field:SerializedName("type")
                                 var type: String)
