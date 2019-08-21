package com.panaceasoft.pskotlinmaterial.activity.feature.payment.ecommerce

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.CreditCard
import com.panaceasoft.pskotlinmaterial.`object`.FinanceTransferTransaction
import com.panaceasoft.pskotlinmaterial.`object`.UserProfile
import com.panaceasoft.pskotlinmaterial.adapter.feature.payment.ecommerce.cardoption1.FeaturePaymentECommerceCardOptions1CardPagerAdapter
import com.panaceasoft.pskotlinmaterial.adapter.feature.payment.ecommerce.cardoption1.FeaturePaymentECommerceCardOptions1ContactAdapter
import com.panaceasoft.pskotlinmaterial.adapter.feature.payment.ecommerce.cardoption1.FeaturePaymentECommerceCardOptions1TransactionAdapter
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.CreditCardRepository
import com.panaceasoft.pskotlinmaterial.repository.finance.TransferTransactionRepository
import com.panaceasoft.pskotlinmaterial.repository.userprofile.UserProfileRepository
import kotlinx.android.synthetic.main.feature_payment_ecommerce_card_options_1_activity.*

class FeaturePaymentECommerceCardOptions1Activity : AppCompatActivity() {

    private lateinit var financePersonalLogList: List<FinanceTransferTransaction>
    private var dotsCount: Int = 0

    // ui variables
    private lateinit var featurePaymentECommerceCardOptions1CardPagerAdapter: FeaturePaymentECommerceCardOptions1CardPagerAdapter
    private lateinit var featurePaymentECommerceCardOptions1TransactionAdapter: FeaturePaymentECommerceCardOptions1TransactionAdapter
    private lateinit var featurePaymentECommerceCardOptions1ContactAdapter: FeaturePaymentECommerceCardOptions1ContactAdapter
    private lateinit var dots: Array<ImageView?>
    internal lateinit var userProfileList: List<UserProfile>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_payment_ecommerce_card_options_1_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initData() {

        // get shopItem detail
        val creditCardList = CreditCardRepository.creditCardList

        featurePaymentECommerceCardOptions1CardPagerAdapter = FeaturePaymentECommerceCardOptions1CardPagerAdapter(this, creditCardList!!)

        // get place list
        financePersonalLogList = TransferTransactionRepository.transferTransactionList

        userProfileList = UserProfileRepository.profileList

    }

    private fun initUI() {

        initToolbar()
        imageViewPager.setPadding(60, 0, 60, 0)
        imageViewPager.clipToPadding = false
        imageViewPager.pageMargin = 15

        // get list featurePaymentECommerceCardOptions1TransactionAdapter
        featurePaymentECommerceCardOptions1TransactionAdapter = FeaturePaymentECommerceCardOptions1TransactionAdapter(financePersonalLogList)

        // get recycler view

        val mLayoutManager = LinearLayoutManager(applicationContext)
        reviewRecyclerView.layoutManager = mLayoutManager
        reviewRecyclerView.itemAnimator = DefaultItemAnimator()
        reviewRecyclerView.isNestedScrollingEnabled = false

        featurePaymentECommerceCardOptions1ContactAdapter = FeaturePaymentECommerceCardOptions1ContactAdapter(userProfileList)


        val mLayoutManager2 = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        categoryRecyclerView.layoutManager = mLayoutManager2
        categoryRecyclerView.itemAnimator = DefaultItemAnimator()
        categoryRecyclerView.isNestedScrollingEnabled = false


    }

    private fun initDataBindings() {

        imageViewPager.adapter = featurePaymentECommerceCardOptions1CardPagerAdapter

        setupSliderPagination()

        // bind featurePaymentECommerceCardOptions1TransactionAdapter to recycler
        reviewRecyclerView.adapter = featurePaymentECommerceCardOptions1TransactionAdapter

        categoryRecyclerView.adapter = featurePaymentECommerceCardOptions1ContactAdapter
    }

    private fun initActions() {
        imageViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {


                setupSliderPagination()

                for (i in 0 until dotsCount) {
                    dots[i]?.setImageDrawable(ContextCompat.getDrawable(this@FeaturePaymentECommerceCardOptions1Activity,R.drawable.nonselecteditem_dot))
                }

                dots[position]?.setImageDrawable(ContextCompat.getDrawable(this@FeaturePaymentECommerceCardOptions1Activity,R.drawable.selecteditem_dot))
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        featurePaymentECommerceCardOptions1ContactAdapter.setOnItemClickListener(object : FeaturePaymentECommerceCardOptions1ContactAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: UserProfile, position: Int) {
                Toast.makeText(applicationContext, "Clicked " + obj.name, Toast.LENGTH_SHORT).show()
            }

            override fun onAddItemClick(view: View, position: Int) {
                Toast.makeText(applicationContext, "Clicked Add New Account.", Toast.LENGTH_SHORT).show()
            }
        })

        featurePaymentECommerceCardOptions1TransactionAdapter.setOnItemClickListener(object : FeaturePaymentECommerceCardOptions1TransactionAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: FinanceTransferTransaction, position: Int) {
                Toast.makeText(this@FeaturePaymentECommerceCardOptions1Activity, "Selected : " + obj.userTo, Toast.LENGTH_LONG).show()
            }
        })

        featurePaymentECommerceCardOptions1CardPagerAdapter.setOnItemClickListener(object : FeaturePaymentECommerceCardOptions1CardPagerAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: CreditCard, position: Int) {
                Toast.makeText(this@FeaturePaymentECommerceCardOptions1Activity, "Selected : " + obj.cardName, Toast.LENGTH_SHORT).show()
            }
        })

        transferButton.setOnClickListener {  Toast.makeText(this, "Clicked Transfer.", Toast.LENGTH_SHORT).show() }
        viewAllTransactionTextView.setOnClickListener {  Toast.makeText(this, "Clicked View All Transaction.", Toast.LENGTH_SHORT).show() }
        findContactTextView.setOnClickListener {  Toast.makeText(this, "Clicked Find Contact.", Toast.LENGTH_SHORT).show() }
    }

    fun setupSliderPagination() {

        dotsCount = featurePaymentECommerceCardOptions1CardPagerAdapter.count

        if (dotsCount > 0) {

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

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Card Options 1"

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
}