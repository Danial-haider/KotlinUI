package com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.home

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.adapter.application.ecommerce.home.home2.AppECommerceHome2ItemAdapter
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.ShopItemRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils
import java.util.*

class AppECommerceHome2Activity : AppCompatActivity() {

    private lateinit var itemArrayList: ArrayList<ShopItem>
    private lateinit var mAdapter: AppECommerceHome2ItemAdapter
    private lateinit var recyclerView: RecyclerView
    internal var numberOfColumns = 2
    private lateinit var filterLayout: ConstraintLayout
    private val filterViewHeight = 50
    private var dyg = 0

    //region override methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_ecommerce_home_2_activity)

        initData()

        initUI()

        initDataBinding()

        initActions()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search_basket, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(applicationContext, item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    //endregion


    //region Init Functions

    private fun initData() {

        itemArrayList = ShopItemRepository.kidShopItemList

    }

    private fun initUI() {

        initToolbar()

        mAdapter = AppECommerceHome2ItemAdapter(itemArrayList, numberOfColumns)

        // Init Filter UI
        val cityCardView = findViewById<CardView>(R.id.cityFilterCardView)
        val categoryCardView = findViewById<CardView>(R.id.categoryFilterCardView)
        val sortCardView = findViewById<CardView>(R.id.sortCardView)

        cityCardView.setOnClickListener { Toast.makeText(this, "Clicked City Filter.", Toast.LENGTH_SHORT).show() }

        categoryCardView.setOnClickListener { Toast.makeText(this, "Clicked Category Filter.", Toast.LENGTH_SHORT).show() }

        sortCardView.setOnClickListener {  Toast.makeText(this, "Clicked Sort/Filter.", Toast.LENGTH_SHORT).show() }

        // get RecyclerView and bind
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, numberOfColumns)
        recyclerView.itemAnimator = DefaultItemAnimator()

        filterLayout = findViewById(R.id.filterConstraintLayout)
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 1) {

                    dyg -= dy

                    if (dyg < -filterViewHeight) {
                        dyg = -filterViewHeight
                    }

                    filterLayout.animate()
                            .translationY(Utils.dpToPx(applicationContext, dyg).toFloat())
                            .alpha(1f).setDuration(100).interpolator = DecelerateInterpolator()
                } else if (dy < 0) {

                    dyg -= dy

                    if (dyg > 0) {
                        dyg = 0
                    }

                    filterLayout.animate()
                            .translationY(dyg.toFloat())
                            .alpha(1f).setDuration(100).interpolator = DecelerateInterpolator()
                }
            }
        })

    }

    private fun initDataBinding() {
        // get data and adapter
        recyclerView.adapter = mAdapter
    }

    private fun initActions() {
        mAdapter.setOnItemClickListener(object : AppECommerceHome2ItemAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(applicationContext, "Clicked " + obj.name, Toast.LENGTH_SHORT).show()
            }

            override fun onAddToCartClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(applicationContext, "Clicked Add To Cart ", Toast.LENGTH_SHORT).show()
            }

            override fun onLikeClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(applicationContext, "Clicked Like ", Toast.LENGTH_SHORT).show()
            }

            override fun onMenuClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(applicationContext, "Clicked Menu ", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initToolbar() {

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Home 2"

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

    //endregion
}
