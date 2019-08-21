package com.panaceasoft.pskotlinmaterial.fragment.feature.dashboard.directory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.*
import com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.directory.*
import com.panaceasoft.pskotlinmaterial.repository.directory.DirectoryHome9Repository
import com.panaceasoft.pskotlinmaterial.utils.Utils

class FeatureDashboardDirectoryDashboard9Fragment : Fragment() {

    internal lateinit var productsList: List<DirectoryHome9ProductsVO>
    internal lateinit var categoryList: List<DirectoryHome9CategoryVO>
    internal lateinit var promotionsList: List<DirectoryHome9PromotionsVO>
    internal lateinit var popularList: List<DirectoryHome9PopularVO>
    internal lateinit var flightsList: List<DirectoryHome9FlightsVO>

    internal lateinit var productsAdapter: FeatureDashboardDirectoryDashboard9ProductsAdapter
    internal lateinit var categoryAdapter: FeatureDashboardDirectoryDashboard9CategoryAdapter
    internal lateinit var promotionsAdapter: FeatureDashboardDirectoryDashboard9PromotionsAdapter
    internal lateinit var popularAdapter: FeatureDashboardDirectoryDashboard9PopularAdapter
    internal lateinit var flightsAdapter: FeatureDashboardDirectoryDashboard9FlightsAdapter

    internal lateinit var rvProduct: RecyclerView
    internal lateinit var rvCategory: RecyclerView
    internal lateinit var rvPromotions: RecyclerView
    internal lateinit var rvPopular: RecyclerView
    internal lateinit var rvFlights: RecyclerView

    internal lateinit var moreImageView: ImageView
    internal lateinit var moreImageView2: ImageView
    internal lateinit var profileImageView: ImageView

    internal lateinit var loginRegisterTextView: TextView

    internal var noOfProductColumn = 5
    internal var noOfPopularColumn = 2

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.feature_dashboard_directory_dashboard_9_fragment, container, false)

        initData()

        initUI(view)

        initDataBindings()

        initActions()

        return view
    }

    private fun initData() {
        productsList = DirectoryHome9Repository.productsList
        categoryList = DirectoryHome9Repository.categoryList
        promotionsList = DirectoryHome9Repository.promotionsList
        popularList = DirectoryHome9Repository.popularList
        flightsList = DirectoryHome9Repository.flightsList
    }

    private fun initUI(view: View) {

        productsAdapter = FeatureDashboardDirectoryDashboard9ProductsAdapter(productsList)
        categoryAdapter = FeatureDashboardDirectoryDashboard9CategoryAdapter(categoryList)
        promotionsAdapter = FeatureDashboardDirectoryDashboard9PromotionsAdapter(promotionsList)
        popularAdapter = FeatureDashboardDirectoryDashboard9PopularAdapter(popularList)
        flightsAdapter = FeatureDashboardDirectoryDashboard9FlightsAdapter(flightsList)

        if (activity != null) {

            rvProduct = view.findViewById(R.id.rvProducts)
            rvCategory = view.findViewById(R.id.rvCategory)
            rvPromotions = view.findViewById(R.id.rvPromotions)
            rvPopular = view.findViewById(R.id.rvPopular)
            rvFlights = view.findViewById(R.id.rvFlights)

            val productLayoutManager = GridLayoutManager(activity?.applicationContext, noOfProductColumn)
            rvProduct.layoutManager = productLayoutManager
            rvProduct.adapter = productsAdapter
            //            rvProduct.setOnClickListener();

            val categoryLayoutManger = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.HORIZONTAL, false)
            rvCategory.layoutManager = categoryLayoutManger
            rvCategory.adapter = categoryAdapter

            val promotionsLayoutManger = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.HORIZONTAL, false)
            rvPromotions.layoutManager = promotionsLayoutManger
            rvPromotions.adapter = promotionsAdapter

            val popularLayoutManager = GridLayoutManager(activity?.applicationContext, noOfPopularColumn)
            rvPopular.layoutManager = popularLayoutManager
            rvPopular.adapter = popularAdapter

            val flightsLayoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.HORIZONTAL, false)
            rvFlights.layoutManager = flightsLayoutManager
            rvFlights.adapter = flightsAdapter
        }

        moreImageView = view.findViewById(R.id.moreImageView)
        moreImageView2 = view.findViewById(R.id.moreImageView2)
        profileImageView = view.findViewById(R.id.home9ProfileImageView)
        loginRegisterTextView = view.findViewById(R.id.loginRegisterTextView)
    }

    private fun initDataBindings() {
        val leftImageId = R.drawable.baseline_arrow_right_24
        val profileImageId = R.drawable.home9_profile

        Utils.setImageToImageView(context!!, moreImageView, leftImageId)
        Utils.setImageToImageView(context!!, moreImageView2, leftImageId)
        Utils.setImageToImageView(context!!, profileImageView, profileImageId)

        profileImageView.setOnClickListener { Toast.makeText(context, "Clicked : Profile", Toast.LENGTH_SHORT).show() }

        loginRegisterTextView.setOnClickListener { Toast.makeText(context, "Clicked : Log in and Register", Toast.LENGTH_SHORT).show() }
    }

    private fun initActions() {

        productsAdapter.setOnItemClickListener(object : FeatureDashboardDirectoryDashboard9ProductsAdapter.OnItemClickListener{
            override fun onItemClick(view: View, product: DirectoryHome9ProductsVO, position: Int) {
                Toast.makeText(context, "Clicked : " + product.name, Toast.LENGTH_SHORT).show()
            }
        })


        categoryAdapter.setOnItemClickListener(object : FeatureDashboardDirectoryDashboard9CategoryAdapter.OnItemClickListener{
            override fun onItemClick(view: View, category: DirectoryHome9CategoryVO, position: Int) {
                Toast.makeText(context, "Clicked : " + category.name, Toast.LENGTH_SHORT).show()
            }
        })

        promotionsAdapter.setOnItemClickListener(object : FeatureDashboardDirectoryDashboard9PromotionsAdapter.OnItemClickListener{
            override fun onItemClick(view: View, promotion: DirectoryHome9PromotionsVO, position: Int) {
                if(position == 0){
                    Toast.makeText(context, "Clicked : See All Promos", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(context, "Clicked : " + promotion.name, Toast.LENGTH_SHORT).show()
                }
            }
        })

        popularAdapter.setOnItemClickListener(object : FeatureDashboardDirectoryDashboard9PopularAdapter.OnItemClickListener{
            override fun onItemClick(view: View, popular: DirectoryHome9PopularVO, position: Int) {
                Toast.makeText(context, "Clicked : " + popular.name, Toast.LENGTH_SHORT).show()
            }
        })


        flightsAdapter.setOnItemClickListener(object :FeatureDashboardDirectoryDashboard9FlightsAdapter.OnItemClickListener{
            override fun onItemClick(view: View, flight: DirectoryHome9FlightsVO, position: Int) {
                Toast.makeText(context, "Clicked : " + flight.country, Toast.LENGTH_SHORT).show()
            }
        })

    }


}
