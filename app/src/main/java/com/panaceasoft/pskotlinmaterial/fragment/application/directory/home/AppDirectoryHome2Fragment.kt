package com.panaceasoft.pskotlinmaterial.fragment.application.directory.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Place
import com.panaceasoft.pskotlinmaterial.adapter.application.directory.home.AppDirectoryHome2PagerAdapter
import com.panaceasoft.pskotlinmaterial.repository.directory.PlaceRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils


/**
 * A simple [Fragment] subclass.
 */
class AppDirectoryHome2Fragment : Fragment() {

    private lateinit var pagerAdapter: AppDirectoryHome2PagerAdapter
    private lateinit var imageViewPager: ViewPager

    private lateinit var pagerIndicator: LinearLayout
    private lateinit var dots: Array<ImageView?>
    private var dotsCount: Int = 0

    private lateinit var savedConstraintLayout: ConstraintLayout
    private lateinit var likedConstraintLayout: ConstraintLayout
    private lateinit var discoverMoreTextView: TextView

    // data variables
    internal lateinit var placeList: List<Place>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.app_directory_home_2_fragment, container, false)

        initData()

        initUI(view)

        initDataBinding()

        initActions()

        return view

    }

    private fun initData() {
        // get featured Item List
        placeList = PlaceRepository.placeList

        pagerAdapter = AppDirectoryHome2PagerAdapter(context, placeList)
    }

    private fun initUI(view: View) {

        imageViewPager = view.findViewById(R.id.imageViewPager)

        pagerIndicator = view.findViewById(R.id.viewPagerCountDots)

        discoverMoreTextView = view.findViewById(R.id.discoverMoreTextView)

        // Saved Cell Group
        val savedImageView1 = view.findViewById<ImageView>(R.id.savedImageView1)
        var logoId = R.drawable.dir_shop_logo_1
        Utils.setCornerRadiusImageToImageView(view.context, savedImageView1, logoId, 10, 2, R.color.md_grey_200)

        val savedImageView2 = view.findViewById<ImageView>(R.id.savedImageView2)
        logoId = R.drawable.dir_shop_logo_2
        Utils.setCornerRadiusImageToImageView(view.context, savedImageView2, logoId, 10, 2, R.color.md_grey_200)

        val savedImageView3 = view.findViewById<ImageView>(R.id.savedImageView3)
        logoId = R.drawable.dir_shop_logo_3
        Utils.setCornerRadiusImageToImageView(view.context, savedImageView3, logoId, 10, 2, R.color.md_grey_200)

        val savedImageView4 = view.findViewById<ImageView>(R.id.savedImageView4)
        logoId = R.drawable.dir_shop_logo_4
        Utils.setCornerRadiusImageToImageView(view.context, savedImageView4, logoId, 10, 2, R.color.md_grey_200)

        savedConstraintLayout = view.findViewById(R.id.savedConstraintLayout)


        // Liked Cell Group
        val likedImageView1 = view.findViewById<ImageView>(R.id.likedImageView1)
        logoId = R.drawable.dir_shop_logo_5
        Utils.setCornerRadiusImageToImageView(view.context, likedImageView1, logoId, 10, 2, R.color.md_grey_200)

        val likedImageView2 = view.findViewById<ImageView>(R.id.likedImageView2)
        logoId = R.drawable.dir_shop_logo_4
        Utils.setCornerRadiusImageToImageView(view.context, likedImageView2, logoId, 10, 2, R.color.md_grey_200)

        val likedImageView3 = view.findViewById<ImageView>(R.id.likedImageView3)
        logoId = R.drawable.dir_shop_logo_3
        Utils.setCornerRadiusImageToImageView(view.context, likedImageView3, logoId, 10, 2, R.color.md_grey_200)

        val likedImageView4 = view.findViewById<ImageView>(R.id.likedImageView4)
        logoId = R.drawable.dir_shop_logo_2
        Utils.setCornerRadiusImageToImageView(view.context, likedImageView4, logoId, 10, 2, R.color.md_grey_200)

        likedConstraintLayout = view.findViewById(R.id.likedConstraintLayout)

        // Shape Image View
        val shapedImageView = view.findViewById<ImageView>(R.id.savedImageView5)
        val shapedImageView2 = view.findViewById<ImageView>(R.id.likedImageView5)
        if (Utils.isRTL) {
            shapedImageView.rotationY = 180f
            shapedImageView2.rotationY = 180f
        }

        // Profile
        val profileImage1 = view.findViewById<ImageView>(R.id.savedImageView6)
        val profileImage2 = view.findViewById<ImageView>(R.id.likedImageView6)

        Utils.setCornerRadiusImageToImageView(view.context, profileImage1, R.drawable.profile1, 10, 10, R.color.colorPrimary)
        Utils.setCornerRadiusImageToImageView(view.context, profileImage2, R.drawable.profile1, 10, 10, R.color.colorPrimary)


    }

    private fun initDataBinding() {
        imageViewPager.adapter = pagerAdapter

        setupSliderPagination()
    }

    private fun initActions() {

        savedConstraintLayout.setOnClickListener { Toast.makeText(context, "Clicked Saved Collection", Toast.LENGTH_SHORT).show() }
        likedConstraintLayout.setOnClickListener { Toast.makeText(context, "Clicked Liked Collection", Toast.LENGTH_SHORT).show() }
        discoverMoreTextView.setOnClickListener { Toast.makeText(context, "Clicked Discover More", Toast.LENGTH_SHORT).show() }

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


        pagerAdapter.setOnItemClickListener(object : AppDirectoryHome2PagerAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: Place, position: Int) {
                Toast.makeText(context, "Clicked : " + obj.imageName, Toast.LENGTH_SHORT).show()
            }
        })

    }

    fun setupSliderPagination() {

        dotsCount = pagerAdapter.count

        if (dotsCount > 0) {

            dots = arrayOfNulls(dotsCount)


                if (pagerIndicator.childCount > 0) {
                    pagerIndicator.removeAllViewsInLayout()

            }

            for (i in 0 until dotsCount) {
                dots[i] = ImageView(context)
                dots[i]?.setImageDrawable(ContextCompat.getDrawable(context!!,R.drawable.nonselecteditem_dot))

                val params = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )

                params.setMargins(4, 0, 4, 0)

                pagerIndicator.addView(dots[i], params)
            }

            dots[0]?.setImageDrawable(ContextCompat.getDrawable(context!!,R.drawable.selecteditem_dot))

        }
    }
}// Required empty public constructor
