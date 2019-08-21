package com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.finance.dashboard1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.FinanceSummary

/**
 * Created by Panacea-Soft on 7/17/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class FeatureDashboardFinanceDashboard1PagerAdapter(private val context: Context, private val financeSummaryList: List<FinanceSummary>) : PagerAdapter() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: FinanceSummary, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun getCount(): Int {
        return financeSummaryList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.feature_dashboard_finance_dashboard_1_view_pager_item, container, false)
        val cardView = view.findViewById<CardView>(R.id.cardView)
        val titleTextView = view.findViewById<TextView>(R.id.titleTextView)
        val amountTextView = view.findViewById<TextView>(R.id.amountTextView)

        val financeSummary = financeSummaryList[position]

        titleTextView.text = financeSummary.title
        amountTextView.text = financeSummary.amount

        val vp = container as ViewPager
        vp.addView(view, 0)

        // Listeners

        cardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, financeSummaryList[position], position) }

        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)
    }
}

