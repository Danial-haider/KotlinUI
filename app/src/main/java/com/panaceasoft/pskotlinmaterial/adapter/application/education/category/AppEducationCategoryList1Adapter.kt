package com.panaceasoft.pskotlinmaterial.adapter.application.education.category

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.EducationCategoryListWithCourse
import java.util.*

/**
 * Created by Panacea-Soft on 8/25/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


@Suppress("NAME_SHADOWING")
class AppEducationCategoryList1Adapter(private val _context: Context, private val _listDataHeader: List<String>,
                                       private val _listDataChild: HashMap<String, List<EducationCategoryListWithCourse.Course>>) : BaseExpandableListAdapter() {

    override fun getChild(groupPosition: Int, childPosititon: Int): Any {
        return this._listDataChild[this._listDataHeader[groupPosition]]!![childPosititon]
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int,
                              isLastChild: Boolean, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView

        val childText = getChild(groupPosition, childPosition) as EducationCategoryListWithCourse.Course

        if (convertView == null) {
            val infalInflater = this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.app_education_category_list_1_item, parent, false)
        }

        val txtListChild = convertView?.findViewById<TextView>(R.id.lblListItem)

        txtListChild?.text = childText.courseName
        return convertView!!
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return this._listDataChild[this._listDataHeader[groupPosition]]!!
                .size
    }

    override fun getGroup(groupPosition: Int): Any {
        return this._listDataHeader[groupPosition]
    }

    override fun getGroupCount(): Int {
        return this._listDataHeader.size
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean,
                              view: View?, parent: ViewGroup): View {
        var convertView = view
        val headerTitle = getGroup(groupPosition) as String
        if (convertView == null) {
            val infalInflater = this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.app_education_category_list_1_group, parent, false)
        }

        val lblListHeader = convertView?.findViewById<TextView>(R.id.lblListHeader)
        lblListHeader?.setTypeface(null, Typeface.BOLD)
        lblListHeader?.text = headerTitle

        val groupIndicatorImageView = convertView?.findViewById<ImageView>(R.id.groupIndicatorImageView)

        if (isExpanded) {
            groupIndicatorImageView?.setImageDrawable(ContextCompat.getDrawable(parent.context!!,R.drawable.ic_arrow_drop_up_black_24dp))
        } else {
            groupIndicatorImageView?.setImageDrawable(ContextCompat.getDrawable(parent.context!!,R.drawable.ic_arrow_drop_down_black_24dp))

        }

        return convertView!!
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}