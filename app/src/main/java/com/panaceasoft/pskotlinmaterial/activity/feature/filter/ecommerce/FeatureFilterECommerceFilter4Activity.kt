package com.panaceasoft.pskotlinmaterial.activity.feature.filter.ecommerce

import android.app.Dialog
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.RangeSeekBar
import kotlinx.android.synthetic.main.feature_filter_ecommerce_filter_4_activity.*
import kotlinx.android.synthetic.main.feature_filter_ecommerce_filter_4_dialog.*
import java.util.*

class FeatureFilterECommerceFilter4Activity : AppCompatActivity() {

    internal lateinit var sizeList: List<String>
    internal lateinit var brandList: List<String>
    internal lateinit var sizeArrayAdapter: ArrayAdapter<String>
    internal lateinit var brandArrayAdapter: ArrayAdapter<String>

    private val size: List<String>
        get() {
            val sizeList = ArrayList<String>()

            sizeList.add("ALL")
            sizeList.add("Small ( S )")
            sizeList.add("Medium ( M )")
            sizeList.add("Large ( L )")
            sizeList.add("Extra Large ( XL )")

            return sizeList
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_filter_ecommerce_filter_4_activity)

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
        sizeList = size
        brandList = getBrandList()


    }

    private fun initDataBinding() {

    }

    private fun initActions() {
        filterFab.setOnClickListener { getCustomLayoutDialog(R.layout.feature_filter_ecommerce_filter_4_dialog) }
    }

    private fun getCustomLayoutDialog(layoutId: Int) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(layoutId)

        val lp = WindowManager.LayoutParams()
        if (dialog.window != null) {

            lp.copyFrom(dialog.window?.attributes)
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT

            // Size Spinner
            val sizeSpinner = dialog.sizeSpinner

            sizeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                    val item = adapterView.getItemAtPosition(i).toString()
                    Toast.makeText(applicationContext, "Selected Size : $item", Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(adapterView: AdapterView<*>) {

                }
            }

            sizeArrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sizeList)

            sizeArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            sizeSpinner.adapter = sizeArrayAdapter


            // Brand Spinner
            val brandSpinner = dialog.brandSpinner

            brandSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                    val item = adapterView.getItemAtPosition(i).toString()
                    Toast.makeText(applicationContext, "Selected Brand : $item", Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(adapterView: AdapterView<*>) {

                }
            }

            brandArrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, brandList)

            brandArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            brandSpinner.adapter = brandArrayAdapter


            // price range
            val priceRangeToValueTextView = dialog.priceRangeToValueTextView
            val priceRangeFromValueTextView = dialog.priceRangeFromValueTextView


            val maxValue = 100
            val seekBar = RangeSeekBar(0, maxValue, applicationContext)

            seekBar.selectedMinValue = 0
            seekBar.setAbsoluteMaxValue(100)
            val str = "$ $maxValue"
            priceRangeToValueTextView.text = str

            val linearLayout = dialog.findViewById<LinearLayout>(R.id.price_range_bar_container)
            linearLayout.addView(seekBar)

            seekBar.setOnRangeSeekBarChangeListener(object : RangeSeekBar.OnRangeSeekBarChangeListener<Int> {
                override fun onRangeSeekBarValuesChanged(bar: RangeSeekBar<*>, minValue: Int, maxValue: Int) {
                    Log.d("TEAMPS", "initUI: $minValue : $maxValue")

                    val minStr = "$ $minValue"
                    val maxStr = "$ $maxValue"

                    priceRangeFromValueTextView.text = minStr
                    priceRangeToValueTextView.text = maxStr
                }
            })

            // Button
            val filterButton = dialog.findViewById<Button>(R.id.filterButton)
            val resetButton = dialog.findViewById<Button>(R.id.resetButton)

            filterButton.setOnClickListener {
                Toast.makeText(applicationContext, "Clicked Filter.", Toast.LENGTH_SHORT).show()
                dialog.cancel()
            }

            resetButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Reset.", Toast.LENGTH_SHORT).show() }


            dialog.show()

            dialog.window?.attributes = lp
        }
    }

    private fun getBrandList(): List<String> {
        val brandList = ArrayList<String>()

        brandList.add("ALL")
        brandList.add("Gucci")
        brandList.add("Louis Vuitton")
        brandList.add("Dolce & Gabbana")
        brandList.add("Christian Dior")
        brandList.add("Yves Saint Laurent")
        brandList.add("Chanel")
        brandList.add("Fashion Nova")

        return brandList
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Filter 4"

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
