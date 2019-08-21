package com.panaceasoft.pskotlinmaterial.fragment.application.directory.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.UserHistory
import com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.directory.FeatureDashboardDirectoryDashboard3Adapter
import com.panaceasoft.pskotlinmaterial.repository.directory.UserHistoryRepository
import com.panaceasoft.pskotlinmaterial.utils.Utils

/**
 * A simple [Fragment] subclass.
 */
class AppDirectoryHome3Fragment : Fragment() {

    // data and adapter
    internal lateinit var userHistoryList: List<UserHistory>
    internal lateinit var adapter: FeatureDashboardDirectoryDashboard3Adapter
    internal lateinit var nestedScrollView: NestedScrollView

    // RecyclerView
    internal lateinit var recyclerView: RecyclerView

    internal lateinit var userImageView: ImageView
    internal lateinit var viewAllTextView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.app_directory_home_3_fragment, container, false)

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
        adapter = FeatureDashboardDirectoryDashboard3Adapter(userHistoryList)

        // get recycler view
        recyclerView = view.findViewById(R.id.recyclerView)
        val mLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.isNestedScrollingEnabled = false

        nestedScrollView = view.findViewById(R.id.nestedScrollView)

        viewAllTextView = view.findViewById(R.id.viewAllTextView)

        userImageView = view.findViewById(R.id.userImageView)


    }

    private fun initDataBinding() {
        // bind adapter to recycler
        recyclerView.adapter = adapter

        val id = R.drawable.user_profile_man
        Utils.setCircleImageToImageView(context, userImageView, id, 0, 0)

    }

    private fun initActions() {
        adapter.setOnItemClickListener(object : FeatureDashboardDirectoryDashboard3Adapter.OnItemClickListener {
            override fun onItemClick(view: View, obj: UserHistory, position: Int) {
                Toast.makeText(context, "Selected : " + obj.placeName, Toast.LENGTH_SHORT).show()
            }

            override fun onLikeClick(view: View, obj: UserHistory, position: Int) {
                Toast.makeText(context, "Clicked Liked.", Toast.LENGTH_SHORT).show()
            }

            override fun onAddClick(view: View, obj: UserHistory, position: Int) {
                Toast.makeText(context, "Clicked Add To Place.", Toast.LENGTH_SHORT).show()
            }
        })
        viewAllTextView.setOnClickListener { Toast.makeText(context, "Clicked : View All ", Toast.LENGTH_SHORT).show() }
    }


}// Required empty public constructor
