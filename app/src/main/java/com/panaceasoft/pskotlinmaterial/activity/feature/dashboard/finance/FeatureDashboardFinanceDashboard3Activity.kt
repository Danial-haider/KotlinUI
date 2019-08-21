package com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.finance

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.FinancePersonalLog
import com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.finance.dashboard3.FeatureDashboardFinanceDashboard3Adapter
import com.panaceasoft.pskotlinmaterial.repository.finance.TransactionRepository
import kotlinx.android.synthetic.main.feature_dashboard_finance_dashboard_3_activity.*

class FeatureDashboardFinanceDashboard3Activity : AppCompatActivity() {

    private lateinit var financePersonalLogList: List<FinancePersonalLog>

    // ui variables
    private lateinit var adapter: FeatureDashboardFinanceDashboard3Adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_dashboard_finance_dashboard_3_activity)

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

        // get place list
        financePersonalLogList = TransactionRepository.transactionList

    }

    private fun initUI() {

        initToolbar()

        // get list adapter
        adapter = FeatureDashboardFinanceDashboard3Adapter(financePersonalLogList)

        // get recycler view

        val mLayoutManager = LinearLayoutManager(applicationContext)
        reviewRecyclerView.layoutManager = mLayoutManager
        reviewRecyclerView.itemAnimator = DefaultItemAnimator()
        reviewRecyclerView.isNestedScrollingEnabled = false
    }

    private fun initDataBindings() {

        // bind adapter to recycler
        reviewRecyclerView.adapter = adapter

    }

    private fun initActions() {
        adapter.setOnItemClickListener(object : FeatureDashboardFinanceDashboard3Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: FinancePersonalLog, position: Int) {
                Toast.makeText(this@FeatureDashboardFinanceDashboard3Activity, "Selected : " + obj.title, Toast.LENGTH_LONG).show()
            }
        })
        floatingButtonForHome3.setOnClickListener {  Toast.makeText(this@FeatureDashboardFinanceDashboard3Activity, "Clicked Floating Action Button", Toast.LENGTH_SHORT).show() }
        calendarImageView.setOnClickListener {Toast.makeText(this@FeatureDashboardFinanceDashboard3Activity, "Clicked Calendar", Toast.LENGTH_SHORT).show() }
        catImageView.setOnClickListener { Toast.makeText(this@FeatureDashboardFinanceDashboard3Activity, "Clicked Category", Toast.LENGTH_SHORT).show() }
        pieChargImageView.setOnClickListener {  Toast.makeText(this@FeatureDashboardFinanceDashboard3Activity, "Clicked PieCharge", Toast.LENGTH_SHORT).show() }
        shareImageView.setOnClickListener {  Toast.makeText(this@FeatureDashboardFinanceDashboard3Activity, "Clicked Share", Toast.LENGTH_SHORT).show() }

    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "January 2019"

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
