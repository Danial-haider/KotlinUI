package com.panaceasoft.pskotlinmaterial.fragment.feature.dashboard.education.home3


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Course
import com.panaceasoft.pskotlinmaterial.`object`.EducationVideo
import com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.education.home3.FeatureDashboardEducationDashboard3CoursesAdapter
import com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.education.home3.FeatureDashboardEducationDashboard3SavedCourseAdapter
import com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.education.home3.FeatureDashboardEducationDashboard3VideoAdapter
import com.panaceasoft.pskotlinmaterial.repository.education.CourseListRepository
import com.panaceasoft.pskotlinmaterial.repository.education.EducationVideoListRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils

/**
 * A simple [Fragment] subclass.
 */
class FeatureDashboardEducationDashboard3Fragment1 : Fragment() {

    private lateinit var course: Course

    private lateinit var featureDashboardEducationDashboard3CoursesAdapter: FeatureDashboardEducationDashboard3CoursesAdapter
    private lateinit var featureDashboardEducationDashboard3VideoAdapter: FeatureDashboardEducationDashboard3VideoAdapter
    private lateinit var featureDashboardEducationDashboard3SavedCourseAdapter: FeatureDashboardEducationDashboard3SavedCourseAdapter

    // RecyclerView
    private lateinit var enrollmentRecyclerView: RecyclerView
    private lateinit var savedVideoRecyclerView: RecyclerView
    private lateinit var savedCourseRecyclerView: RecyclerView

    private lateinit var viewAllEnrollmentsTextView: TextView
    private lateinit var viewAllVideoTextView: TextView
    private lateinit var viewAllCoursesTextView: TextView

    private lateinit var courseImageView: ImageView
    private lateinit var bookmarkImageView: ImageView

    private lateinit var lengthTextView: TextView
    private lateinit var titleTextView: TextView
    private lateinit var viewCountTextView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.feature_dashboard_education_dashboard_3_fragment_1, container, false)

        initData()

        initUI(view)

        initDataBindings()

        initActions()

        return view
    }

    private fun initData() {

        course = CourseListRepository.courseList[0]
        featureDashboardEducationDashboard3CoursesAdapter = FeatureDashboardEducationDashboard3CoursesAdapter(CourseListRepository.courseList, 3)

        featureDashboardEducationDashboard3VideoAdapter = FeatureDashboardEducationDashboard3VideoAdapter(EducationVideoListRepository.educationVideoList, 10)

        featureDashboardEducationDashboard3SavedCourseAdapter = FeatureDashboardEducationDashboard3SavedCourseAdapter(CourseListRepository.courseList, 10)
    }

    private fun initUI(view: View) {

        val mLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        enrollmentRecyclerView = view.findViewById(R.id.enrollmentRecyclerView)
        enrollmentRecyclerView.layoutManager = mLayoutManager
        enrollmentRecyclerView.itemAnimator = DefaultItemAnimator()
        enrollmentRecyclerView.isNestedScrollingEnabled = false

        val mLayoutManager2 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        savedVideoRecyclerView = view.findViewById(R.id.savedVideoRecyclerView)
        savedVideoRecyclerView.layoutManager = mLayoutManager2
        savedVideoRecyclerView.isNestedScrollingEnabled = false

        val mLayoutManager3 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        savedCourseRecyclerView = view.findViewById(R.id.savedCourseRecyclerView)
        savedCourseRecyclerView.layoutManager = mLayoutManager3
        savedCourseRecyclerView.isNestedScrollingEnabled = false

        viewAllEnrollmentsTextView = view.findViewById(R.id.viewAllEnrollmentsTextView)
        viewAllVideoTextView = view.findViewById(R.id.viewAllVideoTextView)
        viewAllCoursesTextView = view.findViewById(R.id.viewAllCoursesTextView)

        courseImageView = view.findViewById(R.id.courseImageView)
        bookmarkImageView = view.findViewById(R.id.bookmarkImageView)

        lengthTextView = view.findViewById(R.id.lengthTextView)
        titleTextView = view.findViewById(R.id.titleTextView)
        viewCountTextView = view.findViewById(R.id.viewCountTextView)

    }

    private fun initDataBindings() {
        // bind items
        enrollmentRecyclerView.adapter = featureDashboardEducationDashboard3CoursesAdapter

        savedVideoRecyclerView.adapter = featureDashboardEducationDashboard3VideoAdapter

        savedCourseRecyclerView.adapter = featureDashboardEducationDashboard3SavedCourseAdapter

        titleTextView.text = course.title
        lengthTextView.text = "Course - " + course.length
        viewCountTextView.text = course.viewCount + " Viewers"

        val id = Utils.getDrawableInt(context, course.image)
        Utils.setImageToImageView(context!!, courseImageView, id)

    }

    private fun initActions() {

        featureDashboardEducationDashboard3CoursesAdapter.setOnItemClickListener(object : FeatureDashboardEducationDashboard3CoursesAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: Course, position: Int) {
                Toast.makeText(context, "Selected : " + obj.title, Toast.LENGTH_SHORT).show()
            }
        })

        featureDashboardEducationDashboard3VideoAdapter.setOnItemClickListener(object :FeatureDashboardEducationDashboard3VideoAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: EducationVideo, position: Int) {
                Toast.makeText(context, "Selected : " + obj.title, Toast.LENGTH_SHORT).show()
            }
        })


        featureDashboardEducationDashboard3SavedCourseAdapter.setOnItemClickListener(object :FeatureDashboardEducationDashboard3SavedCourseAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: Course, position: Int) {
                Toast.makeText(context, "Selected : " + obj.title, Toast.LENGTH_SHORT).show()
            }
        })

        viewAllEnrollmentsTextView.setOnClickListener {  Toast.makeText(context, "Clicked View All My Enrollments.", Toast.LENGTH_SHORT).show() }

        viewAllVideoTextView.setOnClickListener {  Toast.makeText(context, "Clicked View All Saved Videos.", Toast.LENGTH_SHORT).show() }

        viewAllCoursesTextView.setOnClickListener {  Toast.makeText(context, "Clicked View All Saved Courses.", Toast.LENGTH_SHORT).show() }

        bookmarkImageView.setOnClickListener {  Toast.makeText(context, "Clicked bookmark.", Toast.LENGTH_SHORT).show() }
    }


}// Required empty public constructor