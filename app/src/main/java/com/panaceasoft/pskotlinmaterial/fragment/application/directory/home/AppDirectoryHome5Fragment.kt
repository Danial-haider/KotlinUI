package com.panaceasoft.pskotlinmaterial.fragment.application.directory.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.adapter.application.directory.home.AppDirectoryHome5ItemAdapter
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.repository.directory.PlaceRepository

import java.util.ArrayList

class AppDirectoryHome5Fragment : Fragment() {

    // data and featuredAdapter
    internal lateinit var placeArrayList: ArrayList<Place>
    internal lateinit var itemAdapter: AppDirectoryHome5ItemAdapter


    // RecyclerView
    internal lateinit var itemsRecyclerView: RecyclerView
    internal var type = "F"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.app_directory_home_5_fragment, container, false)

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
                    placeArrayList = PlaceRepository.placeList

                "C" ->
                    // get data
                    placeArrayList = PlaceRepository.placeList

                else -> placeArrayList = PlaceRepository.placeList
            }
        }
    }

    private fun initUI(view: View) {
        // get item list featuredAdapter
        itemAdapter = AppDirectoryHome5ItemAdapter(placeArrayList)


        if (activity != null) {

            // get Item recycler view
            itemsRecyclerView = view.findViewById(R.id.shopFeaturedItemRecyclerView2)
            val mLayoutManagerForItems = GridLayoutManager(activity?.applicationContext, 2)

            itemsRecyclerView.layoutManager = mLayoutManagerForItems
            itemsRecyclerView.itemAnimator = DefaultItemAnimator()
            itemsRecyclerView.isNestedScrollingEnabled = false
        }

    }

    private fun initDataBindings() {
        // bind items
        itemsRecyclerView.adapter = itemAdapter
    }

    private fun initActions() {
        itemAdapter.setOnItemClickListener(object : AppDirectoryHome5ItemAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: Place, position: Int) {
                Toast.makeText(context, "Clicked " + obj.name, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
