package com.panaceasoft.pskotlinmaterial.activity.feature.timeline.social

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
import com.panaceasoft.pskotlinmaterial.`object`.TimelineSocial
import com.panaceasoft.pskotlinmaterial.adapter.feature.timeline.social.FeatureTimelineSocialTimeline1Adapter
import com.panaceasoft.pskotlinmaterial.repository.social.TimelineSocialRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_timeline_social_timeline_1_activity.*

class FeatureTimelineSocialTimeline1Activity : AppCompatActivity() {

    private lateinit var timelineSocialList: List<TimelineSocial>

    // ui variables
    private lateinit var adapter: FeatureTimelineSocialTimeline1Adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_timeline_social_timeline_1_activity)

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
        timelineSocialList = TimelineSocialRepository.timelineSocialList

    }

    private fun initUI() {

        initToolbar()

        // get list adapter
        adapter = FeatureTimelineSocialTimeline1Adapter(timelineSocialList)

        // get recycler view

        val mLayoutManager = LinearLayoutManager(applicationContext)
        reviewRecyclerView.layoutManager = mLayoutManager
        reviewRecyclerView.itemAnimator = DefaultItemAnimator()
        reviewRecyclerView.isNestedScrollingEnabled = false

    }

    private fun initDataBindings() {

        // bind adapter to recycler
        reviewRecyclerView.adapter = adapter

        Utils.setCircleImageToImageView(this, userImageView, R.drawable.profile2, 5, R.color.md_blue_grey_400)
    }

    private fun initActions() {

        adapter.setOnItemClickListener(object : FeatureTimelineSocialTimeline1Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: TimelineSocial, position: Int) {
                Toast.makeText(this@FeatureTimelineSocialTimeline1Activity, "Selected : " + obj.name, Toast.LENGTH_LONG).show()
            }
        })

    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Timeline 1 (Social)"

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