package com.panaceasoft.pskotlinmaterial.fragment.feature.dashboard.ecommerce

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.ecommerce.FeatureDashboardECommerceDashboard3ItemAdapter
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.ShopItemRepository
import java.util.*

/**
 * Created by Panacea-Soft on 17/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureDashboardECommerceDashboard3Fragment : Fragment() {

    // data
    internal lateinit var itemArrayList: ArrayList<ShopItem>
    internal lateinit var itemAdapter: FeatureDashboardECommerceDashboard3ItemAdapter


    // RecyclerView
    internal lateinit var itemsRecyclerView: RecyclerView

    internal lateinit var filterLayout: ConstraintLayout
    internal  var numberOfColumn = 2

    internal var type = "F"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.feature_dashboard_ecommerce_dashboard_3_fragment, container, false)

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
        itemAdapter = FeatureDashboardECommerceDashboard3ItemAdapter(itemArrayList)

        // Init Filter UI
        val cityCardView = view.findViewById<CardView>(R.id.cityCardView)
        val categoryCardView = view.findViewById<CardView>(R.id.categoryCardView)
        val sortCardView = view.findViewById<CardView>(R.id.sortCardView)

        cityCardView.setOnClickListener { Toast.makeText(context, "Clicked City Filter.", Toast.LENGTH_SHORT).show() }

        categoryCardView.setOnClickListener { Toast.makeText(context, "Clicked Category Filter.", Toast.LENGTH_SHORT).show() }

        sortCardView.setOnClickListener { Toast.makeText(context, "Clicked Sort/Filter.", Toast.LENGTH_SHORT).show() }

        if (activity != null) {

            // get Item recycler view
            itemsRecyclerView = view.findViewById(R.id.shopFeaturedItemRecyclerView3)
            val mLayoutManagerForItems = GridLayoutManager(activity?.applicationContext, numberOfColumn)

            itemsRecyclerView.layoutManager = mLayoutManagerForItems
            itemsRecyclerView.itemAnimator = DefaultItemAnimator()

            filterLayout = view.findViewById(R.id.filterConstraintLayout)

        }

    }

    private fun initDataBindings() {
        // bind items
        itemsRecyclerView.adapter = itemAdapter
    }

    private fun initActions() {

        itemAdapter.setOnItemClickListener(object : FeatureDashboardECommerceDashboard3ItemAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(context, "Clicked " + obj.name, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
