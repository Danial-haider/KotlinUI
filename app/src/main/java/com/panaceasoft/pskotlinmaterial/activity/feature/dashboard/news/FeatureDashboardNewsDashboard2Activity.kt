package com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.news

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
import com.panaceasoft.pskotlinmaterial.`object`.News
import com.panaceasoft.pskotlinmaterial.`object`.NewsCategory
import com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.news.FeatureDashboardNewsDashboard2CategoryAdapter
import com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.news.FeatureDashboardNewsDashboard2CoverFlowPagerAdapter
import com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.news.FeatureDashboardNewsDashboard2NewsAdapter
import com.panaceasoft.pskotlinmaterial.repository.news.NewsCategoryRepository
import com.panaceasoft.pskotlinmaterial.repository.news.NewsRepository
import kotlinx.android.synthetic.main.feature_dashboard_news_dashboard_2_activity.*

class FeatureDashboardNewsDashboard2Activity : AppCompatActivity() {

    private lateinit var appNewsHome2CoverFlowPagerAdapter: FeatureDashboardNewsDashboard2CoverFlowPagerAdapter
    private lateinit var dots: Array<ImageView?>
    private var dotsCount: Int = 0

    private lateinit var appNewsHome2CategoryAdapter: FeatureDashboardNewsDashboard2CategoryAdapter
    private lateinit var categoryList: List<NewsCategory>

    private lateinit var itemAdapter: FeatureDashboardNewsDashboard2NewsAdapter
    private lateinit var newsList: List<News>
    internal var noOfColumn = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_dashboard_news_dashboard_2_activity)

        initData()

        initUI()

        initDataBinding()

        initActions()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(this, "Clicked " + item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initData() {

        newsList = NewsRepository.newsList

        val editorPickedNewsList = NewsRepository.newsList

        appNewsHome2CoverFlowPagerAdapter = FeatureDashboardNewsDashboard2CoverFlowPagerAdapter(this, editorPickedNewsList)

        categoryList = NewsCategoryRepository.newsCategoryList

        appNewsHome2CategoryAdapter = FeatureDashboardNewsDashboard2CategoryAdapter(categoryList)
    }

    private fun initUI() {

        // Init Toolbar
        initToolbar()

        // get item list featuredAdapter
        itemAdapter = FeatureDashboardNewsDashboard2NewsAdapter(newsList)

        // get Item recycler view

        val mLayoutManagerForItems = GridLayoutManager(this, noOfColumn)

        recyclerView.layoutManager = mLayoutManagerForItems
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.isNestedScrollingEnabled = false

        // get featured recycler view
        val mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoryRecyclerView.layoutManager = mLayoutManager
        categoryRecyclerView.itemAnimator = DefaultItemAnimator()
        categoryRecyclerView.isNestedScrollingEnabled = false


    }

    private fun initDataBinding() {

        // bind items
        recyclerView.adapter = itemAdapter

        imageViewPager.adapter = appNewsHome2CoverFlowPagerAdapter

        setupSliderPagination()

        categoryRecyclerView.adapter = appNewsHome2CategoryAdapter

    }

    private fun initActions() {
        itemAdapter.setOnItemClickListener(object : FeatureDashboardNewsDashboard2NewsAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: News, position: Int) {
                Toast.makeText(this@FeatureDashboardNewsDashboard2Activity, "Clicked: " + obj.title, Toast.LENGTH_SHORT).show()
            }
        })

        imageViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {


                setupSliderPagination()


                for (i in 0 until dotsCount) {
                    dots[i]?.setImageDrawable(ContextCompat.getDrawable(this@FeatureDashboardNewsDashboard2Activity,R.drawable.nonselecteditem_dot))
                }

                dots[position]?.setImageDrawable(ContextCompat.getDrawable(this@FeatureDashboardNewsDashboard2Activity,R.drawable.selecteditem_dot))
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        appNewsHome2CategoryAdapter.setOnItemClickListener(object : FeatureDashboardNewsDashboard2CategoryAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: NewsCategory, position: Int) {
                Toast.makeText(this@FeatureDashboardNewsDashboard2Activity, "Selected : " + obj.category, Toast.LENGTH_SHORT).show()
            }
        })

        appNewsHome2CoverFlowPagerAdapter.setOnItemClickListener(object : FeatureDashboardNewsDashboard2CoverFlowPagerAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: News, position: Int) {
                Toast.makeText(this@FeatureDashboardNewsDashboard2Activity, "Selected : " + obj.title, Toast.LENGTH_SHORT).show()
            }
        })

        viewAllRecentButton.setOnClickListener { Toast.makeText(this, "Clicked View All Recent News.", Toast.LENGTH_SHORT).show() }
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "News Dashboard 2"

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

    fun setupSliderPagination() {

        dotsCount = appNewsHome2CoverFlowPagerAdapter.count

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
}
