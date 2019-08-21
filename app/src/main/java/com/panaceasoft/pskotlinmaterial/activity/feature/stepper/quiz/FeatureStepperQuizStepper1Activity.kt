package com.panaceasoft.pskotlinmaterial.activity.feature.stepper.quiz

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.QuizGeneral
import com.panaceasoft.pskotlinmaterial.fragment.feature.stepper.quiz.FeatureStepperQuizStepper1Fragment
import com.panaceasoft.pskotlinmaterial.repository.quiz.QuizGeneralListRepository
import kotlinx.android.synthetic.main.feature_stepper_quiz_stepper_1_activity.*

class FeatureStepperQuizStepper1Activity : AppCompatActivity(), FeatureStepperQuizStepper1Fragment.OnItemClickListener {

    private var position = 1
    private var maxPosition = 5
    private lateinit var quizGeneralList: List<QuizGeneral>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_stepper_quiz_stepper_1_activity)

        initData()

        initUI()

        initDataBinding()

        initActions()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(applicationContext, item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }


    //region Init Functions
    private fun initData() {
        quizGeneralList = QuizGeneralListRepository.quizGeneralList

        maxPosition = quizGeneralList.size
    }

    private fun initUI() {

        initToolbar()

        updatePositionTextView()

        setupFragment(FeatureStepperQuizStepper1Fragment.newInstance(quizGeneralList[position - 1], position - 1))

    }

    private fun updatePositionTextView() {

        imageNoTextView.text = "Question $position of $maxPosition"

        progressBar.progress = position

        if (position == 1) {
            prevButton.visibility = View.GONE
        } else if (position == maxPosition) {
            nextButton.visibility = View.GONE
        } else {
            prevButton.visibility = View.VISIBLE
            nextButton.visibility = View.VISIBLE
        }
    }

    private fun setupFragment(fragment: Fragment) {
        try {
            this.supportFragmentManager.beginTransaction()
                    .replace(R.id.contentLayout, fragment)
                    .commitAllowingStateLoss()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun initDataBinding() {

    }

    private fun initActions() {

        nextButton.setOnClickListener {

            if (position < maxPosition) {
                position++

                updatePositionTextView()
                setupFragment(FeatureStepperQuizStepper1Fragment.newInstance(quizGeneralList[position - 1], position - 1))
            } else {
                Toast.makeText(this, "No More Step.", Toast.LENGTH_SHORT).show()
            }
        }

        prevButton.setOnClickListener {

            if (position > 1) {
                position--

                updatePositionTextView()
                setupFragment(FeatureStepperQuizStepper1Fragment.newInstance(quizGeneralList[position - 1], position - 1))
            } else {
                Toast.makeText(this, "No More Step.", Toast.LENGTH_SHORT).show()
            }
        }


    }

    //region Init Toolbar
    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24)

        if (toolbar.navigationIcon != null) {
           toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Quiz Stepper 1"

        try {
           toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.md_white_1000))
        } catch (e: Exception) {
            Log.e("TEAMPS", "Can't set color.")
        }

        try {
            setSupportActionBar(toolbar)
        } catch (e: Exception) {
            Log.e("TEAMPS", "Error in set support action bar.")
        }

        try {
            if (supportActionBar != null) {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
        } catch (e: Exception) {
            Log.e("TEAMPS", "Error in set display home as up enabled.")
        }

    }

    override fun onItemClick(position: Int, selectedAnswer: Int) {
        quizGeneralList[position].selectedAnswer = selectedAnswer
    }

    //endregion
}