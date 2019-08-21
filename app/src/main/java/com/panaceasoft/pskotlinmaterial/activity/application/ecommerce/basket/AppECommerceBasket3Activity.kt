package com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.basket

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Basket
import com.panaceasoft.pskotlinmaterial.adapter.application.ecommerce.basket.AppECommerceBasket3Adapter
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.BasketItemRepository
import kotlinx.android.synthetic.main.app_ecommerce_basket_3_activity.*

class AppECommerceBasket3Activity : AppCompatActivity() {

    // data and adapter
    internal lateinit var basketList: List<Basket>
    internal lateinit var adapter: AppECommerceBasket3Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_ecommerce_basket_3_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initData() {
        // get place list
        basketList = BasketItemRepository.busketItemList
    }

    private fun initUI() {
        initToolbar()

        // get list adapter
        adapter = AppECommerceBasket3Adapter(basketList)

        // get recycler view

        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
    }

    private fun initDataBindings() {
        // bind adapter to recycler
        recyclerView.adapter = adapter

        try {
            var total = 0
            for (i in basketList.indices) {
                val basket = basketList[i]
                total += Integer.parseInt(basket.price)
            }

            val totalCost = basketList[0].currency + " " + total.toString()
            totalPriceTextView.text = totalCost
        } catch (ignored: Exception) {
        }

    }

    private fun initActions() {
        adapter.setOnItemClickListener(object : AppECommerceBasket3Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: Basket, position: Int) {
                Toast.makeText(applicationContext, "Clicked " + obj.name, Toast.LENGTH_SHORT).show()
            }

            override fun onDeleteClick(view: View, obj: Basket, position: Int) {
                Toast.makeText(applicationContext, "Clicked Delete. ", Toast.LENGTH_SHORT).show()
            }

            override fun onPriceChange(currency: String, subTotal: Int) {
                val totalStr = "$currency $subTotal"
                totalPriceTextView.text = totalStr
            }
        })

        checkoutButton.setOnClickListener { Toast.makeText(this, "Clicked Checkout.", Toast.LENGTH_SHORT).show() }
    }

    //region Init Toolbar
    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Basket 3"

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
