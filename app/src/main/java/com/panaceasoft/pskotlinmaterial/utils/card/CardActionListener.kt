package com.panaceasoft.pskotlinmaterial.utils.card

/**
 * Created by Panacea-Soft on 7/18/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


interface CardActionListener {

    fun cardNumberChanged(cardNumber: String)
    fun cardNameChanged(name: String)
    fun cardExpiryDateChanged(date: String)
    fun cvvChanged(cvv: String)
}
