package com.panaceasoft.pskotlinmaterial.activity.feature.chat.general

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
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Chat
import com.panaceasoft.pskotlinmaterial.adapter.feature.chat.general.FeatureChatGeneralChat1Adapter
import com.panaceasoft.pskotlinmaterial.repository.general.GeneralChatListRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_chat_general_chat_1_activity.*

class FeatureChatGeneralChat1Activity : AppCompatActivity() {

    // data and adapter
    internal lateinit var chatList: List<Chat>
    internal lateinit var adapter: FeatureChatGeneralChat1Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_chat_general_chat_1_activity)

        initData()

        initUI()

        initDataBindings()

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

    private fun initData() {
        // get place list
        chatList = GeneralChatListRepository.generalChatList
    }

    private fun initUI() {


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        Utils.removeShiftMode(bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->


            Toast.makeText(applicationContext, "Clicked " + item.title, Toast.LENGTH_SHORT).show()

            false
        }

        initToolbar()

        // get list adapter
        adapter = FeatureChatGeneralChat1Adapter(chatList)

        val mLayoutManager = LinearLayoutManager(applicationContext)
        photoRecyclerView.layoutManager = mLayoutManager
        photoRecyclerView.itemAnimator = DefaultItemAnimator()


    }

    private fun initDataBindings() {
        // bind adapter to recycler
        photoRecyclerView.adapter = adapter
    }

    private fun initActions() {
        adapter.setOnItemClickListener(object : FeatureChatGeneralChat1Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: Chat, position: Int) {
                Toast.makeText(applicationContext, "Clicked " + obj.Name, Toast.LENGTH_SHORT).show()
            }

        })


    }

    //region Init Toolbar
    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Chat 1"

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
