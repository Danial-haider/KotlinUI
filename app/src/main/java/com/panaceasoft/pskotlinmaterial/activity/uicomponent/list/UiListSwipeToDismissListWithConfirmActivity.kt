package com.panaceasoft.pskotlinmaterial.activity.uicomponent.list

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.GeneralList
import com.panaceasoft.pskotlinmaterial.adapter.uicomponent.list.RecyclerItemTouchHelper
import com.panaceasoft.pskotlinmaterial.adapter.uicomponent.list.UIListSwipeToDismissListWithConfirmAdapter
import com.panaceasoft.pskotlinmaterial.repository.general.GeneralListRepository
import com.panaceasoft.pskotlinmaterial.utils.drag_and_swipe.OnStartDragListener
import kotlinx.android.synthetic.main.ui_list_swipe_to_dismiss_list_with_confirm_activity.*

class UiListSwipeToDismissListWithConfirmActivity : AppCompatActivity(), OnStartDragListener, RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {

    private lateinit var generalListList: MutableList<GeneralList>
    private lateinit var adapter: UIListSwipeToDismissListWithConfirmAdapter


    private  lateinit var mItemTouchHelper: ItemTouchHelper
    lateinit var conordiLayout: CoordinatorLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_list_swipe_to_dismiss_list_with_confirm_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()



        conordiLayout = findViewById(R.id.coordinatorLayoutForDismissListWithConfirm)
        val itemTouchHelperCallback1 = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT or ItemTouchHelper.UP) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}

            override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            }
        }

        ItemTouchHelper(itemTouchHelperCallback1).attachToRecyclerView(recyclerView)
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
        adapter = UIListSwipeToDismissListWithConfirmAdapter(this, generalListList)


        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.isNestedScrollingEnabled = false

        val itemTouchHelperCallback = RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this)
        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView)
    }

    private fun initDataBindings() {
        // bind adapter to recycler
        recyclerView.adapter = adapter
    }

    private fun initActions() {
        adapter.setOnItemClickListener(object : UIListSwipeToDismissListWithConfirmAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: GeneralList, position: Int) {
                Toast.makeText(this@UiListSwipeToDismissListWithConfirmActivity, "Selected : " + obj.name, Toast.LENGTH_SHORT).show()
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

        toolbar.title = "Swipe To Dismiss List with Confirm"

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

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {
        if (viewHolder is UIListSwipeToDismissListWithConfirmAdapter.GeneralListViewHolder) {
            // get the removed item name to display it in snack bar
            val name = generalListList[viewHolder.getAdapterPosition()].name

            // backup of removed item for undo purpose
            val deletedItem = generalListList[viewHolder.getAdapterPosition()]
            val deletedIndex = viewHolder.getAdapterPosition()

            // remove the item from recycler view
            adapter.removeItem(viewHolder.getAdapterPosition())

            // showing snack bar with Undo option
            val snackbar = Snackbar
                    .make(conordiLayout, "$name removed from cart!", Snackbar.LENGTH_LONG)
            snackbar.setAction("UNDO") {

                // undo is selected, restore the deleted item
                adapter.restoreItem(deletedItem, deletedIndex)
            }
            snackbar.setActionTextColor(Color.YELLOW)
            snackbar.show()
        }
    }
}