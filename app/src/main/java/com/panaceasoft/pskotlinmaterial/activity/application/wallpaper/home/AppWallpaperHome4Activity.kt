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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.WallpaperCategory
import com.panaceasoft.pskotlinmaterial.`object`.WallpaperItem
import com.panaceasoft.pskotlinmaterial.adapter.application.wallpaper.home.home4.AppWallpaperHome4CategoryAdapter
import com.panaceasoft.pskotlinmaterial.adapter.application.wallpaper.home.home4.AppWallpaperHome4ItemAdapter
import com.panaceasoft.pskotlinmaterial.adapter.application.wallpaper.home.home4.AppWallpaperHome4PagerAdapter
import com.panaceasoft.pskotlinmaterial.repository.wallpaper.WallpaperCategoryRepository
import com.panaceasoft.pskotlinmaterial.repository.wallpaper.WallpaperItemRepository
import kotlinx.android.synthetic.main.app_wallpaper_home_4_activity.*

class AppWallpaperHome4Activity : AppCompatActivity() {

    // data and wallpaperHome2CategoryAdapter
    private lateinit var itemArrayList: List<WallpaperItem>
    private lateinit var categoryList: List<WallpaperCategory>

    private lateinit var wallpaperHome4CategoryAdapter: AppWallpaperHome4CategoryAdapter
    private lateinit var itemAdapter: AppWallpaperHome4ItemAdapter

    private lateinit var dots: Array<ImageView?>
    private var dotsCount: Int = 0

    private lateinit var appWallpaperHome4PagerAdapter: AppWallpaperHome4PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.app_wallpaper_home_4_activity)

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

        appWallpaperHome4PagerAdapter = AppWallpaperHome4PagerAdapter(this, categoryList)

        wallpaperHome4CategoryAdapter = AppWallpaperHome4CategoryAdapter(categoryList)

    }

    private fun initUI() {

        initToolbar()

        // get item list wallpaperHome2CategoryAdapter
        itemAdapter = AppWallpaperHome4ItemAdapter(itemArrayList)

        // get Item recycler view
        val mLayoutManagerForItems = GridLayoutManager(applicationContext, 2)

        photoRecyclerView.layoutManager = mLayoutManagerForItems
        photoRecyclerView.itemAnimator = DefaultItemAnimator()
        photoRecyclerView.isNestedScrollingEnabled = false

        val mLayoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        categoryRecyclerView.layoutManager = mLayoutManager
        categoryRecyclerView.itemAnimator = DefaultItemAnimator()
        categoryRecyclerView.isNestedScrollingEnabled = false

    }

    private fun initDataBinding() {

        // bind items
        photoRecyclerView.adapter = itemAdapter

        imageViewPager.adapter = appWallpaperHome4PagerAdapter
        setupSliderPagination()

        val featureStr = "Top " + categoryList.size + " wallpaper of this weeks."
        featureLabelTextView.text = featureStr

        categoryRecyclerView.adapter = wallpaperHome4CategoryAdapter
    }

    private fun initActions() {

        wallpaperHome4CategoryAdapter.setOnItemClickListener(object : AppWallpaperHome4CategoryAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: WallpaperCategory, position: Int) {
                Toast.makeText(applicationContext, "Clicked " + obj.name, Toast.LENGTH_SHORT).show()
            }
        })

        itemAdapter.setOnItemClickListener(object : AppWallpaperHome4ItemAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: WallpaperItem, position: Int) {
                Toast.makeText(this@AppWallpaperHome4Activity, "Selected : " + obj.imageName, Toast.LENGTH_SHORT).show()
            }
        })

        itemViewAllTextView.setOnClickListener { Toast.makeText(applicationContext, "Clicked View All Wallpapers.", Toast.LENGTH_SHORT).show() }

        imageViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {


                setupSliderPagination()


                for (i in 0 until dotsCount) {
                    dots[i]?.setImageDrawable(ContextCompat.getDrawable(this@AppWallpaperHome4Activity,R.drawable.nonselecteditem_dot))
                }

                dots[position]?.setImageDrawable(ContextCompat.getDrawable(this@AppWallpaperHome4Activity,R.drawable.selecteditem_dot))
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        appWallpaperHome4PagerAdapter.setOnItemClickListener(object : AppWallpaperHome4PagerAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: WallpaperCategory, position: Int) {
                Toast.makeText(this@AppWallpaperHome4Activity, "Selected : " + obj.imageName, Toast.LENGTH_LONG).show()
            }
        })

    }

    fun setupSliderPagination() {

        dotsCount = appWallpaperHome4PagerAdapter.count

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

        toolbar.title = "Home 4"

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
