package com.panaceasoft.pskotlinmaterial.activity.feature.timeline.ecommerce

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.DeliveryStatus
import com.panaceasoft.pskotlinmaterial.adapter.feature.timeline.ecommerce.FeatureTimelineECommerceTimeline1Adapter
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.DeliveryStatusRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_timeline_ecommerce_timeline_1_activity.*

class FeatureTimelineECommerceTimeline1Activity : AppCompatActivity() {

    private lateinit var deliveryStatusList: List<DeliveryStatus>

    // ui variables
    private lateinit var adapter: FeatureTimelineECommerceTimeline1Adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_timeline_ecommerce_timeline_1_activity)

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


    private fun initData() {

        // get place list
        deliveryStatusList = DeliveryStatusRepository.deliveryStatusList

    }

    private fun initUI() {

        initToolbar()

        // get list adapter
        adapter = FeatureTimelineECommerceTimeline1Adapter(deliveryStatusList)

        // get recycler view
        val mLayoutManager = LinearLayoutManager(applicationContext)
        reviewRecyclerView.layoutManager = mLayoutManager
        reviewRecyclerView.itemAnimator = DefaultItemAnimator()
        reviewRecyclerView.isNestedScrollingEnabled = false

    }

    private fun initDataBindings() {

        // bind adapter to recycler
        reviewRecyclerView.adapter = adapter

        Utils.setImageToImageView(this, bgImageView!!, R.drawable.timeline_1_bg)
    }

    private fun initActions() {

        adapter.setOnItemClickListener(object : FeatureTimelineECommerceTimeline1Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: DeliveryStatus, position: Int) {
                Toast.makeText(this@FeatureTimelineECommerceTimeline1Activity, "Selected : " + obj.remark, Toast.LENGTH_LONG).show()
            }
        })

    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Timeline 1 ( Delivery Status)"

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

