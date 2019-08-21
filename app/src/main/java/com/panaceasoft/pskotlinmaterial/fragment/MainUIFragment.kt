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
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.adview.UiAdViewBannerActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.adview.UiAdViewFullScreenActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.appbarlayoutandtoolbar.UiAppBarLayoutAndToolbarBasicAppbarLayoutActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.appbarlayoutandtoolbar.UiAppBarLayoutAndToolbarCollapseAndPinActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.appbarlayoutandtoolbar.UiAppBarLayoutAndToolbarCollapsingAppbarLayoutActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.bottomappbar.*
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.bottomsheet.UiBottomSheetBasicBottomSheetActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.bottomsheet.UiBottomSheetBottomSheetDialogActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.bottomsheet.UiBottomSheetFloatingBottomSheetActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.buttons.UiButtonBasicButtonActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.buttons.UiButtonIconActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.buttons.UiButtonRoundedButtonActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.calendar.UiCalendarBasicCalendarActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.cards.UiCardsBasicCardViewActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.cards.UiCardsCardViewOverlapActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.cards.UiCardsCardViewPropertiesActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.checkbox.UiCheckboxBasicCheckboxActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.checkbox.UiCheckboxRoundedCheckboxActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.chips.UiChipsBasicChips1Activity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.chips.UiChipsFlexBoxAdjustmentActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.chips.UiChipsFlexBoxDirectionActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.dialogs.*
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.edittext.UiEditTextEditTextBasicActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.edittext.UiEditTextEditTextDatetimeActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.edittext.UiEditTextFormattedEditTextActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.expandable.UiExpandableExpandable1Activity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.expandable.UiExpandableExpandable2Activity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.fab.UiFabBasicFABActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.fab.UiFabHorizontalSubMenuFabActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.fab.UiFabSubMenuFabActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.fab.UiFabSubMenuWithTextFabActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.font.UiFontBasicFontActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.font.UiFontCustomFontActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.fragment.UiFragmentBasicFragmentActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.fragment.UiFragmentBasicFragmentFullInsideActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.grid.*
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.imagebutton.UiImageButtonBasicImageButtonActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.imageview.UiImageViewImageViewBasicActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.imageview.UiImageViewImageViewCircleShapeActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.imageview.UiImageViewImageViewScaleTypeActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.include.UiIncludeBasicIncludeActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.layout.constraint.UiLayoutConstraintLayoutAdjustViewActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.layout.constraint.UiLayoutConstraintLayoutBasicActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.layout.constraint.UiLayoutConstraintLayoutChainActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.layout.framelayout.UiLayoutFrameLayoutBasicActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.layout.gridlayout.UiLayoutGridLayoutBasicActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.layout.gridview.UiLayoutGridViewBasicActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.layout.linear.UiLayoutLinearLayoutBasicActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.layout.listview.UiLayoutListViewBasicActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.layout.listview.UiLayoutListViewCustomActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.layout.relativelayout.UiLayoutRelativeLayoutBasicActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.layout.table.UiLayoutTableLayoutBasicActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.list.*
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.mapviews.UiMapViewsBasicMapViewActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.mapviews.UiMapViewsMapViewCustomPinActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.mapviews.UiMapViewsSupportMapFragmentActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.navigationdrawer.*
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.pickers.UiPickersDatePickerActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.pickers.UiPickersTimePickerActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.progress.*
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.radiobutton.UiRadioButtonBasicRadioButtonActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.radiobutton.UiRadioButtonCustomRadioButtonActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.rating.UiRatingCustomRatingMultipleValueActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.rating.UiRatingPopupRatingActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.rating.UiRatingRatingBarBasicActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.requestfocus.UiRequestFocusBasicRequestFocusActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.requestfocus.UiRequestFocusRequestFocusCodeActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.scrollview.UiScrollViewHorizontalScrollViewActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.scrollview.UiScrollViewNestedScrollViewActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.scrollview.UiScrollViewVerticalScrollViewActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.searchview.UiSearchViewSearchViewBasicActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.searchview.UiSearchViewToolbarSearchViewActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.seekbar.UiSeekBarSeekBarBasicActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.seekbar.UiSeekBarSeekBarDiscreteActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.snackbars.*
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.spinner.UiSpinnerBasicSpinnerActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.spinner.UiSpinnerCustomSpinnerActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.steppers.UiStepperBasicSteppersTextActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.steppers.UiStepperDotsStepperActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.steppers.UiStepperProgressStepperActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.surfaceview.UiSurfaceViewSurfaceViewBasicActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.switchbutton.UiSwitchButtonBasicSwitchActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.tabs.*
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.text.UiTextTextViewAdvancedActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.text.UiTextTextViewBasicActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.textureview.UiTextureViewTextureViewBasicActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.toast.UiToastBasicToastActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.toast.UiToastCustomToastActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.togglebutton.UiToggleButtonBasicToggleButtonActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.videoview.UiVideoViewVideoViewBasicActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.viewstub.UiViewStubBasicViewStubActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.webview.UiWebViewWebViewBasicActivity
import com.panaceasoft.pskotlinmaterial.activity.uicomponent.webview.UiWebViewWebViewYouTubeActivity
import com.panaceasoft.pskotlinmaterial.adapter.MainThirdLevelListAdapter
import com.panaceasoft.pskotlinmaterial.utils.NavigationController
import com.panaceasoft.pskotlinmaterial.utils.Utils

