package com.panaceasoft.pskotlinmaterial.activity.uicomponent.cards

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.ui_cards_card_view_overlap_activity.*

class UiCardsCardViewOverlapActivity : AppCompatActivity() {

    //region override functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_cards_card_view_overlap_activity)

        initData()

        initUI()

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

    //endregion

    //region Init Functions
    private fun initData() {

    }

    private fun initUI() {

        val profileImageView = findViewById<ImageView>(R.id.profileImageView)
        val id = R.drawable.profile2
        Utils.setCircleImageToImageView(applicationContext, profileImageView, id, 20, R.color.md_white_1000)

        val coverUserImageView = findViewById<ImageView>(R.id.coverUserImageView)
        Utils.setImageToImageView(applicationContext, coverUserImageView, id)

    }

    private fun initActions() {
        emailTextView.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_VIEW)
                val data = Uri.parse("mailto:?subject=" + "Hello" + "&body=" + "About Awesome Material App")
                intent.data = data
                intent.putExtra(Intent.EXTRA_EMAIL, emailTextView?.text.toString())
                startActivity(intent)

            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
            }
        }

        phoneTextView.setOnClickListener {
            try {

                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneTextView?.text.toString()))
                startActivity(intent)

            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
            }
        }

        websiteTextView.setOnClickListener {
            try {
                val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse(websiteTextView?.text.toString()))
                startActivity(myIntent)
            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
            }
        }

    }
    //endregion

}
