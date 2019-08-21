package com.panaceasoft.pskotlinmaterial.fragment.application.ecommerce.order

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.panaceasoft.pskotlinmaterial.R


class AppECommerceOrder4Fragment : Fragment {

    private lateinit var statusTextView1: TextView
    private lateinit var statusTextView2: TextView
    private lateinit var statusTextView3: TextView
    private lateinit var copyImageView1: ImageView
    private lateinit var copyImageView2: ImageView
    private lateinit var copyImageView3: ImageView

    private lateinit var transNoTextView1: TextView
    private lateinit var transNoTextView2: TextView
    private lateinit var transNoTextView3: TextView

    private lateinit var status: String

    constructor() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    constructor(status: String) {
        // Required empty public constructor
        this.status = status
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.app_ecommerce_order_4_fragment, container, false)
        initUI(view)
        initActions()
        return view
    }

    private fun initUI(view: View) {
        statusTextView1 = view.findViewById(R.id.statusTextView1)
        statusTextView1.text = this.status

        statusTextView2 = view.findViewById(R.id.statusTextView2)
        statusTextView2.text = this.status

        statusTextView3 = view.findViewById(R.id.statusTextView3)
        statusTextView3.text = this.status

        copyImageView1 = view.findViewById(R.id.copyImageView1)
        copyImageView2 = view.findViewById(R.id.copyImageView2)
        copyImageView3 = view.findViewById(R.id.copyImageView3)

        transNoTextView1 = view.findViewById(R.id.transNoTextView1)
        transNoTextView2 = view.findViewById(R.id.transNoTextView2)
        transNoTextView3 = view.findViewById(R.id.transNoTextView3)

    }

    private fun initActions() {
        copyImageView1.setOnClickListener {
            val cManager = context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val cData = ClipData.newPlainText("text", transNoTextView1.text)
            cManager.primaryClip = cData
            Toast.makeText(context, "Copied to clipboard.", Toast.LENGTH_SHORT).show()
        }

        copyImageView2.setOnClickListener {
            val cManager = context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val cData = ClipData.newPlainText("text", transNoTextView2.text)
            cManager.primaryClip = cData
            Toast.makeText(context, "Copied to clipboard.", Toast.LENGTH_SHORT).show()
        }

        copyImageView3.setOnClickListener {
            val cManager = context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val cData = ClipData.newPlainText("text", transNoTextView3.text)
            cManager.primaryClip = cData
            Toast.makeText(context, "Copied to clipboard.", Toast.LENGTH_SHORT).show()
        }
    }


}
