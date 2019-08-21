package com.panaceasoft.pskotlinmaterial.activity.feature.profile.ecommerce

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.adapter.feature.profile.ecommerce.FeatureProfileECommerceProfile3Adapter
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.ShopItemRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_profile_ecommerce_profile_3_activity.*
import java.util.*

class FeatureProfileECommerceProfile3Activity : AppCompatActivity() {

    private lateinit var itemArrayList: ArrayList<ShopItem>
    private lateinit var mAdapter: FeatureProfileECommerceProfile3Adapter
    internal var numberOfColumns = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_profile_ecommerce_profile_3_activity)

        initData()

        initUI()

        initDataBindings()

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
        itemArrayList = ShopItemRepository.kidShopItemList
    }


    private fun initUI() {
        initToolbar()

        val shopImageVIew = findViewById<ImageView>(R.id.shopImageVIew)
        val id = R.drawable.shop_info_1
        Utils.setImageToImageView(applicationContext, shopImageVIew, id)

        mAdapter = FeatureProfileECommerceProfile3Adapter(itemArrayList)

        // get RecyclerView and bind
        recyclerView.layoutManager = GridLayoutManager(this, numberOfColumns)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.isNestedScrollingEnabled = false


    }

    private fun initDataBindings() {
        // get data and adapter
        recyclerView.adapter = mAdapter
    }

    private fun initActions() {
        mAdapter.setOnItemClickListener(object : FeatureProfileECommerceProfile3Adapter.OnItemClickListener {
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

        followButton.setOnClickListener {  Toast.makeText(this, "Clicked Follow.", Toast.LENGTH_SHORT).show() }
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Profile 3 (For Shop)"

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
