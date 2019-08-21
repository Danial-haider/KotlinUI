package com.panaceasoft.pskotlinmaterial.activity.feature.chat.general

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ChatDetailsVO
import com.panaceasoft.pskotlinmaterial.adapter.feature.chat.general.FeatureChatGeneralChat2Adapter
import com.panaceasoft.pskotlinmaterial.repository.general.GeneralChatDetailsListRepository
import kotlinx.android.synthetic.main.feature_chat_general_chat2_activity.*

class FeatureChatGeneralChat2Activity : AppCompatActivity() {

    internal lateinit var chatDetailsList: List<ChatDetailsVO>
    internal lateinit var chatDetailsAdapter: FeatureChatGeneralChat2Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_chat_general_chat2_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_call, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initData() {
        chatDetailsList = GeneralChatDetailsListRepository.generalChatDetailsList
    }

    private fun initUI() {
        initToolbar()

        //get list adapter
        chatDetailsAdapter = FeatureChatGeneralChat2Adapter(chatDetailsList)

        val mLayoutManger = LinearLayoutManager(applicationContext)
        rv_chat_details.layoutManager = mLayoutManger

        rv_chat_details.adapter = chatDetailsAdapter

    }

    private fun initDataBindings() {

    }

    private fun initActions() {

    }

    //region Init Toolbar
    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "John Cena"

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
