package com.panaceasoft.pskotlinmaterial.activity.application.directory.filter

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.adapter.application.directory.filter.AppDirectoryFilter1Adapter
import com.panaceasoft.pskotlinmaterial.repository.directory.PlaceRepository
import kotlinx.android.synthetic.main.app_directory_filter_1_activity.*
import java.util.*

class AppDirectoryFilter1Activity : AppCompatActivity() {

    private lateinit var placeArrayList: ArrayList<Place>
    private lateinit var mAdapter: AppDirectoryFilter1Adapter
    internal var numberOfColumns = 2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_directory_filter_1_activity)

        initData()

        initUI()

        initDataBinding()

        initActions()
    }

    //region Init Functions
    private fun initData() {
        placeArrayList = PlaceRepository.placeList
    }

    private fun initUI() {

        mAdapter = AppDirectoryFilter1Adapter(placeArrayList)

        // get RecyclerView and bind
        recyclerView.layoutManager = GridLayoutManager(this, numberOfColumns)
        recyclerView.itemAnimator = DefaultItemAnimator()

        val searchEditText = findViewById<EditText>(R.id.searchEditText)
        searchEditText.isFocusable = false

        val filterButton = findViewById<Button>(R.id.filterButton)
        filterButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Filter", Toast.LENGTH_SHORT).show() }


        val openNowButton = findViewById<Button>(R.id.openNowButton)
        openNowButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Open Now", Toast.LENGTH_SHORT).show() }

        val savedButton = findViewById<Button>(R.id.savedButton)
        savedButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Saved", Toast.LENGTH_SHORT).show() }

        val likedButton = findViewById<Button>(R.id.likedButton)
        likedButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked Liked", Toast.LENGTH_SHORT).show() }

        val moreFiltersButton = findViewById<Button>(R.id.moreFiltersButton)
        moreFiltersButton.setOnClickListener { Toast.makeText(applicationContext, "Clicked More Filters", Toast.LENGTH_SHORT).show() }

        val backImageView = findViewById<ImageView>(R.id.backImageView)
        backImageView.setOnClickListener { finish() }

        val mapPageImageView = findViewById<ImageView>(R.id.mapPageImageView)
        mapPageImageView.setOnClickListener { Toast.makeText(applicationContext, "Clicked Map", Toast.LENGTH_SHORT).show() }
    }

    private fun initDataBinding() {
        recyclerView.adapter = mAdapter
    }

    private fun initActions() {
        mAdapter.setOnItemClickListener(object : AppDirectoryFilter1Adapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: Place, position: Int) {
                Toast.makeText(this@AppDirectoryFilter1Activity,obj.name,Toast.LENGTH_LONG).show()
            }

        })
    }

    //endregion
}
