package com.panaceasoft.pskotlinmaterial.activity

import android.os.Bundle
import android.preference.PreferenceManager
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.adapter.MainWalkthroughtAdapter

@Suppress("DEPRECATION")
class MainWalkthroughtActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var mainWalkthroughtAdapter: MainWalkthroughtAdapter
    lateinit var pages: Array<TextView?>
    internal lateinit var welcomeScreen: IntArray
    private lateinit var dotsLayout: LinearLayout
    private lateinit var btnSkip: Button
    private lateinit var btnNext: Button
    lateinit var letExploreTextView: TextView
    internal lateinit var constraintLayoutLetExplore: ConstraintLayout
    internal lateinit var checkBoxIntro: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_walkthrough_activity)

        initUI()

        initActions()

    }

    private fun initUI() {

        welcomeScreen = intArrayOf(R.layout.main_walkthrough_slider_1, R.layout.main_walkthrough_slider_2, R.layout.main_walkthrough_slider_3)

        constraintLayoutLetExplore = findViewById(R.id.constraintLayoutLetExplore)
        checkBoxIntro = findViewById(R.id.checkBoxIntro)
        letExploreTextView = findViewById(R.id.letExploreTextView)
        btnSkip = findViewById(R.id.btn_skip)
        btnNext = findViewById(R.id.btn_next)

        viewPager = findViewById(R.id.view_pager)
        dotsLayout = findViewById(R.id.layoutDots)

        addPagination(0)

    }

    private fun initActions() {

        val viewPagerPageChangeListener = object : ViewPager.OnPageChangeListener {

            override fun onPageSelected(position: Int) {
                addPagination(position)

                if (position == welcomeScreen.size - 1) {
                    btnNext.visibility = View.GONE
                    btnSkip.visibility = View.GONE
                    dotsLayout.visibility = View.GONE
                    checkBoxIntro.visibility = View.VISIBLE
                    constraintLayoutLetExplore.visibility = View.VISIBLE
                } else {
                    btnNext.text = "Next"
                    btnNext.visibility = View.VISIBLE
                    btnSkip.visibility = View.VISIBLE
                    dotsLayout.visibility = View.VISIBLE
                    checkBoxIntro.visibility = View.GONE
                    constraintLayoutLetExplore.visibility = View.GONE
                }
            }

            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {

            }

            override fun onPageScrollStateChanged(arg0: Int) {

            }
        }


        mainWalkthroughtAdapter = MainWalkthroughtAdapter(welcomeScreen, applicationContext)
        viewPager.adapter = mainWalkthroughtAdapter
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener)

        btnSkip.setOnClickListener {
            finish()
            //MainWalkthroughtActivity.this.launchApp();
        }

        btnNext.setOnClickListener {

            val current = getItem(+1)
            if (current < welcomeScreen.size) {
                viewPager.currentItem = current
            } else {
                //launchApp();
            }
        }

        letExploreTextView.setOnClickListener {
            val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
            val editor = preferences.edit()
            editor.putBoolean("checked", !checkBoxIntro.isChecked)
            editor.apply()
            //launchApp();

            finish()
        }

        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        //        final SharedPreferences.Editor editor = preferences.edit();
        if (preferences.contains("checked") && preferences.getBoolean("checked", false) == true) {
            //launchApp();
        } else {

        }
    }

    private fun addPagination(currentPage: Int) {
        pages = arrayOfNulls(welcomeScreen.size)

        dotsLayout.removeAllViews()
        for (i in pages.indices) {
            pages[i] = TextView(this)
            pages[i]?.text = Html.fromHtml("&#8226;")
            pages[i]?.textSize = 35f
            pages[i]?.setTextColor(ContextCompat.getColor(this,R.color.md_grey_300))
            dotsLayout.addView(pages[i])
        }

        if (pages.size > 0) {
            pages[currentPage]?.setTextColor(ContextCompat.getColor(this,R.color.md_yellow_600))
        }
    }

    private fun getItem(i: Int): Int {
        return viewPager.currentItem + i
    }

}
