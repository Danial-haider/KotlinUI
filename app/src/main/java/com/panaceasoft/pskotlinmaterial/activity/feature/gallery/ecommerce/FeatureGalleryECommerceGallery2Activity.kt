package com.panaceasoft.pskotlinmaterial.activity.feature.gallery.ecommerce

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.widget.Toast

import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.adapter.feature.gallery.ecommerce.FeatureGalleryECommerceGallery2PagerAdapter
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.ShopItemRepository
import kotlinx.android.synthetic.main.feature_gallery_ecommerce_gallery_2_activity.*

class FeatureGalleryECommerceGallery2Activity : AppCompatActivity() {

    private lateinit var pagerAdapter: FeatureGalleryECommerceGallery2PagerAdapter
    private lateinit var shopItemList: List<ShopItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_gallery_ecommerce_gallery_2_activity)

        initData()

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
        pagerAdapter = FeatureGalleryECommerceGallery2PagerAdapter(this, shopItemList)
    }

    private fun initDataBinding() {
        imageViewPager.adapter = pagerAdapter

        val noStr = "1 / " + shopItemList.size
        imageNoTextView.text = noStr
    }

    private fun initActions() {

        imageViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                val noStr = (position + 1).toString() + " / " + shopItemList.size
                imageNoTextView.text = noStr

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })


        pagerAdapter.setOnItemClickListener(object : FeatureGalleryECommerceGallery2PagerAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(applicationContext, "Clicked : " + obj.name, Toast.LENGTH_SHORT).show()
            }
        })

    }

    //endregion
}
