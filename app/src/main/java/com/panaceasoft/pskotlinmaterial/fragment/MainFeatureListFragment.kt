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
import com.panaceasoft.pskotlinmaterial.activity.feature.aboutus.education.FeatureAboutusEducationAboutus1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.aboutus.news.FeatureAboutusNewsAboutus1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.article.news.FeatureArticleNewsArticle1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.article.news.FeatureArticleNewsArticle2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.article.news.FeatureArticleNewsArticle3Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.article.news.FeatureArticleNewsArticle4Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.basket.FeatureBasketECommerceBasket1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.basket.FeatureBasketECommerceBasket2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.basket.FeatureBasketECommerceBasket3Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.basket.FeatureBasketECommerceBasket4Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.chat.general.FeatureChatGeneralChat1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.chat.general.FeatureChatGeneralChat2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.checkout.*
import com.panaceasoft.pskotlinmaterial.activity.feature.comment.general.entry.FeatureCommentGeneralEntry1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.comment.general.entry.FeatureCommentGeneralEntry2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.comment.general.list.FeatureCommentGeneralList1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.coverflow.general.FeatureCoverflowGeneralCoverflow1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.coverflow.general.FeatureCoverflowGeneralCoverflow2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.directory.*
import com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.ecommerce.*
import com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.education.FeatureDashboardEducationDashboard1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.education.FeatureDashboardEducationDashboard2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.education.FeatureDashboardEducationDashboard3Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.finance.FeatureDashboardFinanceDashboard1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.finance.FeatureDashboardFinanceDashboard2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.finance.FeatureDashboardFinanceDashboard3Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.news.FeatureDashboardNewsDashboard1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.news.FeatureDashboardNewsDashboard2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.wallpaper.FeatureDashboardWallpaperDashboard1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.wallpaper.FeatureDashboardWallpaperDashboard2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.wallpaper.FeatureDashboardWallpaperDashboard3Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.dashboard.wallpaper.FeatureDashboardWallpaperDashboard4Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.detail.directory.FeatureDetailDirectoryPlaceDetail1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.detail.directory.FeatureDetailDirectoryPlaceDetail2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.detail.directory.FeatureDetailDirectoryPlaceDetail3Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.detail.directory.FeatureDetailDirectoryPlaceDetail4Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.detail.ecommerce.*
import com.panaceasoft.pskotlinmaterial.activity.feature.detail.education.FeatureDetailEducationDetail1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.detail.education.FeatureDetailEducationDetail2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.detail.education.FeatureDetailEducationDetail3Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.detail.wallpaper.FeatureDetailWallpaperPhotoDetail1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.detail.wallpaper.FeatureDetailWallpaperPhotoDetail2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.dialog.finance.FeatureDialogFinanceDialog1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.dialog.general.*
import com.panaceasoft.pskotlinmaterial.activity.feature.expandable.ecommerce.FeatureExpandableECommerceExpandable1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.expandable.ecommerce.FeatureExpandableECommerceExpandable2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.filter.directory.FeatureFilterDirectoryFilter1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.filter.directory.FeatureFilterDirectoryFilter2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.filter.directory.FeatureFilterDirectoryFilter3Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.filter.directory.FeatureFilterDirectoryFilter4Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.filter.ecommerce.FeatureFilterECommerceFilter1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.filter.ecommerce.FeatureFilterECommerceFilter2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.filter.ecommerce.FeatureFilterECommerceFilter3Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.filter.ecommerce.FeatureFilterECommerceFilter4Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.forgotpassword.general.FeatureForgotPasswordGeneralForgotPassword1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.forgotpassword.general.FeatureForgotPasswordGeneralForgotPassword2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.forgotpassword.general.FeatureForgotPasswordGeneralForgotPassword3Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.forgotpassword.general.FeatureForgotPasswordGeneralForgotPassword4Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.gallery.directory.FeatureGalleryDirectoryGallery1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.gallery.directory.FeatureGalleryDirectoryGallery2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.gallery.directory.FeatureGalleryDirectoryGallery3Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.gallery.directory.FeatureGalleryDirectoryGallery4Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.gallery.ecommerce.FeatureGalleryECommerceGallery1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.gallery.ecommerce.FeatureGalleryECommerceGallery2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.gallery.ecommerce.FeatureGalleryECommerceGallery3Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.gallery.news.FeatureGalleryNewsGallery1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.gallery.news.FeatureGalleryNewsGallery2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.gdpr.general.FeatureGdprGeneralGdpr1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.gdpr.general.FeatureGdprGeneralGdpr2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.grid.directory.*
import com.panaceasoft.pskotlinmaterial.activity.feature.grid.ecommerce.*
import com.panaceasoft.pskotlinmaterial.activity.feature.grid.education.*
import com.panaceasoft.pskotlinmaterial.activity.feature.grid.news.*
import com.panaceasoft.pskotlinmaterial.activity.feature.grid.wallpaper.*
import com.panaceasoft.pskotlinmaterial.activity.feature.list.directory.*
import com.panaceasoft.pskotlinmaterial.activity.feature.list.ecommerce.*
import com.panaceasoft.pskotlinmaterial.activity.feature.list.education.*
import com.panaceasoft.pskotlinmaterial.activity.feature.list.general.*
import com.panaceasoft.pskotlinmaterial.activity.feature.list.news.*
import com.panaceasoft.pskotlinmaterial.activity.feature.list.wallpaper.*
import com.panaceasoft.pskotlinmaterial.activity.feature.loadmore.general.FeatureLoadMoreGeneralOnScroll
import com.panaceasoft.pskotlinmaterial.activity.feature.loadmore.general.FeatureLoadMoreGeneralPullRefresh
import com.panaceasoft.pskotlinmaterial.activity.feature.login.FeatureLoginGeneralLogin1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.login.FeatureLoginGeneralLogin2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.login.FeatureLoginGeneralLogin3Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.login.FeatureLoginGeneralLogin4Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.map.directory.FeatureMapDirectoryMap1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.map.directory.FeatureMapDirectoryMap2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.map.directory.FeatureMapDirectoryMap3Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.map.directory.FeatureMapDirectoryMap4Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.media.general.FeatureMediaGeneralMP3Player1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.media.general.FeatureMediaGeneralMP3Player2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.media.general.videoplayer1.FeatureMediaGeneralVideoPlayer1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.media.general.videoplayer2.FeatureMediaGeneralVideoPlayer2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.menu.general.*
import com.panaceasoft.pskotlinmaterial.activity.feature.notfound.general.FeatureNotFoundGeneralNoData1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.notfound.general.FeatureNotFoundGeneralNoInternet1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.notfound.general.FeatureNotFoundGeneralNoMessage1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.notfound.general.FeatureNotFoundGeneralNoResult1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.order.ecommerce.FeatureOrderECommerceOrder1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.order.ecommerce.FeatureOrderECommerceOrder2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.order.ecommerce.FeatureOrderECommerceOrder3Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.order.ecommerce.FeatureOrderECommerceOrder4Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.payment.ecommerce.FeaturePaymentECommerceCardEntry1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.payment.ecommerce.FeaturePaymentECommerceCardOptions1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.profile.directory.FeatureProfileDirectoryProfile1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.profile.directory.FeatureProfileDirectoryProfile2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.profile.directory.FeatureProfileDirectoryProfile3Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.profile.directory.FeatureProfileDirectoryProfile4Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.profile.ecommerce.FeatureProfileECommerceProfile1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.profile.ecommerce.FeatureProfileECommerceProfile2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.profile.ecommerce.FeatureProfileECommerceProfile3Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.profile.education.FeatureProfileEducationProfile1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.profile.education.FeatureProfileEducationProfile2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.profile.general.FeatureProfileGeneralProfile1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.profile.general.FeatureProfileGeneralProfile2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.profile.general.FeatureProfileGeneralProfile3Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.profile.general.FeatureProfileGeneralProfile4Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.rating.general.entry.FeatureRatingGeneralEntry1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.rating.general.list.FeatureRatingGeneralList1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.rating.general.list.FeatureRatingGeneralList2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.report.FeatureReportFinanceReport1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.setting.general.FeatureSettingGeneralSetting1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.setting.general.FeatureSettingGeneralSetting2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.setting.general.FeatureSettingGeneralSetting3Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.signup.general.FeatureSignUpGeneralSignUp1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.signup.general.FeatureSignUpGeneralSignUp2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.signup.general.FeatureSignUpGeneralSignUp3Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.signup.general.FeatureSignUpGeneralSignUp4Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.splash.general.splash1.FeatureSplashGeneralSplashScreen1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.splash.general.splash2.FeatureSplashGeneralSplashScreen2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.stepper.ecommerce.FeatureStepperECommerceStepper1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.stepper.general.FeatureStepperGeneralStepper1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.stepper.quiz.FeatureStepperQuizStepper1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.stepper.quiz.FeatureStepperQuizStepper2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.timeline.ecommerce.FeatureTimelineECommerceTimeline1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.timeline.education.FeatureTimelineEducationOutline1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.timeline.general.FeatureTimelineGeneralTimeline1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.timeline.general.FeatureTimelineGeneralTimeline2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.timeline.news.FeatureTimelineNewsTimeline1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.timeline.social.FeatureTimelineSocialTimeline1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.verification.general.FeatureVerificationGeneralVerification1Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.verification.general.FeatureVerificationGeneralVerification2Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.verification.general.FeatureVerificationGeneralVerification3Activity
import com.panaceasoft.pskotlinmaterial.activity.feature.walkthrough.general.FeatureWalkthroughGeneralWalkthrough1Activity
import com.panaceasoft.pskotlinmaterial.adapter.MainThirdLevelListAdapter
import com.panaceasoft.pskotlinmaterial.utils.NavigationController
import com.panaceasoft.pskotlinmaterial.utils.Utils


