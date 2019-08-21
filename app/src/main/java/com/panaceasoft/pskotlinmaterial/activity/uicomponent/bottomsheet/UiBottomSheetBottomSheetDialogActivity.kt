package com.panaceasoft.pskotlinmaterial.activity.uicomponent.bottomsheet


import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.fragment.uicomponent.container.bottomsheet.UiContainerBottomSheetDialogFragment
import kotlinx.android.synthetic.main.ui_bottom_sheet_bottom_sheet_dialog_activity.*
import kotlinx.android.synthetic.main.ui_container_bottom_sheet_dialog_fragment.view.*
import java.util.*

class UiBottomSheetBottomSheetDialogActivity : AppCompatActivity() {

    internal lateinit var list: ArrayList<String>
    internal lateinit var adapter: ArrayAdapter<String>
    internal lateinit var fruits: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_bottom_sheet_bottom_sheet_dialog_activity)

        initToolbar()

        fruits = resources.getStringArray(R.array.fruits)

        openBSButton.setOnClickListener {

            val view = layoutInflater.inflate(R.layout.ui_container_bottom_sheet_dialog_fragment, null)

            val dialog = BottomSheetDialog(this)

            list = ArrayList(Arrays.asList(*fruits))
            adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)

            view.bsDialogListView.adapter = adapter

            dialog.setContentView(view)
            dialog.show()
        }

        // Dialog Fragment
        openBSFragmentButton.setOnClickListener {

            val uiContainerBottomSheetDialogFragment = UiContainerBottomSheetDialogFragment()
            uiContainerBottomSheetDialogFragment.show(supportFragmentManager, uiContainerBottomSheetDialogFragment.tag)
        }
    }

    //region Init Toolbar

    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Bottom Sheet Dialog"

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
