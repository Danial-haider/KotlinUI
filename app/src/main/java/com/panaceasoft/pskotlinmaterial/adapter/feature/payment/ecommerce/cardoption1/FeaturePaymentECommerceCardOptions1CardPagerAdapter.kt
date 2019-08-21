package com.panaceasoft.pskotlinmaterial.adapter.feature.payment.ecommerce.cardoption1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.CreditCard
import com.panaceasoft.pskotlinmaterial.utils.Utils

/**
 * Created by Panacea-Soft on 7/18/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class FeaturePaymentECommerceCardOptions1CardPagerAdapter(private val context: Context, private val creditCardList: List<CreditCard>) : PagerAdapter() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: CreditCard, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun getCount(): Int {
        return creditCardList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.feature_payment_ecommerce_card_options_1_view_pager_item, container, false)

        val cardImageView = view.findViewById<ImageView>(R.id.cardImageView)
        val typeImageView = view.findViewById<ImageView>(R.id.typeImageView)
        val cardNumberTextView = view.findViewById<TextView>(R.id.cardNumberTextView)
        val cardNameTextView = view.findViewById<TextView>(R.id.cardNameTextView)
        val cardCvvTextView = view.findViewById<TextView>(R.id.cardCvvTextView)
        val cardDateTextView = view.findViewById<TextView>(R.id.cardDateTextView)

        val creditCard = creditCardList[position]

        cardNumberTextView.text = creditCard.cardNumber
        cardNameTextView.text = creditCard.cardName
        cardCvvTextView.text = creditCard.cardCVV
        cardDateTextView.text = creditCard.cardExpiryDate

        val context = cardImageView.context

        val id = Utils.getDrawableInt(context, creditCard.cardBg)
        Utils.setImageToImageView(context, cardImageView, id)

        val cardTypeId = Utils.getDrawableInt(context, creditCard.cardType)
        Utils.setImageToImageView(context, typeImageView, cardTypeId)


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

