package com.panaceasoft.pskotlinmaterial.activity.uicomponent.adview

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_adview_full_screen_activity.*


class UiAdViewFullScreenActivity : AppCompatActivity() {

    lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_adview_full_screen_activity)

        initToolbar()

        prepareFullScreenAds()

        showAdsButton.isEnabled = false
        showAdsButton.text = "Loading Ads"
        showAdsButton.setOnClickListener { showFullScreenAds() }
    }

    private fun prepareFullScreenAds() {
        mInterstitialAd = InterstitialAd(this)

        // set the ad unit ID
        mInterstitialAd.adUnitId = getString(R.string.adview_interstitial_ad_key)

        val adRequest = AdRequest.Builder().build()

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest)

        mInterstitialAd.adListener = object : AdListener() {

            override fun onAdFailedToLoad(i: Int) {
                Log.d("TEAMPS", "Failed to load.$i")
                super.onAdFailedToLoad(i)
            }

            override fun onAdClosed() {
                showAdsButton.isEnabled = false
                showAdsButton.text = "Loading Ads"
                prepareFullScreenAds()
                super.onAdClosed()
            }

            override fun onAdLoaded() {
                showAdsButton.isEnabled = true
                showAdsButton.text = "Ads is ready. Click here!"

            }
        }
    }

    fun showFullScreenAds(): Boolean {
        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show()
            return true
        }
        return false
    }

    //region Init Toolbar

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "AdView FullScreen"

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}