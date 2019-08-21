package com.panaceasoft.pskotlinmaterial.adapter.feature.detail.directory

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
import java.util.*

/**
 * Created by Panacea-Soft on 19/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureDetailDirectoryPlaceDetail2PagerAdapter(private val context: Context, private val imageList: ArrayList<String>?) : PagerAdapter() {
    private val shopItemArrayList: List<ShopItem>? = null
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: ShopItem, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun getCount(): Int {

        return imageList?.size ?: shopItemArrayList!!.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {

        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.feature_detail_directory_place_detail_2_pager_item, container, false)
        val imageView = view.findViewById<ImageView>(R.id.placeImageView)
        val gradientImageView = view.findViewById<ImageView>(R.id.gradientImageView)

        val context = container.context

        if (imageList == null) {
            val id = Utils.getDrawableInt(context, shopItemArrayList!![position].imageName)
            Utils.setImageToImageView(context, imageView, id)
        } else {
            val id = Utils.getDrawableInt(context, imageList[position])
            Utils.setImageToImageView(context, imageView, id)
        }

        val gradientImg = R.drawable.black_alpha_70
        Utils.setImageToImageView(context, gradientImageView, gradientImg)

        val vp = container as ViewPager
        vp.addView(view, 0)

        // Listeners
        imageView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, shopItemArrayList!![position], position) }

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)
    }
}

