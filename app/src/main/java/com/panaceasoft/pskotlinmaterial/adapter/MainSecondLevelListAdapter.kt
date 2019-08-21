package com.panaceasoft.pskotlinmaterial.adapter

import android.content.Context
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.MainViewSecondLevelObject
import com.panaceasoft.pskotlinmaterial.databinding.MainSecondRowBinding
import com.panaceasoft.pskotlinmaterial.databinding.MainThirdRowBinding

/**
 * Created by Panacea-Soft on 5/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


@Suppress("NAME_SHADOWING")
class MainSecondLevelListAdapter(//private final android.databinding.DataBindingComponent dataBindingComponent;
        private val context: Context, private val groupPosition: Int, private val mainViewSecondLevelObjectList: List<MainViewSecondLevelObject>, private val cellClickCallback: MainSecondLevelListAdapter.CellClickCallback)//this.dataBindingComponent = dataBindingComponent;
    : BaseExpandableListAdapter() {


    override fun getGroup(groupPosition: Int): Any {

        return mainViewSecondLevelObjectList[groupPosition]
    }

    override fun getGroupCount(): Int {

        return mainViewSecondLevelObjectList.size
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup): View {

        val convertView = convertView
            val binding = DataBindingUtil.inflate<MainSecondRowBinding>(LayoutInflater.from(parent.context),
                    R.layout.main_second_row, parent, false)
        if (convertView == null) {
            val imageResourceId = if (isExpanded)
                R.drawable.ic_arrow_drop_up_black_24dp
            else
                R.drawable.ic_arrow_drop_down_black_24dp

            binding.subHeaderImageView.setImageResource(imageResourceId)
        }
            if (mainViewSecondLevelObjectList[groupPosition].isNew == "true") {
                binding.subHeaderImageView.setColorFilter(ContextCompat.getColor(context, R.color.md_orange_800), PorterDuff.Mode.SRC_IN)
                binding.subHeaderTextView.setTextColor(ContextCompat.getColor(context, R.color.md_orange_800))
                if (mainViewSecondLevelObjectList[groupPosition].thirdLevelObjectList.size <= 0) {
                    binding.newImageView.visibility = View.VISIBLE
                } else {
                    binding.newImageView.visibility = View.GONE
                }
            } else {
                binding.subHeaderImageView.setColorFilter(ContextCompat.getColor(context, R.color.md_grey_400), PorterDuff.Mode.SRC_IN)
                binding.newImageView.visibility = View.GONE
            }
            val mainViewThirdLevelObjectList = mainViewSecondLevelObjectList[groupPosition].thirdLevelObjectList
            if (mainViewThirdLevelObjectList.size <= 0) {
                binding.subHeaderImageView.visibility = View.GONE
                binding.subHeaderTextView.setOnClickListener {

                    if (binding.secondLevelObj != null) {
                        cellClickCallback.onClick(binding.secondLevelObj!!.id)
                    }
                }
            } else if (mainViewThirdLevelObjectList.size == 1) {
                if (mainViewThirdLevelObjectList[0].id == "") {
                    binding.subHeaderImageView.visibility = View.GONE
                    binding.subHeaderTextView.setOnClickListener {
                        if (binding.secondLevelObj != null) {
                            cellClickCallback.onClick(binding.secondLevelObj!!.id)
                        }
                    }
                }
            }

            binding.secondLevelObj = mainViewSecondLevelObjectList[groupPosition]

            return binding.root

    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return mainViewSecondLevelObjectList[groupPosition].thirdLevelObjectList[childPosition].name
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup): View {

        val binding = DataBindingUtil.inflate<MainThirdRowBinding>(LayoutInflater.from(parent.context),
                R.layout.main_third_row, parent, false)

        if (mainViewSecondLevelObjectList[groupPosition].thirdLevelObjectList[childPosition].isNew == "true") {
            binding.nameTextView.setTextColor(ContextCompat.getColor(context, R.color.md_orange_800))
            binding.newImageView.visibility = View.VISIBLE
        } else {
            binding.newImageView.visibility = View.GONE
        }

        binding.thirdLevelObj = mainViewSecondLevelObjectList[groupPosition].thirdLevelObjectList[childPosition]

        binding.nameTextView.setOnClickListener {

                if (binding.thirdLevelObj != null) {

                    cellClickCallback.onClick(binding.thirdLevelObj!!.id)
                }
        }

        return binding.root
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return mainViewSecondLevelObjectList[groupPosition].thirdLevelObjectList.size
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    interface CellClickCallback {
        fun onClick(id: String)
    }

}
