package com.panaceasoft.pskotlinmaterial.adapter

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.MainViewObject
import com.panaceasoft.pskotlinmaterial.activity.MainSecondLevelExpandableListView

/**
 * Created by Panacea-Soft on 5/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


@Suppress("NAME_SHADOWING")
class MainThirdLevelListAdapter(private val context: Context, private val mainViewObjectList: List<MainViewObject>?, private val cellClickCallback: CellClickCallback?) : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {

        return mainViewObjectList?.size ?: 0

    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return 1
    }

    override fun getGroup(groupPosition: Int): Any {

        return groupPosition
    }

    override fun getChild(group: Int, child: Int): Any {

        return child

    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView

        if(convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.main_first_row, parent, false)
        }

            val text = convertView?.findViewById<TextView>(R.id.categoryTextView)

            val categoryIndicatorImageView = convertView!!.findViewById<ImageView>(R.id.categoryIndicatorImageView)
            categoryIndicatorImageView.setColorFilter(ContextCompat.getColor(context, R.color.md_icon_color), PorterDuff.Mode.SRC_IN)

            val id = context.resources.getIdentifier(mainViewObjectList!![groupPosition].imageName, "drawable", convertView.context.packageName)

            val categoryImageView = convertView.findViewById<ImageView>(R.id.categoryImageView)
            categoryImageView.setImageResource(id)

            val newImageView = convertView.findViewById<ImageView>(R.id.newImageView)

            if (mainViewObjectList[groupPosition].isNew == "true") {
                newImageView.visibility = View.VISIBLE

            } else {
                newImageView.visibility = View.GONE
            }

            val layoutCountTextView = convertView.findViewById<TextView>(R.id.layoutCountTextView)

            val secondLevelCount = mainViewObjectList[groupPosition].secondLevelObjectList?.size

            var totalCount = 0

            for (i in 0 until secondLevelCount!!) {
                val thirdLevelCount = mainViewObjectList[groupPosition].secondLevelObjectList!![i].thirdLevelObjectList.size

                if (thirdLevelCount == 0) {
                    totalCount += 1
                } else {
                    totalCount += thirdLevelCount
                }
            }

            val layoutCount = "($totalCount) UI Layouts"
            layoutCountTextView.text = layoutCount

            categoryImageView.setColorFilter(ContextCompat.getColor(context, R.color.md_icon_color), PorterDuff.Mode.SRC_IN)

            text?.text = this.mainViewObjectList[groupPosition].name
            val imageResourceId = if (isExpanded)
                R.drawable.ic_arrow_drop_up_black_24dp
            else
                R.drawable.ic_arrow_drop_down_black_24dp
            categoryIndicatorImageView.setImageResource(imageResourceId)


        return convertView
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup): View {

        val secondLevelELV = MainSecondLevelExpandableListView(context)

        val cd = ColorDrawable(ContextCompat.getColor(parent.context,R.color.colorLine))
        secondLevelELV.divider = cd
        secondLevelELV.dividerHeight = 1
        secondLevelELV.setChildDivider(cd)

        secondLevelELV.setAdapter(MainSecondLevelListAdapter(
                context,
                groupPosition,
                mainViewObjectList!![groupPosition].secondLevelObjectList!!,
                object : MainSecondLevelListAdapter.CellClickCallback {
                    override fun onClick(id: String) {
                        cellClicked(id)
                    }
                })
        )

        secondLevelELV.setGroupIndicator(null)


        secondLevelELV.setOnGroupExpandListener(object : ExpandableListView.OnGroupExpandListener {
            internal var previousGroup = -1

            override fun onGroupExpand(groupPosition: Int) {
                if (groupPosition != previousGroup)
                    secondLevelELV.collapseGroup(previousGroup)
                previousGroup = groupPosition
            }
        })


        return secondLevelELV
    }

    private fun cellClicked(id: String) {

        cellClickCallback?.onClick(id)

    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    interface CellClickCallback {
        fun onClick(id: String)
    }
}
