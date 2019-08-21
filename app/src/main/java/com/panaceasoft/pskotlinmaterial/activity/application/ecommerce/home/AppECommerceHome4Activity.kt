package com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.home

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.viewpager.widget.ViewPager
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.adapter.application.ecommerce.home.home4.AppECommerceHome4PagerAdapter
import com.panaceasoft.pskotlinmaterial.fragment.application.ecommerce.home.AppECommerceHome4Fragment
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.ShopItemRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils
import com.panaceasoft.pskotlinmaterial.utils.common_adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.app_ecommerce_home_4_activity.*

class AppECommerceHome4Activity : AppCompatActivity() {

    private lateinit var pagerAdapter: AppECommerceHome4PagerAdapter
    private lateinit var dots: Array<ImageView?>
    private var dotsCount: Int = 0

    // data variables
    internal lateinit var shopItemList: List<ShopItem>


    //region Override Methods

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_ecommerce_home_4_activity)

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

        // get featured Item List
        shopItemList = ShopItemRepository.menShopItemList

        pagerAdapter = AppECommerceHome4PagerAdapter(this, shopItemList)

    }

    private fun initUI() {

        val toolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbar)
        toolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this,android.R.color.transparent))

        val viewPager = findViewById<ViewPager>(R.id.viewPager)

        val index = setupViewPager(viewPager)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {

            tabLayout.layoutDirection = View.LAYOUT_DIRECTION_LTR
            //https://stackoverflow.com/questions/37071342/how-to-create-rtl-viewpager/39977360
        } else {
            ViewCompat.setLayoutDirection(tabLayout, ViewCompat.LAYOUT_DIRECTION_LTR)
        }

        if (Utils.isRTL) {

            tabLayout.getTabAt(index - 1)?.select()
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        Utils.removeShiftMode(bottomNavigationView)

    }

    private fun initDataBinding() {

        imageViewPager.adapter = pagerAdapter

        setupSliderPagination()
    }

    private fun initActions() {

        imageViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {


                    setupSliderPagination()


                for (i in 0 until dotsCount) {
                    dots[i]?.setImageDrawable(ContextCompat.getDrawable(this@AppECommerceHome4Activity,R.drawable.nonselecteditem_dot))
                }

                dots[position]?.setImageDrawable(ContextCompat.getDrawable(this@AppECommerceHome4Activity,R.drawable.selecteditem_dot))
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        pagerAdapter.setOnItemClickListener(object : AppECommerceHome4PagerAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(this@AppECommerceHome4Activity.applicationContext, "Clicked : " + obj.imageName, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupViewPager(viewPager: ViewPager): Int {
        val adapter = ViewPagerAdapter(supportFragmentManager)

        val fragment1 = AppECommerceHome4Fragment()
        fragment1.setType("F")

        val fragment2 = AppECommerceHome4Fragment()
        fragment2.setType("M")

        val fragment3 = AppECommerceHome4Fragment()
        fragment3.setType("K")

        val fragment4 = AppECommerceHome4Fragment()
        fragment4.setType("M")

        val fragment5 = AppECommerceHome4Fragment()
        fragment5.setType("F")

        val fragment6 = AppECommerceHome4Fragment()
        fragment6.setType("M")

        if (Utils.isRTL) {
            adapter.addFragment(fragment6, "MEN")
            adapter.addFragment(fragment5, "WOMEN")
            adapter.addFragment(fragment4, "RECOMMENDED")
            adapter.addFragment(fragment3, "TRENDING")
            adapter.addFragment(fragment2, "BRANDS")
            adapter.addFragment(fragment1, "ALL")
        } else {
            adapter.addFragment(fragment1, "ALL")
            adapter.addFragment(fragment2, "BRANDS")
            adapter.addFragment(fragment3, "TRENDING")
            adapter.addFragment(fragment4, "RECOMMENDED")
            adapter.addFragment(fragment5, "WOMEN")
            adapter.addFragment(fragment6, "MEN")
        }
        viewPager.adapter = adapter

        return adapter.count
    }

    fun setupSliderPagination() {

        dotsCount = pagerAdapter.count

        if (dotsCount > 0) {

            dots = arrayOfNulls(dotsCount)


                if (viewPagerCountDots.childCount > 0) {
                    viewPagerCountDots.removeAllViewsInLayout()

            }

            for (i in 0 until dotsCount) {
                dots[i] = ImageView(this)
                dots[i]?.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.nonselecteditem_dot))

                val params = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )

                params.setMargins(4, 0, 4, 0)

                viewPagerCountDots.addView(dots[i], params)
            }

            dots[0]?.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.selecteditem_dot))

        }
    }

    //endregion
}
