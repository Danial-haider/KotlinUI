package com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.filter

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.RangeSeekBar
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_ecommerce_filter_3_activity.*

class AppECommerceFilter3Activity : AppCompatActivity() {

    private lateinit var seekBar: RangeSeekBar<Int>

    internal var selectedList: Drawable? =null


    private var size1Status: Boolean = false
    private var size2Status: Boolean = false
    private var size3Status: Boolean = false
    private var size4Status: Boolean = false
    private var size5Status: Boolean = false

    private var color1Status: Boolean = true
    private var color2Status: Boolean = false
    private var color3Status: Boolean = false
    private var color4Status: Boolean = false
    private var color5Status: Boolean = false
    private var color6Status: Boolean = false
    private var color7Status: Boolean = false

    private var brand1status: Boolean = false
    private var brand2status: Boolean = false
    private var brand3status: Boolean = false
    private var brand4status: Boolean = false
    private var brand5status: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_ecommerce_filter_3_activity)

        initData()

        initUI()

        initDataBinding()

        initActions()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initData() {

    }

    private fun initUI() {

        // Init Toolbar
        initToolbar()


        val maxValue2 = 100
        seekBar = RangeSeekBar(0, maxValue2, this)

        seekBar.selectedMinValue = 0
        seekBar.setAbsoluteMaxValue(100)

        val linearLayout = findViewById<LinearLayout>(R.id.price_range_bar_container)
        linearLayout.addView(seekBar)

        setDefaultCircleImage(color1BgImageView, R.color.md_white_1000)
        setDefaultCircleImage(color2BgImageView, R.color.md_grey_400)
        setDefaultCircleImage(color3BgImageView, R.color.md_yellow_400)
        setDefaultCircleImage(color4BgImageView, R.color.md_green_500)
        setDefaultCircleImage(color5BgImageView, R.color.md_green_900)
        setDefaultCircleImage(color6BgImageView, R.color.md_blue_500)
        setDefaultCircleImage(color7BgImageView, R.color.md_black_1000)


        selectedList = ContextCompat.getDrawable(this,R.drawable.baseline_selected_list_24)
        selectedList?.setColorFilter(ContextCompat.getColor(this,R.color.colorPrimary), PorterDuff.Mode.SRC_IN)



        setDefaultCircleImage(size1BgImageView, R.color.md_grey_400)
        setDefaultCircleImage(size2BgImageView, R.color.md_grey_400)
        setDefaultCircleImage(size3BgImageView, R.color.md_grey_400)
        setDefaultCircleImage(size4BgImageView, R.color.md_grey_400)
        setDefaultCircleImage(size5BgImageView, R.color.md_grey_400)


        // Set Color Default
        color1ImageView?.setImageResource(R.drawable.baseline_select_with_check_transparent_24)
        color1Status = true


        // Set Size Default
        setSelectUnSelectSizeFilter(size3BgImageView, R.color.colorPrimary, size3TextView, R.color.md_white_1000)
        size3Status = true


    }

    private fun setDefaultCircleImage(imageView: ImageView?, color: Int) {
        Utils.setCircleImageToImageView(applicationContext, imageView!!, R.drawable.white_background, 0, 0)
        imageView.setColorFilter(ContextCompat.getColor(this,color), PorterDuff.Mode.SRC_IN)
    }

    private fun setSelectUnSelectSizeFilter(imageView: ImageView, bgColor: Int, textView: TextView, color: Int) {
        imageView.setColorFilter(ContextCompat.getColor(this,bgColor), PorterDuff.Mode.SRC_IN)
        textView.setTextColor(ContextCompat.getColor(this,color))
    }


    private fun initDataBinding() {

    }

    private fun initActions() {

        seekBar.setOnRangeSeekBarChangeListener(object : RangeSeekBar.OnRangeSeekBarChangeListener<Int>{
            override fun onRangeSeekBarValuesChanged(bar: RangeSeekBar<*>, minValue: Int, maxValue: Int) {
                Log.d("TEAMPS", "initUI: $minValue : $maxValue")

                val minStr = "$ $minValue"
                val maxStr = "$ $maxValue"

                priceRangeFromValueTextView.text = minStr
                priceRangeToValueTextView.text = maxStr
            }
        })

//
//        seekBar?.setOnRangeSeekBarChangeListener({ bar, minValue, maxValue ->
//
//            Log.d("TEAMPS", "initUI: $minValue : $maxValue")
//
//            val minStr = "$ $minValue"
//            val maxStr = "$ $maxValue"
//
//            priceRangeFromValueTextView?.text = minStr
//            priceRangeToValueTextView?.text = maxStr
//
//        })

        //region Size
        size1TextView.setOnClickListener {
            if (size1Status) {
                setSelectUnSelectSizeFilter(size1BgImageView, R.color.md_grey_400, size1TextView, R.color.md_grey_800)
                size1Status = false
            } else {
                setSelectUnSelectSizeFilter(size1BgImageView, R.color.colorPrimary, size1TextView, R.color.md_white_1000)
                size1Status = true
            }

        }

        size2TextView.setOnClickListener {
            if (size2Status) {
                setSelectUnSelectSizeFilter(size2BgImageView, R.color.md_grey_400, size2TextView, R.color.md_grey_800)
                size2Status = false
            } else {
                setSelectUnSelectSizeFilter(size2BgImageView, R.color.colorPrimary, size2TextView, R.color.md_white_1000)
                size2Status = true
            }

        }

        size3TextView.setOnClickListener {
            if (size3Status) {
                setSelectUnSelectSizeFilter(size3BgImageView, R.color.md_grey_400, size3TextView, R.color.md_grey_800)
                size3Status = false
            } else {
                setSelectUnSelectSizeFilter(size3BgImageView, R.color.colorPrimary, size3TextView, R.color.md_white_1000)
                size3Status = true
            }

        }

        size4TextView.setOnClickListener {
            if (size4Status) {
                setSelectUnSelectSizeFilter(size4BgImageView, R.color.md_grey_400, size4TextView, R.color.md_grey_800)
                size4Status = false
            } else {
                setSelectUnSelectSizeFilter(size4BgImageView, R.color.colorPrimary, size4TextView, R.color.md_white_1000)
                size4Status = true
            }

        }

        size5TextView.setOnClickListener {
            if (size5Status) {
                setSelectUnSelectSizeFilter(size5BgImageView, R.color.md_grey_400, size5TextView, R.color.md_grey_800)
                size5Status = false
            } else {
                setSelectUnSelectSizeFilter(size5BgImageView, R.color.colorPrimary, size5TextView, R.color.md_white_1000)
                size5Status = true
            }

        }

        //endregion

        //region Color

        color1ImageView.setOnClickListener {
            if (color1Status) {
                color1ImageView.setImageDrawable(null)
                color1Status = false
            } else {
                color1ImageView.setImageResource(R.drawable.baseline_select_with_check_transparent_24)
                color1Status = true
            }

        }

        color2ImageView.setOnClickListener {
            if (color2Status) {
                color2ImageView.setImageDrawable(null)
                color2Status = false
            } else {
                color2ImageView.setImageResource(R.drawable.baseline_select_with_check_transparent_24)
                color2Status = true
            }

        }

        color3ImageView.setOnClickListener {
            if (color3Status) {
                color3ImageView.setImageDrawable(null)
                color3Status = false
            } else {
                color3ImageView.setImageResource(R.drawable.baseline_select_with_check_transparent_24)
                color3Status = true
            }

        }

        color4ImageView.setOnClickListener {
            if (color4Status) {
                color4ImageView.setImageDrawable(null)
                color4Status = false
            } else {
                color4ImageView.setImageResource(R.drawable.baseline_select_with_check_transparent_24)
                color4Status = true
            }

        }

        color5ImageView.setOnClickListener {
            if (color5Status) {
                color5ImageView.setImageDrawable(null)
                color5Status = false
            } else {
                color5ImageView.setImageResource(R.drawable.baseline_select_with_check_transparent_24)
                color5Status = true
            }

        }

        color6ImageView.setOnClickListener {
            if (color6Status) {
                color6ImageView.setImageDrawable(null)
                color6Status = false
            } else {
                color6ImageView.setImageResource(R.drawable.baseline_select_with_check_transparent_24)
                color6Status = true
            }

        }

        color7ImageView.setOnClickListener {
            if (color7Status) {
                color7ImageView.setImageDrawable(null)
                color7Status = false
            } else {
                color7ImageView.setImageResource(R.drawable.baseline_select_with_check_transparent_24)
                color7Status = true
            }

        }

        //endregion


        // Price Range Reset
        priceRangeResetTextView.setOnClickListener { Toast.makeText(this, "Clicked Price Range Reset.", Toast.LENGTH_SHORT).show() }

        // Size Reset
        sizeResetTextView.setOnClickListener { Toast.makeText(this, "Clicked Size Reset.", Toast.LENGTH_SHORT).show() }

        // Color Reset
        colorResetTextView.setOnClickListener { Toast.makeText(this, "Clicked Color Reset.", Toast.LENGTH_SHORT).show() }

        // Brands Reset
        brandResetTextView.setOnClickListener { Toast.makeText(this, "Clicked Brand Reset.", Toast.LENGTH_SHORT).show() }

        //regions Brands
        brand1Button.setOnClickListener {

            if (brand1status) {
                brand1Button.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
                brand1status = false
            } else {
                setDrawable(brand1Button)
                brand1status = true
            }

        }

        brand2Button.setOnClickListener {

            if (brand2status) {
                brand2Button.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
                brand2status = false
            } else {
                //brand2Button.setCompoundDrawablesWithIntrinsicBounds(null, null, selectedList, null);
                setDrawable(brand2Button)
                brand2status = true
            }

        }

        brand3Button.setOnClickListener {

            if (brand3status) {
                brand3Button.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
                brand3status = false
            } else {
                //brand3Button.setCompoundDrawablesWithIntrinsicBounds(null, null, selectedList, null);
                setDrawable(brand3Button)
                brand3status = true
            }

        }

        brand4Button.setOnClickListener {

            if (brand4status) {
                brand4Button.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
                brand4status = false
            } else {
                //brand4Button.setCompoundDrawablesWithIntrinsicBounds(null, null, selectedList, null);
                setDrawable(brand4Button)
                brand4status = true
            }

        }

        brand5Button.setOnClickListener {

            if (brand5status) {
                brand5Button.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
                brand5status = false
            } else {
                setDrawable(brand5Button)
                //brand5Button.setCompoundDrawablesWithIntrinsicBounds(null, null, selectedList, null);
                brand5status = true
            }

        }
        //endregion

    }

    private fun setDrawable(button: Button?) {
        if (Utils.isRTL) {
            button?.setCompoundDrawablesWithIntrinsicBounds(selectedList, null, null, null)
        } else {
            button?.setCompoundDrawablesWithIntrinsicBounds(null, null, selectedList, null)
        }
    }

    fun clickMaterial(view: View?) {
        if (view != null && view is Button) {
            view.isSelected = !view.isSelected
        }
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Filter 3"

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

}
