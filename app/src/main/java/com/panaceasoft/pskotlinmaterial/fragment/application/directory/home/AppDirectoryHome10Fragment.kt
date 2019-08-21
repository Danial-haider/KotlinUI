package com.panaceasoft.pskotlinmaterial.fragment.application.directory.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.DirectoryHome7Category
import com.panaceasoft.pskotlinmaterial.adapter.application.directory.home.AppDirectoryHome10ItemAdapter
import com.panaceasoft.pskotlinmaterial.repository.directory.DirectoryHome7Repository
import com.panaceasoft.pskotlinmaterial.utils.Utils
import java.util.*

class AppDirectoryHome10Fragment : Fragment() {

    // data and featuredAdapter
    internal lateinit var itemArrayList: ArrayList<DirectoryHome7Category>
    internal lateinit var itemAdapter: AppDirectoryHome10ItemAdapter


    // RecyclerView
    internal lateinit var itemsRecyclerView: RecyclerView
    internal var type = "F"
    internal lateinit var imageView: ImageView
    internal lateinit var button: Button
    internal lateinit var viewall: TextView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.app_directory_home_10_fragment, container, false)

        initData()

        initUI(view)

        initDataBindings()

        initActions()

        return view
    }

    fun setType(type: String) {
        this.type = type
    }

    private fun initData() {
        if (activity != null) {

            when (type) {
                "A" ->
                    // get data
                    itemArrayList = DirectoryHome7Repository.categoryList


                "B" ->
                    // get data
                    itemArrayList = DirectoryHome7Repository.categoryList

                "C" ->
                    // get data
                    itemArrayList = DirectoryHome7Repository.categoryList

                else -> itemArrayList = DirectoryHome7Repository.categoryList
            }
        }
    }

    private fun initUI(view: View) {
        // get item list featuredAdapter
        itemAdapter = AppDirectoryHome10ItemAdapter(itemArrayList)


        if (activity != null) {

            // get Item recycler view
            viewall = view.findViewById(R.id.textView326)
            button = view.findViewById(R.id.button8)
            itemsRecyclerView = view.findViewById(R.id.recyclerView)
            imageView = view.findViewById(R.id.imageView)


            Utils.setImageToImageView(context!!, imageView, R.drawable.profile1)

            Utils.setCircleImageToImageView(context!!, imageView, R.drawable.profile1, 0, 0)

            val mLayoutManagerForItems = GridLayoutManager(activity?.applicationContext, 3)

            itemsRecyclerView.layoutManager = mLayoutManagerForItems
            itemsRecyclerView.itemAnimator = DefaultItemAnimator()
            itemsRecyclerView.isNestedScrollingEnabled = true
        }

    }

    private fun initDataBindings() {
        // bind items
        itemsRecyclerView.adapter = itemAdapter
    }

    private fun initActions() {
        itemAdapter.setOnItemClickListener(object : AppDirectoryHome10ItemAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: DirectoryHome7Category, position: Int) {
                Toast.makeText(context, "Clicked " + obj.name, Toast.LENGTH_SHORT).show()
            }
        })
        button.setOnClickListener { Toast.makeText(context, "Clicked Top Up", Toast.LENGTH_SHORT).show() }

        viewall.setOnClickListener { Toast.makeText(context, "View All", Toast.LENGTH_SHORT).show() }
    }
}
