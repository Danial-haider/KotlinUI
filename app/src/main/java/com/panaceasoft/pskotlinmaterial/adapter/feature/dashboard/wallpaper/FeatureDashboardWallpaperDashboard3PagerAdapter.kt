package com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.wallpaper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.WallpaperCategory
import com.panaceasoft.pskotlinmaterial.utils.Utils

/**
 * Created by Panacea-Soft on 17/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureDashboardWallpaperDashboard3PagerAdapter(private val context: Context, private val categoryList: List<WallpaperCategory>) : PagerAdapter() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: WallpaperCategory, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun getCount(): Int {
        return categoryList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.feature_dashboard_wallpaper_dashboard_3_pager_item, container, false)
        val pagerItemImageView = view.findViewById<ImageView>(R.id.pagerItemImageView)
        val pagerItemBgImageView = view.findViewById<ImageView>(R.id.pagerItemBgImageView)

        val context = container.context

        val id = Utils.getDrawableInt(context, categoryList[position].imageName)
        Utils.setImageToImageView(context, pagerItemImageView, id)

        Utils.setImageToImageView(context, pagerItemBgImageView, R.drawable.black_alpha_70)

        val vp = container as ViewPager
        vp.addView(view, 0)

        // Listeners

        pagerItemImageView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, categoryList[position], position) }
        pagerItemBgImageView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, categoryList[position], position) }

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)
    }
}
