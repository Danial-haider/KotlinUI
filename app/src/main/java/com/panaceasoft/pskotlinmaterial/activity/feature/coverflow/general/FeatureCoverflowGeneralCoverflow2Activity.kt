package com.panaceasoft.pskotlinmaterial.activity.feature.coverflow.general

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.adapter.feature.coverflow.general.FeatureCoverflowGeneralCoverflow2Adapter
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.ShopItemRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_coverflow_general_coverflow_2_activity.*

class FeatureCoverflowGeneralCoverflow2Activity : AppCompatActivity() {

    private lateinit var pagerAdapter: FeatureCoverflowGeneralCoverflow2Adapter
    private lateinit var shopItemList: List<ShopItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_coverflow_general_coverflow_2_activity)

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
        pagerAdapter = FeatureCoverflowGeneralCoverflow2Adapter(this, shopItemList)
    }

    private fun initUI() {

        imageViewPager.setPadding(60, 0, 60, 0)
        imageViewPager.clipToPadding = false
        imageViewPager.pageMargin = 15

    }

    private fun initDataBinding() {
        imageViewPager.adapter = pagerAdapter

        val noStr = "1 / " + shopItemList.size
        imageNoTextView.text = noStr

        Utils.setImageToImageView(this, bgImageView!!, R.drawable.coverflow_bg)
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


        pagerAdapter.setOnItemClickListener(object : FeatureCoverflowGeneralCoverflow2Adapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(applicationContext, "Clicked : " + obj.name, Toast.LENGTH_SHORT).show()
            }
        })

    }

    //endregion
}
