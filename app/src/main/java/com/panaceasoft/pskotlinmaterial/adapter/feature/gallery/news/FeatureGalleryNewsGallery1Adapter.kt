package com.panaceasoft.pskotlinmaterial.adapter.feature.gallery.news

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.News
import com.panaceasoft.pskotlinmaterial.utils.Utils

/**
 * Created by Panacea-Soft on 12/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureGalleryNewsGallery1Adapter(private val context: Context, private val newsList: List<News>) : PagerAdapter() {
    private lateinit var itemClickListener: FeatureGalleryNewsGallery1Adapter.OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: News, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: FeatureGalleryNewsGallery1Adapter.OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun getCount(): Int {
        return newsList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.feature_gallery_news_gallery_1_pager_item, container, false)
        val imageView = view.findViewById<ImageView>(R.id.placeImageView)


        val context = container.context

        val id = Utils.getDrawableInt(context, newsList[position].newsImage)
        Utils.setImageToImageView(context, imageView, id)

        val vp = container as ViewPager
        vp.addView(view, 0)

        // Listeners

        imageView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, newsList[position], position) }

        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)
    }
}



