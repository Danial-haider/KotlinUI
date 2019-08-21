package com.panaceasoft.pskotlinmaterial.fragment.feature.timeline.general


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.TimelineTodo
import com.panaceasoft.pskotlinmaterial.adapter.feature.timeline.general.FeatureTimelineGeneralTimeline2Adapter
import com.panaceasoft.pskotlinmaterial.repository.todo.GeneralTimelineTodoRepository

class FeatureTimelineGeneralTimeline2Fragment : Fragment() {

    private lateinit var featureTimelineGeneralTimeline2Adapter: FeatureTimelineGeneralTimeline2Adapter
    private lateinit var videoRecyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.feature_timeline_general_timeline_2_fragment, container, false)

        initData()

        initUI(view)

        initDataBindings()

        initActions()

        return view

    }

    private fun initData() {
        featureTimelineGeneralTimeline2Adapter = FeatureTimelineGeneralTimeline2Adapter(GeneralTimelineTodoRepository.toDoList, 100)
    }

    private fun initUI(view: View) {
        val mLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        videoRecyclerView = view.findViewById(R.id.videoRecyclerView)
        videoRecyclerView.layoutManager = mLayoutManager
        videoRecyclerView.itemAnimator = DefaultItemAnimator()
        videoRecyclerView.isNestedScrollingEnabled = false
    }

    private fun initDataBindings() {
        videoRecyclerView.adapter = featureTimelineGeneralTimeline2Adapter
    }

    private fun initActions() {

        featureTimelineGeneralTimeline2Adapter.setOnItemClickListener(object : FeatureTimelineGeneralTimeline2Adapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: TimelineTodo, position: Int) {
                Toast.makeText(context, "Selected : " + obj.note, Toast.LENGTH_SHORT).show()
            }
        })
    }
}// Required empty public constructor

