package com.panaceasoft.pskotlinmaterial.activity.feature.gallery.directory

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.adapter.feature.gallery.directory.FeatureGalleryDirectoryGallery2Adapter
import com.panaceasoft.pskotlinmaterial.repository.directory.PlaceRepository
import kotlinx.android.synthetic.main.feature_gallery_directory_gallery_2_activity.*

class FeatureGalleryDirectoryGallery2Activity : AppCompatActivity() {


    private lateinit var dots: Array<ImageView?>
    private var dotsCount: Int = 0

    internal lateinit var pagerAdapter: FeatureGalleryDirectoryGallery2Adapter
    internal lateinit var placeList: List<Place>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_gallery_directory_gallery_2_activity)

        initData()

        initDataBinding()

        initActions()

    }

    //region Init Functions
    private fun initData() {
        placeList = PlaceRepository.placeList
        pagerAdapter = FeatureGalleryDirectoryGallery2Adapter(this, placeList)
    }


    private fun initDataBinding() {
        imageViewPager.adapter = pagerAdapter
        setupSliderPagination()
    }

    private fun initActions() {

        backImageView.setOnClickListener {  finish() }

        shareImageView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Share", Toast.LENGTH_SHORT).show() }


        imageViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {


                    setupSliderPagination()


                for (i in 0 until dotsCount) {
                    dots[i]?.setImageDrawable(ContextCompat.getDrawable(this@FeatureGalleryDirectoryGallery2Activity,R.drawable.nonselecteditem_dot))
                }

                dots[position]?.setImageDrawable(ContextCompat.getDrawable(this@FeatureGalleryDirectoryGallery2Activity,R.drawable.selecteditem_dot))
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })


        pagerAdapter.setOnItemClickListener(object : FeatureGalleryDirectoryGallery2Adapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: Place, position: Int) {
                Toast.makeText(applicationContext, "Clicked : " + obj.name, Toast.LENGTH_SHORT).show()
            }
        })

    }

    fun setupSliderPagination() {

        dotsCount = pagerAdapter.count

        if (dotsCount > 0 ) {

            //mainSlider.setVisibility(View.VISIBLE);

            dots = arrayOfNulls(dotsCount)


                if (viewPagerCountDots.childCount > 0) {
                    viewPagerCountDots.removeAllViewsInLayout()

            }

            for (i in 0 until dotsCount) {
                dots[i] = ImageView(this)
                dots[i]?.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.nonselecteditem_dot))

                val params = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )

                params.setMargins(4, 0, 4, 0)

                viewPagerCountDots.addView(dots[i], params)
            }

            dots[0]?.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.selecteditem_dot))

        }
    }

    //endregion
}
