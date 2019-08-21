package com.panaceasoft.pskotlinmaterial.fragment.feature.dashboard.directory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.UserHistory
import com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.directory.FeatureDashboardDirectoryDashboard4Adapter
import com.panaceasoft.pskotlinmaterial.repository.directory.UserHistoryRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils

/**
 * Created by Panacea-Soft on 15/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureDashboardDirectoryDashboard4Fragment : Fragment() {


    // data and adapter
    internal lateinit var userHistoryList: List<UserHistory>
    internal lateinit var adapter: FeatureDashboardDirectoryDashboard4Adapter
    internal lateinit var nestedScrollView: NestedScrollView

    // RecyclerView
    internal lateinit var recyclerView: RecyclerView

    internal lateinit var userImageView: ImageView
    internal lateinit var expertise1ImageView: ImageView
    internal lateinit var expertise2ImageView: ImageView
    internal lateinit var expertise3ImageView: ImageView

    internal lateinit var editProfileButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.feature_dashboard_directory_dashboard_4_fragment, container, false)

        initData()

        initUI(view)

        initDataBinding()

        initActions()

        return view

    }

    private fun initData() {
        // get place list
        userHistoryList = UserHistoryRepository.historyList
    }

    private fun initUI(view: View) {
        // get list adapter
        adapter = FeatureDashboardDirectoryDashboard4Adapter(userHistoryList)

        // get recycler view
        recyclerView = view.findViewById(R.id.recyclerView)
        val mLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.isNestedScrollingEnabled = false

        nestedScrollView = view.findViewById(R.id.nestedScrollView)

        editProfileButton = view.findViewById(R.id.editProfileButton)

        userImageView = view.findViewById(R.id.userImageView)

        expertise1ImageView = view.findViewById(R.id.expertise1ImageView)
        expertise2ImageView = view.findViewById(R.id.expertise2ImageView)
        expertise3ImageView = view.findViewById(R.id.expertise3ImageView)
    }

    private fun initDataBinding() {
        // bind adapter to recycler
        recyclerView.adapter = adapter

        val id = R.drawable.user_profile_man
        Utils.setCircleImageToImageView(context, userImageView, id, 0, 0)

        val id1 = R.drawable.cafe1
        Utils.setImageToImageView(context!!, expertise1ImageView, id1)

        val id2 = R.drawable.cafe2
        Utils.setImageToImageView(context!!, expertise2ImageView, id2)

        val id3 = R.drawable.cafe3
        Utils.setImageToImageView(context!!, expertise3ImageView, id3)

    }

    private fun initActions() {
        adapter.setOnItemClickListener(object : FeatureDashboardDirectoryDashboard4Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: UserHistory, position: Int) {
                Toast.makeText(context, "Selected : " + obj.placeName, Toast.LENGTH_SHORT).show()
            }

            override fun onSaveClick(view: View, obj: UserHistory, position: Int) {
                Toast.makeText(context, "Clicked Save.", Toast.LENGTH_SHORT).show()
            }

            override fun onShareClick(view: View, obj: UserHistory, position: Int) {
                Toast.makeText(context, "Clicked Share.", Toast.LENGTH_SHORT).show()
            }
        })

        editProfileButton.setOnClickListener { Toast.makeText(context, "Clicked Edit Profile.", Toast.LENGTH_SHORT).show() }
    }

}// Required empty public constructor

