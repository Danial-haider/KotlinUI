package com.panaceasoft.pskotlinmaterial.activity.feature.dialog.finance

import android.app.Dialog
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomappbar.BottomAppBar
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.FinancePersonalLog
import com.panaceasoft.pskotlinmaterial.adapter.application.finances.dialog.AppFinanceDialog1Adapter
import com.panaceasoft.pskotlinmaterial.adapter.feature.dialog.FeatureDialogFinanceDialog1Adapter
import com.panaceasoft.pskotlinmaterial.repository.finance.TransactionRepository
import kotlinx.android.synthetic.main.feature_dialog_finance_dialog_1_activity.*

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class FeatureDialogFinanceDialog1Activity : AppCompatActivity() {

    internal lateinit var dialog: Dialog
    internal lateinit var msgTextView: TextView
    internal lateinit var subTitleTextView: TextView
    internal lateinit var image: ImageView
    internal lateinit var letDoItButton: Button
    internal lateinit var skipButton: Button
    private lateinit var financePersonalLogList: List<FinancePersonalLog>
    private lateinit var adapter: FeatureDialogFinanceDialog1Adapter
    internal lateinit var bottomAppBar: BottomAppBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_dialog_finance_dialog_1_activity)

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
        getCustomLayoutDialog(R.layout.feature_dialog_finance_dialog_1_layout)

        // get list adapter
        adapter = FeatureDialogFinanceDialog1Adapter(financePersonalLogList)

        // get recycler view
        val mLayoutManager = LinearLayoutManager(applicationContext)
        reviewRecyclerView.layoutManager = mLayoutManager
        reviewRecyclerView.itemAnimator = DefaultItemAnimator()
        reviewRecyclerView.isNestedScrollingEnabled = false
        bottomAppBar = findViewById(R.id.bottomAppBar)


    }

    private fun initDataBindings() {

        // bind adapter to recycler
        reviewRecyclerView.adapter = adapter

    }

    private fun getCustomLayoutDialog(layoutId: Int) {
        dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(layoutId)

        subTitleTextView = dialog.findViewById(R.id.subTitleTextView)
        subTitleTextView.text = "Month Closing !"

        msgTextView = dialog.findViewById(R.id.messageTextView)
        msgTextView.text = "You got some balance to carry over to next month."

        image = dialog.findViewById(R.id.dialogImageView)
        image.setImageResource(R.drawable.finance_dialog_coins)

        letDoItButton = dialog.findViewById(R.id.letDoItButton)
        letDoItButton.text = "Let's do it "

        skipButton = dialog.findViewById(R.id.skipButton)

        if (dialog.window != null) {
            dialog.window.attributes = getLayoutParams(dialog)
        }

        dialog.show()
    }

    private fun initActions() {

        letDoItButton.setOnClickListener {
            dialog.cancel()
            Toast.makeText(applicationContext, "Clicked Let's Do It.", Toast.LENGTH_SHORT).show()
        }

        skipButton.setOnClickListener {
            dialog.cancel()
            Toast.makeText(applicationContext, "Clicked Skip.", Toast.LENGTH_SHORT).show()
        }

        adapter.setOnItemClickListener(object : AppFinanceDialog1Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: FinancePersonalLog, position: Int) {
                Toast.makeText(this@FeatureDialogFinanceDialog1Activity, "Selected : " + obj.title, Toast.LENGTH_LONG).show()
            }
        })
        floatingButtonForHome3.setOnClickListener { Toast.makeText(this@FeatureDialogFinanceDialog1Activity, "Clicked Floating Action Button", Toast.LENGTH_SHORT).show() }
        calendarImageView.setOnClickListener {  Toast.makeText(this@FeatureDialogFinanceDialog1Activity, "Clicked Calendar", Toast.LENGTH_SHORT).show() }
        catImageView.setOnClickListener {  Toast.makeText(this@FeatureDialogFinanceDialog1Activity, "Clicked Category", Toast.LENGTH_SHORT).show() }
        pieChargImageView.setOnClickListener {  Toast.makeText(this@FeatureDialogFinanceDialog1Activity, "Clicked PieCharge", Toast.LENGTH_SHORT).show() }
        shareImageView.setOnClickListener {  Toast.makeText(this@FeatureDialogFinanceDialog1Activity, "Clicked Share", Toast.LENGTH_SHORT).show() }

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

    private fun getLayoutParams(dialog: Dialog): WindowManager.LayoutParams {
        val layoutParams = WindowManager.LayoutParams()
        if (dialog.window != null) {
            layoutParams.copyFrom(dialog.window?.attributes)
        }
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT

        return layoutParams
    }
}
