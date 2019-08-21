package com.panaceasoft.pskotlinmaterial.fragment.application.directory.home


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
import com.panaceasoft.pskotlinmaterial.adapter.application.directory.home.AppDirectoryHome1ItemAdapter
import com.panaceasoft.pskotlinmaterial.repository.directory.CategoryRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils

/**
 * A simple [Fragment] subclass.
 */
class AppDirectoryHome1Fragment : Fragment() {


    // data
    internal lateinit var directoryCategoryList: List<DirectoryCategory>
    internal lateinit var itemAdapter: AppDirectoryHome1ItemAdapter

    // RecyclerView
    internal lateinit var itemsRecyclerView: RecyclerView

    internal lateinit var cityImageView: ImageView
    internal lateinit var gradientImageView: ImageView

    internal var noOfColumn = 3

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.app_directory_home_1_fragment, container, false)

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
        itemAdapter = AppDirectoryHome1ItemAdapter(directoryCategoryList)

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

        itemAdapter.setOnItemClickListener(object : AppDirectoryHome1ItemAdapter.OnItemClickListener{
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
