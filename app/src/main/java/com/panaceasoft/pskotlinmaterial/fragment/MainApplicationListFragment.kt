package com.panaceasoft.pskotlinmaterial.fragment


import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.MainViewObject
import com.panaceasoft.pskotlinmaterial.activity.MainActivity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.countrylist.AppDirectoryCountryList1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.countrylist.AppDirectoryCountryList2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.countrylist.AppDirectoryCountryList3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.countrylist.AppDirectoryCountryList4Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.detail.AppDirectoryDetail1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.detail.AppDirectoryDetail2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.detail.AppDirectoryDetail3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.detail.AppDirectoryDetail4Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.filter.AppDirectoryFilter1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.filter.AppDirectoryFilter2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.filter.AppDirectoryFilter3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.filter.AppDirectoryFilter4Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.gallery.AppDirectoryGallery1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.gallery.AppDirectoryGallery2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.gallery.AppDirectoryGallery3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.gallery.AppDirectoryGallery4Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.home.*
import com.panaceasoft.pskotlinmaterial.activity.application.directory.placegrid.*
import com.panaceasoft.pskotlinmaterial.activity.application.directory.placelist.*
import com.panaceasoft.pskotlinmaterial.activity.application.directory.placemap.AppDirectoryPlaceMap1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.placemap.AppDirectoryPlaceMap2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.placemap.AppDirectoryPlaceMap3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.placemap.AppDirectoryPlaceMap4Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.profile.AppDirectoryProfile1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.profile.AppDirectoryProfile2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.profile.AppDirectoryProfile3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.directory.profile.AppDirectoryProfile4Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.basket.AppECommerceBasket1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.basket.AppECommerceBasket2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.basket.AppECommerceBasket3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.basket.AppECommerceBasket4Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.category.AppECommerceCategory1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.category.AppECommerceCategory2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.category.AppECommerceCategory3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.category.AppECommerceCategory4Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.checkout.*
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.detail.*
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.filter.AppECommerceFilter1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.filter.AppECommerceFilter2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.filter.AppECommerceFilter3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.filter.AppECommerceFilter4Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.gallery.AppECommerceGallery1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.gallery.AppECommerceGallery2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.gallery.AppECommerceGallery3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.grid.*
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.home.*
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.list.*
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.order.AppECommerceOrder1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.order.AppECommerceOrder2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.order.AppECommerceOrder3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.order.AppECommerceOrder4Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.profile.AppECommerceProfile1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.shopinfo.AppECommerceShopInfo1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.ecommerce.shopinfo.AppECommerceShopInfo2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.education.aboutus.AppEducationAboutUs1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.education.category.AppEducationCategoryGrid1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.education.category.AppEducationCategoryList1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.education.coursecollection.AppEducationCourseCollectionList1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.education.coursecollection.AppEducationCourseCollectionList2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.education.detail.AppEducationDetail1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.education.detail.AppEducationDetail2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.education.detail.AppEducationDetail3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.education.grid.*
import com.panaceasoft.pskotlinmaterial.activity.application.education.home.AppEducationHome1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.education.home.AppEducationHome2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.education.home.AppEducationHome3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.education.list.*
import com.panaceasoft.pskotlinmaterial.activity.application.education.outline.AppEducationOutline1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.education.profile.AppEducationProfile1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.education.profile.AppEducationProfile2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.finance.dialog.AppFinanceDialog1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.finance.home.AppFinanceHome1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.finance.home.AppFinanceHome2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.finance.home.AppFinanceHome3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.finance.report.AppFinanceReport1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.news.aboutus.AppNewsAboutUs1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.news.category.AppNewsCategoryGrid1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.news.category.AppNewsCategoryGrid2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.news.category.AppNewsCategoryList1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.news.category.AppNewsCategoryList2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.news.detail.AppNewsDetail1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.news.detail.AppNewsDetail2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.news.detail.AppNewsDetail3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.news.detail.AppNewsDetail4Activity
import com.panaceasoft.pskotlinmaterial.activity.application.news.gallery.AppNewsGallery1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.news.gallery.AppNewsGallery2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.news.grid.*
import com.panaceasoft.pskotlinmaterial.activity.application.news.home.AppNewsHome1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.news.home.AppNewsHome2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.news.list.*
import com.panaceasoft.pskotlinmaterial.activity.application.news.timeline.AppNewsTimeline1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.user.forgotpassword.AppUserForgotPassword1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.user.forgotpassword.AppUserForgotPassword2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.user.forgotpassword.AppUserForgotPassword3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.user.forgotpassword.AppUserForgotPassword4Activity
import com.panaceasoft.pskotlinmaterial.activity.application.user.login.AppUserLogin1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.user.login.AppUserLogin2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.user.login.AppUserLogin3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.user.login.AppUserLogin4Activity
import com.panaceasoft.pskotlinmaterial.activity.application.user.profile.AppUserProfile1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.user.profile.AppUserProfile2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.user.profile.AppUserProfile3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.user.profile.AppUserProfile4Activity
import com.panaceasoft.pskotlinmaterial.activity.application.user.signup.AppUserSignUp1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.user.signup.AppUserSignUp2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.user.signup.AppUserSignUp3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.user.signup.AppUserSignUp4Activity
import com.panaceasoft.pskotlinmaterial.activity.application.wallpaper.category.AppWallpaperCategory1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.wallpaper.category.AppWallpaperCategory2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.wallpaper.category.AppWallpaperCategory3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.wallpaper.category.AppWallpaperCategory4Activity
import com.panaceasoft.pskotlinmaterial.activity.application.wallpaper.detail.AppWallpaperDetail1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.wallpaper.detail.AppWallpaperDetail2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.wallpaper.grid.*
import com.panaceasoft.pskotlinmaterial.activity.application.wallpaper.home.AppWallpaperHome1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.wallpaper.home.AppWallpaperHome2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.wallpaper.home.AppWallpaperHome3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.wallpaper.home.AppWallpaperHome4Activity
import com.panaceasoft.pskotlinmaterial.activity.application.wallpaper.list.AppWallpaperList1Activity
import com.panaceasoft.pskotlinmaterial.activity.application.wallpaper.list.AppWallpaperList2Activity
import com.panaceasoft.pskotlinmaterial.activity.application.wallpaper.list.AppWallpaperList3Activity
import com.panaceasoft.pskotlinmaterial.activity.application.wallpaper.list.AppWallpaperList4Activity
import com.panaceasoft.pskotlinmaterial.adapter.MainThirdLevelListAdapter
import com.panaceasoft.pskotlinmaterial.utils.NavigationController
import com.panaceasoft.pskotlinmaterial.utils.Utils


