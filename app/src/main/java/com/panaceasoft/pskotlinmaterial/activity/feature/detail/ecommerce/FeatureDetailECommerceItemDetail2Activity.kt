package com.panaceasoft.pskotlinmaterial.activity.feature.detail.ecommerce

import android.graphics.Paint
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.`object`.UserReview
import com.panaceasoft.pskotlinmaterial.adapter.feature.detail.ecommerce.FeatureDetailECommerceItemDetail2PagerAdapter
import com.panaceasoft.pskotlinmaterial.adapter.feature.detail.ecommerce.FeatureDetailECommerceItemDetail2ReviewAdapter
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.ShopItemRepository
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.UserReviewRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_detail_ecommerce_item_detail_2_activity.*

class FeatureDetailECommerceItemDetail2Activity : AppCompatActivity() {

    // data variables
    private lateinit var shopItem: ShopItem
    private lateinit var userReviewList: List<UserReview>
    private var dotsCount: Int = 0

    private var size1Status: Boolean = false
    private var size2Status: Boolean = false
    private var size3Status: Boolean = false
    private var size4Status: Boolean = false
    private var size5Status: Boolean = false

    private var color1Status: Boolean = true
    private var color2Status: Boolean = false
    private var color3Status: Boolean = false
    private var color4Status: Boolean = false
    private var color5Status: Boolean = false
    private var color6Status: Boolean = false
    private var color7Status: Boolean = false

