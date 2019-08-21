package com.panaceasoft.pskotlinmaterial.activity.feature.detail.ecommerce

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.`object`.UserReview
import com.panaceasoft.pskotlinmaterial.adapter.feature.detail.ecommerce.FeatureDetailECommerceItemDetail5PagerAdapter
import com.panaceasoft.pskotlinmaterial.adapter.feature.detail.ecommerce.FeatureDetailECommerceItemDetail5ReviewAdapter
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.ShopItemRepository
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.UserReviewRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_detail_ecommerce_item_detail_5_activity.*

class FeatureDetailECommerceItemDetail5Activity : AppCompatActivity() {

    // data variables
    private lateinit var shopItem: ShopItem
    private lateinit var userReviewList: List<UserReview>
    private var dotsCount: Int = 0

    // ui variables
    private lateinit var appECommerceDetail5PagerAdapter: FeatureDetailECommerceItemDetail5PagerAdapter
    private lateinit var adapter: FeatureDetailECommerceItemDetail5ReviewAdapter
    private lateinit var dots: Array<ImageView?>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_detail_ecommerce_item_detail_5_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else if (item.itemId == R.id.action_share) {
            Toast.makeText(this, "Clicked Share.", Toast.LENGTH_SHORT).show()
        } else if (item.itemId == R.id.action_basket) {
            Toast.makeText(this, "Clicked Basket.", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_share_basket, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun initData() {

        // get shopItem detail
        shopItem = ShopItemRepository.womenShopItem

        appECommerceDetail5PagerAdapter = FeatureDetailECommerceItemDetail5PagerAdapter(this, shopItem)

        // get place list
        userReviewList = UserReviewRepository.userReviewList

    }

    private fun initUI() {

        initToolbar()

        // get list adapter
        adapter = FeatureDetailECommerceItemDetail5ReviewAdapter(userReviewList)

        // get recycler view

        val mLayoutManager = LinearLayoutManager(applicationContext)
        reviewRecyclerView.layoutManager = mLayoutManager
        reviewRecyclerView.itemAnimator = DefaultItemAnimator()
        reviewRecyclerView.isNestedScrollingEnabled = false

    }

    private fun initDataBindings() {

        imageViewPager.adapter = appECommerceDetail5PagerAdapter
        setupSliderPagination()

        nameTextView.text = shopItem.name

        val priceStr = "$ " + shopItem.price
        priceTextView.text = priceStr

        // bind adapter to recycler
        reviewRecyclerView.adapter = adapter

        val mainId = Utils.getDrawableInt(applicationContext, userReviewList[0].userImage)
        Utils.setCircleImageToImageView(applicationContext, sellerImageView, mainId, 0, 0)

    }

    private fun initActions() {
        imageViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {


                setupSliderPagination()


                for (i in 0 until dotsCount) {
                    dots[i]?.setImageDrawable(ContextCompat.getDrawable(this@FeatureDetailECommerceItemDetail5Activity,R.drawable.nonselecteditem_dot))
                }

                dots[position]?.setImageDrawable(ContextCompat.getDrawable(this@FeatureDetailECommerceItemDetail5Activity,R.drawable.selecteditem_dot))
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        adapter.setOnItemClickListener(object : FeatureDetailECommerceItemDetail5ReviewAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: UserReview, position: Int) {
                Toast.makeText(this@FeatureDetailECommerceItemDetail5Activity, "Selected : " + obj.userName, Toast.LENGTH_LONG).show()
            }
        })

        appECommerceDetail5PagerAdapter.setOnItemClickListener(object : FeatureDetailECommerceItemDetail5PagerAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(this@FeatureDetailECommerceItemDetail5Activity, "Selected : " + obj.imageList.get(position).imageName!!, Toast.LENGTH_SHORT).show()
            }
        })

        viewAllCommentsButton.setOnClickListener { Toast.makeText(this, "Clicked View All Comments.", Toast.LENGTH_SHORT).show() }
        buyNowButton.setOnClickListener { Toast.makeText(this, "Clicked buy now.", Toast.LENGTH_SHORT).show() }
        chatButton.setOnClickListener { Toast.makeText(this, "Clicked chat.", Toast.LENGTH_SHORT).show() }
        shareImageView.setOnClickListener { Toast.makeText(this, "Clicked Share.", Toast.LENGTH_SHORT).show() }

    }

    fun setupSliderPagination() {

        dotsCount = appECommerceDetail5PagerAdapter.count

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

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Item Detail 5"

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
}