/**
 * A simple [Fragment] subclass.
 */
class MainApplicationListFragment : Fragment() {

    private var expandableListView: ExpandableListView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main_application_list, container, false)

        val myJson = Utils.inputStreamToString(resources.openRawResource(R.raw.main_application_list))

        val mainViewObjectList = Gson().fromJson<List<MainViewObject>>(myJson, object : TypeToken<List<MainViewObject>>() {

        }.type)

        expandableListView = view.findViewById(R.id.expandible_listview)


        // Passing third level of information to constructor

        val mainThirdLevelListAdapter = MainThirdLevelListAdapter(context!!, mainViewObjectList, object : MainThirdLevelListAdapter.CellClickCallback {
            override fun onClick(id: String) {
                cellClicked(id)
            }
        }
//                MainThirdLevelListAdapter.CellClickCallback { this.cellClicked(it) }
        )
        expandableListView?.setAdapter(mainThirdLevelListAdapter)


        val cd = ColorDrawable(ContextCompat.getColor(container!!.context!!,R.color.colorLine))
        expandableListView?.divider = cd
        expandableListView?.dividerHeight = 1
        expandableListView?.setOnGroupExpandListener(object : ExpandableListView.OnGroupExpandListener {
            internal var previousGroup = -1

            override fun onGroupExpand(groupPosition: Int) {
                if (groupPosition != previousGroup)
                    expandableListView?.collapseGroup(previousGroup)
                previousGroup = groupPosition
            }

        })

        return view

    }


    private fun cellClicked(id: String) {
        Log.d("TEAMPS", "Main UI Fragment : $id")

        if (activity is MainActivity) {
            (activity as MainActivity).userClickCount++
            Log.d("TEAMPS", (activity as MainActivity).userClickCount.toString() + "")

            if ((activity as MainActivity).userClickCount == (activity as MainActivity).limitToStartAction) {

                if ((activity as MainActivity).isAds == false) {
                    (activity as MainActivity).getCustomLayoutDialog(R.layout.activity_main_dialog_layout)
                    (activity as MainActivity).isAds = true
                } else {
                    (activity as MainActivity).showFullScreenAds()
                    (activity as MainActivity).isAds = false

                }
                (activity as MainActivity).userClickCount = 0

                return
            }
        }

        when (id) {

            "AppDirectoryHome1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryHome1Activity::class.java))

            "AppDirectoryHome2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryHome2Activity::class.java))

            "AppDirectoryHome3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryHome3Activity::class.java))

            "AppDirectoryHome4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryHome4Activity::class.java))

            "AppDirectoryHome5Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryHome5Activity::class.java))

            "AppDirectoryHome6Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryHome6Activity::class.java))

            "AppDirectoryHome7Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryHome7Activity::class.java))

            "AppDirectoryHome8Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryHome8Activity::class.java))

            "AppDirectoryHome9Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryHome9Activity::class.java))

            "AppDirectoryHome10Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryHome10Activity::class.java))

            "AppDirectoryCountryList1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryCountryList1Activity::class.java))

            "AppDirectoryCountryList2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryCountryList2Activity::class.java))

            "AppDirectoryCountryList3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryCountryList3Activity::class.java))

            "AppDirectoryCountryList4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryCountryList4Activity::class.java))

            "AppDirectoryPlaceList1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryPlaceList1Activity::class.java))

            "AppDirectoryPlaceList2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryPlaceList2Activity::class.java))

            "AppDirectoryPlaceList3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryPlaceList3Activity::class.java))

            "AppDirectoryPlaceList4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryPlaceList4Activity::class.java))

            "AppDirectoryPlaceList5Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryPlaceList5Activity::class.java))

            "AppDirectoryPlaceList6Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryPlaceList6Activity::class.java))

            "AppDirectoryPlaceList7Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryPlaceList7Activity::class.java))

            "AppDirectoryPlaceList8Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryPlaceList8Activity::class.java))

            "AppDirectoryPlaceList9Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryPlaceList9Activity::class.java))

            "AppDirectoryDetail1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryDetail1Activity::class.java))

            "AppDirectoryDetail2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryDetail2Activity::class.java))

            "AppDirectoryDetail3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryDetail3Activity::class.java))

            "AppDirectoryDetail4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryDetail4Activity::class.java))

            "AppDirectoryPlaceGrid1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryPlaceGrid1Activity::class.java))

            "AppDirectoryPlaceGrid2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryPlaceGrid2Activity::class.java))

            "AppDirectoryPlaceGrid3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryPlaceGrid3Activity::class.java))

            "AppDirectoryPlaceGrid4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryPlaceGrid4Activity::class.java))

            "AppDirectoryPlaceGrid5Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryPlaceGrid5Activity::class.java))

            "AppDirectoryPlaceGrid6Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryPlaceGrid6Activity::class.java))

            "AppDirectoryPlaceMap1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryPlaceMap1Activity::class.java))

            "AppDirectoryPlaceMap2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryPlaceMap2Activity::class.java))

            "AppDirectoryPlaceMap3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryPlaceMap3Activity::class.java))

            "AppDirectoryPlaceMap4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryPlaceMap4Activity::class.java))

            "AppDirectoryFilter1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryFilter1Activity::class.java))

            "AppDirectoryFilter2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryFilter2Activity::class.java))

            "AppDirectoryFilter3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryFilter3Activity::class.java))

            "AppDirectoryFilter4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryFilter4Activity::class.java))


            // Gallery
            "AppDirectoryGallery1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryGallery1Activity::class.java))

            "AppDirectoryGallery2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryGallery2Activity::class.java))

            "AppDirectoryGallery3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryGallery3Activity::class.java))

            "AppDirectoryGallery4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryGallery4Activity::class.java))


            // Profile
            "AppDirectoryProfile1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryProfile1Activity::class.java))

            "AppDirectoryProfile2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryProfile2Activity::class.java))

            "AppDirectoryProfile3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryProfile3Activity::class.java))

            "AppDirectoryProfile4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppDirectoryProfile4Activity::class.java))

            // ****************************************************************************************************************
            // E-Commerce
            // ****************************************************************************************************************

            // Home
            "AppECommerceHome1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceHome1Activity::class.java))

            "AppECommerceHome2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceHome2Activity::class.java))

            "AppECommerceHome3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceHome3Activity::class.java))

            "AppECommerceHome4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceHome4Activity::class.java))

            "AppECommerceHome5Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceHome5Activity::class.java))

            // List
            "AppECommerceList1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceList1Activity::class.java))

            "AppECommerceList2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceList2Activity::class.java))

            "AppECommerceList3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceList3Activity::class.java))

            "AppECommerceList4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceList4Activity::class.java))

            "AppECommerceList5Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceList5Activity::class.java))

            "AppECommerceList6Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceList6Activity::class.java))

            "AppECommerceList7Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceList7Activity::class.java))

            "AppECommerceList8Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceList8Activity::class.java))

            // Filter
            "AppECommerceFilter1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceFilter1Activity::class.java))

            "AppECommerceFilter2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceFilter2Activity::class.java))

            "AppECommerceFilter3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceFilter3Activity::class.java))

            "AppECommerceFilter4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceFilter4Activity::class.java))

            // Detail
            "AppECommerceDetail1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceDetail1Activity::class.java))
            "AppECommerceDetail2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceDetail2Activity::class.java))
            "AppECommerceDetail3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceDetail3Activity::class.java))
            "AppECommerceDetail4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceDetail4Activity::class.java))
            "AppECommerceDetail5Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceDetail5Activity::class.java))


            // Checkout
            "AppECommerceCheckout1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceCheckout1Activity::class.java))
            "AppECommerceCheckout2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceCheckout2Activity::class.java))
            "AppECommerceCheckout3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceCheckout3Activity::class.java))
            "AppECommerceCheckout4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceCheckout4Activity::class.java))
            "AppECommerceCheckout5Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceCheckout5Activity::class.java))
            "AppECommerceCheckout6Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceCheckout6Activity::class.java))

            // Basket
            "AppECommerceBasket1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceBasket1Activity::class.java))
            "AppECommerceBasket2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceBasket2Activity::class.java))
            "AppECommerceBasket3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceBasket3Activity::class.java))
            "AppECommerceBasket4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceBasket4Activity::class.java))

            // Shop Info
            "AppECommerceShopInfo1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceShopInfo1Activity::class.java))
            "AppECommerceShopInfo2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceShopInfo2Activity::class.java))

            // User Profile
            "AppECommerceProfile1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceProfile1Activity::class.java))

            // Order
            "AppECommerceOrder1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceOrder1Activity::class.java))

            "AppECommerceOrder2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceOrder2Activity::class.java))

            "AppECommerceOrder3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceOrder3Activity::class.java))

            "AppECommerceOrder4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceOrder4Activity::class.java))

            // Gallery
            "AppECommerceGallery1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceGallery1Activity::class.java))
            "AppECommerceGallery2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceGallery2Activity::class.java))
            "AppECommerceGallery3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceGallery3Activity::class.java))

            //Grid
            "AppECommerceGrid1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceGrid1Activity::class.java))

            "AppECommerceGrid2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceGrid2Activity::class.java))


            "AppECommerceGrid3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceGrid3Activity::class.java))

            "AppECommerceGrid4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceGrid4Activity::class.java))

            "AppECommerceGrid5Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceGrid5Activity::class.java))

            "AppECommerceGrid6Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceGrid6Activity::class.java))

            "AppECommerceGrid7Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceGrid7Activity::class.java))

            "AppECommerceGrid8Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceGrid8Activity::class.java))

            "AppECommerceGrid9Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceGrid9Activity::class.java))

            "AppECommerceGrid10Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceGrid10Activity::class.java))

            "AppECommerceGrid11Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceGrid11Activity::class.java))

            //Category
            "AppECommerceCategory1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceCategory1Activity::class.java))

            "AppECommerceCategory2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceCategory2Activity::class.java))

            "AppECommerceCategory3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceCategory3Activity::class.java))

            "AppECommerceCategory4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppECommerceCategory4Activity::class.java))

            // ****************************************************************************************************************
            // Wallpaper
            // ****************************************************************************************************************

            // Home
            "AppWallpaperHome1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppWallpaperHome1Activity::class.java))
            "AppWallpaperHome2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppWallpaperHome2Activity::class.java))
            "AppWallpaperHome3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppWallpaperHome3Activity::class.java))
            "AppWallpaperHome4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppWallpaperHome4Activity::class.java))

            // Grid
            "AppWallpaperGrid1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppWallpaperGrid1Activity::class.java))
            "AppWallpaperGrid2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppWallpaperGrid2Activity::class.java))
            "AppWallpaperGrid3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppWallpaperGrid3Activity::class.java))
            "AppWallpaperGrid4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppWallpaperGrid4Activity::class.java))
            "AppWallpaperGrid5Activity" -> NavigationController.openActivity(activity, Intent(activity, AppWallpaperGrid5Activity::class.java))
            "AppWallpaperGrid6Activity" -> NavigationController.openActivity(activity, Intent(activity, AppWallpaperGrid6Activity::class.java))

            // ****************************************************************************************************************
            // Finance
            // ****************************************************************************************************************

            //Home
            "AppFinanceHome1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppFinanceHome1Activity::class.java))
            "AppFinanceHome2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppFinanceHome2Activity::class.java))
            "AppFinanceHome3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppFinanceHome3Activity::class.java))

            //Report
            "AppFinanceReport1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppFinanceReport1Activity::class.java))

            //Dialog
            "AppFinanceDialog1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppFinanceDialog1Activity::class.java))

            // List
            "AppWallpaperList1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppWallpaperList1Activity::class.java))
            "AppWallpaperList2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppWallpaperList2Activity::class.java))
            "AppWallpaperList3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppWallpaperList3Activity::class.java))
            "AppWallpaperList4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppWallpaperList4Activity::class.java))


            // Category
            "AppWallpaperCategory1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppWallpaperCategory1Activity::class.java))

            "AppWallpaperCategory2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppWallpaperCategory2Activity::class.java))

            "AppWallpaperCategory3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppWallpaperCategory3Activity::class.java))

            "AppWallpaperCategory4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppWallpaperCategory4Activity::class.java))

            //Detail
            "AppWallpaperDetail1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppWallpaperDetail1Activity::class.java))

            "AppWallpaperDetail2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppWallpaperDetail2Activity::class.java))

            // ****************************************************************************************************************
            // User Management
            // ****************************************************************************************************************

            // User Profile
            "AppUserProfile1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppUserProfile1Activity::class.java))
            "AppUserProfile2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppUserProfile2Activity::class.java))
            "AppUserProfile3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppUserProfile3Activity::class.java))
            "AppUserProfile4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppUserProfile4Activity::class.java))

            //User Login
            "AppUserLogin1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppUserLogin1Activity::class.java))

            "AppUserLogin2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppUserLogin2Activity::class.java))

            "AppUserLogin3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppUserLogin3Activity::class.java))

            "AppUserLogin4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppUserLogin4Activity::class.java))

            //Signup
            "AppUserSignUp1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppUserSignUp1Activity::class.java))

            "AppUserSignUp2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppUserSignUp2Activity::class.java))

            "AppUserSignUp3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppUserSignUp3Activity::class.java))

            "AppUserSignUp4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppUserSignUp4Activity::class.java))


            //Forgot Password
            "AppUserForgotPassword1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppUserForgotPassword1Activity::class.java))

            "AppUserForgotPassword2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppUserForgotPassword2Activity::class.java))

            "AppUserForgotPassword3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppUserForgotPassword3Activity::class.java))

            "AppUserForgotPassword4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppUserForgotPassword4Activity::class.java))

            // ****************************************************************************************************************
            // News
            // ****************************************************************************************************************

            // Category Grid 1
            "AppNewsCategoryGrid1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsCategoryGrid1Activity::class.java))

            // Category Grid 2
            "AppNewsCategoryGrid2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsCategoryGrid2Activity::class.java))

            // Category List 1
            "AppNewsCategoryList1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsCategoryList1Activity::class.java))

            // Category List 2
            "AppNewsCategoryList2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsCategoryList2Activity::class.java))

            // Timeline 1
            "AppNewsTimeline1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsTimeline1Activity::class.java))

            // Home 1
            "AppNewsHome1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsHome1Activity::class.java))

            // Home 2
            "AppNewsHome2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsHome2Activity::class.java))

            // About Us 1
            "AppNewsAboutUs1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsAboutUs1Activity::class.java))

            // Gallery 1
            "AppNewsGallery1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsGallery1Activity::class.java))
            // About Us 1
            "AppNewsGallery2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsGallery2Activity::class.java))

            // Detail 1
            "AppNewsDetail1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsDetail1Activity::class.java))

            // Detail 2
            "AppNewsDetail2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsDetail2Activity::class.java))

            // Detail 3
            "AppNewsDetail3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsDetail3Activity::class.java))

            // Detail 4
            "AppNewsDetail4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsDetail4Activity::class.java))

            //News List 1
            "AppNewsList1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsList1Activity::class.java))

            //News List 2
            "AppNewsList2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsList2Activity::class.java))

            //News List 3
            "AppNewsList3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsList3Activity::class.java))

            //News List 4
            "AppNewsList4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsList4Activity::class.java))

            //News List 5
            "AppNewsList5Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsList5Activity::class.java))

            //News Grid 1
            "AppNewsGrid1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsGrid1Activity::class.java))

            //News Grid 2
            "AppNewsGrid2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsGrid2Activity::class.java))

            //News Grid 3
            "AppNewsGrid3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsGrid3Activity::class.java))

            //News Grid 4
            "AppNewsGrid4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsGrid4Activity::class.java))

            //News Grid 5
            "AppNewsGrid5Activity" -> NavigationController.openActivity(activity, Intent(activity, AppNewsGrid5Activity::class.java))

            // ****************************************************************************************************************
            // Education
            // ****************************************************************************************************************

            // Education Outline
            "AppEducationOutline1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationOutline1Activity::class.java))

            // Education Home 1
            "AppEducationHome1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationHome1Activity::class.java))

            // Education Home 2
            "AppEducationHome2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationHome2Activity::class.java))

            // Education Home 3
            "AppEducationHome3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationHome3Activity::class.java))

            // Education Detail 1
            "AppEducationDetail1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationDetail1Activity::class.java))

            // Education Detail 2
            "AppEducationDetail2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationDetail2Activity::class.java))

            // Education Detail 3
            "AppEducationDetail3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationDetail3Activity::class.java))

            // Education List 1
            "AppEducationList1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationList1Activity::class.java))

            // Education List 2
            "AppEducationList2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationList2Activity::class.java))

            // Education List 3
            "AppEducationList3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationList3Activity::class.java))

            // Education List 4
            "AppEducationList4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationList4Activity::class.java))

            // Education List 5
            "AppEducationList5Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationList5Activity::class.java))

            // Education Grid 1
            "AppEducationGrid1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationGrid1Activity::class.java))

            // Education Grid 2
            "AppEducationGrid2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationGrid2Activity::class.java))

            // Education Grid 3
            "AppEducationGrid3Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationGrid3Activity::class.java))
            // Education Grid 4
            "AppEducationGrid4Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationGrid4Activity::class.java))

            // Education Grid 5
            "AppEducationGrid5Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationGrid5Activity::class.java))

            // Education Course Collection 1
            "AppEducationCourseCollectionList1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationCourseCollectionList1Activity::class.java))

            // Education Course Collection 2
            "AppEducationCourseCollectionList2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationCourseCollectionList2Activity::class.java))

            // Education Category List 1
            "AppEducationCategoryList1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationCategoryList1Activity::class.java))

            // Education Category Grid 1
            "AppEducationCategoryGrid1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationCategoryGrid1Activity::class.java))

            // Education About Us
            "AppEducationAboutUs1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationAboutUs1Activity::class.java))

            // Education Profile 1
            "AppEducationProfile1Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationProfile1Activity::class.java))

            // Education Profile 2
            "AppEducationProfile2Activity" -> NavigationController.openActivity(activity, Intent(activity, AppEducationProfile2Activity::class.java))

            else -> Log.d("TEAMPS", "No Action")
        }
    }

    companion object {

        fun newInstance(): MainApplicationListFragment {
            return MainApplicationListFragment()
        }
    }
}// Required empty public constructor
