package com.panaceasoft.pskotlinmaterial.activity.feature.gallery.ecommerce

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.adapter.feature.gallery.ecommerce.FeatureGalleryECommerceGallery1PagerAdapter
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.ShopItemRepository
import kotlinx.android.synthetic.main.feature_gallery_ecommerce_gallery_1_activity.*

class FeatureGalleryECommerceGallery1Activity : AppCompatActivity() {

    private lateinit var pagerAdapter: FeatureGalleryECommerceGallery1PagerAdapter
    private lateinit var shopItemList: List<ShopItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_gallery_ecommerce_gallery_1_activity)

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


    //region Init Functions
    private fun initData() {
        shopItemList = ShopItemRepository.womenShopItemList
        pagerAdapter = FeatureGalleryECommerceGallery1PagerAdapter(this, shopItemList)
    }

    private fun initUI() {
        initToolbar()
        imageViewPager.setPadding(60, 0, 60, 0)
        imageViewPager.clipToPadding = false
        imageViewPager.pageMargin = 15
    }

    private fun initDataBinding() {
        imageViewPager.adapter = pagerAdapter

        val noStr = "1 / " + shopItemList.size
        imageNoTextView.text = noStr

        if (shopItemList.size > 0) {
            nameTextView.text = shopItemList[0].name
            val price = shopItemList[0].currency + " " + shopItemList[0].price
            priceTextView.text = price
        }
    }

    private fun initActions() {

        imageViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                val noStr = (position + 1).toString() + " / " + shopItemList.size
                imageNoTextView.text = noStr

                if (shopItemList.size > position) {
                    nameTextView.text = shopItemList[position].name
                    val price = shopItemList[position].currency + " " + shopItemList[position].price
                    priceTextView.text = price
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })


        pagerAdapter.setOnItemClickListener(object : FeatureGalleryECommerceGallery1PagerAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(applicationContext, "Clicked : " + obj.name, Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Gallery 1"

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
