package com.panaceasoft.pskotlinmaterial.fragment.feature.stepper.ecommerce


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

import com.panaceasoft.pskotlinmaterial.R


/**
 * A simple [Fragment] subclass.
 */
class FeatureStepperECommerceStepper1Fragment3 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.feature_stepper_ecommerce_stepper_1_fragment_3, container, false)

        val reviewTextView = view.findViewById<TextView>(R.id.reviewTextView)
        reviewTextView.setOnClickListener {  Toast.makeText(context, "Clicked Review Your Order.", Toast.LENGTH_SHORT).show() }

        return view
    }

    companion object {

        fun newInstance(): FeatureStepperECommerceStepper1Fragment3 {

            return FeatureStepperECommerceStepper1Fragment3()
        }
    }

}// Required empty public constructor