package com.panaceasoft.pskotlinmaterial.activity.feature.grid.ecommerce

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.adapter.feature.grid.ecommerce.FeatureGridECommerceItemGrid10Adapter
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.ShopItemRepository
import kotlinx.android.synthetic.main.feature_grid_ecommerce_item_grid_10_activity.*
import java.util.*

class FeatureGridECommerceItemGrid10Activity : AppCompatActivity() {

    private lateinit var itemArrayList: ArrayList<ShopItem>
    private lateinit var mAdapter: FeatureGridECommerceItemGrid10Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_grid_ecommerce_item_grid_10_activity)

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

        mAdapter = FeatureGridECommerceItemGrid10Adapter(itemArrayList)

        // get RecyclerView and bind

        val mLayoutManagerForItems = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        recyclerView.layoutManager = mLayoutManagerForItems
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.isNestedScrollingEnabled = false
    }

    private fun initDataBinding() {
        recyclerView.adapter = mAdapter
    }

    private fun initActions() {
        mAdapter.setOnItemClickListener(object : FeatureGridECommerceItemGrid10Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(this@FeatureGridECommerceItemGrid10Activity, "Selected : " + obj.name, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Item Grid 10"

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
