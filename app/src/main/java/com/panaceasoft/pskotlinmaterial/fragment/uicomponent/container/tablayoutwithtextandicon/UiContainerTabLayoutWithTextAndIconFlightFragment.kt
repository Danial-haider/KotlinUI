package com.panaceasoft.pskotlinmaterial.fragment.uicomponent.container.tablayoutwithtextandicon

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.panaceasoft.pskotlinmaterial.R

import androidx.fragment.app.Fragment

class UiContainerTabLayoutWithTextAndIconFlightFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.ui_container_tab_layout_with_text_and_icon_flights_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }
}// Required empty public constructor
