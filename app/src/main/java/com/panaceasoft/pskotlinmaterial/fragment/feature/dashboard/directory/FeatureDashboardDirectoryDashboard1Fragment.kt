package com.panaceasoft.pskotlinmaterial.fragment.feature.dashboard.directory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.DirectoryCategory
import com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.directory.FeatureDashboardDirectoryDashboard1Adapter
import com.panaceasoft.pskotlinmaterial.repository.directory.CategoryRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils

/**
 * Created by Panacea-Soft on 15/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureDashboardDirectoryDashboard1Fragment : Fragment() {


    // data
    internal lateinit var directoryCategoryList: List<DirectoryCategory>
    internal lateinit var itemAdapter: FeatureDashboardDirectoryDashboard1Adapter

    // RecyclerView
    internal lateinit var itemsRecyclerView: RecyclerView

    internal lateinit var cityImageView: ImageView
    internal lateinit var gradientImageView: ImageView

    internal var noOfColumn = 3

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.feature_dashboard_directory_dashboard_1_fragment, container, false)

        initData()

        initUI(view)

        initDataBindings()

        initActions()

        return view
    }

    private fun initData() {

        directoryCategoryList = CategoryRepository.categoryList

    }

    private fun initUI(view: View) {

        // get item list featuredAdapter
        itemAdapter = FeatureDashboardDirectoryDashboard1Adapter(directoryCategoryList)

        if (activity != null) {

            // get Item recycler view
            itemsRecyclerView = view.findViewById(R.id.recyclerView)
            val mLayoutManagerForItems = GridLayoutManager(activity?.applicationContext, noOfColumn)

            itemsRecyclerView.layoutManager = mLayoutManagerForItems
            itemsRecyclerView.itemAnimator = DefaultItemAnimator()
            itemsRecyclerView.isNestedScrollingEnabled = false
        }

        cityImageView = view.findViewById(R.id.cityImageView)
        gradientImageView = view.findViewById(R.id.gradientImageView)
    }

    private fun initDataBindings() {
        // bind items
        itemsRecyclerView.adapter = itemAdapter

        val id = R.drawable.sg_clarke_quay
        Utils.setImageToImageView(context!!, cityImageView, id)

        val gradientImg = R.drawable.black_alpha_70
        Utils.setImageToImageView(context!!, gradientImageView, gradientImg)
    }

    private fun initActions() {

        itemAdapter.setOnItemClickListener(object :FeatureDashboardDirectoryDashboard1Adapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: DirectoryCategory, position: Int) {
                Toast.makeText(context, "Clicked: " + obj.name, Toast.LENGTH_SHORT).show()
            }
        })

    }

    override fun onResume() {
        super.onResume()

        val appCompatActivity = activity as AppCompatActivity?
        if (appCompatActivity != null) {
            if (appCompatActivity.supportActionBar != null) {
                appCompatActivity.supportActionBar?.hide()
            }
        }
    }

}// Required empty public constructor
