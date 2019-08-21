package com.panaceasoft.pskotlinmaterial.fragment.application.news.home


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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.News
import com.panaceasoft.pskotlinmaterial.`object`.NewsCategory
import com.panaceasoft.pskotlinmaterial.adapter.application.news.home.home1.AppNewsHome1CategoryAdapter
import com.panaceasoft.pskotlinmaterial.adapter.application.news.home.home1.AppNewsHome1CoverFlowPagerAdapter
import com.panaceasoft.pskotlinmaterial.adapter.application.news.home.home1.AppNewsHome1NewsAdapter
import com.panaceasoft.pskotlinmaterial.repository.news.NewsCategoryRepository
import com.panaceasoft.pskotlinmaterial.repository.news.NewsRepository

/**
 * A simple [Fragment] subclass.
 */
class AppNewsHome1Fragment : Fragment() {

    private lateinit var appNewsHome1CoverFlowPagerAdapter: AppNewsHome1CoverFlowPagerAdapter
    private lateinit var imageViewPager: ViewPager
    private lateinit var pager_indicator: LinearLayout
    private lateinit var dots: Array<ImageView?>
    private  var dotsCount: Int = 0

    private lateinit var appNewsHome1CategoryAdapter: AppNewsHome1CategoryAdapter
    private lateinit var categoryList: List<NewsCategory>
    private lateinit var categoryRecyclerView: RecyclerView

    private lateinit var editorPickedViewAllTextView: TextView
    private lateinit var viewAllCategoryTextView: TextView
    private lateinit var viewAllRecentNewsTextView: TextView

    // data
    internal lateinit var newsList: List<News>
    internal lateinit var itemAdapter: AppNewsHome1NewsAdapter

    // RecyclerView
    internal lateinit var itemsRecyclerView: RecyclerView

    internal  var noOfColumn = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.app_news_home_1_fragment, container, false)

        initData()

        initUI(view)

        initDataBindings()

        initActions()

        return view
    }

    private fun initData() {

        newsList = NewsRepository.newsList

        val editorPickedNewsList = NewsRepository.newsList

        appNewsHome1CoverFlowPagerAdapter = AppNewsHome1CoverFlowPagerAdapter(context, editorPickedNewsList)

        categoryList = NewsCategoryRepository.newsCategoryList

        appNewsHome1CategoryAdapter = AppNewsHome1CategoryAdapter(categoryList)
    }

    private fun initUI(view: View) {


        imageViewPager = view.findViewById(R.id.imageViewPager)
        imageViewPager.setPadding(60, 0, 60, 0)
        imageViewPager.clipToPadding = false
        imageViewPager.pageMargin = 25

        pager_indicator = view.findViewById(R.id.viewPagerCountDots)


        // get item list featuredAdapter
        itemAdapter = AppNewsHome1NewsAdapter(newsList)

        if (activity != null) {

            // get Item recycler view
            itemsRecyclerView = view.findViewById(R.id.recyclerView)
            val mLayoutManagerForItems = GridLayoutManager(activity?.applicationContext, noOfColumn)

            itemsRecyclerView.layoutManager = mLayoutManagerForItems
            itemsRecyclerView.itemAnimator = DefaultItemAnimator()
            itemsRecyclerView.isNestedScrollingEnabled = false
        }

        // get featured recycler view
        categoryRecyclerView = view.findViewById(R.id.categoryRecyclerView)
        val mLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        categoryRecyclerView.layoutManager = mLayoutManager
        categoryRecyclerView.itemAnimator = DefaultItemAnimator()
        categoryRecyclerView.isNestedScrollingEnabled = false

        editorPickedViewAllTextView = view.findViewById(R.id.editorPickedViewAllTextView)
        viewAllCategoryTextView = view.findViewById(R.id.viewAllCategoryTextView)
        viewAllRecentNewsTextView = view.findViewById(R.id.viewAllRecentNewsTextView)

    }

    private fun initDataBindings() {
        // bind items
        itemsRecyclerView.adapter = itemAdapter

        imageViewPager.adapter = appNewsHome1CoverFlowPagerAdapter

        setupSliderPagination()

        categoryRecyclerView.adapter = appNewsHome1CategoryAdapter
    }

    private fun initActions() {

        itemAdapter.setOnItemClickListener(object : AppNewsHome1NewsAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: News, position: Int) {
                Toast.makeText(context, "Clicked: " + obj.title, Toast.LENGTH_SHORT).show()
            }
        })

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

        appNewsHome1CategoryAdapter.setOnItemClickListener(object : AppNewsHome1CategoryAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: NewsCategory, position: Int) {
                Toast.makeText(context, "Selected : " + obj.category, Toast.LENGTH_SHORT).show()
            }
        })


        appNewsHome1CoverFlowPagerAdapter.setOnItemClickListener(object : AppNewsHome1CoverFlowPagerAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: News, position: Int) {
                Toast.makeText(context, "Selected : " + obj.title, Toast.LENGTH_SHORT).show()
            }
        })

        editorPickedViewAllTextView.setOnClickListener {  Toast.makeText(context, "Clicked View All Editor Picked News.", Toast.LENGTH_SHORT).show() }

        viewAllCategoryTextView.setOnClickListener {  Toast.makeText(context, "Clicked View All Category.", Toast.LENGTH_SHORT).show() }

        viewAllRecentNewsTextView.setOnClickListener {  Toast.makeText(context, "Clicked View All Recent News.", Toast.LENGTH_SHORT).show() }
    }

    fun setupSliderPagination() {

        dotsCount = appNewsHome1CoverFlowPagerAdapter.count

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
