package com.panaceasoft.pskotlinmaterial.fragment.feature.stepper.ecommerce

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.panaceasoft.pskotlinmaterial.R

/**
 * Created by Panacea-Soft on 7/22/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class FeatureStepperECommerceStepper1Fragment : Fragment() {

    private var name: String? = null
    private var email: String? = null
    private var phone: String? = null
    private var address: String? = null
    private var city: String? = null
    private var state: String? = null
    private var country: String? = null
    private var zip: String? = null
    private var listener: OnInfoListener? = null

    interface OnInfoListener {
        fun onInfoChange(name: String,
                         email: String,
                         phone: String,
                         address: String,
                         city: String,
                         state: String,
                         country: String,
                         zip: String)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        name = if (arguments != null) arguments?.getString("NAME") else ""
        email = if (arguments != null) arguments?.getString("EMAIL") else ""
        phone = if (arguments != null) arguments?.getString("PHONE") else ""
        address = if (arguments != null) arguments?.getString("ADDRESS") else ""
        city = if (arguments != null) arguments?.getString("CITY") else ""
        state = if (arguments != null) arguments?.getString("STATE") else ""
        country = if (arguments != null) arguments?.getString("COUNTRY") else ""
        zip = if (arguments != null) arguments?.getString("ZIP") else ""

        try {
            listener = activity as OnInfoListener
        } catch (e: ClassCastException) {
            e.printStackTrace()
        }

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.feature_stepper_ecommerce_stepper_1_fragment_1, container, false)

        val nameEditText = view.findViewById<EditText>(R.id.nameEditText)
        nameEditText.setText(name)
        val emailEditText = view.findViewById<EditText>(R.id.emailEditText)
        emailEditText.setText(email)
        val phoneEditText = view.findViewById<EditText>(R.id.phoneEditText)
        phoneEditText.setText(phone)
        val addressEditText = view.findViewById<EditText>(R.id.addressEditText)
        addressEditText.setText(address)
        val cityEditText = view.findViewById<EditText>(R.id.cityEditText)
        cityEditText.setText(city)
        val countryEditText = view.findViewById<EditText>(R.id.countryEditText)
        countryEditText.setText(country)
        val stateEditText = view.findViewById<EditText>(R.id.stateEditText)
        stateEditText.setText(state)
        val postalEditText = view.findViewById<EditText>(R.id.postalEditText)
        postalEditText.setText(zip)


        nameEditText.setOnKeyListener { _, _, _ ->
            name = nameEditText.text.toString()
            listener?.onInfoChange(name!!, email!!, phone!!, address!!, city!!, state!!, country!!, zip!!)
            false
        }

        emailEditText.setOnKeyListener { _, _, _ ->
            email = emailEditText.text.toString()
            listener?.onInfoChange(name!!, email!!, phone!!, address!!, city!!, state!!, country!!, zip!!)
            false
        }

        phoneEditText.setOnKeyListener { _, _, _ ->
            phone = phoneEditText.text.toString()
            listener?.onInfoChange(name!!, email!!, phone!!, address!!, city!!, state!!, country!!, zip!!)
            false
        }

        addressEditText.setOnKeyListener { _, _, _ ->
            address = addressEditText.text.toString()
            listener?.onInfoChange(name!!, email!!, phone!!, address!!, city!!, state!!, country!!, zip!!)
            false
        }

        cityEditText.setOnKeyListener { _, _, _ ->
            city = cityEditText.text.toString()
            listener?.onInfoChange(name!!, email!!, phone!!, address!!, city!!, state!!, country!!, zip!!)
            false
        }

        countryEditText.setOnKeyListener { _, _, _ ->
            country = countryEditText.text.toString()
            listener?.onInfoChange(name!!, email!!, phone!!, address!!, city!!, state!!, country!!, zip!!)
            false
        }

        stateEditText.setOnKeyListener { _, _, _ ->
            state = stateEditText.text.toString()
            listener?.onInfoChange(name!!, email!!, phone!!, address!!, city!!, state!!, country!!, zip!!)
            false
        }

        postalEditText.setOnKeyListener { _, _, _ ->
            zip = postalEditText.text.toString()
            listener?.onInfoChange(name!!, email!!, phone!!, address!!, city!!, state!!, country!!, zip!!)
            false
        }

        return view
    }

    companion object {
        fun newInstance(name: String,
                        email: String,
                        phone: String,
                        address: String,
                        city: String,
                        state: String,
                        country: String,
                        zip: String): FeatureStepperECommerceStepper1Fragment {
            val fragment = FeatureStepperECommerceStepper1Fragment()

            // Supply num input as an argument.
            val args = Bundle()
            args.putString("NAME", name)
            args.putString("EMAIL", email)
            args.putString("PHONE", phone)
            args.putString("ADDRESS", address)
            args.putString("CITY", city)
            args.putString("STATE", state)
            args.putString("COUNTRY", country)
            args.putString("ZIP", zip)


            fragment.arguments = args

            return fragment
        }
    }

}// Required empty public constructor
