package com.panaceasoft.pskotlinmaterial.activity

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.net.Uri
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.gms.ads.*
import com.google.android.material.tabs.TabLayout
import com.panaceasoft.pskotlinmaterial.Config
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.fragment.MainApplicationListFragment
import com.panaceasoft.pskotlinmaterial.fragment.MainFeatureListFragment
import com.panaceasoft.pskotlinmaterial.fragment.MainUIFragment
import com.panaceasoft.pskotlinmaterial.utils.NavigationController
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var userClickCount = 5
    var limitToStartAction = 10
    var isAds = false
    internal lateinit var dialog: Dialog
    internal lateinit var image: ImageView
    internal lateinit var subTitleTextView: TextView
    internal lateinit var msgTextView: TextView
    internal lateinit var sourceCodeButton: Button
    internal lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileAds.initialize(this, "@string/adview_banner_home_footer")
        //        MobileAds.initialize(this,"@string/adview_interstitial_ad_key");
        initToolbar()

        if(Config.SHOW_ADMOB) {
            prepareFullScreenAds()
        }

        initUI()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_info, menu)

        Utils.updateMenuIconColor(menu, ContextCompat.getColor(this,R.color.md_white_1000))

        return true
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            AlertDialog.Builder(this)
                    .setTitle(resources.getString(R.string.app_name))
                    .setMessage(R.string.message__want_to_quit)
                    .setIcon(R.drawable.baseline_info_line_24)
                    .setNegativeButton(android.R.string.no, null)
                    .setPositiveButton(android.R.string.yes) { _: DialogInterface, _: Int ->
                        finish()
                        System.exit(0)
                    }.show()

        }
        return true
    }


    //region Init Toolbar

    private fun initToolbar() {

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        toolbar.setNavigationIcon(R.drawable.app_icon)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = getString(R.string.app_name)

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
            //Toast.makeText(this, getString(R.string.app_name), Toast.LENGTH_SHORT).show();
            getCustomLayoutDialog(R.layout.activity_main_dialog_layout)
        } else if (item.itemId == R.id.action_app_info) {
            NavigationController.openActivity(this, Intent(this, MainAboutUs::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    //endregion

    private fun initUI() {

        val view_pager = findViewById<ViewPager>(R.id.view_pager)
        val tab_layout = findViewById<TabLayout>(R.id.tab_layout)
        setupViewPager(view_pager)

        tab_layout.setupWithViewPager(view_pager)

        try {

            // set icon color pre-selected
            val tab1 = tab_layout.getTabAt(0)
            if (tab1 != null) {
                tab1.setIcon(R.drawable.baseline_book_white_24)
                if (tab1.icon != null) {
                    tab1.icon?.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN)
                }
            }

            val tab2 = tab_layout.getTabAt(1)
            if (tab2 != null) {
                tab2.setIcon(R.drawable.baseline_layers_white_24)
                if (tab2.icon != null) {
                    tab2.icon?.setColorFilter(ContextCompat.getColor(this,R.color.md_grey_200), PorterDuff.Mode.SRC_IN)
                }
            }

            val tab3 = tab_layout.getTabAt(2)
            if (tab3 != null) {
                tab3.setIcon(R.drawable.baseline_widgets_black_24)
                if (tab3.icon != null) {
                    tab3.icon?.setColorFilter(ContextCompat.getColor(this,R.color.md_grey_200), PorterDuff.Mode.SRC_IN)
                }
            }

            tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    if (tab.icon != null) {
                        tab.icon?.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN)
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {
                    if (tab.icon != null) {
                        tab.icon?.setColorFilter(ContextCompat.getColor(this@MainActivity,R.color.md_grey_200), PorterDuff.Mode.SRC_IN)
                    }
                }

                override fun onTabReselected(tab: TabLayout.Tab) {
                    if (tab.icon != null) {
                        tab.icon?.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN)
                    }
                }
            })

        } catch (e: NullPointerException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val adRequest = AdRequest.Builder().build()

        if(Config.SHOW_ADMOB) {

            adView.adListener = object : AdListener() {
                override fun onAdLoaded() {
                    //Toast.makeText(getApplicationContext(), "Ad is loaded!", Toast.LENGTH_SHORT).show();
                }

                override fun onAdClosed() {
                    //Toast.makeText(getApplicationContext(), "Ad is closed!", Toast.LENGTH_SHORT).show();
                }

                override fun onAdFailedToLoad(errorCode: Int) {
                    //Toast.makeText(getApplicationContext(), "Ad failed to load! error code: " + errorCode, Toast.LENGTH_SHORT).show();
                }

                override fun onAdLeftApplication() {
                    //Toast.makeText(getApplicationContext(), "Ad left application!", Toast.LENGTH_SHORT).show();
                }

                override fun onAdOpened() {
                    super.onAdOpened()
                }
            }

            adView.loadAd(adRequest)
        }else {
            adView.visibility = View.GONE
        }

        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        if (preferences.contains("checked")) {

            if (preferences.getBoolean("checked", true)) {
                launchAppIntro()
            }
        } else {
            launchAppIntro()
        }

    }

    private fun launchAppIntro() {
        val intent = Intent(this, MainWalkthroughtActivity::class.java)
        startActivity(intent)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val viewPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(MainUIFragment.newInstance(), getString(R.string.tab_ui_collection))    // index 0
        viewPagerAdapter.addFragment(MainFeatureListFragment.newInstance(), getString(R.string.tab_features))    // index 1
        viewPagerAdapter.addFragment(MainApplicationListFragment.newInstance(), getString(R.string.tab_application))   // index 2

        viewPager.adapter = viewPagerAdapter
    }

    private inner class SectionsPagerAdapter internal constructor(manager: FragmentManager) : FragmentPagerAdapter(manager) {

        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        fun getTitle(position: Int): String {
            return mFragmentTitleList[position]
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList[position]
        }
    }

    fun getCustomLayoutDialog(layoutId: Int) {
        dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(layoutId)

        subTitleTextView = dialog.findViewById(R.id.subTitleTextView)
        subTitleTextView.text = "It's Awesome !"

        msgTextView = dialog.findViewById(R.id.messageTextView)
        msgTextView.text = "We hope you love our app."

        image = dialog.findViewById(R.id.dialogImageView)
        image.setImageResource(R.drawable.home_popup_coding)

        sourceCodeButton = dialog.findViewById(R.id.sourceCodeButton)
        sourceCodeButton.text = "GET SOURCE CODE HERE"

        sourceCodeButton.setOnClickListener {
            val url = "http://bit.ly/2cdH8K3"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        if (dialog.window != null) {
            dialog.window?.attributes = getLayoutParams(dialog)
        }

        dialog.show()
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

    private fun prepareFullScreenAds() {
        mInterstitialAd = InterstitialAd(this)

        // set the ad unit ID
        mInterstitialAd.adUnitId = getString(R.string.adview_interstitial_ad_key)

        val adRequest = AdRequest.Builder().build()

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest)

        mInterstitialAd.adListener = object : AdListener() {
            override fun onAdClosed() {
                prepareFullScreenAds()
                super.onAdClosed()
            }

            override fun onAdLoaded() {

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

}
