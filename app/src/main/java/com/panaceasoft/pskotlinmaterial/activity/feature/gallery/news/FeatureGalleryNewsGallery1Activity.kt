package com.panaceasoft.pskotlinmaterial.activity.feature.gallery.news

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.widget.Toast

import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.adapter.application.news.gallery.AppNewsGallery1Adapter
import com.panaceasoft.pskotlinmaterial.`object`.News
import com.panaceasoft.pskotlinmaterial.repository.news.NewsRepository
import kotlinx.android.synthetic.main.feature_gallery_news_gallery_1_activity.*

class FeatureGalleryNewsGallery1Activity : AppCompatActivity() {

    private lateinit var pagerAdapter: AppNewsGallery1Adapter
    private lateinit var newsList: List<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_gallery_news_gallery_1_activity)

        initData()

        initDataBinding()

        initActions()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(applicationContext, item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }


    //region Init Functions
    private fun initData() {
        newsList = NewsRepository.newsList
        pagerAdapter = AppNewsGallery1Adapter(this, newsList )
    }

    private fun initDataBinding() {
        imageViewPager.adapter = pagerAdapter

        val noStr = "1 / " + newsList.size
        imageNoTextView.text = noStr
    }

    private fun initActions() {

        imageViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                val noStr = (position + 1).toString() + " / " + newsList.size
                imageNoTextView.text = noStr

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })


        pagerAdapter.setOnItemClickListener(object : AppNewsGallery1Adapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: News, position: Int) {
                Toast.makeText(applicationContext, "Clicked : " + obj.newsImage, Toast.LENGTH_SHORT).show()
            }
        })

    }

    //endregion
}
