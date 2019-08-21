package com.panaceasoft.pskotlinmaterial.activity.feature.list.general

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.GeneralList
import com.panaceasoft.pskotlinmaterial.adapter.feature.list.general.FeatureListGeneralSwipeToDismissListAdapter
import com.panaceasoft.pskotlinmaterial.repository.general.GeneralListRepository
import com.panaceasoft.pskotlinmaterial.utils.drag_and_swipe.OnStartDragListener
import com.panaceasoft.pskotlinmaterial.utils.drag_and_swipe.SimpleItemDragAndSwipeHelperCallback
import kotlinx.android.synthetic.main.feature_list_general_swipe_to_dismiss_list_activity.*

class FeatureListGeneralSwipeToDismissListActivity : AppCompatActivity(), OnStartDragListener {

    private lateinit var generalListList: MutableList<GeneralList>
    private lateinit var adapter: FeatureListGeneralSwipeToDismissListAdapter
    private lateinit var mItemTouchHelper: ItemTouchHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_list_general_swipe_to_dismiss_list_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initData() {

        // get place list
        generalListList = GeneralListRepository.generalList
    }

    private fun initUI() {
        initToolbar()

        // get list adapter
        adapter = FeatureListGeneralSwipeToDismissListAdapter(generalListList, this)

        // get recycler view
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.isNestedScrollingEnabled = false

        val callback = SimpleItemDragAndSwipeHelperCallback(adapter)
        mItemTouchHelper = ItemTouchHelper(callback)
        mItemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun initDataBindings() {
        // bind adapter to recycler
        recyclerView.adapter = adapter
    }

    private fun initActions() {
        adapter.setOnItemClickListener(object : FeatureListGeneralSwipeToDismissListAdapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: GeneralList, position: Int) {
                Toast.makeText(this@FeatureListGeneralSwipeToDismissListActivity, "Selected : " + obj.name, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
        mItemTouchHelper.startDrag(viewHolder)
    }

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Swipe To Dismiss List"

        try {
           toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.md_white_1000))
        } catch (e: Exception) {
            Log.e("TEAMPS", "Can't set color.")
        }

        try {
            setSupportActionBar(toolbar)
        } catch (e: Exception) {
            Log.e("TEAMPS", "Error in set support action bar.")
        }

        try {
            if (supportActionBar != null) {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
        } catch (e: Exception) {
            Log.e("TEAMPS", "Error in set display home as up enabled.")
        }

    }

}