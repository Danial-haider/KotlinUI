package com.panaceasoft.pskotlinmaterial.activity.application.directory.profile

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.UserHistory
import com.panaceasoft.pskotlinmaterial.adapter.application.directory.profile.AppDirectoryProfile1Adapter
import com.panaceasoft.pskotlinmaterial.repository.directory.UserHistoryRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_directory_profile_1_activity.*
import java.util.*

class AppDirectoryProfile1Activity : AppCompatActivity() {

    // data and adapter
    lateinit var historyArrayList: ArrayList<UserHistory>
    internal lateinit var adapter: AppDirectoryProfile1Adapter



    //region override functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_directory_profile_1_activity)

        initData()

        initUI()

        initDataBinding()

        initActions()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_edit, menu)
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
        historyArrayList = UserHistoryRepository.historyList
    }

    private fun initUI() {
        initToolbar()

        // get list adapter
        adapter = AppDirectoryProfile1Adapter(historyArrayList)

        // get recycler view
        val mLayoutManager = LinearLayoutManager(applicationContext)
        profile1RecyclerView.layoutManager = mLayoutManager
        profile1RecyclerView.itemAnimator = DefaultItemAnimator()

        profile1RecyclerView.isFocusable = false

        val profileImageView = findViewById<ImageView>(R.id.profileImageView)
        val id = R.drawable.profile1
        Utils.setCircleImageToImageView(applicationContext, profileImageView, id, 20, R.color.md_white_1000)

    }

    private fun initDataBinding() {
        profile1RecyclerView.adapter = adapter
    }

    private fun initActions() {
        viewAllTextView.setOnClickListener { Toast.makeText(applicationContext, "Click View All", Toast.LENGTH_SHORT).show() }

        adapter.setOnItemClickListener(object : AppDirectoryProfile1Adapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: UserHistory, position: Int) {
                Toast.makeText(applicationContext, "Selected " + obj.placeName, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Profile 1"

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
