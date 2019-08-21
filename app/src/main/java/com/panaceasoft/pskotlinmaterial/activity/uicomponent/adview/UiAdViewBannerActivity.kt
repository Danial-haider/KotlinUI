package com.panaceasoft.pskotlinmaterial.activity.uicomponent.adview

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
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Country
import com.panaceasoft.pskotlinmaterial.adapter.uicomponent.adview.UiAdViewCountryList1Adapter
import com.panaceasoft.pskotlinmaterial.repository.directory.CountryRepository
import kotlinx.android.synthetic.main.ui_adview_banner_activity.*
import java.util.*

class UiAdViewBannerActivity : AppCompatActivity() {

    // data and adapter
    internal lateinit var countryArrayList: ArrayList<Country>
    internal lateinit var adapter: UiAdViewCountryList1Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_adview_banner_activity)
        initData()

        initUI()

        initDataBindings()

        initActions()

        val adRequest = AdRequest.Builder().build()

        adView.adListener = object : AdListener() {
            override fun onAdLoaded() {
                Toast.makeText(applicationContext, "Ad is loaded!", Toast.LENGTH_SHORT).show()
            }

            override fun onAdClosed() {
                Toast.makeText(applicationContext, "Ad is closed!", Toast.LENGTH_SHORT).show()
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                Toast.makeText(applicationContext, "Ad failed to load! error code: $errorCode", Toast.LENGTH_SHORT).show()
            }

            override fun onAdLeftApplication() {
                Toast.makeText(applicationContext, "Ad left application!", Toast.LENGTH_SHORT).show()
            }

        }

        adView.loadAd(adRequest)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_sort, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(this, "Clicked " + item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initData() {
        // get place list
        countryArrayList = CountryRepository.countryList
    }

    private fun initUI() {
        initToolbar()

        // get list adapter
        adapter = UiAdViewCountryList1Adapter(countryArrayList)


        val mLayoutManager = LinearLayoutManager(applicationContext)
        countryListRecyclerView.layoutManager = mLayoutManager
        countryListRecyclerView.itemAnimator = DefaultItemAnimator()
    }

    private fun initDataBindings() {
        // bind adapter to recycler
        countryListRecyclerView.adapter = adapter
    }

    private fun initActions() {
        adapter.setOnItemClickListener(object : UiAdViewCountryList1Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: Country, position: Int) {
                Toast.makeText(this@UiAdViewBannerActivity, "Selected : " + obj.name, Toast.LENGTH_LONG).show()
            }
        })
    }

    //region Init Toolbar
    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Basic AdView Banner"

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
