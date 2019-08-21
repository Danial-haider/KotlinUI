package com.panaceasoft.pskotlinmaterial.fragment.uicomponent.container.stepper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.panaceasoft.pskotlinmaterial.R

class UiStepperProgressStepperFragment : Fragment() {

    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        position = if (arguments != null) arguments!!.getInt("POSITION") else 0


    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.ui_stepper_progress_stepper_fragment, container, false)

        val stepperTextView = view.findViewById<TextView>(R.id.stepperTextView)

        stepperTextView.text = position.toString()

        return view
    }

    companion object {

        fun newInstance(position: Int): UiStepperProgressStepperFragment {
            val fragment = UiStepperProgressStepperFragment()

            // Supply num input as an argument.
            val args = Bundle()
            args.putInt("POSITION", position)
            fragment.arguments = args

            return fragment
        }
    }

}// Required empty public constructor