/**
 * A simple [Fragment] subclass.
 */

class MainUIFragment : Fragment() {

    private var expandableListView: ExpandableListView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main_ui, container, false)

        val myJson = Utils.inputStreamToString(resources.openRawResource(R.raw.main_ui_list))

        val mainViewObjectList = Gson().fromJson<List<MainViewObject>>(myJson, object : TypeToken<List<MainViewObject>>() {

        }.type)

        expandableListView = view.findViewById(R.id.expandible_listview)

        // Passing third level of information to constructor
//        val mainThirdLevelListAdapter = MainThirdLevelListAdapter(context, mainViewObjectList, MainThirdLevelListAdapter.CellClickCallback { this.cellClicked(it) })
        val mainThirdLevelListAdapter = MainThirdLevelListAdapter(context!!, mainViewObjectList, object : MainThirdLevelListAdapter.CellClickCallback {
            override fun onClick(id: String) {
                cellClicked(id)
            }
        })
        expandableListView?.setAdapter(mainThirdLevelListAdapter)



        val cd = ColorDrawable( ContextCompat.getColor(container!!.context,R.color.colorLine))
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

                if (!(activity as MainActivity).isAds) {
                    (activity as MainActivity).getCustomLayoutDialog(R.layout.activity_main_dialog_layout)
                    (activity as MainActivity).isAds = true
                } else {
                    (activity as MainActivity).showFullScreenAds()
                    (activity as MainActivity).isAds = false
                }
                (activity as MainActivity).userClickCount = 0

                Log.d("TEAMPS", "cellClicked: Return")
                return
            }
        }

        when (id) {

            //AdView
            "UiAdViewBannerActivity" -> NavigationController.openActivity(activity, Intent(activity, UiAdViewBannerActivity::class.java))

            "UiAdViewFullScreenActivity" -> NavigationController.openActivity(activity, Intent(activity, UiAdViewFullScreenActivity::class.java))

            //AppBarLayoutAndToolbar
            "UiAppBarLayoutAndToolbarBasicAppbarLayoutActivity" -> NavigationController.openActivity(activity, Intent(activity, UiAppBarLayoutAndToolbarBasicAppbarLayoutActivity::class.java))

            "UiAppBarLayoutAndToolbarCollapsingAppbarLayoutActivity" -> NavigationController.openActivity(activity, Intent(activity, UiAppBarLayoutAndToolbarCollapsingAppbarLayoutActivity::class.java))

            "UiBottomAppBarCustomColorBottomNavigationViewActivity" -> NavigationController.openActivity(activity, Intent(activity, UiBottomAppBarCustomColorBottomNavigationViewActivity::class.java))

            "UiAppBarLayoutAndToolbarCollapseAndPinActivity" -> NavigationController.openActivity(activity, Intent(activity, UiAppBarLayoutAndToolbarCollapseAndPinActivity::class.java))

            //BottomAppBar
            "UiBottomAppBarBasicBottomNavigationViewActivity" -> NavigationController.openActivity(activity, Intent(activity, UiBottomAppBarBasicBottomNavigationViewActivity::class.java))

            "UiBottomAppBarBottomNavigationViewFabActivity" -> NavigationController.openActivity(activity, Intent(activity, UiBottomAppBarBottomNavigationViewFabActivity::class.java))

            "UiBottomAppBarBottomNavigationViewWithIconActivity" -> NavigationController.openActivity(activity, Intent(activity, UiBottomAppBarBottomNavigationViewWithIconActivity::class.java))

            "UiBottomAppBarWithFabActivity" -> NavigationController.openActivity(activity, Intent(activity, UiBottomAppBarWithFabActivity::class.java))

            "UiBottomAppBarShiftingBottomNavigationViewActivity" -> NavigationController.openActivity(activity, Intent(activity, UiBottomAppBarShiftingBottomNavigationViewActivity::class.java))

            "UiBottomAppBarOnScrollHideBottomNavigationViewActivity" -> NavigationController.openActivity(activity, Intent(activity, UiBottomAppBarOnScrollHideBottomNavigationViewActivity::class.java))
            //BottomSheet
            "UiBottomSheetFloatingBottomSheetActivity" -> NavigationController.openActivity(activity, Intent(activity, UiBottomSheetFloatingBottomSheetActivity::class.java))

            "UiBottomSheetBottomSheetDialogActivity" -> NavigationController.openActivity(activity, Intent(activity, UiBottomSheetBottomSheetDialogActivity::class.java))

            "UiBottomSheetBasicBottomSheetActivity" -> NavigationController.openActivity(activity, Intent(activity, UiBottomSheetBasicBottomSheetActivity::class.java))

            //Button
            "UiButtonBasicButtonActivity" -> NavigationController.openActivity(activity, Intent(activity, UiButtonBasicButtonActivity::class.java))

            "UiButtonIconActivity" -> NavigationController.openActivity(activity, Intent(activity, UiButtonIconActivity::class.java))

            "UiButtonRoundedButtonActivity" -> NavigationController.openActivity(activity, Intent(activity, UiButtonRoundedButtonActivity::class.java))


            //Calendar
            "UiCalendarBasicCalendarActivity" -> NavigationController.openActivity(activity, Intent(activity, UiCalendarBasicCalendarActivity::class.java))

            //Cards
            "UiCardsBasicCardViewActivity" -> NavigationController.openActivity(activity, Intent(activity, UiCardsBasicCardViewActivity::class.java))

            "UiCardsCardViewPropertiesActivity" -> NavigationController.openActivity(activity, Intent(activity, UiCardsCardViewPropertiesActivity::class.java))

            "UiCardsCardViewOverlapActivity" -> NavigationController.openActivity(activity, Intent(activity, UiCardsCardViewOverlapActivity::class.java))
            //Checkbox
            "UiCheckboxBasicCheckboxActivity" -> NavigationController.openActivity(activity, Intent(activity, UiCheckboxBasicCheckboxActivity::class.java))

            "UiCheckboxRoundedCheckboxActivity" -> NavigationController.openActivity(activity, Intent(activity, UiCheckboxRoundedCheckboxActivity::class.java))

            //Dialogs
            "UiDialogsDialogSuccessActivity" -> NavigationController.openActivity(activity, Intent(activity, UiDialogsDialogSuccessActivity::class.java))

            "UiDialogsDialogAlertActivity" -> NavigationController.openActivity(activity, Intent(activity, UiDialogsDialogAlertActivity::class.java))

            "UiDialogsDialogConfirmActivity" -> NavigationController.openActivity(activity, Intent(activity, UiDialogsDialogConfirmActivity::class.java))

            "UiDialogsDialogInfoActivity" -> NavigationController.openActivity(activity, Intent(activity, UiDialogsDialogInfoActivity::class.java))

            "UiDialogsDialogCustomActivity" -> NavigationController.openActivity(activity, Intent(activity, UiDialogsDialogCustomActivity::class.java))

            "UiDialogsDialogSingleChoiceActivity" -> NavigationController.openActivity(activity, Intent(activity, UiDialogsDialogSingleChoiceActivity::class.java))

            "UiDialogsDialogMultiChoiceActivity" -> NavigationController.openActivity(activity, Intent(activity, UiDialogsDialogMultiChoiceActivity::class.java))

            //EditText
            "UiEditTextEditTextBasicActivity" -> NavigationController.openActivity(activity, Intent(activity, UiEditTextEditTextBasicActivity::class.java))

            "UiEditTextEditTextDatetimeActivity" -> NavigationController.openActivity(activity, Intent(activity, UiEditTextEditTextDatetimeActivity::class.java))

            "UiEditTextFormattedEditTextActivity" -> NavigationController.openActivity(activity, Intent(activity, UiEditTextFormattedEditTextActivity::class.java))

            //ImageView
            "UiImageViewImageViewBasicActivity" -> NavigationController.openActivity(activity, Intent(activity, UiImageViewImageViewBasicActivity::class.java))

            "UiImageViewImageViewScaleTypeActivity" -> NavigationController.openActivity(activity, Intent(activity, UiImageViewImageViewScaleTypeActivity::class.java))

            "UiImageViewImageViewCircleShapeActivity" -> NavigationController.openActivity(activity, Intent(activity, UiImageViewImageViewCircleShapeActivity::class.java))

            //Progress
            "UiProgressProgressBarBasicActivity" -> NavigationController.openActivity(activity, Intent(activity, UiProgressProgressBarBasicActivity::class.java))

            "UiProgressProgressBarHorizontalActivity" -> NavigationController.openActivity(activity, Intent(activity, UiProgressProgressBarHorizontalActivity::class.java))

            "UiProgressOnScrollProgressActivity" -> NavigationController.openActivity(activity, Intent(activity, UiProgressOnScrollProgressActivity::class.java))

            "UiProgressPullRefreshProgressActivity" -> NavigationController.openActivity(activity, Intent(activity, UiProgressPullRefreshProgressActivity::class.java))

            "UiProgressLinearBottomProgressActivity" -> NavigationController.openActivity(activity, Intent(activity, UiProgressLinearBottomProgressActivity::class.java))

            "UiProgressLinearCenterProgressActivity" -> NavigationController.openActivity(activity, Intent(activity, UiProgressLinearCenterProgressActivity::class.java))

            "UiProgressLinearTopProgressActivity" -> NavigationController.openActivity(activity, Intent(activity, UiProgressLinearTopProgressActivity::class.java))
            //Rating
            "UiRatingRatingBarBasicActivity" -> NavigationController.openActivity(activity, Intent(activity, UiRatingRatingBarBasicActivity::class.java))

            "UiRatingPopupRatingActivity" -> NavigationController.openActivity(activity, Intent(activity, UiRatingPopupRatingActivity::class.java))

            "UiRatingCustomRatingMultipleValueActivity" -> NavigationController.openActivity(activity, Intent(activity, UiRatingCustomRatingMultipleValueActivity::class.java))


            //SearchView
            "UiSearchViewSearchViewBasicActivity" -> NavigationController.openActivity(activity, Intent(activity, UiSearchViewSearchViewBasicActivity::class.java))

            "UiSearchViewToolbarSearchViewActivity" -> NavigationController.openActivity(activity, Intent(activity, UiSearchViewToolbarSearchViewActivity::class.java))

            //SeekBar
            "UiSeekBarSeekBarBasicActivity" -> NavigationController.openActivity(activity, Intent(activity, UiSeekBarSeekBarBasicActivity::class.java))

            "UiSeekBarSeekBarDiscreteActivity" -> NavigationController.openActivity(activity, Intent(activity, UiSeekBarSeekBarDiscreteActivity::class.java))
            //SnackBars
            "UiSnackBarsSnackBarBasicActivity" -> NavigationController.openActivity(activity, Intent(activity, UiSnackBarsSnackBarBasicActivity::class.java))

            "UiSnackBarsSnackBarActionButtonActivity" -> NavigationController.openActivity(activity, Intent(activity, UiSnackBarsSnackBarActionButtonActivity::class.java))

            "UiSnackBarsSnackBarCustomColorActivity" -> NavigationController.openActivity(activity, Intent(activity, UiSnackBarsSnackBarCustomColorActivity::class.java))

            "UiSnackBarsSnackBarAndLiftFabActivity" -> NavigationController.openActivity(activity, Intent(activity, UiSnackBarsSnackBarAndLiftFabActivity::class.java))

            "UiSnackBarsCustomSnackBarActivity" -> NavigationController.openActivity(activity, Intent(activity, UiSnackBarsCustomSnackBarActivity::class.java))
            //SurfaceView
            "UiSurfaceViewSurfaceViewBasicActivity" -> NavigationController.openActivity(activity, Intent(activity, UiSurfaceViewSurfaceViewBasicActivity::class.java))

            //TextureView
            "UiTextureViewTextureViewBasicActivity" -> NavigationController.openActivity(activity, Intent(activity, UiTextureViewTextureViewBasicActivity::class.java))

            //VideoView
            "UiVideoViewVideoViewBasicActivity" -> NavigationController.openActivity(activity, Intent(activity, UiVideoViewVideoViewBasicActivity::class.java))

            //WebView
            "UiWebViewWebViewBasicActivity" -> NavigationController.openActivity(activity, Intent(activity, UiWebViewWebViewBasicActivity::class.java))

            "UiWebViewWebViewYouTubeActivity" -> NavigationController.openActivity(activity, Intent(activity, UiWebViewWebViewYouTubeActivity::class.java))

            //Text
            "UiTextTextViewBasicActivity" -> NavigationController.openActivity(activity, Intent(activity, UiTextTextViewBasicActivity::class.java))

            "UiTextTextViewAdvancedActivity" -> NavigationController.openActivity(activity, Intent(activity, UiTextTextViewAdvancedActivity::class.java))

            //FAB
            "UiFabBasicFABActivity" -> NavigationController.openActivity(activity, Intent(activity, UiFabBasicFABActivity::class.java))

            "UiFabSubMenuFabActivity" -> NavigationController.openActivity(activity, Intent(activity, UiFabSubMenuFabActivity::class.java))

            "UiFabSubMenuWithTextFabActivity" -> NavigationController.openActivity(activity, Intent(activity, UiFabSubMenuWithTextFabActivity::class.java))

            "UiFabHorizontalSubMenuFabActivity" -> NavigationController.openActivity(activity, Intent(activity, UiFabHorizontalSubMenuFabActivity::class.java))

            //ImageButton
            "UiImageButtonBasicImageButtonActivity" -> NavigationController.openActivity(activity, Intent(activity, UiImageButtonBasicImageButtonActivity::class.java))

            //RadioButton
            "UiRadioButtonBasicRadioButtonActivity" -> NavigationController.openActivity(activity, Intent(activity, UiRadioButtonBasicRadioButtonActivity::class.java))

            "UiRadioButtonCustomRadioButtonActivity" -> NavigationController.openActivity(activity, Intent(activity, UiRadioButtonCustomRadioButtonActivity::class.java))

            //SwitchButton
            "UiSwitchButtonBasicSwitchActivity" -> NavigationController.openActivity(activity, Intent(activity, UiSwitchButtonBasicSwitchActivity::class.java))

            //ToggleButton
            "UiToggleButtonBasicToggleButtonActivity" -> NavigationController.openActivity(activity, Intent(activity, UiToggleButtonBasicToggleButtonActivity::class.java))

            //Fragment
            "UiFragmentBasicFragmentActivity" -> NavigationController.openActivity(activity, Intent(activity, UiFragmentBasicFragmentActivity::class.java))

            "UiFragmentBasicFragmentFullInsideActivity" -> NavigationController.openActivity(activity, Intent(activity, UiFragmentBasicFragmentFullInsideActivity::class.java))
            //Include
            "UiIncludeBasicIncludeActivity" -> NavigationController.openActivity(activity, Intent(activity, UiIncludeBasicIncludeActivity::class.java))

            //RequestFocus
            "UiRequestFocusBasicRequestFocusActivity" -> NavigationController.openActivity(activity, Intent(activity, UiRequestFocusBasicRequestFocusActivity::class.java))

            "UiRequestFocusRequestFocusCodeActivity" -> NavigationController.openActivity(activity, Intent(activity, UiRequestFocusRequestFocusCodeActivity::class.java))

            //ScrollView
            "UiScrollViewVerticalScrollViewActivity" -> NavigationController.openActivity(activity, Intent(activity, UiScrollViewVerticalScrollViewActivity::class.java))

            "UiScrollViewNestedScrollViewActivity" -> NavigationController.openActivity(activity, Intent(activity, UiScrollViewNestedScrollViewActivity::class.java))

            "UiScrollViewHorizontalScrollViewActivity" -> NavigationController.openActivity(activity, Intent(activity, UiScrollViewHorizontalScrollViewActivity::class.java))

            //Spinner
            "UiSpinnerBasicSpinnerActivity" -> NavigationController.openActivity(activity, Intent(activity, UiSpinnerBasicSpinnerActivity::class.java))

            "UiSpinnerCustomSpinnerActivity" -> NavigationController.openActivity(activity, Intent(activity, UiSpinnerCustomSpinnerActivity::class.java))

            //TabLayout
            "UiTabsBasicTabLayoutActivity" -> NavigationController.openActivity(activity, Intent(activity, UiTabsBasicTabLayoutActivity::class.java))

            "UiTabsScrollableTabLayoutActivity" -> NavigationController.openActivity(activity, Intent(activity, UiTabsScrollableTabLayoutActivity::class.java))

            "UiTabsStickyTabLayoutActivity" -> NavigationController.openActivity(activity, Intent(activity, UiTabsStickyTabLayoutActivity::class.java))

            "UiTabsTabLayoutWithIconActivity" -> NavigationController.openActivity(activity, Intent(activity, UiTabsTabLayoutWithIconActivity::class.java))

            "UiTabsTabLayoutWithTextAndIconActivity" -> NavigationController.openActivity(activity, Intent(activity, UiTabsTabLayoutWithTextAndIconActivity::class.java))
            //ViewStub

            "UiViewStubBasicViewStubActivity" -> NavigationController.openActivity(activity, Intent(activity, UiViewStubBasicViewStubActivity::class.java))

            //Chips
            "UiChipsFlexBoxDirectionActivity" -> NavigationController.openActivity(activity, Intent(activity, UiChipsFlexBoxDirectionActivity::class.java))

            "UiChipsFlexBoxAdjustmentActivity" -> NavigationController.openActivity(activity, Intent(activity, UiChipsFlexBoxAdjustmentActivity::class.java))

            "UiChipsBasicChips1Activity" -> NavigationController.openActivity(activity, Intent(activity, UiChipsBasicChips1Activity::class.java))

            //MapViews
            "UiMapViewsSupportMapFragmentActivity" -> NavigationController.openActivity(activity, Intent(activity, UiMapViewsSupportMapFragmentActivity::class.java))

            "UiMapViewsBasicMapViewActivity" -> NavigationController.openActivity(activity, Intent(activity, UiMapViewsBasicMapViewActivity::class.java))

            "UiMapViewsMapViewCustomPinActivity" -> NavigationController.openActivity(activity, Intent(activity, UiMapViewsMapViewCustomPinActivity::class.java))

            //Pickers
            "UiPickersDatePickerActivity" -> NavigationController.openActivity(activity, Intent(activity, UiPickersDatePickerActivity::class.java))

            "UiPickersTimePickerActivity" -> NavigationController.openActivity(activity, Intent(activity, UiPickersTimePickerActivity::class.java))

            //Layouts
            "UiLayoutListViewBasicActivity" -> NavigationController.openActivity(activity, Intent(activity, UiLayoutListViewBasicActivity::class.java))

            "UiLayoutListViewCustomActivity" -> NavigationController.openActivity(activity, Intent(activity, UiLayoutListViewCustomActivity::class.java))

            "UiLayoutGridLayoutBasicActivity" -> NavigationController.openActivity(activity, Intent(activity, UiLayoutGridLayoutBasicActivity::class.java))

            "UiLayoutRelativeLayoutBasicActivity" -> NavigationController.openActivity(activity, Intent(activity, UiLayoutRelativeLayoutBasicActivity::class.java))

            "UiLayoutGridViewBasicActivity" -> NavigationController.openActivity(activity, Intent(activity, UiLayoutGridViewBasicActivity::class.java))

            "UiLayoutLinearLayoutBasicActivity" -> NavigationController.openActivity(activity, Intent(activity, UiLayoutLinearLayoutBasicActivity::class.java))

            "UiLayoutConstraintLayoutBasicActivity" -> NavigationController.openActivity(activity, Intent(activity, UiLayoutConstraintLayoutBasicActivity::class.java))

            "UiLayoutConstraintLayoutAdjustViewActivity" -> NavigationController.openActivity(activity, Intent(activity, UiLayoutConstraintLayoutAdjustViewActivity::class.java))

            "UiLayoutConstraintLayoutChainActivity" -> NavigationController.openActivity(activity, Intent(activity, UiLayoutConstraintLayoutChainActivity::class.java))

            "UiLayoutFrameLayoutBasicActivity" -> NavigationController.openActivity(activity, Intent(activity, UiLayoutFrameLayoutBasicActivity::class.java))

            "UiLayoutTableLayoutBasicActivity" -> NavigationController.openActivity(activity, Intent(activity, UiLayoutTableLayoutBasicActivity::class.java))

            //Menu
            "UiNavigationDrawerBasicNavigationDrawerActivity" -> NavigationController.openActivity(activity, Intent(activity, UiNavigationDrawerBasicNavigationDrawerActivity::class.java))

            "UiNavigationDrawerNavigationDrawer1Activity" -> NavigationController.openActivity(activity, Intent(activity, UiNavigationDrawerNavigationDrawer1Activity::class.java))

            "UiNavigationDrawerNavigationDrawer2Activity" -> NavigationController.openActivity(activity, Intent(activity, UiNavigationDrawerNavigationDrawer2Activity::class.java))

            "UiNavigationDrawerNavigationDrawer3Activity" -> NavigationController.openActivity(activity, Intent(activity, UiNavigationDrawerNavigationDrawer3Activity::class.java))

            "UiNavigationDrawerNavigationDrawer4Activity" -> NavigationController.openActivity(activity, Intent(activity, UiNavigationDrawerNavigationDrawer4Activity::class.java))

            "UiNavigationDrawerNavigationDrawer5Activity" -> NavigationController.openActivity(activity, Intent(activity, UiNavigationDrawerNavigationDrawer5Activity::class.java))

            "UiNavigationDrawerNavigationDrawer6Activity" -> NavigationController.openActivity(activity, Intent(activity, UiNavigationDrawerNavigationDrawer6Activity::class.java))

            "UiNavigationDrawerNavigationDrawer7Activity" -> NavigationController.openActivity(activity, Intent(activity, UiNavigationDrawerNavigationDrawer7Activity::class.java))

            //Grid
            "UiGridBasicGridActivity" -> NavigationController.openActivity(activity, Intent(activity, UiGridBasicGridActivity::class.java))

            "UiGridGridWithThreeColumnsActivity" -> NavigationController.openActivity(activity, Intent(activity, UiGridGridWithThreeColumnsActivity::class.java))

            "UiGridGridWithAlphaViewActivity" -> NavigationController.openActivity(activity, Intent(activity, UiGridGridWithAlphaViewActivity::class.java))

            "UiGridGridWithMultipleLineIconActivity" -> NavigationController.openActivity(activity, Intent(activity, UiGridGridWithMultipleLineIconActivity::class.java))

            "UiGridGridWithMultipleTextLinesActivity" -> NavigationController.openActivity(activity, Intent(activity, UiGridGridWithMultipleTextLinesActivity::class.java))

            "UiGridGridWithSingleLineIconActivity" -> NavigationController.openActivity(activity, Intent(activity, UiGridGridWithSingleLineIconActivity::class.java))

            "UiGridGridWithSingleTextLineActivity" -> NavigationController.openActivity(activity, Intent(activity, UiGridGridWithSingleTextLineActivity::class.java))

            "UiGridPinterestGridActivity" -> NavigationController.openActivity(activity, Intent(activity, UiGridPinterestGridActivity::class.java))

            "UiGridSectionedGridActivity" -> NavigationController.openActivity(activity, Intent(activity, UiGridSectionedGridActivity::class.java))
            //List
            "UiListBasicListActivity" -> NavigationController.openActivity(activity, Intent(activity, UiListBasicListActivity::class.java))

            "UiListDragAndDropListActivity" -> NavigationController.openActivity(activity, Intent(activity, UiListDragAndDropListActivity::class.java))

            "UiListExpandableListActivity" -> NavigationController.openActivity(activity, Intent(activity, UiListExpandableListActivity::class.java))

            "UiListScrollToTopListActivity" -> NavigationController.openActivity(activity, Intent(activity, UiListScrollToTopListActivity::class.java))

            "UiListSectionedListActivity" -> NavigationController.openActivity(activity, Intent(activity, UiListSectionedListActivity::class.java))

            "UiListStickyHeaderListActivity" -> NavigationController.openActivity(activity, Intent(activity, UiListStickyHeaderListActivity::class.java))

            "UiListSwipeToDismissListActivity" -> NavigationController.openActivity(activity, Intent(activity, UiListSwipeToDismissListActivity::class.java))

            "UiListSwipeToDismissListWithConfirmActivity" -> NavigationController.openActivity(activity, Intent(activity, UiListSwipeToDismissListWithConfirmActivity::class.java))

            "UiListMultipleSelectionListActivity" -> NavigationController.openActivity(activity, Intent(activity, UiListMultipleSelectionListActivity::class.java))
            //Expandable
            "UiExpandableExpandable1Activity" -> NavigationController.openActivity(activity, Intent(activity, UiExpandableExpandable1Activity::class.java))

            "UiExpandableExpandable2Activity" -> NavigationController.openActivity(activity, Intent(activity, UiExpandableExpandable2Activity::class.java))

            //Stepper
            "UiStepperBasicSteppersTextActivity" -> NavigationController.openActivity(activity, Intent(activity, UiStepperBasicSteppersTextActivity::class.java))

            "UiStepperDotsStepperActivity" -> NavigationController.openActivity(activity, Intent(activity, UiStepperDotsStepperActivity::class.java))

            "UiStepperProgressStepperActivity" -> NavigationController.openActivity(activity, Intent(activity, UiStepperProgressStepperActivity::class.java))
            //Font
            "UiFontBasicFontActivity" -> NavigationController.openActivity(activity, Intent(activity, UiFontBasicFontActivity::class.java))

            "UiFontCustomFontActivity" -> NavigationController.openActivity(activity, Intent(activity, UiFontCustomFontActivity::class.java))

            //Toast
            "UiToastBasicToastActivity" -> NavigationController.openActivity(activity, Intent(activity, UiToastBasicToastActivity::class.java))
            "UiToastCustomToastActivity" -> NavigationController.openActivity(activity, Intent(activity, UiToastCustomToastActivity::class.java))

            else -> Log.d("TEAMPS", "No Action")
        }

    }

    companion object {

        fun newInstance(): MainUIFragment {
            return MainUIFragment()
        }
    }

}// Required empty public constructor
