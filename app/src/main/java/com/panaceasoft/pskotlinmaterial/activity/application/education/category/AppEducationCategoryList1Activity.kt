package com.panaceasoft.pskotlinmaterial.activity.application.education.category

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.EducationCategoryListWithCourse
import com.panaceasoft.pskotlinmaterial.adapter.application.education.category.AppEducationCategoryList1Adapter
import com.panaceasoft.pskotlinmaterial.repository.education.EducationCategoryListWithCourseRepository
import java.util.*

class AppEducationCategoryList1Activity : AppCompatActivity() {

    lateinit var appEducationCategoryList1Adapter: AppEducationCategoryList1Adapter
    lateinit var expListView: ExpandableListView
    lateinit var listDataHeader: MutableList<String>
    lateinit var listDataChild: HashMap<String, List<EducationCategoryListWithCourse.Course>>
    lateinit var educationCategoryListWithCourseList: List<EducationCategoryListWithCourse>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_education_category_list_1_activity)

        initData()

        initUI()

        initDataBindings()

        initActions()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(applicationContext, item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initData() {
        educationCategoryListWithCourseList = EducationCategoryListWithCourseRepository.categoryList

        prepareListData()


    }

    private fun initUI() {
        initToolbar()

        expListView = findViewById(R.id.lvExp)

    }

    private fun initDataBindings() {
        appEducationCategoryList1Adapter = AppEducationCategoryList1Adapter(this, listDataHeader, listDataChild)

        expListView.setAdapter(appEducationCategoryList1Adapter)
    }

    private fun initActions() {
        expListView.setOnGroupClickListener { _, _, _, _ -> false }

        expListView.setOnGroupExpandListener { groupPosition ->
            Toast.makeText(applicationContext,
                    listDataHeader[groupPosition] + " Expanded",
                    Toast.LENGTH_SHORT).show()
        }

        expListView.setOnGroupCollapseListener { groupPosition ->
            Toast.makeText(applicationContext,
                    listDataHeader[groupPosition] + " Collapsed",
                    Toast.LENGTH_SHORT).show()
        }

        expListView.setOnChildClickListener { _, _, groupPosition, childPosition, _ ->
            Toast.makeText(
                    applicationContext,
                    listDataHeader[groupPosition]
                            + " : "
                            + listDataChild[listDataHeader[groupPosition]]!![childPosition].courseName, Toast.LENGTH_SHORT)
                    .show()
            false
        }
    }


    /*
     * Preparing the list data
     */
    private fun prepareListData() {

        listDataHeader = ArrayList()
        listDataChild = HashMap<String, List<EducationCategoryListWithCourse.Course>>()

        for (i in educationCategoryListWithCourseList.indices) {
            listDataHeader.add(educationCategoryListWithCourseList[i].category_name)
            listDataChild[educationCategoryListWithCourseList[i].category_name] = educationCategoryListWithCourseList[i].courseList
        }

    }

    //region Init Toolbar
    private fun initToolbar() {

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Category List 1"

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