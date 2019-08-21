package com.panaceasoft.pskotlinmaterial.activity.application.finance.home

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
import com.panaceasoft.pskotlinmaterial.`object`.FinancePersonalLog
import com.panaceasoft.pskotlinmaterial.`object`.FinanceSummary
import com.panaceasoft.pskotlinmaterial.adapter.application.finances.home.AppFinanceHome1Adapter
import com.panaceasoft.pskotlinmaterial.adapter.application.finances.home.AppFinanceHome1PagerAdapter
import com.panaceasoft.pskotlinmaterial.repository.finance.TransactionRepository
import com.panaceasoft.pskotlinmaterial.repository.finance.TransactionSummaryRepository
import kotlinx.android.synthetic.main.app_finance_home_1_activity.*

class AppFinanceHome1Activity : AppCompatActivity() {

    private lateinit var financePersonalLogList: List<FinancePersonalLog>
    private var dotsCount: Int = 0

    // ui lateinit variables
    private lateinit var AppFinanceHome1PagerAdapter: AppFinanceHome1PagerAdapter
    private lateinit var adapter: AppFinanceHome1Adapter
    private lateinit var dots: Array<ImageView?>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_finance_home_1_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun initData() {

        // get shopItem detail
        val financeSummaryList = TransactionSummaryRepository.summaryList

        AppFinanceHome1PagerAdapter = AppFinanceHome1PagerAdapter(this, financeSummaryList!!)

        // get place list
        financePersonalLogList = TransactionRepository.transactionList

    }

    private fun initUI() {

        initToolbar()

        // get list adapter
        adapter = AppFinanceHome1Adapter(financePersonalLogList)

        // get recycler view
        val mLayoutManager = LinearLayoutManager(applicationContext)
        reviewRecyclerView.layoutManager = mLayoutManager
        reviewRecyclerView.itemAnimator = DefaultItemAnimator()
        reviewRecyclerView.isNestedScrollingEnabled = false

    }

    private fun initDataBindings() {

        imageViewPager.adapter = AppFinanceHome1PagerAdapter
        setupSliderPagination()

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
                    dots[i]?.setImageDrawable(ContextCompat.getDrawable(this@AppFinanceHome1Activity,R.drawable.nonselecteditem_dot))
                }

                dots[position]?.setImageDrawable(ContextCompat.getDrawable(this@AppFinanceHome1Activity,R.drawable.selecteditem_dot))
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })


        adapter.setOnItemClickListener(object : AppFinanceHome1Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: FinancePersonalLog, position: Int) {
                Toast.makeText(this@AppFinanceHome1Activity, "Selected : " + obj.title, Toast.LENGTH_LONG).show()
            }
        })

        AppFinanceHome1PagerAdapter.setOnItemClickListener(object : AppFinanceHome1PagerAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: FinanceSummary, position: Int) {
                Toast.makeText(this@AppFinanceHome1Activity, "Selected : " + obj.title, Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun setupSliderPagination() {

        dotsCount = AppFinanceHome1PagerAdapter.count

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

        toolbar.title = "Finance Home 1"

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