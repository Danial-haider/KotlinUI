package com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.ecommerce

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.home.NavigationIconClickListener
import com.panaceasoft.pskotlinmaterial.adapter.application.ecommerce.home.home5.ProductGridItemDecoration
import com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.ecommerce.FeatureDashboardECommerceDashboard5ItemAdapter
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.ShopItemRepository
import kotlinx.android.synthetic.main.feature_dashboard_ecommerce_dashboard_5_activity.*
import java.util.*

class FeatureDashboardECommerceDashboard5Activity : AppCompatActivity() {

    private lateinit var itemArrayList: ArrayList<ShopItem>
    private lateinit var mAdapter: FeatureDashboardECommerceDashboard5ItemAdapter

    //region override methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_dashboard_ecommerce_dashboard_5_activity)

        layoutInflater.inflate(R.layout.feature_dashboard_ecommerce_dashboard_5_activity, null)

        initData()

        initUI()

        initDataBinding()

        initActions()

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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //region Init Functions
    private fun initData() {
        itemArrayList = ShopItemRepository.menShopItemList

    }

    private fun initUI() {
        //        initToolbar();
        setUpToolbar()

        photoRecyclerView.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position % 3 == 2) 2 else 1
            }
        }
        photoRecyclerView.layoutManager = gridLayoutManager

        mAdapter = FeatureDashboardECommerceDashboard5ItemAdapter(itemArrayList)
        photoRecyclerView.adapter = mAdapter
        val largePadding = resources.getDimensionPixelSize(R.dimen.shr_staggered_product_grid_spacing_large)
        val smallPadding = resources.getDimensionPixelOffset(R.dimen.shr_staggered_product_grid_spacing_small)
        photoRecyclerView.addItemDecoration(ProductGridItemDecoration(largePadding, smallPadding))
    }

    private fun initDataBinding() {
        photoRecyclerView.adapter = mAdapter
    }

    private fun initActions() {
        mAdapter.setOnItemClickListener(object : FeatureDashboardECommerceDashboard5ItemAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(this@FeatureDashboardECommerceDashboard5Activity.applicationContext, "Selected : " + obj.name, Toast.LENGTH_LONG).show()
            }
        })
    }


    private fun setUpToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.app_bar)

        this.setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener(NavigationIconClickListener(this@FeatureDashboardECommerceDashboard5Activity, findViewById(R.id.something), AccelerateDecelerateInterpolator()))
    }
}
