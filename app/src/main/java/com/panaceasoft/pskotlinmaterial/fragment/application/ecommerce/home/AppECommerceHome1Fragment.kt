package com.panaceasoft.pskotlinmaterial.fragment.application.ecommerce.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.adapter.application.ecommerce.home.home1.AppECommerceHome1FeaturedItemAdapter
import com.panaceasoft.pskotlinmaterial.adapter.application.ecommerce.home.home1.AppECommerceHome1ItemAdapter
import com.panaceasoft.pskotlinmaterial.repository.ecommerce.ShopItemRepository
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class AppECommerceHome1Fragment : Fragment() {

    // data and featuredAdapter
    internal lateinit var itemArrayList: ArrayList<ShopItem>
    internal lateinit var featuredAdapter: AppECommerceHome1FeaturedItemAdapter
    internal lateinit var itemAdapter: AppECommerceHome1ItemAdapter

    internal lateinit var viewAllFeaturedTextView: TextView
    internal lateinit var viewAllItemTextView: TextView

    // RecyclerView
    internal lateinit var featuredItemRecyclerView: RecyclerView
    internal lateinit var itemsRecyclerView: RecyclerView

    internal var type = "F"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.app_ecommerce_home_1_fragment, container, false)

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
        // get feature list featuredAdapter
        featuredAdapter = AppECommerceHome1FeaturedItemAdapter(itemArrayList)

        // get item list featuredAdapter
        itemAdapter = AppECommerceHome1ItemAdapter(itemArrayList)


        if (activity != null) {
            // get featured recycler view
            featuredItemRecyclerView = view.findViewById(R.id.shopFeaturedItemRecyclerView)
            val mLayoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.HORIZONTAL, false)
            featuredItemRecyclerView.layoutManager = mLayoutManager
            featuredItemRecyclerView.itemAnimator = DefaultItemAnimator()
            featuredItemRecyclerView.isNestedScrollingEnabled = false

            // get Item recycler view
            itemsRecyclerView = view.findViewById(R.id.shopFeaturedItemRecyclerView2)
            val mLayoutManagerForItems = GridLayoutManager(activity?.applicationContext, 3)

            itemsRecyclerView.layoutManager = mLayoutManagerForItems
            itemsRecyclerView.itemAnimator = DefaultItemAnimator()
            itemsRecyclerView.isNestedScrollingEnabled = false
        }

        viewAllFeaturedTextView = view.findViewById(R.id.featuredViewAllTextView)
        viewAllItemTextView = view.findViewById(R.id.itemViewAllTextView)


    }

    private fun initDataBindings() {
        // bind featuredAdapter to recycler
        featuredItemRecyclerView.adapter = featuredAdapter

        // bind items
        itemsRecyclerView.adapter = itemAdapter
    }

    private fun initActions() {
        featuredAdapter.setOnItemClickListener(object : AppECommerceHome1FeaturedItemAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(context, "Clicked " + obj.name, Toast.LENGTH_SHORT).show()
            }

            override fun onAddToCartClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(context, "Clicked Add To Cart ", Toast.LENGTH_SHORT).show()
            }

            override fun onLikeClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(context, "Clicked Like ", Toast.LENGTH_SHORT).show()
            }

            override fun onMenuClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(context, "Clicked Menu ", Toast.LENGTH_SHORT).show()
            }
        })

        itemAdapter.setOnItemClickListener(object : AppECommerceHome1ItemAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: ShopItem, position: Int) {
                Toast.makeText(context, "Selected " + obj.name, Toast.LENGTH_SHORT).show()
            }
        })

        viewAllFeaturedTextView.setOnClickListener { Toast.makeText(context, "Clicked View All Featured.", Toast.LENGTH_SHORT).show() }

        viewAllItemTextView.setOnClickListener { Toast.makeText(context, "Clicked View All Item.", Toast.LENGTH_SHORT).show() }

    }
}
