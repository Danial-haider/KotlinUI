package com.panaceasoft.pskotlinmaterial.fragment.application.education.home.home3


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
import com.panaceasoft.pskotlinmaterial.adapter.application.education.home.home3.AppEducationHome3CoursesAdapter
import com.panaceasoft.pskotlinmaterial.adapter.application.education.home.home3.AppEducationHome3SavedCourseAdapter
import com.panaceasoft.pskotlinmaterial.adapter.application.education.home.home3.AppEducationHome3VideoAdapter
import com.panaceasoft.pskotlinmaterial.`object`.Course
import com.panaceasoft.pskotlinmaterial.`object`.EducationVideo
import com.panaceasoft.pskotlinmaterial.repository.education.CourseListRepository
import com.panaceasoft.pskotlinmaterial.repository.education.EducationVideoListRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils

/**
 * A simple [Fragment] subclass.
 */
class AppEducationHome3Fragment1 : Fragment() {

    private lateinit var course: Course

    private lateinit var appEducationHome1CoursesAdapter: AppEducationHome3CoursesAdapter
    private lateinit var appEducationHome2CoursesAdapter: AppEducationHome3VideoAdapter
    private lateinit var appEducationHome3CoursesAdapter: AppEducationHome3SavedCourseAdapter

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
        val view = inflater.inflate(R.layout.app_education_home_3_fragment_1, container, false)

        initData()

        initUI(view)

        initDataBindings()

        initActions()

        return view
    }

    private fun initData() {

        course = CourseListRepository.courseList[0]
        appEducationHome1CoursesAdapter = AppEducationHome3CoursesAdapter(CourseListRepository.courseList, 3)

        appEducationHome2CoursesAdapter = AppEducationHome3VideoAdapter(EducationVideoListRepository.educationVideoList, 10)

        appEducationHome3CoursesAdapter = AppEducationHome3SavedCourseAdapter(CourseListRepository.courseList, 10)
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
        //savedVideoRecyclerView.setItemAnimator(new DefaultItemAnimator());
        savedVideoRecyclerView.isNestedScrollingEnabled = false

        val mLayoutManager3 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        savedCourseRecyclerView = view.findViewById(R.id.savedCourseRecyclerView)
        savedCourseRecyclerView.layoutManager = mLayoutManager3
        ///savedCourseRecyclerView.setItemAnimator(new DefaultItemAnimator());
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
        enrollmentRecyclerView.adapter = appEducationHome1CoursesAdapter

        savedVideoRecyclerView.adapter = appEducationHome2CoursesAdapter

        savedCourseRecyclerView.adapter = appEducationHome3CoursesAdapter

        titleTextView.text = course.title
        lengthTextView.text = "Course - " + course.length
        viewCountTextView.text = course.viewCount + " Viewers"

        val id = Utils.getDrawableInt(context, course.image)
        Utils.setImageToImageView(context!!, courseImageView, id)

    }

    private fun initActions() {

        appEducationHome1CoursesAdapter.setOnItemClickListener(object :AppEducationHome3CoursesAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: Course, position: Int) {
                Toast.makeText(context, "Selected : " + obj.title, Toast.LENGTH_SHORT).show()
            }
        })

        appEducationHome2CoursesAdapter.setOnItemClickListener(object : AppEducationHome3VideoAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: EducationVideo, position: Int) {
                Toast.makeText(context, "Selected : " + obj.title, Toast.LENGTH_SHORT).show()
            }
        })

        appEducationHome3CoursesAdapter.setOnItemClickListener(object : AppEducationHome3SavedCourseAdapter.OnItemClickListener{
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

