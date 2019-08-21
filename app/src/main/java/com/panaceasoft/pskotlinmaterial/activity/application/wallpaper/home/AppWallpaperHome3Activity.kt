package com.panaceasoft.pskotlinmaterial.activity.application.wallpaper.home

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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.WallpaperCategory
import com.panaceasoft.pskotlinmaterial.`object`.WallpaperItem
import com.panaceasoft.pskotlinmaterial.adapter.application.wallpaper.home.home3.AppWallpaperHome3ItemAdapter
import com.panaceasoft.pskotlinmaterial.adapter.application.wallpaper.home.home3.AppWallpaperHome3PagerAdapter
import com.panaceasoft.pskotlinmaterial.repository.wallpaper.WallpaperCategoryRepository
import com.panaceasoft.pskotlinmaterial.repository.wallpaper.WallpaperItemRepository
import kotlinx.android.synthetic.main.app_wallpaper_home_3_activity.*

class AppWallpaperHome3Activity : AppCompatActivity() {

    // data and wallpaperHome2CategoryAdapter
    internal lateinit var itemArrayList: List<WallpaperItem>
    internal lateinit var categoryList: List<WallpaperCategory>
    internal lateinit var itemAdapter: AppWallpaperHome3ItemAdapter
    private lateinit var dots: Array<ImageView?>
    private var dotsCount: Int = 0


    private lateinit var appWallpaperHome3PagerAdapter: AppWallpaperHome3PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.app_wallpaper_home_3_activity)

        initData()

        initUI()

        initDataBinding()

        initActions()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_more, menu)
        return true
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

        // get data
        itemArrayList = WallpaperItemRepository.wallpaperItemList

        categoryList = WallpaperCategoryRepository.wallpaperCategoryList

        appWallpaperHome3PagerAdapter = AppWallpaperHome3PagerAdapter(this, categoryList)

    }

    private fun initUI() {

        initToolbar()

        // get item list wallpaperHome2CategoryAdapter
        itemAdapter = AppWallpaperHome3ItemAdapter(itemArrayList)

        // get Item recycler view
        val mLayoutManagerForItems = GridLayoutManager(applicationContext, 2)

        shopFeaturedItemRecyclerView2.layoutManager = mLayoutManagerForItems
        shopFeaturedItemRecyclerView2.itemAnimator = DefaultItemAnimator()
        shopFeaturedItemRecyclerView2.isNestedScrollingEnabled = false


    }

    private fun initDataBinding() {

        // bind items
        shopFeaturedItemRecyclerView2.adapter = itemAdapter

        imageViewPager.adapter = appWallpaperHome3PagerAdapter
        setupSliderPagination()

        val featureStr = "Top " + categoryList.size + " wallpaper of this weeks."
        featureLabelTextView.text = featureStr
    }

    private fun initActions() {

        itemAdapter.setOnItemClickListener(object : AppWallpaperHome3ItemAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: WallpaperItem, position: Int) {
                Toast.makeText(this@AppWallpaperHome3Activity, "Selected : " + obj.imageName, Toast.LENGTH_SHORT).show()
            }
        })

        itemViewAllTextView.setOnClickListener { Toast.makeText(applicationContext, "Clicked View All Wallpapers.", Toast.LENGTH_SHORT).show() }

        imageViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {


                setupSliderPagination()


                for (i in 0 until dotsCount) {
                    dots[i]?.setImageDrawable(ContextCompat.getDrawable(this@AppWallpaperHome3Activity,R.drawable.nonselecteditem_dot))
                }

                dots[position]?.setImageDrawable(ContextCompat.getDrawable(this@AppWallpaperHome3Activity,R.drawable.selecteditem_dot))
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        appWallpaperHome3PagerAdapter.setOnItemClickListener(object : AppWallpaperHome3PagerAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: WallpaperCategory, position: Int) {
                Toast.makeText(this@AppWallpaperHome3Activity, "Selected : " + obj.imageName, Toast.LENGTH_LONG).show()
            }
        })

    }

    fun setupSliderPagination() {

        dotsCount = appWallpaperHome3PagerAdapter.count

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

        toolbar.title = "Home 3"

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
