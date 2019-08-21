package com.panaceasoft.pskotlinmaterial.activity.application.finance.report

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.FinancePersonalLog
import com.panaceasoft.pskotlinmaterial.adapter.application.finances.report.AppFinanceReport1Adapter
import com.panaceasoft.pskotlinmaterial.repository.finance.TransactionRepository
import kotlinx.android.synthetic.main.app_finance_report_1_activity.*

class AppFinanceReport1Activity : AppCompatActivity() {

    private lateinit var financePersonalLogList: List<FinancePersonalLog>

    // ui variables
    private lateinit var adapter: AppFinanceReport1Adapter
    private var year = 2019
    private val count = 1

    internal var isUp = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_finance_report_1_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            val id = item.itemId
            if (id == R.id.calendar) {
                if (isUp) {
                    collapseDetailFunction()
                } else {
                    expandDetailFunction()
                }
                isUp = !isUp
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_calendar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun initData() {

        // get place list
        financePersonalLogList = TransactionRepository.transactionList

    }

    private fun initUI() {

        initToolbar()

        // get list adapter
        adapter = AppFinanceReport1Adapter(financePersonalLogList)

        // get recycler view

        val mLayoutManager = LinearLayoutManager(applicationContext)
        reviewRecyclerView.layoutManager = mLayoutManager
        reviewRecyclerView.itemAnimator = DefaultItemAnimator()
        reviewRecyclerView.isNestedScrollingEnabled = false
        yearTextView.text = year.toString()

    }

    private fun initDataBindings() {

        // bind adapter to recycler
        reviewRecyclerView.adapter = adapter
    }

    private fun initActions() {

        adapter.setOnItemClickListener(object : AppFinanceReport1Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: FinancePersonalLog, position: Int) {
                Toast.makeText(this@AppFinanceReport1Activity, "Selected : " + obj.title, Toast.LENGTH_LONG).show()
            }
        })

        rightArrowImageView.setOnClickListener {
            val numberCount1 = year - count
            yearTextView.text = numberCount1.toString()
            year = numberCount1
        }

        leftArrowImageView.setOnClickListener {
            val numberCount2 = year + count
            yearTextView.text = numberCount2.toString()
            year = numberCount2
        }

    }

    private fun initToolbar() {
        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Report 1"

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

    private fun expandDetailFunction() {
        expand(findViewById(R.id.addExpenseConstraintLayout))
    }

    private fun collapseDetailFunction() {
        collapse(findViewById(R.id.addExpenseConstraintLayout))
    }

    companion object {

        fun expand(v: View) {
            v.measure(ConstraintLayout.LayoutParams.MATCH_CONSTRAINT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
            val targetHeight: Int

            if (0 <= v.measuredHeight) {

                targetHeight = 10
            } else {
                targetHeight = v.measuredHeight
            }

            Log.d("TEAMPS", "expand: $targetHeight")

            v.layoutParams.height = 0
            v.visibility = View.VISIBLE
            val a = object : Animation() {
                override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
                    v.layoutParams.height = if (interpolatedTime == 1f)
                        ConstraintLayout.LayoutParams.WRAP_CONTENT
                    else
                        (targetHeight * interpolatedTime).toInt()
                    v.requestLayout()
                }

                override fun willChangeBounds(): Boolean {
                    return true
                }
            }

            Log.d("TEAMPS", "expand: " + v.context.resources.displayMetrics.density)
            a.duration = (targetHeight / v.context.resources.displayMetrics.density).toInt().toLong()
            v.startAnimation(a)
        }

        fun collapse(v: View) {
            val initialHeight = v.measuredHeight

            val a = object : Animation() {
                override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
                    if (interpolatedTime == 1f) {
                        v.visibility = View.GONE
                    } else {
                        v.layoutParams.height = initialHeight - (initialHeight * interpolatedTime).toInt()
                        v.requestLayout()
                    }
                }

                override fun willChangeBounds(): Boolean {
                    return true
                }
            }

            Log.d("TEAMPS", "collapse: " + initialHeight / v.context.resources.displayMetrics.density)
            // 1dp/ms
            a.duration = (initialHeight / v.context.resources.displayMetrics.density).toInt().toLong()
            v.startAnimation(a)
        }
    }
}
