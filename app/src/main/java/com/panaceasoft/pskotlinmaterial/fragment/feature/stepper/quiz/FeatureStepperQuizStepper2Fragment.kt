package com.panaceasoft.pskotlinmaterial.fragment.feature.stepper.quiz


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.QuizGeneral
import com.panaceasoft.pskotlinmaterial.utils.Utils

/**
 * A simple [Fragment] subclass.
 */
class FeatureStepperQuizStepper2Fragment : Fragment() {

    private  var question: String? =null
    private  var answer1: String? =null
    private  var answer2: String? =null
    private  var answer3: String? =null
    private  var answer4: String? =null
    private  var answer5: String? =null
    private  var image: String? =null
    private  var correctAnswer: Int = 0
    private  var selectedAnswer: Int = 0
    private lateinit var listener: OnItemClickListener
    private  var position: Int = 0

    private lateinit var constraintLayout: ConstraintLayout

    interface OnItemClickListener {
        fun onItemClick(position: Int, selectedAnswer: Int)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        question = if (arguments != null) arguments?.getString("QUESTION") else ""
        answer1 = if (arguments != null) arguments?.getString("ANSWER1") else ""
        answer2 = if (arguments != null) arguments?.getString("ANSWER2") else ""
        answer3 = if (arguments != null) arguments?.getString("ANSWER3") else ""
        answer4 = if (arguments != null) arguments?.getString("ANSWER4") else ""
        answer5 = if (arguments != null) arguments?.getString("ANSWER5") else ""
        image = if (arguments != null) arguments?.getString("IMAGE") else ""
        position = if (arguments != null) arguments!!.getInt("POSITION") else 0
        correctAnswer = Integer.parseInt(if (arguments != null) arguments!!.getString("CORRECT_ANSWER") else "0")
        selectedAnswer = if (arguments != null) arguments!!.getInt("SELECTED_ANSWER") else 0

        try {
            listener = activity as OnItemClickListener
        } catch (e: ClassCastException) {
            e.printStackTrace()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.feature_stepper_quiz_stepper_2_fragment, container, false)

        val quizImageView = view.findViewById<ImageView>(R.id.quizImageView)
        if (context != null) {
            val id = Utils.getDrawableInt(context, image!!)
            Utils.setImageToImageView(context!!, quizImageView, id)
        }

        val questionTextView = view.findViewById<TextView>(R.id.questionTextView)
        questionTextView.text = question

        val aTextView = view.findViewById<TextView>(R.id.aTextView)
        aTextView.text = answer1
        val bTextView = view.findViewById<TextView>(R.id.bTextView)
        bTextView.text = answer2
        val cTextView = view.findViewById<TextView>(R.id.cTextView)
        cTextView.text = answer3
        val dTextView = view.findViewById<TextView>(R.id.dTextView)
        dTextView.text = answer4
        val eTextView = view.findViewById<TextView>(R.id.eTextView)
        eTextView.text = answer5

        constraintLayout = view.findViewById(R.id.constraintLayout)

        val aConstraintLayout = view.findViewById<ConstraintLayout>(R.id.aConstraintLayout)
        val bConstraintLayout = view.findViewById<ConstraintLayout>(R.id.bConstraintLayout)
        val cConstraintLayout = view.findViewById<ConstraintLayout>(R.id.cConstraintLayout)
        val dConstraintLayout = view.findViewById<ConstraintLayout>(R.id.dConstraintLayout)
        val eConstraintLayout = view.findViewById<ConstraintLayout>(R.id.eConstraintLayout)


        if (selectedAnswer == 1) {
            setHightLight(aConstraintLayout)
        } else if (selectedAnswer == 2) {
            setHightLight(bConstraintLayout)
        } else if (selectedAnswer == 3) {
            setHightLight(cConstraintLayout)
        } else if (selectedAnswer == 4) {
            setHightLight(dConstraintLayout)
        } else if (selectedAnswer == 5) {
            setHightLight(eConstraintLayout)
        }

        aConstraintLayout.setOnClickListener { view1 ->
            resetAllButton()
            selectedAnswer = 1
            listener.onItemClick(position, selectedAnswer)

            setHightLight(view1)
        }

        bConstraintLayout.setOnClickListener { view2 ->
            resetAllButton()
            selectedAnswer = 2
            listener.onItemClick(position, selectedAnswer)

            setHightLight(view2)
        }

        cConstraintLayout.setOnClickListener { view3 ->
            resetAllButton()
            selectedAnswer = 3
            listener.onItemClick(position, selectedAnswer)

            setHightLight(view3)
        }

        dConstraintLayout.setOnClickListener { view4 ->
            resetAllButton()
            selectedAnswer = 4
            listener.onItemClick(position, selectedAnswer)

            setHightLight(view4)
        }

        eConstraintLayout.setOnClickListener { view5 ->
            resetAllButton()
            selectedAnswer = 5
            listener.onItemClick(position, selectedAnswer)

            setHightLight(view5)
        }

        return view
    }

    private fun setHightLight(view: View) {
        if (correctAnswer == selectedAnswer) {
            view.setBackgroundColor(ContextCompat.getColor(context!!,R.color.md_light_green_A100))
        } else {
            view.setBackgroundColor(ContextCompat.getColor(context!!,R.color.md_red_50))
        }
    }

    private fun resetAllButton() {

        try {
            if (context != null) {
                val color = ContextCompat.getColor(context!!, R.color.md_white_1000)

                for (index in 0 until constraintLayout.getChildCount()) {
                    val nextChild = constraintLayout.getChildAt(index)

                    if (nextChild is ConstraintLayout) {
                        nextChild.setBackgroundColor(color)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    companion object {

        fun newInstance(quizGeneral: QuizGeneral, position: Int): FeatureStepperQuizStepper2Fragment {
            val fragment = FeatureStepperQuizStepper2Fragment()

            // Supply num input as an argument.
            val args = Bundle()
            args.putString("QUESTION", quizGeneral.question)
            args.putString("ANSWER1", quizGeneral.answer1)
            args.putString("ANSWER2", quizGeneral.answer2)
            args.putString("ANSWER3", quizGeneral.answer3)
            args.putString("ANSWER4", quizGeneral.answer4)
            args.putString("ANSWER5", quizGeneral.answer5)
            args.putString("IMAGE", quizGeneral.image)
            args.putString("CORRECT_ANSWER", quizGeneral.correctAnswer)
            args.putInt("SELECTED_ANSWER", quizGeneral.selectedAnswer)

            args.putInt("POSITION", position)
            fragment.arguments = args

            return fragment
        }
    }

}// Required empty public constructor
