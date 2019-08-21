package com.panaceasoft.pskotlinmaterial.adapter.application.ecommerce.gallery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.utils.Utils

/**
 * Created by Panacea-Soft on 6/29/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class AppECommerceGallery2PagerAdapter(private val context: Context, private val shopItemList: List<ShopItem>) : PagerAdapter() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: ShopItem, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun getCount(): Int {
        return shopItemList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.app_ecommerce_gallery_2_view_pager_item, container, false)
        val imageView = view.findViewById<ImageView>(R.id.placeImageView)


        val context = container.context

        val id = Utils.getDrawableInt(context, shopItemList[position].imageName)
        Utils.setImageToImageView(context, imageView, id)

        val vp = container as ViewPager
        vp.addView(view, 0)

        // Listeners
        imageView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, shopItemList[position], position) }

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)
    }
}

