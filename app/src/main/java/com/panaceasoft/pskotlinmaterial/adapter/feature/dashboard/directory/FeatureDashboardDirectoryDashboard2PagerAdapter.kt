package com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.directory

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.utils.Utils

/**
 * Created by Panacea-Soft on 15/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureDashboardDirectoryDashboard2PagerAdapter(private val context: Context?, private val placeList: List<Place>) : PagerAdapter() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: Place, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun getCount(): Int {
        return placeList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            val view = layoutInflater.inflate(R.layout.feature_dashboard_directory_dashboard_2_view_pager_item, container, false)
            val imageView = view.findViewById<ImageView>(R.id.placeImageView)

            val shopIconImageView = view.findViewById<ImageView>(R.id.shopIconImageView)

            val context = container.context

            val id = Utils.getDrawableInt(context, placeList[position].imageName)
            Utils.setImageToImageView(context, imageView, id)

            val logoId = Utils.getDrawableInt(context, placeList[position].logoImage!!)
            Utils.setCornerRadiusImageToImageView(context, shopIconImageView, logoId, 10, 5, R.color.colorPrimary)

            val titleTextView = view.findViewById<TextView>(R.id.titleTextView)
            val descTextView = view.findViewById<TextView>(R.id.descTextView)

            val title = "Trending this week : " + placeList[position].name

            titleTextView.text = title

            var desc = placeList[position].desc
            try {
                if (desc.length > 100) {
                    desc = desc.substring(0, 100) + "..."
                    descTextView.text = desc
                } else {
                    descTextView.text = desc
                }
            } catch (e: Exception) {
                Log.e("TEAMPS", "instantiateItem: ", e)
            }

            val shapedImageView = view.findViewById<ImageView>(R.id.shapeImageView)

            if (Utils.isRTL) {
                shapedImageView.rotationY = 180f
            }

            val vp = container as ViewPager
            vp.addView(view, 0)

            // Listeners

        imageView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, placeList[position], position) }
        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)
    }
}
