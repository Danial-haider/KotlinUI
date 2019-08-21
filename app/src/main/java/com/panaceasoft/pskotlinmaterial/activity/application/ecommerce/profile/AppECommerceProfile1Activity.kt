package com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.profile

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.adapter.application.ecommerce.profile.AppECommerceProfile1ItemAdapter
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.ShopItemRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_ecommerce_profile_1_activity.*
import java.util.*

class AppECommerceProfile1Activity : AppCompatActivity() {

    private lateinit var itemArrayList: ArrayList<ShopItem>
    private lateinit var mAdapter: AppECommerceProfile1ItemAdapter
    internal var numberOfColumns = 2


    //region override functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_ecommerce_profile_1_activity)

        initData()

        initUI()

        initDataBindings()

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
        itemArrayList = ShopItemRepository.menShopItemList
    }


    private fun initUI() {
        initToolbar()

        val shopImageVIew = findViewById<ImageView>(R.id.shopImageVIew)
        val id = R.drawable.profile2
        Utils.setCircleImageToImageView(applicationContext, shopImageVIew, id, 5, R.color.md_blue_grey_400)

        mAdapter = AppECommerceProfile1ItemAdapter(itemArrayList)

        // get RecyclerView and bind

        recyclerView.layoutManager = GridLayoutManager(this, numberOfColumns)
        recyclerView.itemAnimator = DefaultItemAnimator()

        recyclerView.isNestedScrollingEnabled = false

    }

    private fun initDataBindings() {
        // get data and adapter
        recyclerView.adapter = mAdapter
    }

    private fun initActions() {
        mAdapter.setOnItemClickListener(object : AppECommerceProfile1ItemAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(applicationContext, "Clicked " + obj.name, Toast.LENGTH_SHORT).show()
            }

            override fun onAddToCartClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(applicationContext, "Clicked Add To Cart ", Toast.LENGTH_SHORT).show()
            }

            override fun onLikeClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(applicationContext, "Clicked Like ", Toast.LENGTH_SHORT).show()
            }

            override fun onMenuClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(applicationContext, "Clicked Menu ", Toast.LENGTH_SHORT).show()
            }
        })

        editProfileTextView.setOnClickListener {Toast.makeText(this, "Clicked Edit Profile.", Toast.LENGTH_SHORT).show() }
        followerTextView.setOnClickListener {Toast.makeText(this, "Clicked followers.", Toast.LENGTH_SHORT).show() }
        followingTextView.setOnClickListener { Toast.makeText(this, "Clicked following.", Toast.LENGTH_SHORT).show() }
        saveItemLayout.setOnClickListener { Toast.makeText(this, "Clicked Saved Items.", Toast.LENGTH_SHORT).show() }
        likeItemLayout.setOnClickListener { Toast.makeText(this, "Clicked Stuff liked.", Toast.LENGTH_SHORT).show() }
        settingLayout.setOnClickListener {Toast.makeText(this, "Clicked Setting.", Toast.LENGTH_SHORT).show() }

    }

    private fun initToolbar() {
        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "User Profile 1"

        try {
           toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.md_white_1000))
        } catch (e: Exception) {
            Log.e("TEAMPS", "Can't set color.")
        }

        try {
            setSupportActionBar(toolbar)
        } catch (e: Exception) {
            Log.e("TEAMPS", "Error in set support action bar.")
        }

        try {
            if (supportActionBar != null) {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
        } catch (e: Exception) {
            Log.e("TEAMPS", "Error in set display home as up enabled.")
        }

    }
    //endregion

}

