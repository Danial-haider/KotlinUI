package com.panaceasoft.pskotlinmaterial.`object`

import com.google.gson.annotations.SerializedName

/**
 * Created by Panacea-Soft on 7/18/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class CreditCard(@field:SerializedName("card_name")
                 var cardName: String, @field:SerializedName("card_number")
                 var cardNumber: String, @field:SerializedName("card_expiry_date")
                 var cardExpiryDate: String, @field:SerializedName("card_cvv")
                 var cardCVV: String, @field:SerializedName("card_type")
                 var cardType: String, @field:SerializedName("card_bg")
                 var cardBg: String)
