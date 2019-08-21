package com.panaceasoft.pskotlinmaterial.fragment.feature.stepper.ecommerce


import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.panaceasoft.pskotlinmaterial.R

/**
 * A simple [Fragment] subclass.
 */
class FeatureStepperECommerceStepper1Fragment2 : Fragment() {


    private var paymentType = 0
    private var listener: OnPaymentItemClickListener? = null

    private var cashCardView: CardView? = null
    private var paypalCardView: CardView? = null
    private var cardCardView: CardView? = null
    private var cashImageView: ImageView? = null
    private var paypalImageView: ImageView? = null
    private var cardImageView: ImageView? = null
    private var cashTextView: TextView? = null
    private var paypalTextView: TextView? = null
    private var cardTextView: TextView? = null

    interface OnPaymentItemClickListener {
        fun onItemClick(type: Int)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        paymentType = if (arguments != null) arguments!!.getInt("TYPE") else 0


        try {
            listener = activity as OnPaymentItemClickListener?
        } catch (e: ClassCastException) {
            e.printStackTrace()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.feature_stepper_ecommerce_stepper_1_fragment_2, container, false)

        cashCardView = view.findViewById(R.id.cashCardView)
        cashCardView?.setOnClickListener { refreshUI(0) }

        paypalCardView = view.findViewById(R.id.paypalCardView)
        paypalCardView?.setOnClickListener {  refreshUI(1) }

        cardCardView = view.findViewById(R.id.cardCardView)
        cardCardView?.setOnClickListener {  refreshUI(2) }

        cashImageView = view.findViewById(R.id.cashImageView)
        paypalImageView = view.findViewById(R.id.paypalImageView)
        cardImageView = view.findViewById(R.id.cardImageView)

        cashTextView = view.findViewById(R.id.cashTextView)
        paypalTextView = view.findViewById(R.id.paypalTextView)
        cardTextView = view.findViewById(R.id.cardTextView)

        refreshUI(paymentType)

        return view
    }

    private fun refreshUI(index: Int) {

        listener?.onItemClick(index)

        if (index == 0) {
            cashCardView?.setCardBackgroundColor(ContextCompat.getColor(context!!,R.color.colorPrimary))
            paypalCardView?.setCardBackgroundColor(ContextCompat.getColor(context!!,R.color.md_white_1000))
            cardCardView?.setCardBackgroundColor(ContextCompat.getColor(context!!,R.color.md_white_1000))

            if (context != null) {
                cashImageView?.setColorFilter(ContextCompat.getColor(context!!, R.color.md_white_1000), android.graphics.PorterDuff.Mode.SRC_ATOP)
                paypalImageView?.setColorFilter(ContextCompat.getColor(context!!, R.color.md_grey_800), android.graphics.PorterDuff.Mode.SRC_ATOP)
                cardImageView?.setColorFilter(ContextCompat.getColor(context!!, R.color.md_grey_800), android.graphics.PorterDuff.Mode.SRC_ATOP)
            }

            cashTextView?.setTextColor(ContextCompat.getColor(context!!,R.color.md_white_1000))
            paypalTextView?.setTextColor(ContextCompat.getColor(context!!,R.color.md_grey_800))
            cardTextView?.setTextColor(ContextCompat.getColor(context!!,R.color.md_grey_800))

            paymentType = 0
        } else if (index == 1) {
            cashCardView?.setCardBackgroundColor(ContextCompat.getColor(context!!,R.color.md_white_1000))
            paypalCardView?.setCardBackgroundColor(ContextCompat.getColor(context!!,R.color.colorPrimary))
            cardCardView?.setCardBackgroundColor(ContextCompat.getColor(context!!,R.color.md_white_1000))

            if (context != null) {
                cashImageView?.setColorFilter(ContextCompat.getColor(context!!, R.color.md_grey_800), android.graphics.PorterDuff.Mode.SRC_ATOP)
                paypalImageView?.setColorFilter(ContextCompat.getColor(context!!, R.color.md_white_1000), android.graphics.PorterDuff.Mode.SRC_ATOP)
                cardImageView?.setColorFilter(ContextCompat.getColor(context!!, R.color.md_grey_800), android.graphics.PorterDuff.Mode.SRC_ATOP)
            }

            cashTextView?.setTextColor(ContextCompat.getColor(context!!,R.color.md_grey_800))
            paypalTextView?.setTextColor(ContextCompat.getColor(context!!,R.color.md_white_1000))
            cardTextView?.setTextColor(ContextCompat.getColor(context!!,R.color.md_grey_800))

            paymentType = 1
        } else if (index == 2) {
            cashCardView?.setCardBackgroundColor(ContextCompat.getColor(context!!,R.color.md_white_1000))
            paypalCardView?.setCardBackgroundColor(ContextCompat.getColor(context!!,R.color.md_white_1000))
            cardCardView?.setCardBackgroundColor(ContextCompat.getColor(context!!,R.color.colorPrimary))

            if (context != null) {
                cashImageView?.setColorFilter(ContextCompat.getColor(context!!, R.color.md_grey_800), PorterDuff.Mode.SRC_ATOP)
                paypalImageView?.setColorFilter(ContextCompat.getColor(context!!, R.color.md_grey_800), android.graphics.PorterDuff.Mode.SRC_ATOP)
                cardImageView?.setColorFilter(ContextCompat.getColor(context!!, R.color.md_white_1000), android.graphics.PorterDuff.Mode.SRC_ATOP)
            }

            cashTextView?.setTextColor(ContextCompat.getColor(context!!,R.color.md_grey_800))
            paypalTextView?.setTextColor(ContextCompat.getColor(context!!,R.color.md_grey_800))
            cardTextView?.setTextColor(ContextCompat.getColor(context!!,R.color.md_white_1000))

            paymentType = 2
        }
    }

    companion object {

        fun newInstance(paymentType: Int): FeatureStepperECommerceStepper1Fragment2 {
            val fragment = FeatureStepperECommerceStepper1Fragment2()

            // Supply num input as an argument.
            val args = Bundle()

            args.putInt("TYPE", paymentType)
            fragment.arguments = args

            return fragment
        }
    }
}// Required empty public constructor