    // ui variables
    private lateinit var FeatureDetailECommerceItemDetail2PagerAdapter: FeatureDetailECommerceItemDetail2PagerAdapter
    private lateinit var adapter: FeatureDetailECommerceItemDetail2ReviewAdapter
    private lateinit var dots: Array<ImageView?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_detail_ecommerce_item_detail_2_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else if (item.itemId == R.id.action_fav) {
            Toast.makeText(this, "Clicked Favourite.", Toast.LENGTH_SHORT).show()
        } else if (item.itemId == R.id.action_basket) {
            Toast.makeText(this, "Clicked Basket.", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_fav_basket, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun initData() {

        // get shopItem detail
        shopItem = ShopItemRepository.womenShopItem

        FeatureDetailECommerceItemDetail2PagerAdapter = FeatureDetailECommerceItemDetail2PagerAdapter(this, shopItem)

        // get place list
        userReviewList = UserReviewRepository.userReviewList

    }

    private fun initUI() {

        initToolbar()

        setDefaultCircleImage(color1BgImageView, R.color.md_white_1000)
        setDefaultCircleImage(color2BgImageView, R.color.md_grey_400)
        setDefaultCircleImage(color3BgImageView, R.color.md_yellow_400)
        setDefaultCircleImage(color4BgImageView, R.color.md_green_500)
        setDefaultCircleImage(color5BgImageView, R.color.md_green_900)
        setDefaultCircleImage(color6BgImageView, R.color.md_blue_500)
        setDefaultCircleImage(color7BgImageView, R.color.md_black_1000)

        setDefaultCircleImage(size1BgImageView, R.color.md_grey_400)
        setDefaultCircleImage(size2BgImageView, R.color.md_grey_400)
        setDefaultCircleImage(size3BgImageView, R.color.md_grey_400)
        setDefaultCircleImage(size4BgImageView, R.color.md_grey_400)
        setDefaultCircleImage(size5BgImageView, R.color.md_grey_400)


        // Set Color Default
        color1ImageView.setImageResource(R.drawable.baseline_select_with_check_transparent_24)
        color1Status = true


        // Set Size Default
        setSelectUnSelectSizeFilter(size3BgImageView, R.color.colorPrimary, size3TextView, R.color.md_white_1000)
        size3Status = true


        // get list adapter
        adapter = FeatureDetailECommerceItemDetail2ReviewAdapter(userReviewList)

        // get recycler view
        val mLayoutManager = LinearLayoutManager(applicationContext)
        reviewRecyclerView.layoutManager = mLayoutManager
        reviewRecyclerView.itemAnimator = DefaultItemAnimator()
        reviewRecyclerView.isNestedScrollingEnabled = false

    }

    private fun setDefaultCircleImage(imageView: ImageView?, color: Int) {
        Utils.setCircleImageToImageView(applicationContext, imageView!!, R.drawable.white_background, color, 10, R.color.colorLine)
    }

    private fun setSelectUnSelectSizeFilter(imageView: ImageView, bgColor: Int, textView: TextView, color: Int) {
        imageView.setColorFilter(ContextCompat.getColor(this,bgColor), PorterDuff.Mode.SRC_IN)
        textView.setTextColor(ContextCompat.getColor(this,color))
    }

    private fun initDataBindings() {

        imageViewPager.adapter = FeatureDetailECommerceItemDetail2PagerAdapter
        setupSliderPagination()

        descTextView.text = shopItem.description
        nameTextView.text = shopItem.name
        reviewCountTextView.text = shopItem.ratingCount
        itemRatingBar.rating = java.lang.Float.parseFloat(shopItem.totalRating)

        val priceStr = "$ " + shopItem.price
        val originalPriceStr = "$ " + shopItem.originalPrice
        priceTextView.text = priceStr
        originalPriceTextView.text = originalPriceStr
        originalPriceTextView.paintFlags = originalPriceTextView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

        // bind adapter to recycler
        reviewRecyclerView.adapter = adapter
    }

    private fun initActions() {
        imageViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {


                setupSliderPagination()

                for (i in 0 until dotsCount) {
                    dots[i]?.setImageDrawable(ContextCompat.getDrawable(this@FeatureDetailECommerceItemDetail2Activity,R.drawable.nonselecteditem_dot))
                }

                dots[position]?.setImageDrawable(ContextCompat.getDrawable(this@FeatureDetailECommerceItemDetail2Activity,R.drawable.selecteditem_dot))
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })


        //region Size
        size1TextView.setOnClickListener {
            if (size1Status) {
                setSelectUnSelectSizeFilter(size1BgImageView, R.color.md_grey_400, size1TextView, R.color.md_grey_800)
                size1Status = false
            } else {
                setSelectUnSelectSizeFilter(size1BgImageView, R.color.colorPrimary, size1TextView, R.color.md_white_1000)
                size1Status = true
            }

        }

        size2TextView.setOnClickListener {
            if (size2Status) {
                setSelectUnSelectSizeFilter(size2BgImageView, R.color.md_grey_400, size2TextView, R.color.md_grey_800)
                size2Status = false
            } else {
                setSelectUnSelectSizeFilter(size2BgImageView, R.color.colorPrimary, size2TextView, R.color.md_white_1000)
                size2Status = true
            }

        }

        size3TextView.setOnClickListener {
            if (size3Status) {
                setSelectUnSelectSizeFilter(size3BgImageView, R.color.md_grey_400, size3TextView, R.color.md_grey_800)
                size3Status = false
            } else {
                setSelectUnSelectSizeFilter(size3BgImageView, R.color.colorPrimary, size3TextView, R.color.md_white_1000)
                size3Status = true
            }

        }

        size4TextView.setOnClickListener {
            if (size4Status) {
                setSelectUnSelectSizeFilter(size4BgImageView, R.color.md_grey_400, size4TextView, R.color.md_grey_800)
                size4Status = false
            } else {
                setSelectUnSelectSizeFilter(size4BgImageView, R.color.colorPrimary, size4TextView, R.color.md_white_1000)
                size4Status = true
            }

        }

        size5TextView.setOnClickListener {
            if (size5Status) {
                setSelectUnSelectSizeFilter(size5BgImageView, R.color.md_grey_400, size5TextView, R.color.md_grey_800)
                size5Status = false
            } else {
                setSelectUnSelectSizeFilter(size5BgImageView, R.color.colorPrimary, size5TextView, R.color.md_white_1000)
                size5Status = true
            }

        }

        //endregion

        //region Color

        color1ImageView.setOnClickListener {
            if (color1Status) {
                color1ImageView.setImageDrawable(null)
                color1Status = false
            } else {
                color1ImageView.setImageResource(R.drawable.baseline_select_with_check_transparent_24)
                color1Status = true
            }

        }

        color2ImageView.setOnClickListener {
            if (color2Status) {
                color2ImageView.setImageDrawable(null)
                color2Status = false
            } else {
                color2ImageView.setImageResource(R.drawable.baseline_select_with_check_transparent_24)
                color2Status = true
            }

        }

        color3ImageView.setOnClickListener {
            if (color3Status) {
                color3ImageView.setImageDrawable(null)
                color3Status = false
            } else {
                color3ImageView.setImageResource(R.drawable.baseline_select_with_check_transparent_24)
                color3Status = true
            }

        }

        color4ImageView.setOnClickListener {
            if (color4Status) {
                color4ImageView.setImageDrawable(null)
                color4Status = false
            } else {
                color4ImageView.setImageResource(R.drawable.baseline_select_with_check_transparent_24)
                color4Status = true
            }

        }

        color5ImageView.setOnClickListener {
            if (color5Status) {
                color5ImageView.setImageDrawable(null)
                color5Status = false
            } else {
                color5ImageView.setImageResource(R.drawable.baseline_select_with_check_transparent_24)
                color5Status = true
            }

        }

        color6ImageView.setOnClickListener {
            if (color6Status) {
                color6ImageView.setImageDrawable(null)
                color6Status = false
            } else {
                color6ImageView.setImageResource(R.drawable.baseline_select_with_check_transparent_24)
                color6Status = true
            }

        }

        color7ImageView.setOnClickListener {
            if (color7Status) {
                color7ImageView.setImageDrawable(null)
                color7Status = false
            } else {
                color7ImageView.setImageResource(R.drawable.baseline_select_with_check_transparent_24)
                color7Status = true
            }

        }

        //endregion

        adapter.setOnItemClickListener(object : FeatureDetailECommerceItemDetail2ReviewAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: UserReview, position: Int) {
                Toast.makeText(this@FeatureDetailECommerceItemDetail2Activity, "Selected : " + obj.userName, Toast.LENGTH_LONG).show()
            }
        })

        FeatureDetailECommerceItemDetail2PagerAdapter.setOnItemClickListener(object : FeatureDetailECommerceItemDetail2PagerAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(this@FeatureDetailECommerceItemDetail2Activity, "Selected : " + obj.imageList.get(position).imageName, Toast.LENGTH_SHORT).show()
            }
        })

        viewAllCommentTextView.setOnClickListener { Toast.makeText(this, "Clicked View All Reviews.", Toast.LENGTH_SHORT).show() }
        addToBasketButton.setOnClickListener { Toast.makeText(this, "Clicked add to basket..", Toast.LENGTH_SHORT).show() }
        shareImageView.setOnClickListener { Toast.makeText(this, "Clicked Share.", Toast.LENGTH_SHORT).show() }
        shopImageView.setOnClickListener { Toast.makeText(this, "Clicked Shop.", Toast.LENGTH_SHORT).show() }
    }

    fun setupSliderPagination() {

        dotsCount = FeatureDetailECommerceItemDetail2PagerAdapter.count

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
                toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this,R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Item Detail 2"

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
