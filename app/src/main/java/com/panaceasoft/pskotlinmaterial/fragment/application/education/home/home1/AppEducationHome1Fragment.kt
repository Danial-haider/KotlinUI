package com.panaceasoft.pskotlinmaterial.fragment.application.education.home.home1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Course
import com.panaceasoft.pskotlinmaterial.adapter.application.education.home.home1.AppEducationHome1CoursesAdapter
import com.panaceasoft.pskotlinmaterial.adapter.application.education.home.home1.AppEducationHome1CoverFlowPagerAdapter
import com.panaceasoft.pskotlinmaterial.repository.education.CourseListRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils

/**
 * Created by Panacea-Soft on 8/18/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class AppEducationHome1Fragment : Fragment() {


    private lateinit var imageViewPager: ViewPager
    private lateinit var pager_indicator: LinearLayout
    private lateinit var dots: Array<ImageView?>
    private  var dotsCount: Int = 0

    private lateinit var appEducationHome1CoverFlowPagerAdapter: AppEducationHome1CoverFlowPagerAdapter
    private lateinit var appEducationHome1CoursesAdapter: AppEducationHome1CoursesAdapter
    private lateinit var appEducationHome2CoursesAdapter: AppEducationHome1CoursesAdapter
    private lateinit var appEducationHome3CoursesAdapter: AppEducationHome1CoursesAdapter

    // RecyclerView
    private lateinit var newCourseRecyclerView: RecyclerView
    private lateinit var topRatedCourseRecyclerView: RecyclerView
    private lateinit var trendingRecyclerView: RecyclerView

    private lateinit var viewAllRecommendedCourseTextView: TextView
    private lateinit var viewAllNewCourseTextView: TextView
    private lateinit var viewAllTopRatedCourseTextView: TextView
    private lateinit var viewAllTrendingCourseTextView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.app_education_home_1_fragment, container, false)

        initData()

        initUI(view)

        initDataBindings()

        initActions()

        return view
    }

    private fun initData() {

        appEducationHome1CoverFlowPagerAdapter = AppEducationHome1CoverFlowPagerAdapter(context, CourseListRepository.courseList)

        appEducationHome1CoursesAdapter = AppEducationHome1CoursesAdapter(CourseListRepository.courseList)

        appEducationHome2CoursesAdapter = AppEducationHome1CoursesAdapter(CourseListRepository.courseList)

        appEducationHome3CoursesAdapter = AppEducationHome1CoursesAdapter(CourseListRepository.courseList)
    }

    private fun initUI(view: View) {


        imageViewPager = view.findViewById(R.id.imageViewPager)

        if (context != null) {
            val paddingValue = Utils.dpToPx(context!!, 16)
            val marginValue = Utils.dpToPx(context!!, 8)
            imageViewPager.setPadding(paddingValue, 0, paddingValue, 0)
            imageViewPager.clipToPadding = false
            imageViewPager.pageMargin = marginValue
        }

        pager_indicator = view.findViewById(R.id.viewPagerCountDots)


        val mLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        newCourseRecyclerView = view.findViewById(R.id.topRatedRecyclerView)
        topRatedCourseRecyclerView = view.findViewById(R.id.newCourseRecyclerView)
        topRatedCourseRecyclerView.layoutManager = mLayoutManager
        topRatedCourseRecyclerView.itemAnimator = DefaultItemAnimator()
        topRatedCourseRecyclerView.isNestedScrollingEnabled = false

        val mLayoutManager2 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        newCourseRecyclerView.layoutManager = mLayoutManager2
        newCourseRecyclerView.itemAnimator = DefaultItemAnimator()
        newCourseRecyclerView.isNestedScrollingEnabled = false

        val mLayoutManager3 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        trendingRecyclerView = view.findViewById(R.id.trendingRecyclerView)
        trendingRecyclerView.layoutManager = mLayoutManager3
        trendingRecyclerView.itemAnimator = DefaultItemAnimator()
        trendingRecyclerView.isNestedScrollingEnabled = false

        viewAllRecommendedCourseTextView = view.findViewById(R.id.viewAllRecommendedCourseTextView)
        viewAllNewCourseTextView = view.findViewById(R.id.viewAllNewCourseTextView)
        viewAllTopRatedCourseTextView = view.findViewById(R.id.viewAllTopRatedCourseTextView)
        viewAllTrendingCourseTextView = view.findViewById(R.id.viewAllTrendingCourseTextView)

    }

    private fun initDataBindings() {
        // bind items
        newCourseRecyclerView.adapter = appEducationHome1CoursesAdapter

        imageViewPager.adapter = appEducationHome1CoverFlowPagerAdapter

        setupSliderPagination()

        topRatedCourseRecyclerView.adapter = appEducationHome2CoursesAdapter

        trendingRecyclerView.adapter = appEducationHome3CoursesAdapter

    }

    private fun initActions() {

        imageViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {

                    setupSliderPagination()


                for (i in 0 until dotsCount) {
                    dots[i]?.setImageDrawable(ContextCompat.getDrawable(context!!,R.drawable.nonselecteditem_dot))
                }

                dots[position]?.setImageDrawable(ContextCompat.getDrawable(context!!,R.drawable.selecteditem_dot))
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        appEducationHome1CoursesAdapter.setOnItemClickListener(object : AppEducationHome1CoursesAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: Course, position: Int) {
                Toast.makeText(context, "Selected : " + obj.title, Toast.LENGTH_SHORT).show()
            }
        })

        appEducationHome2CoursesAdapter.setOnItemClickListener(object :AppEducationHome1CoursesAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: Course, position: Int) {
                Toast.makeText(context, "Selected : " + obj.title, Toast.LENGTH_SHORT).show()
            }
        })

        appEducationHome3CoursesAdapter.setOnItemClickListener(object : AppEducationHome1CoursesAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: Course, position: Int) {
                Toast.makeText(context, "Selected : " + obj.title, Toast.LENGTH_SHORT).show()
            }
        })

        appEducationHome1CoverFlowPagerAdapter.setOnItemClickListener(object : AppEducationHome1CoverFlowPagerAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: Course, position: Int) {
                Toast.makeText(context, "Selected : " + obj.title, Toast.LENGTH_SHORT).show()
            }
        })

        viewAllRecommendedCourseTextView.setOnClickListener {  Toast.makeText(context, "Clicked View All Recommended Courses.", Toast.LENGTH_SHORT).show() }

        viewAllNewCourseTextView.setOnClickListener {  Toast.makeText(context, "Clicked View All New Courses.", Toast.LENGTH_SHORT).show() }

        viewAllTopRatedCourseTextView.setOnClickListener {  Toast.makeText(context, "Clicked View All Top Rated Courses.", Toast.LENGTH_SHORT).show() }

        viewAllTrendingCourseTextView.setOnClickListener {  Toast.makeText(context, "Clicked View All Trending Courses.", Toast.LENGTH_SHORT).show() }
    }

    fun setupSliderPagination() {

        dotsCount = appEducationHome1CoverFlowPagerAdapter.count

        if (dotsCount > 0) {

            dots = arrayOfNulls(dotsCount)


                if (pager_indicator.childCount > 0) {
                    pager_indicator.removeAllViewsInLayout()

            }

            for (i in 0 until dotsCount) {
                dots[i] = ImageView(context)
                dots[i]?.setImageDrawable(ContextCompat.getDrawable(context!!,R.drawable.nonselecteditem_dot))

                val params = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )

                params.setMargins(4, 0, 4, 0)

                pager_indicator.addView(dots[i], params)
            }

            dots[0]?.setImageDrawable(ContextCompat.getDrawable(context!!,R.drawable.selecteditem_dot))

        }

    }


}// Required empty public constructor
