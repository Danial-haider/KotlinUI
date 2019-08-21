package com.panaceasoft.pskotlinmaterial.fragment.uicomponent.container.bottomsheet

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.ListView
import androidx.core.content.ContextCompat
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.panaceasoft.pskotlinmaterial.R
import java.util.*

class UiContainerBottomSheetDialogFragment : BottomSheetDialogFragment() {

    internal lateinit var list: ArrayList<String>
    internal lateinit var adapter: ArrayAdapter<String>

    internal lateinit var fruits: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        fruits = resources.getStringArray(R.array.fruits)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.ui_container_bottom_sheet_dialog_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list = ArrayList(Arrays.asList(*fruits))

        if (context != null) {
            adapter = ArrayAdapter(context!!, android.R.layout.simple_list_item_1, list)
            val listView = view.findViewById<ListView>(R.id.bsDialogListView)

            val frameLayout = view.findViewById<FrameLayout>(R.id.frameLayout)
            frameLayout.setBackgroundColor(ContextCompat.getColor(context!!,R.color.colorPrimaryButton))

            listView.adapter = adapter
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }
}
