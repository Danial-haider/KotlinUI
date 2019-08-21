package com.panaceasoft.pskotlinmaterial.activity.feature.comment.general.entry

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
import com.panaceasoft.pskotlinmaterial.`object`.RatingItem
import com.panaceasoft.pskotlinmaterial.adapter.feature.comment.general.FeatureCommentGeneralEntry1Adapter
import com.panaceasoft.pskotlinmaterial.repository.rating.RatingRepository
import kotlinx.android.synthetic.main.feature_comment_general_entry_1_activity.*

class FeatureCommentGeneralEntry1Activity : AppCompatActivity() {

    // data and adapter
    internal lateinit var ratingItemList: List<RatingItem>
    internal lateinit var adapter: FeatureCommentGeneralEntry1Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_comment_general_entry_1_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


    private fun initData() {
        // get rating list
        ratingItemList = RatingRepository.ratingList
    }

    private fun initUI() {
        initToolbar()

        // get list adapter
        adapter = FeatureCommentGeneralEntry1Adapter(ratingItemList)

        // get recycler view
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
    }

    private fun initDataBindings() {
        // bind adapter to recycler
        recyclerView.adapter = adapter
    }

    private fun initActions() {
        adapter.setOnItemClickListener(object : FeatureCommentGeneralEntry1Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: RatingItem, position: Int) {
                Toast.makeText(applicationContext, "Selected " + obj.title, Toast.LENGTH_SHORT).show()
            }
        })
    }

    //region Init Toolbar
    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Comment Entry 1 (With List)"

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
