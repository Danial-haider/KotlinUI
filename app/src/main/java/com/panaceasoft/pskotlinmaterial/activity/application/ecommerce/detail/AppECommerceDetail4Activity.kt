package com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.detail

import android.graphics.Paint
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.`object`.UserReview
import com.panaceasoft.pskotlinmaterial.adapter.application.ecommerce.detail.detail4.AppECommerceDetail4PagerAdapter
import com.panaceasoft.pskotlinmaterial.adapter.application.ecommerce.detail.detail4.AppECommerceDetail4ReviewAdapter
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.ShopItemRepository
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.UserReviewRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_ecommerce_detail_4_activity.*
import java.util.*

class AppECommerceDetail4Activity : AppCompatActivity() {

    // data variables
    private lateinit var shopItem: ShopItem
    private lateinit var userReviewList: List<UserReview>

    // ui lateinit variables
    private lateinit var appECommerceDetail4PagerAdapter: AppECommerceDetail4PagerAdapter
    private lateinit var adapter: AppECommerceDetail4ReviewAdapter

    internal lateinit var sizeList: List<String>
    internal lateinit var colorList: List<String>
    internal lateinit var sizeArrayAdapter: ArrayAdapter<String>
    internal lateinit var colorArrayAdapter: ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_ecommerce_detail_4_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else if (item.itemId == R.id.action_share) {
            Toast.makeText(this, "Clicked Share.", Toast.LENGTH_SHORT).show()
        } else if (item.itemId == R.id.action_basket) {
            Toast.makeText(this, "Clicked Basket.", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_share_basket, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun initData() {

        // get shopItem detail
        shopItem = ShopItemRepository.womenShopItem

        appECommerceDetail4PagerAdapter = AppECommerceDetail4PagerAdapter(this, shopItem)

        // get place list
        userReviewList = UserReviewRepository.userReviewList

        sizeList = getSizeList()
        colorList = getColorList()

    }

    private fun initUI() {

        initToolbar()

        // get list adapter
        adapter = AppECommerceDetail4ReviewAdapter(userReviewList)

        // get recycler view
        val mLayoutManager = LinearLayoutManager(applicationContext)
        reviewRecyclerView.layoutManager = mLayoutManager
        reviewRecyclerView.itemAnimator = DefaultItemAnimator()
        reviewRecyclerView.isNestedScrollingEnabled = false

        sizeArrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sizeList)

        sizeArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        sizeSpinner.adapter = sizeArrayAdapter

        colorArrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colorList)

        colorArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        colorSpinner.adapter = colorArrayAdapter


    }

    private fun initDataBindings() {

        addressTextView.text = shopItem.shop.shopAddress
        phoneTextView.text = shopItem.shop.shopPhone
        websiteTextView.text = shopItem.shop.shopWebsite
        emailTextView.text = shopItem.shop.shopEmail

        descTextView.text = shopItem.description
        reviewCountTextView.text = shopItem.ratingCount
        itemRatingBar.rating = java.lang.Float.parseFloat(shopItem.totalRating)

        val priceStr = "$ " + shopItem.price
        val originalPriceStr = "$ " + shopItem.originalPrice
        priceTextView.text = priceStr
        originalPriceTextView.text = originalPriceStr
        originalPriceTextView.paintFlags = originalPriceTextView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

        val id = Utils.getDrawableInt(this, shopItem.imageName)
        Utils.setImageToImageView(this, detailImageView, id)

        Utils.setImageToImageView(this, detailShadowImageView, R.drawable.black_top_bottom_alpha_70)

        collapsingToolbar.title = shopItem.shop.shopName

        // bind adapter to recycler
        reviewRecyclerView.adapter = adapter
    }


    private fun getSizeList(): List<String> {
        val sizeList = ArrayList<String>()

        sizeList.add("Please select size.")
        sizeList.add("Small ( S )")
        sizeList.add("Medium ( M )")
        sizeList.add("Large ( L )")
        sizeList.add("Extra Large ( XL )")

        return sizeList
    }

    private fun getColorList(): List<String> {
        val sizeList = ArrayList<String>()

        sizeList.add("Please select color.")
        sizeList.add("Green")
        sizeList.add("White")
        sizeList.add("Red")
        sizeList.add("Dark Grey")

        return sizeList
    }

    private fun initActions() {

        adapter.setOnItemClickListener(object : AppECommerceDetail4ReviewAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: UserReview, position: Int) {
                Toast.makeText(this@AppECommerceDetail4Activity, "Selected : " + obj.userName, Toast.LENGTH_LONG).show()
            }
        })

        appECommerceDetail4PagerAdapter.setOnItemClickListener(object : AppECommerceDetail4PagerAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(this@AppECommerceDetail4Activity, "Selected : " + obj.imageList.get(position).imageName, Toast.LENGTH_SHORT).show()
            }
        })
        writeReviewTextView.setOnClickListener { Toast.makeText(this, "Clicked Write Review.", Toast.LENGTH_SHORT).show() }
        viewAllReviewButton.setOnClickListener { Toast.makeText(this, "Clicked View All Reviews.", Toast.LENGTH_SHORT).show() }
        addToBasketButton.setOnClickListener { Toast.makeText(this, "Clicked add to basket..", Toast.LENGTH_SHORT).show() }

        sizeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                if (i != 0) {
                    val item = adapterView.getItemAtPosition(i).toString()
                    Toast.makeText(applicationContext, "Selected Size : $item", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {

            }
        }

        inquiryTextView.setOnClickListener { Toast.makeText(this, "Clicked Inquiry.", Toast.LENGTH_SHORT).show() }

        colorSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                if (i != 0) {
                    val item = adapterView.getItemAtPosition(i).toString()
                    Toast.makeText(applicationContext, "Selected Color : $item", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {

            }
        }

        favFloatingActionButton.setOnClickListener { Toast.makeText(this, "Clicked Favourite.", Toast.LENGTH_SHORT).show() }

        minusImageView.setOnClickListener {

            try {
                var value = Integer.parseInt(qtyEditText.text.toString())

                if (value > 0) {
                    value -= 1
                }

                qtyEditText.setText(value.toString())

            } catch (ignored: Exception) {
            }
        }

        plusImageView.setOnClickListener {

            try {
                var value = Integer.parseInt(qtyEditText.text.toString())

                value += 1

                qtyEditText.setText(value.toString())

            } catch (ignored: Exception) {
            }
        }

        phoneTextView.setOnClickListener { Toast.makeText(this, "Clicked phone.", Toast.LENGTH_SHORT).show() }
        emailTextView.setOnClickListener { Toast.makeText(this, "Clicked email.", Toast.LENGTH_SHORT).show() }
        websiteTextView.setOnClickListener { Toast.makeText(this, "Clicked website.", Toast.LENGTH_SHORT).show() }
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Detail 4"

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


        val collapsingToolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbar)

        if (Utils.isRTL) {
            collapsingToolbarLayout.collapsedTitleGravity = Gravity.END
            collapsingToolbarLayout.expandedTitleGravity = Gravity.END or Gravity.BOTTOM
        } else {
            collapsingToolbarLayout.collapsedTitleGravity = Gravity.START
            collapsingToolbarLayout.expandedTitleGravity = Gravity.START or Gravity.BOTTOM
        }

    }

}