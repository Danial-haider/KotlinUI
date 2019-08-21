package com.panaceasoft.pskotlinmaterial.activity.feature.payment.ecommerce

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import com.panaceasoft.pskotlinmaterial.utils.card.*
import kotlinx.android.synthetic.main.feature_payment_ecommerce_card_entry_1_activity.*

class FeaturePaymentECommerceCardEntry1Activity : AppCompatActivity(), CardActionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_payment_ecommerce_card_entry_1_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initData() {

    }

    private fun initUI() {

        initToolbar()

        setDefaultCircleImage(color1BgImageView, R.color.md_black_1000)
        setDefaultCircleImage(color2BgImageView, R.color.md_red_800)
        setDefaultCircleImage(color3BgImageView, R.color.md_blue_800)
        setDefaultCircleImage(color4BgImageView, R.color.md_yellow_800)

        nameEditText.addTextChangedListener(CreditCardNameFormattingTextWatcher(this))
        numberEditText.addTextChangedListener(CreditCardNumberFormattingTextWatcher(this))
        dateEditText.addTextChangedListener(CreditCardExpiryDateFormattingTextWatcher(this))
        cvvEditText.addTextChangedListener(CreditCardCvvFormattingTextWatcher(this))

    }

    private fun setDefaultCircleImage(imageView: ImageView, color: Int) {
        Utils.setCircleImageToImageView(applicationContext, imageView, R.drawable.white_background, color, 10, R.color.colorLine)
    }

    private fun initDataBindings() {
        Utils.setImageToImageView(this, cardImageView, R.drawable.bank_card_1)
    }

    private fun initActions() {

        //region Color

        color1ImageView.setOnClickListener {
            resetAllColor()
            color1ImageView.setImageResource(R.drawable.baseline_select_with_check_transparent_24)
            Utils.setImageToImageView(applicationContext, cardImageView, R.drawable.bank_card_1)
        }

        color2ImageView.setOnClickListener {
            resetAllColor()
            color2ImageView.setImageResource(R.drawable.baseline_select_with_check_transparent_24)
            Utils.setImageToImageView(applicationContext, cardImageView, R.drawable.bank_card_3)
        }

        color3ImageView.setOnClickListener {
            resetAllColor()
            color3ImageView.setImageResource(R.drawable.baseline_select_with_check_transparent_24)
            Utils.setImageToImageView(applicationContext, cardImageView, R.drawable.bank_card_4)
        }

        color4ImageView.setOnClickListener {
            resetAllColor()
            color4ImageView.setImageResource(R.drawable.baseline_select_with_check_transparent_24)
            Utils.setImageToImageView(applicationContext, cardImageView, R.drawable.bank_card_2)
        }

        //endregion
    }

    private fun resetAllColor() {
        color1ImageView.setImageDrawable(null)
        color2ImageView.setImageDrawable(null)
        color3ImageView.setImageDrawable(null)
        color4ImageView.setImageDrawable(null)
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Card Entry 1"

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
        cardNumberTextView?.text = cardNumber
    }

    override fun cardNameChanged(name: String) {
        cardNameTextView?.text = name
    }

    override fun cardExpiryDateChanged(date: String) {
        cardDateTextView?.text = date
    }

    override fun cvvChanged(cvv: String) {
        cardCvvTextView?.text = cvv
    }
}


