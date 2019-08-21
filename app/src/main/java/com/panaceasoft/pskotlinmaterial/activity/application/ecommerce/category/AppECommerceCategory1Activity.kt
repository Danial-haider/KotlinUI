package com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.category

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopCategory
import com.panaceasoft.pskotlinmaterial.adapter.application.ecommerce.category.AppECommerceCategory1Adapter
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.ShopCategoryRepository
import kotlinx.android.synthetic.main.app_ecommerce_category_1_activity.*
import java.util.*

class AppECommerceCategory1Activity : AppCompatActivity() {

    private lateinit var itemArrayList: ArrayList<ShopCategory>
    private lateinit var mAdapter: AppECommerceCategory1Adapter
    internal var numberOfColumns = 1

    //region override methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_ecommerce_category_1_activity)

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

    //region Init Functions
    private fun initData() {
        itemArrayList = ShopCategoryRepository.shopCategoryList
    }

    private fun initUI() {
        initToolbar()

        mAdapter = AppECommerceCategory1Adapter(itemArrayList)

        // get RecyclerView and bind
        recyclerView.layoutManager = GridLayoutManager(this, numberOfColumns)
        recyclerView.itemAnimator = DefaultItemAnimator()

    }

    private fun initDataBinding() {
        recyclerView.adapter = mAdapter
    }

    private fun initActions() {
        mAdapter.setOnItemClickListener(object : AppECommerceCategory1Adapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: ShopCategory, position: Int) {
                Toast.makeText(this@AppECommerceCategory1Activity, "Selected : " + obj.name, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Category 1"

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
