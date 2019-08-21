package com.panaceasoft.pskotlinmaterial.adapter.application.directory.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_directory_detail_2_image_list_adapter_item.view.*
import java.util.*

class AppDirectoryDetail2ImageListPagerAdapter(private val context: Context, private val imageList: ArrayList<String>) : PagerAdapter() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: ShopItem, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun getCount(): Int {

        return imageList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {

        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = layoutInflater.inflate(R.layout.app_directory_detail_2_image_list_adapter_item, container, false)
        val imageView = view.placeImageView
        val gradientImageView = view.gradientImageView

        val context = container.context

        val id = Utils.getDrawableInt(context, imageList[position])
        Utils.setImageToImageView(context, imageView, id)

        val gradientImg = R.drawable.black_alpha_70
        Utils.setImageToImageView(context, gradientImageView, gradientImg)

        val vp = container as ViewPager
        vp.addView(view, 0)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)
    }
}
