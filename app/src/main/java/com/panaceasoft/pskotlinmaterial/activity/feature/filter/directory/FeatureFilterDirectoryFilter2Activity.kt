package com.panaceasoft.pskotlinmaterial.activity.feature.filter.directory

import android.app.DatePickerDialog
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_filter_directory_filter_2_activity.*
import java.util.*

class FeatureFilterDirectoryFilter2Activity : AppCompatActivity() {

    private  var isClickFilter1 = false
    private  var isClickFilter2 = false
    private  var isClickFilter3 = false
    private  var isClickFilter4 = false

    private  var selectedList: Drawable? = null
    private  var notSelectedList: Drawable? = null

    private  var isClickSave = false
    private  var isClickLike = false
    private  var isClickFollow = false
    private  var isClickRecommend = false

    private  var isClickGroup = false
    private  var isClickWorking = false
    private  var isClickSingles = false
    private  var isClickDates = false

    private  var isClickAccepts = false
    private  var isClickDelivery = false
    private  var isClickHappy = false
    private  var isClickLive = false
    private  var isClickOutdoor = false
    private  var isClickParking = false

    internal var dateTime = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_filter_directory_filter_2_activity)

        initUI()

        initDataBinding()

        initActions()

    }

    //region Init Functions

    private fun initUI() {

        selectedList = ContextCompat.getDrawable(this,R.drawable.baseline_selected_list_24)

        notSelectedList = ContextCompat.getDrawable(this,R.drawable.baseline_add_filter_24)

    }

    private fun initDataBinding() {
        defaultSelected()
    }

    private fun initActions() {

        relevanceButton.setOnClickListener { sortByToggle("relevance") }

        distanceButton.setOnClickListener { sortByToggle("distance") }

        ratingButton.setOnClickListener { sortByToggle("rating") }

        filterBy1Button.setOnClickListener {
            if (!isClickFilter1) {
                filterBy1Button.setBackgroundColor(ContextCompat.getColor(this,R.color.md_blue_300))
                filterBy1Button.setTextColor(ContextCompat.getColor(this,R.color.md_blue_900))
                isClickFilter1 = true
            } else {
                filterBy1Button.setBackgroundColor(ContextCompat.getColor(this,R.color.md_white_1000))
                filterBy1Button.setTextColor(ContextCompat.getColor(this,R.color.colorTextLight))
                isClickFilter1 = false
            }
        }

        filterBy2Button.setOnClickListener {

            if (!isClickFilter2) {
                filterBy2Button.setBackgroundColor(ContextCompat.getColor(this,R.color.md_blue_300))
                filterBy2Button.setTextColor(ContextCompat.getColor(this,R.color.md_blue_900))
                isClickFilter2 = true
            } else {
                filterBy2Button.setBackgroundColor(ContextCompat.getColor(this,R.color.md_white_1000))
                filterBy2Button.setTextColor(ContextCompat.getColor(this,R.color.colorTextLight))
                isClickFilter2 = false
            }
        }

        filterBy3Button.setOnClickListener {
            if (!isClickFilter3) {
                filterBy3Button.setBackgroundColor(ContextCompat.getColor(this,R.color.md_blue_300))
                filterBy3Button.setTextColor(ContextCompat.getColor(this,R.color.md_blue_900))
                isClickFilter3 = true
            } else {
                filterBy3Button.setBackgroundColor(ContextCompat.getColor(this,R.color.md_white_1000))
                filterBy3Button.setTextColor(ContextCompat.getColor(this,R.color.colorTextLight))
                isClickFilter3 = false
            }
        }

        filterBy4Button.setOnClickListener {
            if (!isClickFilter4) {
                filterBy4Button.setBackgroundColor(ContextCompat.getColor(this,R.color.md_blue_300))
                filterBy4Button.setTextColor(ContextCompat.getColor(this,R.color.md_blue_900))
                isClickFilter4 = true
            } else {
                filterBy4Button.setBackgroundColor(ContextCompat.getColor(this,R.color.md_white_1000))
                filterBy4Button.setTextColor(ContextCompat.getColor(this,R.color.colorTextLight))
                isClickFilter4 = false
            }
        }

        openNowButton.setOnClickListener {
            openNowButton.setBackgroundColor(ContextCompat.getColor(this,R.color.md_blue_300))
            openNowButton.setTextColor(ContextCompat.getColor(this,R.color.md_blue_900))

            openAtButton.setBackgroundColor(ContextCompat.getColor(this,R.color.md_white_1000))
            openAtButton.setTextColor(ContextCompat.getColor(this,R.color.colorTextLight))
        }


        openAtButton.setOnClickListener(View.OnClickListener {

            val datePickerDialog = (DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                dateTime.set(Calendar.YEAR, year)
                dateTime.set(Calendar.MONTH, monthOfYear)
                dateTime.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            })

            DatePickerDialog(this, datePickerDialog, dateTime.get(Calendar.YEAR), dateTime.get(Calendar.MONTH), dateTime.get(Calendar.DAY_OF_MONTH)).show()

            openAtButton.setBackgroundColor(ContextCompat.getColor(this,R.color.md_blue_300))
            openAtButton.setTextColor(ContextCompat.getColor(this,R.color.md_blue_900))

            openNowButton.setBackgroundColor(ContextCompat.getColor(this,R.color.md_white_1000))
            openNowButton.setTextColor(ContextCompat.getColor(this,R.color.colorTextLight))
        })

        haveBeenButton.setOnClickListener { placeToggle("been") }

        haveNotButton.setOnClickListener { placeToggle("notbeen") }

        saveButton.setOnClickListener {
            if (!isClickSave) {
                setSelectDrawable(saveButton)
                isClickSave = true
            } else {
                setUnSelectDrawable(saveButton)
                isClickSave = false
            }
        }

        likeButton.setOnClickListener {
            if (!isClickLike) {
                setSelectDrawable(likeButton)
                isClickLike = true
            } else {
                setUnSelectDrawable(likeButton)
                isClickLike = false
            }
        }

        followButton.setOnClickListener {
            if (!isClickFollow) {
                setSelectDrawable(followButton)
                isClickFollow = true
            } else {
                setUnSelectDrawable(followButton)
                isClickFollow = false
            }
        }

        recommendedButton.setOnClickListener {
            if (!isClickRecommend) {
                setSelectDrawable(recommendedButton)
                isClickRecommend = true
            } else {
                setUnSelectDrawable(recommendedButton)
                isClickRecommend = false
            }
        }

        groupButton.setOnClickListener {
            if (!isClickGroup) {
                setSelectDrawable(groupButton)
                isClickGroup = true
            } else {
                setUnSelectDrawable(groupButton)
                isClickGroup = false
            }
        }

        workingButton.setOnClickListener {
            if (!isClickWorking) {
                setSelectDrawable(workingButton)
                isClickWorking = true
            } else {
                setUnSelectDrawable(workingButton)
                isClickWorking = false
            }
        }

        singlesButton.setOnClickListener {
            if (!isClickSingles) {
                setSelectDrawable(singlesButton)
                isClickSingles = true
            } else {
                setUnSelectDrawable(singlesButton)
                isClickSingles = false
            }
        }

        datesButton.setOnClickListener {
            if (!isClickDates) {
                setSelectDrawable(datesButton)
                isClickDates = true
            } else {
                setUnSelectDrawable(datesButton)
                isClickDates = false
            }
        }

        acceptsButton.setOnClickListener {
            if (!isClickAccepts) {
                setSelectDrawable(acceptsButton)
                isClickAccepts = true
            } else {
                setUnSelectDrawable(acceptsButton)
                isClickAccepts = false
            }
        }

        deliveryButton.setOnClickListener {
            if (!isClickDelivery) {
                setSelectDrawable(deliveryButton)
                isClickDelivery = true
            } else {
                setUnSelectDrawable(deliveryButton)
                isClickDelivery = false
            }
        }

        happyButton.setOnClickListener {
            if (!isClickHappy) {
                setSelectDrawable(happyButton)
                isClickHappy = true
            } else {
                setUnSelectDrawable(happyButton)
                isClickHappy = false
            }
        }

        liveButton.setOnClickListener {
            if (!isClickLive) {
                setSelectDrawable(liveButton)
                isClickLive = true
            } else {
                setUnSelectDrawable(liveButton)
                isClickLive = false
            }
        }

        outdoorButton.setOnClickListener {
            if (!isClickOutdoor) {
                setSelectDrawable(outdoorButton)
                isClickOutdoor = true
            } else {
                setUnSelectDrawable(outdoorButton)
                isClickOutdoor = false
            }
        }

        parkingButton.setOnClickListener {
            if (!isClickParking) {
                setSelectDrawable(parkingButton)
                isClickParking = true
            } else {
                setUnSelectDrawable(parkingButton)
                isClickParking = false
            }
        }
    }

    private fun setSelectDrawable(button: Button) {

        button.setBackgroundColor(ContextCompat.getColor(this,R.color.md_blue_300))
        button.setTextColor(ContextCompat.getColor(this,R.color.md_blue_900))

        if (Utils.isRTL) {
            button.setCompoundDrawablesWithIntrinsicBounds(selectedList, null, null, null)
        } else {
            button.setCompoundDrawablesWithIntrinsicBounds(null, null, selectedList, null)
        }
    }

    private fun setUnSelectDrawable(button: Button) {
        button.setBackgroundColor(ContextCompat.getColor(this,R.color.md_white_1000))
        button.setTextColor(ContextCompat.getColor(this,R.color.colorTextLight))

        if (Utils.isRTL) {
            button.setCompoundDrawablesWithIntrinsicBounds(notSelectedList, null, null, null)
        } else {
            button.setCompoundDrawablesWithIntrinsicBounds(null, null, notSelectedList, null)
        }
    }

    private fun sortByToggle(type: String) {

        when (type) {
            "relevance" -> {

                relevanceButton.setBackgroundColor(ContextCompat.getColor(this,R.color.md_blue_A200))
                relevanceButton.setTextColor(Color.WHITE)

                distanceButton.setBackgroundColor(ContextCompat.getColor(this,R.color.md_white_1000))
                distanceButton.setTextColor(ContextCompat.getColor(this,R.color.colorTextLight))

                ratingButton.setBackgroundColor(ContextCompat.getColor(this,R.color.md_white_1000))
                ratingButton.setTextColor(ContextCompat.getColor(this,R.color.colorTextLight))
            }
            "distance" -> {
                distanceButton.setBackgroundColor(ContextCompat.getColor(this,R.color.md_blue_A200))
                distanceButton.setTextColor(Color.WHITE)

                relevanceButton.setBackgroundColor(ContextCompat.getColor(this,R.color.md_white_1000))
                relevanceButton.setTextColor(ContextCompat.getColor(this,R.color.colorTextLight))

                ratingButton.setBackgroundColor(ContextCompat.getColor(this,R.color.md_white_1000))
                ratingButton.setTextColor(ContextCompat.getColor(this,R.color.colorTextLight))
            }
            "rating" -> {
                ratingButton.setBackgroundColor(ContextCompat.getColor(this,R.color.md_blue_A200))
                ratingButton.setTextColor(Color.WHITE)

                relevanceButton.setBackgroundColor(ContextCompat.getColor(this,R.color.md_white_1000))
                relevanceButton.setTextColor(ContextCompat.getColor(this,R.color.colorTextLight))

                distanceButton.setBackgroundColor(ContextCompat.getColor(this,R.color.md_white_1000))
                distanceButton.setTextColor(ContextCompat.getColor(this,R.color.colorTextLight))
            }
        }

    }


    private fun placeToggle(type: String) {

        if (type == "been") {

            setSelectDrawable(haveBeenButton)
            setUnSelectDrawable(haveNotButton)
        } else if (type == "notbeen") {

            setSelectDrawable(haveNotButton)
            setUnSelectDrawable(haveBeenButton)
        }

    }

    private fun defaultSelected() {
        sortByToggle("relevance")

        filterBy1Button.setBackgroundColor(ContextCompat.getColor(this,R.color.md_blue_300))
        filterBy1Button.setTextColor(ContextCompat.getColor(this,R.color.md_blue_900))
        isClickFilter1 = true

        filterBy2Button.setBackgroundColor(ContextCompat.getColor(this,R.color.md_blue_300))
        filterBy2Button.setTextColor(ContextCompat.getColor(this,R.color.md_blue_900))
        isClickFilter2 = true

        filterBy2Button.setBackgroundColor(ContextCompat.getColor(this,R.color.md_blue_300))
        filterBy2Button.setTextColor(ContextCompat.getColor(this,R.color.md_blue_900))

        openNowButton.setBackgroundColor(ContextCompat.getColor(this,R.color.md_blue_300))
        openNowButton.setTextColor(ContextCompat.getColor(this,R.color.md_blue_900))

        setSelectDrawable(saveButton)
        isClickSave = true

        setSelectDrawable(singlesButton)
        isClickSingles = true

        setSelectDrawable(happyButton)
        isClickHappy = true

    }
    //endregion
}
