package com.panaceasoft.pskotlinmaterial.fragment.feature.detail.education.detail1


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
import com.panaceasoft.pskotlinmaterial.`object`.EducationVideo
import com.panaceasoft.pskotlinmaterial.adapter.feature.detail.education.detail1.FeatureDetailEducationDetail1VideoAdapter
import com.panaceasoft.pskotlinmaterial.repository.education.EducationVideoListRepository

/**
 * A simple [Fragment] subclass.
 */
class FeatureDetailEducationDetail1Fragment2 : Fragment() {

    private lateinit var featureDetailEducationDetail1VideoAdapter: FeatureDetailEducationDetail1VideoAdapter
    private lateinit var videoRecyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.feature_detail_education_detail_1_fragment_2, container, false)

        initData()

        initUI(view)

        initDataBindings()

        initActions()

        return view

    }

    private fun initData() {

        featureDetailEducationDetail1VideoAdapter = FeatureDetailEducationDetail1VideoAdapter(EducationVideoListRepository.educationVideoList, 10)

    }

    private fun initUI(view: View) {
        val mLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        videoRecyclerView = view.findViewById(R.id.videoRecyclerView)
        videoRecyclerView.layoutManager = mLayoutManager
        videoRecyclerView.itemAnimator = DefaultItemAnimator()
        videoRecyclerView.isNestedScrollingEnabled = false
    }

    private fun initDataBindings() {
        videoRecyclerView.adapter = featureDetailEducationDetail1VideoAdapter
    }

    private fun initActions() {

        featureDetailEducationDetail1VideoAdapter.setOnItemClickListener(object : FeatureDetailEducationDetail1VideoAdapter.OnItemClickListener{
            override fun onItemClick(view: View, obj: EducationVideo, position: Int) {
                Toast.makeText(context, "Selected : " + obj.title, Toast.LENGTH_SHORT).show()
            }
        })
    }
}// Required empty public constructor
