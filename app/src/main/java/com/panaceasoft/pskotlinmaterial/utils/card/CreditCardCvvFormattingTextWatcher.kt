package com.panaceasoft.pskotlinmaterial.utils.card

import android.text.Editable
import android.text.TextWatcher
import android.util.Log

/**
 * Created by Panacea-Soft on 7/18/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class CreditCardCvvFormattingTextWatcher(private val cardActionListener: CardActionListener) : TextWatcher {

    private var lock: Boolean = false

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        Log.d("TEAMPS", "onTextChanged")
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
        Log.d("TEAMPS", "beforeTextChanged")
    }

    override fun afterTextChanged(s: Editable) {
        Log.d("TEAMPS", "$lock afterTextChanged $s")

        lock = true

        cardActionListener.cvvChanged(s.toString())
        lock = false
    }
}
