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
import com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.finance.dashboard2.FeatureDashboardFinanceDashboard2Adapter
import com.panaceasoft.pskotlinmaterial.repository.finance.TransactionRepository
import kotlinx.android.synthetic.main.feature_dashboard_finance_dashboard_2_activity.*

class FeatureDashboardFinanceDashboard2Activity : AppCompatActivity() {

    private lateinit var financePersonalLogList: List<FinancePersonalLog>
    // ui lateinit variables
    private lateinit var adapter: FeatureDashboardFinanceDashboard2Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_dashboard_finance_dashboard_2_activity)

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
        adapter = FeatureDashboardFinanceDashboard2Adapter(financePersonalLogList)

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

        adapter.setOnItemClickListener(object : FeatureDashboardFinanceDashboard2Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: FinancePersonalLog, position: Int) {
                Toast.makeText(this@FeatureDashboardFinanceDashboard2Activity, "Selected : " + obj.title, Toast.LENGTH_LONG).show()
            }
        })

        pieChartConstraintLayout.setOnClickListener {  Toast.makeText(this, "Clicked PieChart.", Toast.LENGTH_SHORT).show() }
        shareConstraintLayout.setOnClickListener { Toast.makeText(this, "Clicked Export.", Toast.LENGTH_SHORT).show() }
        addConstraintLayout.setOnClickListener {  Toast.makeText(this, "Clicked Add Expense.", Toast.LENGTH_SHORT).show() }
        addExpenseConstraintLayout.setOnClickListener {  Toast.makeText(this, "Clicked Add Expense.", Toast.LENGTH_SHORT).show() }
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Finance Dashboard 2"

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
