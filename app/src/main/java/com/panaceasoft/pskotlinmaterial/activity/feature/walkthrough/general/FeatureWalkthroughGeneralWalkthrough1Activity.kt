package com.panaceasoft.pskotlinmaterial.activity.feature.walkthrough.general

import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.adapter.feature.walkthrough.general.FeatureWalkthroughGeneralWalkthrough1Adapter
import kotlinx.android.synthetic.main.feature_walkthrough_general_walkthrough_1_activity.*

@Suppress("DEPRECATION")
class FeatureWalkthroughGeneralWalkthrough1Activity : AppCompatActivity() {


    private lateinit var featureWalkthroughGeneralWalkthrough1Adapter: FeatureWalkthroughGeneralWalkthrough1Adapter
    internal lateinit var pages: Array<TextView?>
    internal lateinit var welcomeScreen: IntArray



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_walkthrough_general_walkthrough_1_activity)

        initUI()

        initActions()

    }

    private fun initUI() {

        welcomeScreen = intArrayOf(R.layout.feature_walkthrough_general_walkthrough_1_slider_1, R.layout.feature_walkthrough_general_walkthrough_1_slider_2, R.layout.feature_walkthrough_general_walkthrough_1_slider_3, R.layout.feature_walkthrough_general_walkthrough_1_slider_4)

        addPagination(0)

    }

    private fun initActions() {

        val viewPagerPageChangeListener = object : ViewPager.OnPageChangeListener {

            override fun onPageSelected(position: Int) {
                addPagination(position)


                if (position == welcomeScreen.size - 1) {
                    btn_next.text = "LET'S EXPLORE"
                    btn_skip.visibility = View.GONE
                } else {
                    btn_next.text = "Next"
                    btn_skip.visibility = View.VISIBLE
                }
            }

            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {

            }

            override fun onPageScrollStateChanged(arg0: Int) {

            }
        }


        featureWalkthroughGeneralWalkthrough1Adapter = FeatureWalkthroughGeneralWalkthrough1Adapter(welcomeScreen, applicationContext)
        view_pager.adapter = featureWalkthroughGeneralWalkthrough1Adapter
        view_pager.addOnPageChangeListener(viewPagerPageChangeListener)

        btn_skip.setOnClickListener { launchApp() }

        btn_next.setOnClickListener {

            val current = getItem(+1)
            if (current < welcomeScreen.size) {
                view_pager.currentItem = current
            } else {
                launchApp()
            }
        }

    }

    private fun addPagination(currentPage: Int) {
        pages = arrayOfNulls(welcomeScreen.size)

        layoutDots.removeAllViews()
        for (i in pages.indices) {
            pages[i] = TextView(this)
            pages[i]?.text = Html.fromHtml("&#8226;")
            pages[i]?.textSize = 35f
            pages[i]?.setTextColor(ContextCompat.getColor(this,R.color.md_grey_300))
            layoutDots.addView(pages[i])
        }

        if (pages.size > 0) {
            pages[currentPage]?.setTextColor(ContextCompat.getColor(this,R.color.md_yellow_600))
        }
    }

    private fun getItem(i: Int): Int {
        return view_pager.currentItem + i
    }

    private fun launchApp() {
        Toast.makeText(applicationContext, "Ready To Launch The App!", Toast.LENGTH_SHORT).show()
    }

}
