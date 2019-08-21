package com.panaceasoft.pskotlinmaterial.activity.application.education.outline

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.EducationCourseOutlineHolder
import com.panaceasoft.pskotlinmaterial.adapter.application.education.outline.AppEducationOutline1Adapter
import com.panaceasoft.pskotlinmaterial.repository.education.EducationCourseOutlineRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_education_outline_1_activity.*
import java.util.*

class AppEducationOutline1Activity : AppCompatActivity() {

    // data and adapter
    internal lateinit var videoList: MutableList<EducationCourseOutlineHolder>
    internal lateinit var adapter: AppEducationOutline1Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_education_outline_1_activity)

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
        videoList = ArrayList()
        val educationCourseOutlineList = EducationCourseOutlineRepository.educationCourseOutlineList

        for (i in educationCourseOutlineList!!.indices) {

            videoList.add(EducationCourseOutlineHolder(educationCourseOutlineList[i].courseName, true))

            val maxCourseSize = educationCourseOutlineList[i].courseList.size - 1
            for (j in educationCourseOutlineList[i].courseList.indices) {
                if (j == 0) {
                    videoList.add(EducationCourseOutlineHolder(educationCourseOutlineList[i].courseName, educationCourseOutlineList[i].courseList[j], false, true, false))
                } else if (j == maxCourseSize) {
                    videoList.add(EducationCourseOutlineHolder(educationCourseOutlineList[i].courseName, educationCourseOutlineList[i].courseList[j], false, false, true))
                } else {
                    videoList.add(EducationCourseOutlineHolder(educationCourseOutlineList[i].courseName, educationCourseOutlineList[i].courseList[j], false, false, false))
                }
            }
        }

    }

    private fun initUI() {
        initToolbar()

        // get list adapter
        adapter = AppEducationOutline1Adapter(videoList)

        // get recycler view
        val mLayoutManager = LinearLayoutManager(applicationContext)
        videoRecyclerView.layoutManager = mLayoutManager
        videoRecyclerView.itemAnimator = DefaultItemAnimator()

    }

    private fun initDataBindings() {
        // bind adapter to recycler
        videoRecyclerView.adapter = adapter

        Utils.setCircleImageToImageView(this, courseImageView!!, R.drawable.education_img_1, 25, R.color.md_white_1000)
    }

    private fun initActions() {
        adapter.setOnItemClickListener(object : AppEducationOutline1Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: EducationCourseOutlineHolder, position: Int) {
                Toast.makeText(applicationContext, "Clicked " + obj.course.videoName!!, Toast.LENGTH_SHORT).show()
            }
        })
    }


    //region Init Toolbar
    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Course Outline 1"

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

