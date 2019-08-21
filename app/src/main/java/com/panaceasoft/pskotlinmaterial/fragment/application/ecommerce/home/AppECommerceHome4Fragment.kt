package com.panaceasoft.pskotlinmaterial.fragment.application.ecommerce.home


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
import com.panaceasoft.pskotlinmaterial.adapter.application.ecommerce.home.home4.AppECommerceHome4ItemAdapter
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.ShopItemRepository

import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class AppECommerceHome4Fragment : Fragment() {

    // data
    internal lateinit var itemArrayList: ArrayList<ShopItem>
    internal lateinit var itemAdapter: AppECommerceHome4ItemAdapter

    // RecyclerView
    internal lateinit var itemsRecyclerView: RecyclerView

    internal var type = "F"

    internal var noOfColumn = 2


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.app_ecommerce_home_4_fragment, container, false)

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
                "F" ->
                    // get data
                    itemArrayList = ShopItemRepository.womenShopItemList
                "M" ->
                    // get data
                    itemArrayList = ShopItemRepository.menShopItemList
                else -> itemArrayList = ShopItemRepository.kidShopItemList
            }
        }
    }

    private fun initUI(view: View) {

        // get item list featuredAdapter
        itemAdapter = AppECommerceHome4ItemAdapter(itemArrayList)

        if (activity != null) {

            // get Item recycler view
            itemsRecyclerView = view.findViewById(R.id.shopFeaturedItemRecyclerView4)
            val mLayoutManagerForItems = GridLayoutManager(activity?.applicationContext, noOfColumn)

            itemsRecyclerView.layoutManager = mLayoutManagerForItems
            itemsRecyclerView.itemAnimator = DefaultItemAnimator()

        }

    }

    private fun initDataBindings() {
        // bind items
        itemsRecyclerView.adapter = itemAdapter
    }

    private fun initActions() {

        itemAdapter.setOnItemClickListener(object : AppECommerceHome4ItemAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(context, "Clicked: " + obj.name, Toast.LENGTH_SHORT).show()
            }

            override fun onLikeClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(context, "Clicked Like ", Toast.LENGTH_SHORT).show()
            }
        })

    }
}
