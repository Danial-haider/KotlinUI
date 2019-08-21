package com.panaceasoft.pskotlinmaterial.activity.uicomponent.edittext

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.card.CardActionListener
import com.panaceasoft.pskotlinmaterial.utils.card.CreditCardExpiryDateFormattingTextWatcher
import com.panaceasoft.pskotlinmaterial.utils.card.CreditCardNumberFormattingTextWatcher
import kotlinx.android.synthetic.main.ui_edit_text_formatted_edit_text_activity.*

class UiEditTextFormattedEditTextActivity : AppCompatActivity(), CardActionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_edit_text_formatted_edit_text_activity)

        initUI()

        initActions()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()

        return super.onOptionsItemSelected(item)
    }


    private fun initUI() {
        initToolbar()
    }

    private fun initActions() {
        editText23.addTextChangedListener(CreditCardNumberFormattingTextWatcher(this))
        editText24.addTextChangedListener(CreditCardExpiryDateFormattingTextWatcher(this))
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Formatted Edit Text"

        try {
           toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.md_white_1000))
        } catch (e: Exception) {
            Log.e("TEAMPS", "Can't set color.")
        }

        try {
            setSupportActionBar(toolbar)
        } catch (e: Exception) {
            Log.e("TEAMPS", "Error in set support action bar.")
        }

        try {
            if (supportActionBar != null) {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
        } catch (e: Exception) {
            Log.e("TEAMPS", "Error in set display home as up enabled.")
        }

    }


    override fun cardNumberChanged(cardNumber: String) {

    }

    override fun cardNameChanged(name: String) {

    }

    override fun cardExpiryDateChanged(date: String) {

    }

    override fun cvvChanged(cvv: String) {

    }
}
