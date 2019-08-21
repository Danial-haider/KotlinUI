package com.panaceasoft.pskotlinmaterial.fragment.feature.dashboard.education.home3


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.education.home3.FeatureDashboardEducationDashboard3CoursesAdapter
import com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.education.home3.FeatureDashboardEducationDashboard3VideoAdapter
import com.panaceasoft.pskotlinmaterial.`object`.Course
import com.panaceasoft.pskotlinmaterial.`object`.EducationVideo
import com.panaceasoft.pskotlinmaterial.repository.education.CourseListRepository
import com.panaceasoft.pskotlinmaterial.repository.education.EducationVideoListRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils

/**
 * A simple [Fragment] subclass.
 */
class FeatureDashboardEducationDashboard3Fragment2 : Fragment() {

    private lateinit var course: Course

    private lateinit var featureDashboardEducationDashboard3VideoAdapter: FeatureDashboardEducationDashboard3VideoAdapter
    private lateinit var featureDashboardEducationDashboard3CoursesAdapter: FeatureDashboardEducationDashboard3CoursesAdapter


    // RecyclerView
    private lateinit var recommendedRecyclerView: RecyclerView
    private lateinit var editorPicksRecyclerView: RecyclerView

    private lateinit var viewAllRecommendedVideoTextView: TextView
    private lateinit var viewAllEditorPicksTextView: TextView

    private lateinit var courseImageView: ImageView
    private lateinit var bookmarkImageView: ImageView

    private lateinit var lengthTextView: TextView
    private lateinit var titleTextView: TextView
    private lateinit var viewCountTextView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.feature_dashboard_education_dashboard_3_fragment_2, container, false)

        initData()

        initUI(view)

        initDataBindings()

        initActions()

        return view
    }

    private fun initData() {

        course = CourseListRepository.courseList[0]
        featureDashboardEducationDashboard3VideoAdapter = FeatureDashboardEducationDashboard3VideoAdapter(EducationVideoListRepository.educationVideoList, 10)

        featureDashboardEducationDashboard3CoursesAdapter = FeatureDashboardEducationDashboard3CoursesAdapter(CourseListRepository.courseList, 10)

    }

    private fun initUI(view: View) {

        val mLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recommendedRecyclerView = view.findViewById(R.id.recommendedRecyclerView)
        recommendedRecyclerView.layoutManager = mLayoutManager
        recommendedRecyclerView.itemAnimator = DefaultItemAnimator()
        recommendedRecyclerView.isNestedScrollingEnabled = false

        val mLayoutManager2 = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        editorPicksRecyclerView = view.findViewById(R.id.editorPicksRecyclerView)
        editorPicksRecyclerView.layoutManager = mLayoutManager2
        editorPicksRecyclerView.itemAnimator = DefaultItemAnimator()
        editorPicksRecyclerView.isNestedScrollingEnabled = false

        viewAllRecommendedVideoTextView = view.findViewById(R.id.viewAllRecommendedVideoTextView)
        viewAllEditorPicksTextView = view.findViewById(R.id.viewAllEditorPicksTextView)

        courseImageView = view.findViewById(R.id.courseImageView)
        bookmarkImageView = view.findViewById(R.id.bookmarkImageView)

        lengthTextView = view.findViewById(R.id.lengthTextView)
        titleTextView = view.findViewById(R.id.titleTextView)
        viewCountTextView = view.findViewById(R.id.viewCountTextView)

    }

    private fun initDataBindings() {
        // bind items
        recommendedRecyclerView.adapter = featureDashboardEducationDashboard3VideoAdapter

        editorPicksRecyclerView.adapter = featureDashboardEducationDashboard3CoursesAdapter

        titleTextView.text = course.title
        lengthTextView.text = "Course - " + course.length
        viewCountTextView.text = course.viewCount + " Viewers"

        val id = Utils.getDrawableInt(context, course.image)
        Utils.setImageToImageView(context!!, courseImageView, id)

    }

    private fun initActions() {
        featureDashboardEducationDashboard3VideoAdapter.setOnItemClickListener(object:FeatureDashboardEducationDashboard3VideoAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: EducationVideo, position: Int) {
                Toast.makeText(context, "Selected : " + obj.title, Toast.LENGTH_SHORT).show()
            }
        })

        featureDashboardEducationDashboard3CoursesAdapter.setOnItemClickListener(object : FeatureDashboardEducationDashboard3CoursesAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: Course, position: Int) {
                Toast.makeText(context, "Selected : " + obj.title, Toast.LENGTH_SHORT).show()
            }
        })

        viewAllRecommendedVideoTextView.setOnClickListener {  Toast.makeText(context, "Clicked View All New Recommended Videos.", Toast.LENGTH_SHORT).show() }

        viewAllEditorPicksTextView.setOnClickListener {  Toast.makeText(context, "Clicked View All Editor Picks.", Toast.LENGTH_SHORT).show() }

        bookmarkImageView.setOnClickListener {  Toast.makeText(context, "Clicked bookmark.", Toast.LENGTH_SHORT).show() }
    }


}// Required empty public constructor

