package com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.gallery

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.adapter.application.ecommerce.gallery.AppECommerceGallery2PagerAdapter
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.ShopItemRepository
import kotlinx.android.synthetic.main.app_ecommerce_gallery_2_activity.*

class AppECommerceGallery2Activity : AppCompatActivity() {


    private lateinit var pagerAdapter: AppECommerceGallery2PagerAdapter
    private lateinit var shopItemList: List<ShopItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_ecommerce_gallery_2_activity)

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
        pagerAdapter = AppECommerceGallery2PagerAdapter(this, shopItemList)
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


        pagerAdapter.setOnItemClickListener(object : AppECommerceGallery2PagerAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(applicationContext, "Clicked : " + obj.name, Toast.LENGTH_SHORT).show()
            }
        })

    }

    //endregion
}