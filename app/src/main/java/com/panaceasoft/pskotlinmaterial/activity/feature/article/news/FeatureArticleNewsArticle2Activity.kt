package com.panaceasoft.pskotlinmaterial.activity.feature.article.news

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_article_news_article_2_activity.*

class FeatureArticleNewsArticle2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_article_news_article_2_activity)

        initUI()

        initActions()

    }


    private fun initUI() {

        val id1 = Utils.getDrawableInt(applicationContext, "cafe3")
        Utils.setImageToImageView(applicationContext, coverPhotoImageView, id1)

        val id2 = Utils.getDrawableInt(applicationContext, "profile2")
        Utils.setCircleImageToImageView(applicationContext, userProfileImageView, id2, 1, R.color.md_grey_200)


    }

    private fun initActions() {
        likeImageView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Like.", Toast.LENGTH_SHORT).show() }
        faceImageView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Happy.", Toast.LENGTH_SHORT).show() }
        commentImageView.setOnClickListener {  Toast.makeText(applicationContext, "Clicked Comment.", Toast.LENGTH_SHORT).show() }
        shareImageView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Share.", Toast.LENGTH_SHORT).show() }
        backImageButton.setOnClickListener { finish() }
        heartImageView.setOnClickListener {  Toast.makeText(applicationContext, "Clicked Favourite.", Toast.LENGTH_SHORT).show() }

    }

}