/**
 * A simple [Fragment] subclass.
 */
class MainFeatureListFragment : Fragment() {

    private var expandableListView: ExpandableListView? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main_feature_list, container, false)

        val myJson = Utils.inputStreamToString(resources.openRawResource(R.raw.main_feature_list))

        val mainViewObjectList = Gson().fromJson<List<MainViewObject>>(myJson, object : TypeToken<List<MainViewObject>>() {

        }.type)

        expandableListView = view.findViewById(R.id.expandible_listview)

        // Passing third level of information to constructor
        val mainThirdLevelListAdapter = MainThirdLevelListAdapter(context!!, mainViewObjectList, object : MainThirdLevelListAdapter.CellClickCallback {
            override fun onClick(id: String) {
                cellClicked(id)
            }
        })
        expandableListView?.setAdapter(mainThirdLevelListAdapter)


        expandableListView?.setGroupIndicator(null)
        val cd = ColorDrawable(ContextCompat.getColor(container!!.context,R.color.colorLine))

        expandableListView?.divider = cd
        expandableListView?.dividerHeight = 1

        expandableListView?.setOnGroupExpandListener(object : ExpandableListView.OnGroupExpandListener {
             var previousGroup = -1

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
            // Directory Dashboard
            "FeatureDashboardDirectoryDashboard1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardDirectoryDashboard1Activity::class.java))

            "FeatureDashboardDirectoryDashboard2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardDirectoryDashboard2Activity::class.java))

            "FeatureDashboardDirectoryDashboard3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardDirectoryDashboard3Activity::class.java))

            "FeatureDashboardDirectoryDashboard4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardDirectoryDashboard4Activity::class.java))

            "FeatureDashboardDirectoryDashboard5Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardDirectoryDashboard5Activity::class.java))

            "FeatureDashboardDirectoryDashboard6Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardDirectoryDashboard6Activity::class.java))

            "FeatureDashboardDirectoryDashboard7Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardDirectoryDashboard7Activity::class.java))

            "FeatureDashboardDirectoryDashboard8Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardDirectoryDashboard8Activity::class.java))

            "FeatureDashboardDirectoryDashboard9Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardDirectoryDashboard9Activity::class.java))

            "FeatureDashboardDirectoryDashboard10Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardDirectoryDashboard10Activity::class.java))

            // ECommerce Dashboard
            "FeatureDashboardECommerceDashboard1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardECommerceDashboard1Activity::class.java))

            "FeatureDashboardECommerceDashboard2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardECommerceDashboard2Activity::class.java))

            "FeatureDashboardECommerceDashboard3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardECommerceDashboard3Activity::class.java))

            "FeatureDashboardECommerceDashboard4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardECommerceDashboard4Activity::class.java))

            "FeatureDashboardECommerceDashboard5Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardECommerceDashboard5Activity::class.java))

            //Wallpaper Dashboard
            "FeatureDashboardWallpaperDashboard1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardWallpaperDashboard1Activity::class.java))

            "FeatureDashboardWallpaperDashboard2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardWallpaperDashboard2Activity::class.java))

            "FeatureDashboardWallpaperDashboard3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardWallpaperDashboard3Activity::class.java))

            "FeatureDashboardWallpaperDashboard4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardWallpaperDashboard4Activity::class.java))


            // Finance Dashboard
            "FeatureDashboardFinanceDashboard1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardFinanceDashboard1Activity::class.java))

            "FeatureDashboardFinanceDashboard2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardFinanceDashboard2Activity::class.java))

            "FeatureDashboardFinanceDashboard3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardFinanceDashboard3Activity::class.java))

            // Directory Place List
            "FeatureListDirectoryPlaceList1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListDirectoryPlaceList1Activity::class.java))

            "FeatureListDirectoryPlaceList2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListDirectoryPlaceList2Activity::class.java))

            "FeatureListDirectoryPlaceList3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListDirectoryPlaceList3Activity::class.java))

            "FeatureListDirectoryPlaceList4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListDirectoryPlaceList4Activity::class.java))

            "FeatureListDirectoryPlaceList5Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListDirectoryPlaceList5Activity::class.java))

            "FeatureListDirectoryPlaceList6Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListDirectoryPlaceList6Activity::class.java))

            "FeatureListDirectoryPlaceList7Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListDirectoryPlaceList7Activity::class.java))

            "FeatureListDirectoryPlaceList8Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListDirectoryPlaceList8Activity::class.java))


            "FeatureListDirectoryPlaceList9Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListDirectoryPlaceList9Activity::class.java))

            //Directory City List
            "FeatureListDirectoryCityList1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListDirectoryCityList1Activity::class.java))

            "FeatureListDirectoryCityList2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListDirectoryCityList2Activity::class.java))

            "FeatureListDirectoryCityList3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListDirectoryCityList3Activity::class.java))

            "FeatureListDirectoryCityList4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListDirectoryCityList4Activity::class.java))

            //ECommerce Item List
            "FeatureListECommerceItemList1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListECommerceItemList1Activity::class.java))

            "FeatureListECommerceItemList2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListECommerceItemList2Activity::class.java))

            "FeatureListECommerceItemList3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListECommerceItemList3Activity::class.java))

            "FeatureListECommerceItemList4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListECommerceItemList4Activity::class.java))

            "FeatureListECommerceItemList5Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListECommerceItemList5Activity::class.java))

            "FeatureListECommerceItemList6Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListECommerceItemList6Activity::class.java))

            "FeatureListECommerceItemList7Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListECommerceItemList7Activity::class.java))

            "FeatureListECommerceItemList8Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListECommerceItemList8Activity::class.java))

            "FeatureListECommerceCategoryList1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListECommerceCategoryList1Activity::class.java))

            "FeatureListECommerceCategoryList2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListECommerceCategoryList2Activity::class.java))

            //Wallpaper List
            "FeatureListWallpaperPhotoList1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListWallpaperPhotoList1Activity::class.java))

            "FeatureListWallpaperPhotoList2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListWallpaperPhotoList2Activity::class.java))

            "FeatureListWallpaperPhotoList3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListWallpaperPhotoList3Activity::class.java))

            "FeatureListWallpaperPhotoList4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListWallpaperPhotoList4Activity::class.java))

            "FeatureListWallpaperCategoryList1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListWallpaperCategoryList1Activity::class.java))

            "FeatureListWallpaperCategoryList2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListWallpaperCategoryList2Activity::class.java))


            // Payment Ecommerce
            "FeaturePaymentECommerceCardEntry1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeaturePaymentECommerceCardEntry1Activity::class.java))

            "FeaturePaymentECommerceCardOptions1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeaturePaymentECommerceCardOptions1Activity::class.java))


            // General List
            "FeatureListGeneralDragAndDropListActivity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListGeneralDragAndDropListActivity::class.java))

            "FeatureListGeneralExpandableListActivity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListGeneralExpandableListActivity::class.java))

            "FeatureListGeneralSectionedListActivity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListGeneralSectionedListActivity::class.java))

            "FeatureListGeneralStickyHeaderListActivity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListGeneralStickyHeaderListActivity::class.java))

            "FeatureListGeneralSwipeToDismissListActivity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListGeneralSwipeToDismissListActivity::class.java))

            "FeatureListGeneralScrollToTopListActivity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListGeneralScrollToTopListActivity::class.java))

            // General Media Player
            "FeatureMediaGeneralMP3Player1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureMediaGeneralMP3Player1Activity::class.java))

            "FeatureMediaGeneralMP3Player2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureMediaGeneralMP3Player2Activity::class.java))

            "FeatureMediaGeneralVideoPlayer1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureMediaGeneralVideoPlayer1Activity::class.java))

            "FeatureMediaGeneralVideoPlayer2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureMediaGeneralVideoPlayer2Activity::class.java))

            // Timeline
            "FeatureTimelineECommerceTimeline1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureTimelineECommerceTimeline1Activity::class.java))

            "FeatureTimelineGeneralTimeline1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureTimelineGeneralTimeline1Activity::class.java))

            "FeatureTimelineGeneralTimeline2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureTimelineGeneralTimeline2Activity::class.java))

            "FeatureTimelineSocialTimeline1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureTimelineSocialTimeline1Activity::class.java))

            // Directory Grid
            "FeatureGridDirectoryPlaceGrid1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridDirectoryPlaceGrid1Activity::class.java))

            "FeatureGridDirectoryPlaceGrid2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridDirectoryPlaceGrid2Activity::class.java))

            "FeatureGridDirectoryPlaceGrid3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridDirectoryPlaceGrid3Activity::class.java))

            "FeatureGridDirectoryPlaceGrid4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridDirectoryPlaceGrid4Activity::class.java))

            "FeatureGridDirectoryPlaceGrid5Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridDirectoryPlaceGrid5Activity::class.java))

            "FeatureGridDirectoryPlaceGrid6Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridDirectoryPlaceGrid6Activity::class.java))

            "FeatureGridDirectoryCityGrid1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridDirectoryCityGrid1Activity::class.java))

            //ECommerce Grid
            "FeatureGridECommerceItemGrid1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridECommerceItemGrid1Activity::class.java))

            "FeatureGridECommerceItemGrid2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridECommerceItemGrid2Activity::class.java))

            "FeatureGridECommerceItemGrid3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridECommerceItemGrid3Activity::class.java))

            "FeatureGridECommerceItemGrid4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridECommerceItemGrid4Activity::class.java))

            "FeatureGridECommerceItemGrid5Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridECommerceItemGrid5Activity::class.java))

            "FeatureGridECommerceItemGrid6Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridECommerceItemGrid6Activity::class.java))

            "FeatureGridECommerceItemGrid7Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridECommerceItemGrid7Activity::class.java))

            "FeatureGridECommerceItemGrid8Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridECommerceItemGrid8Activity::class.java))

            "FeatureGridECommerceItemGrid9Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridECommerceItemGrid9Activity::class.java))

            "FeatureGridECommerceItemGrid10Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridECommerceItemGrid10Activity::class.java))

            "FeatureGridECommerceItemGrid11Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridECommerceItemGrid11Activity::class.java))

            "FeatureGridECommerceCategoryGrid1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridECommerceCategoryGrid1Activity::class.java))

            "FeatureGridECommerceCategoryGrid2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridECommerceCategoryGrid2Activity::class.java))

            //Wallpaper Grid
            "FeatureGridWallpaperPhotoGrid1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridWallpaperPhotoGrid1Activity::class.java))

            "FeatureGridWallpaperPhotoGrid2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridWallpaperPhotoGrid2Activity::class.java))

            "FeatureGridWallpaperPhotoGrid3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridWallpaperPhotoGrid3Activity::class.java))

            "FeatureGridWallpaperPhotoGrid4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridWallpaperPhotoGrid4Activity::class.java))

            "FeatureGridWallpaperPhotoGrid5Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridWallpaperPhotoGrid5Activity::class.java))

            "FeatureGridWallpaperPhotoGrid6Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridWallpaperPhotoGrid6Activity::class.java))

            "FeatureGridWallpaperCategoryGrid1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridWallpaperCategoryGrid1Activity::class.java))

            "FeatureGridWallpaperCategoryGrid2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridWallpaperCategoryGrid2Activity::class.java))


            //Directory Detail
            "FeatureDetailDirectoryPlaceDetail1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDetailDirectoryPlaceDetail1Activity::class.java))

            "FeatureDetailDirectoryPlaceDetail2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDetailDirectoryPlaceDetail2Activity::class.java))

            "FeatureDetailDirectoryPlaceDetail3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDetailDirectoryPlaceDetail3Activity::class.java))

            "FeatureDetailDirectoryPlaceDetail4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDetailDirectoryPlaceDetail4Activity::class.java))

            //Ecommerce Detail
            "FeatureDetailECommerceItemDetail1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDetailECommerceItemDetail1Activity::class.java))

            "FeatureDetailECommerceItemDetail2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDetailECommerceItemDetail2Activity::class.java))

            "FeatureDetailECommerceItemDetail3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDetailECommerceItemDetail3Activity::class.java))

            "FeatureDetailECommerceItemDetail4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDetailECommerceItemDetail4Activity::class.java))

            "FeatureDetailECommerceItemDetail5Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDetailECommerceItemDetail5Activity::class.java))

            //Wallpaper Detail
            "FeatureDetailWallpaperPhotoDetail1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDetailWallpaperPhotoDetail1Activity::class.java))

            "FeatureDetailWallpaperPhotoDetail2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDetailWallpaperPhotoDetail2Activity::class.java))

            //Basket
            "FeatureBasketECommerceBasket1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureBasketECommerceBasket1Activity::class.java))

            "FeatureBasketECommerceBasket2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureBasketECommerceBasket2Activity::class.java))

            "FeatureBasketECommerceBasket3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureBasketECommerceBasket3Activity::class.java))

            "FeatureBasketECommerceBasket4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureBasketECommerceBasket4Activity::class.java))

            //Chat
            "FeatureChatGeneralChat1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureChatGeneralChat1Activity::class.java))

            "FeatureChatGeneralChat2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureChatGeneralChat2Activity::class.java))

            //Checkout
            "FeatureCheckoutECommerceCheckout1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureCheckoutECommerceCheckout1Activity::class.java))

            "FeatureCheckoutECommerceCheckout2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureCheckoutECommerceCheckout2Activity::class.java))

            "FeatureCheckoutECommerceCheckout3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureCheckoutECommerceCheckout3Activity::class.java))

            "FeatureCheckoutECommerceCheckout4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureCheckoutECommerceCheckout4Activity::class.java))

            "FeatureCheckoutECommerceCheckout5Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureCheckoutECommerceCheckout5Activity::class.java))

            "FeatureCheckoutECommerceCheckout6Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureCheckoutECommerceCheckout6Activity::class.java))

            //Order History
            "FeatureOrderECommerceOrder1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureOrderECommerceOrder1Activity::class.java))

            "FeatureOrderECommerceOrder2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureOrderECommerceOrder2Activity::class.java))

            "FeatureOrderECommerceOrder3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureOrderECommerceOrder3Activity::class.java))

            "FeatureOrderECommerceOrder4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureOrderECommerceOrder4Activity::class.java))

            //Search & Filter
            "FeatureFilterDirectoryFilter1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureFilterDirectoryFilter1Activity::class.java))

            "FeatureFilterDirectoryFilter2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureFilterDirectoryFilter2Activity::class.java))

            "FeatureFilterDirectoryFilter3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureFilterDirectoryFilter3Activity::class.java))

            "FeatureFilterDirectoryFilter4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureFilterDirectoryFilter4Activity::class.java))

            "FeatureFilterECommerceFilter1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureFilterECommerceFilter1Activity::class.java))

            "FeatureFilterECommerceFilter2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureFilterECommerceFilter2Activity::class.java))

            "FeatureFilterECommerceFilter3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureFilterECommerceFilter3Activity::class.java))

            "FeatureFilterECommerceFilter4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureFilterECommerceFilter4Activity::class.java))

            //Gallery
            "FeatureGalleryDirectoryGallery1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGalleryDirectoryGallery1Activity::class.java))

            "FeatureGalleryDirectoryGallery2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGalleryDirectoryGallery2Activity::class.java))

            "FeatureGalleryDirectoryGallery3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGalleryDirectoryGallery3Activity::class.java))

            "FeatureGalleryDirectoryGallery4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGalleryDirectoryGallery4Activity::class.java))

            "FeatureGalleryECommerceGallery1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGalleryECommerceGallery1Activity::class.java))

            "FeatureGalleryECommerceGallery2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGalleryECommerceGallery2Activity::class.java))

            "FeatureGalleryECommerceGallery3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGalleryECommerceGallery3Activity::class.java))

            //Map
            "FeatureMapDirectoryMap1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureMapDirectoryMap1Activity::class.java))

            "FeatureMapDirectoryMap2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureMapDirectoryMap2Activity::class.java))

            "FeatureMapDirectoryMap3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureMapDirectoryMap3Activity::class.java))

            "FeatureMapDirectoryMap4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureMapDirectoryMap4Activity::class.java))


            //Menu
            "FeatureMenuGeneralMenu1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureMenuGeneralMenu1Activity::class.java))
            "FeatureMenuGeneralMenu2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureMenuGeneralMenu2Activity::class.java))
            "FeatureMenuGeneralMenu3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureMenuGeneralMenu3Activity::class.java))
            "FeatureMenuGeneralMenu4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureMenuGeneralMenu4Activity::class.java))
            "FeatureMenuGeneralMenu5Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureMenuGeneralMenu5Activity::class.java))
            "FeatureMenuGeneralMenu6Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureMenuGeneralMenu6Activity::class.java))
            "FeatureMenuGeneralMenu7Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureMenuGeneralMenu7Activity::class.java))

            //Profile
            "FeatureProfileGeneralProfile1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureProfileGeneralProfile1Activity::class.java))

            "FeatureProfileGeneralProfile2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureProfileGeneralProfile2Activity::class.java))

            "FeatureProfileGeneralProfile3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureProfileGeneralProfile3Activity::class.java))

            "FeatureProfileGeneralProfile4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureProfileGeneralProfile4Activity::class.java))

            "FeatureProfileDirectoryProfile1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureProfileDirectoryProfile1Activity::class.java))

            "FeatureProfileDirectoryProfile2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureProfileDirectoryProfile2Activity::class.java))

            "FeatureProfileDirectoryProfile3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureProfileDirectoryProfile3Activity::class.java))

            "FeatureProfileDirectoryProfile4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureProfileDirectoryProfile4Activity::class.java))

            "FeatureProfileECommerceProfile1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureProfileECommerceProfile1Activity::class.java))

            "FeatureProfileECommerceProfile2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureProfileECommerceProfile2Activity::class.java))

            "FeatureProfileECommerceProfile3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureProfileECommerceProfile3Activity::class.java))

            //Login
            "FeatureLoginGeneralLogin1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureLoginGeneralLogin1Activity::class.java))

            "FeatureLoginGeneralLogin2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureLoginGeneralLogin2Activity::class.java))

            "FeatureLoginGeneralLogin3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureLoginGeneralLogin3Activity::class.java))

            "FeatureLoginGeneralLogin4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureLoginGeneralLogin4Activity::class.java))

            //Sign Up
            "FeatureSignUpGeneralSignUp1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureSignUpGeneralSignUp1Activity::class.java))

            "FeatureSignUpGeneralSignUp2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureSignUpGeneralSignUp2Activity::class.java))

            "FeatureSignUpGeneralSignUp3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureSignUpGeneralSignUp3Activity::class.java))

            "FeatureSignUpGeneralSignUp4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureSignUpGeneralSignUp4Activity::class.java))


            //Stepper
            "FeatureStepperECommerceStepper1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureStepperECommerceStepper1Activity::class.java))
            "FeatureStepperGeneralStepper1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureStepperGeneralStepper1Activity::class.java))
            "FeatureStepperQuizStepper1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureStepperQuizStepper1Activity::class.java))
            "FeatureStepperQuizStepper2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureStepperQuizStepper2Activity::class.java))

            // Load More
            "FeatureLoadMoreGeneralPullRefresh" -> NavigationController.openActivity(activity, Intent(activity, FeatureLoadMoreGeneralPullRefresh::class.java))
            "FeatureLoadMoreGeneralOnScroll" -> NavigationController.openActivity(activity, Intent(activity, FeatureLoadMoreGeneralOnScroll::class.java))

            // GDPR
            "FeatureGdprGeneralGdpr1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGdprGeneralGdpr1Activity::class.java))
            "FeatureGdprGeneralGdpr2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGdprGeneralGdpr2Activity::class.java))

            // Splash Screen
            "FeatureSplashGeneralSplashScreen1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureSplashGeneralSplashScreen1Activity::class.java))
            "FeatureSplashGeneralSplashScreen2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureSplashGeneralSplashScreen2Activity::class.java))


            //Forgot Password
            "FeatureForgotPasswordGeneralForgotPassword1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureForgotPasswordGeneralForgotPassword1Activity::class.java))

            "FeatureForgotPasswordGeneralForgotPassword2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureForgotPasswordGeneralForgotPassword2Activity::class.java))

            "FeatureForgotPasswordGeneralForgotPassword3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureForgotPasswordGeneralForgotPassword3Activity::class.java))

            "FeatureForgotPasswordGeneralForgotPassword4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureForgotPasswordGeneralForgotPassword4Activity::class.java))


            //Dialog
            "FeatureDialogGeneralSuccessDialog1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDialogGeneralSuccessDialog1Activity::class.java))

            "FeatureDialogGeneralErrorDialog1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDialogGeneralErrorDialog1Activity::class.java))

            "FeatureDialogGeneralWarningDialog1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDialogGeneralWarningDialog1Activity::class.java))

            "FeatureDialogGeneralConfirmDialog1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDialogGeneralConfirmDialog1Activity::class.java))

            "FeatureDialogGeneralFeedbackDialog1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDialogGeneralFeedbackDialog1Activity::class.java))

            //Finance
            "FeatureDialogFinanceDialog1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDialogFinanceDialog1Activity::class.java))

            //Rating
            "FeatureRatingGeneralEntry1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureRatingGeneralEntry1Activity::class.java))

            "FeatureRatingGeneralList1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureRatingGeneralList1Activity::class.java))

            "FeatureRatingGeneralList2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureRatingGeneralList2Activity::class.java))

            //Not Found
            "FeatureNotFoundGeneralNoInternet1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureNotFoundGeneralNoInternet1Activity::class.java))

            "FeatureNotFoundGeneralNoData1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureNotFoundGeneralNoData1Activity::class.java))

            "FeatureNotFoundGeneralNoResult1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureNotFoundGeneralNoResult1Activity::class.java))

            "FeatureNotFoundGeneralNoMessage1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureNotFoundGeneralNoMessage1Activity::class.java))

            //Comment
            "FeatureCommentGeneralEntry1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureCommentGeneralEntry1Activity::class.java))

            "FeatureCommentGeneralEntry2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureCommentGeneralEntry2Activity::class.java))

            "FeatureCommentGeneralList1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureCommentGeneralList1Activity::class.java))


            //Walkthrough
            "FeatureWalkthroughGeneralWalkthrough1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureWalkthroughGeneralWalkthrough1Activity::class.java))

            //Coverflow
            "FeatureCoverflowGeneralCoverflow1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureCoverflowGeneralCoverflow1Activity::class.java))

            "FeatureCoverflowGeneralCoverflow2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureCoverflowGeneralCoverflow2Activity::class.java))

            //Article
            "FeatureArticleNewsArticle1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureArticleNewsArticle1Activity::class.java))

            "FeatureArticleNewsArticle2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureArticleNewsArticle2Activity::class.java))

            "FeatureArticleNewsArticle3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureArticleNewsArticle3Activity::class.java))

            "FeatureArticleNewsArticle4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureArticleNewsArticle4Activity::class.java))

            //Verification
            "FeatureVerificationGeneralVerification1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureVerificationGeneralVerification1Activity::class.java))

            "FeatureVerificationGeneralVerification2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureVerificationGeneralVerification2Activity::class.java))

            "FeatureVerificationGeneralVerification3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureVerificationGeneralVerification3Activity::class.java))


            //Setting
            "FeatureExpandableECommerceExpandable1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureExpandableECommerceExpandable1Activity::class.java))
            "FeatureExpandableECommerceExpandable2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureExpandableECommerceExpandable2Activity::class.java))

            //Setting
            "FeatureSettingGeneralSetting3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureSettingGeneralSetting3Activity::class.java))
            "FeatureSettingGeneralSetting1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureSettingGeneralSetting1Activity::class.java))

            "FeatureSettingGeneralSetting2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureSettingGeneralSetting2Activity::class.java))

            //News Dashboard 1
            "FeatureDashboardNewsDashboard1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardNewsDashboard1Activity::class.java))

            //News Dashboard 2
            "FeatureDashboardNewsDashboard2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardNewsDashboard2Activity::class.java))

            //News List 1
            "FeatureListNewsList1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListNewsList1Activity::class.java))

            //News List 2
            "FeatureListNewsList2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListNewsList2Activity::class.java))

            //News List 3
            "FeatureListNewsList3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListNewsList3Activity::class.java))

            //News List 4
            "FeatureListNewsList4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListNewsList4Activity::class.java))

            //News List 5
            "FeatureListNewsList5Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListNewsList5Activity::class.java))

            //News Category List 1
            "FeatureListNewsCategoryList1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListNewsCategoryList1Activity::class.java))

            //News Category List 2
            "FeatureListNewsCategoryList2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListNewsCategoryList2Activity::class.java))

            //News Grid 1
            "FeatureGridNewsGrid1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridNewsGrid1Activity::class.java))

            //News Grid 2
            "FeatureGridNewsGrid2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridNewsGrid2Activity::class.java))

            //News Grid 3
            "FeatureGridNewsGrid3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridNewsGrid3Activity::class.java))

            //News Grid 4
            "FeatureGridNewsGrid4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridNewsGrid4Activity::class.java))

            //News Grid 5
            "FeatureGridNewsGrid5Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridNewsGrid5Activity::class.java))

            //News Timeline 3
            "FeatureTimelineNewsTimeline1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureTimelineNewsTimeline1Activity::class.java))

            //News Gallery 1
            "FeatureGalleryNewsGallery1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGalleryNewsGallery1Activity::class.java))

            //News Gallery 2
            "FeatureGalleryNewsGallery2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGalleryNewsGallery2Activity::class.java))

            //News Category Grid 1
            "FeatureGridNewsCategoryGrid1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridNewsCategoryGrid1Activity::class.java))

            //News Category Grid 2
            "FeatureGridNewsCategoryGrid2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridNewsCategoryGrid2Activity::class.java))

            //News About Us 1
            "FeatureAboutusNewsAboutus1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureAboutusNewsAboutus1Activity::class.java))

            //Education Dashboard 1
            "FeatureDashboardEducationDashboard1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardEducationDashboard1Activity::class.java))

            //Education Dashboard 2
            "FeatureDashboardEducationDashboard2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardEducationDashboard2Activity::class.java))

            //Education Dashboard 3
            "FeatureDashboardEducationDashboard3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDashboardEducationDashboard3Activity::class.java))

            //Education List 1
            "FeatureListEducationVideoList1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListEducationVideoList1Activity::class.java))

            //Education List 2
            "FeatureListEducationVideoList2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListEducationVideoList2Activity::class.java))

            //Education List 3
            "FeatureListEducationVideoList3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListEducationVideoList3Activity::class.java))

            //Education List 4
            "FeatureListEducationVideoList4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListEducationVideoList4Activity::class.java))

            //Education List 5
            "FeatureListEducationVideoList5Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListEducationVideoList5Activity::class.java))


            //Education Grid 1
            "FeatureGridEducationGrid1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridEducationGrid1Activity::class.java))

            //Education Grid 2
            "FeatureGridEducationGrid2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridEducationGrid2Activity::class.java))

            //Education Grid 3
            "FeatureGridEducationGrid3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridEducationGrid3Activity::class.java))

            //Education Grid 4
            "FeatureGridEducationGrid4Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridEducationGrid4Activity::class.java))

            //Education Grid 5
            "FeatureGridEducationGrid5Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridEducationGrid5Activity::class.java))

            //Education Detail 1
            "FeatureDetailEducationDetail1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDetailEducationDetail1Activity::class.java))

            //Education Detail 2
            "FeatureDetailEducationDetail2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDetailEducationDetail2Activity::class.java))

            //Education Detail 3
            "FeatureDetailEducationDetail3Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureDetailEducationDetail3Activity::class.java))

            //Education Category List 1
            "FeatureListEducationCategoryList1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListEducationCategoryList1Activity::class.java))

            //Education Course Collection List 1
            "FeatureListEducationCourseCollectionList1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListEducationCourseCollectionList1Activity::class.java))

            //Education Course Collection List 2
            "FeatureListEducationCourseCollectionList2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureListEducationCourseCollectionList2Activity::class.java))

            //Education Category Grid 1
            "FeatureGridEducationCategoryGrid1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureGridEducationCategoryGrid1Activity::class.java))

            //Education Profile 1
            "FeatureProfileEducationProfile1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureProfileEducationProfile1Activity::class.java))

            //Education Profile 2
            "FeatureProfileEducationProfile2Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureProfileEducationProfile2Activity::class.java))

            //Education Outline 1
            "FeatureTimelineEducationOutline1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureTimelineEducationOutline1Activity::class.java))

            //Education About us
            "FeatureAboutusEducationAboutus1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureAboutusEducationAboutus1Activity::class.java))

            //Report
            "FeatureReportFinanceReport1Activity" -> NavigationController.openActivity(activity, Intent(activity, FeatureReportFinanceReport1Activity::class.java))

            else -> Log.d("TEAMPS", "No Action")
        }

    }

    companion object {

        fun newInstance(): MainFeatureListFragment {
            return MainFeatureListFragment()
        }
    }
}// Required empty public constructor
