package com.panaceasoft.pskotlinmaterial.activity.application.directory.profile

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.UserHistory
import com.panaceasoft.pskotlinmaterial.adapter.application.directory.profile.AppDirectoryProfile3Adapter
import com.panaceasoft.pskotlinmaterial.repository.directory.UserHistoryRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_directory_profile_3_activity.*
import java.util.*

class AppDirectoryProfile3Activity : AppCompatActivity() {

    private lateinit var historyArrayList: ArrayList<UserHistory>
    private lateinit var adapter: AppDirectoryProfile3Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_directory_profile_3_activity)

        initData()

        initUI()

        initDataBinding()

        initActions()
    }

    //region Init Functions
    private fun initData() {
        historyArrayList = UserHistoryRepository.historyList
    }

    private fun initUI() {


        // get list adapter
        adapter = AppDirectoryProfile3Adapter(historyArrayList)

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
        seeAllTextView.setOnClickListener { Toast.makeText(applicationContext, "Click View All", Toast.LENGTH_SHORT).show() }

        logoutTextView.setOnClickListener { Toast.makeText(applicationContext, "Click Logout", Toast.LENGTH_SHORT).show() }

        backImageView.setOnClickListener { finish() }

        adapter.setOnItemClickListener(object : AppDirectoryProfile3Adapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: UserHistory, position: Int) {
                Toast.makeText(applicationContext, "Selected " + obj.placeName, Toast.LENGTH_SHORT).show()
            }
        })
    }

    //endregion
}
