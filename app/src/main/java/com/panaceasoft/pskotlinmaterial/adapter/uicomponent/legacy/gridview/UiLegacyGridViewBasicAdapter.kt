package com.panaceasoft.pskotlinmaterial.adapter.uicomponent.legacy.gridview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Country
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.ui_legacy_grid_view_basic_item.view.*
import java.util.*

@Suppress("NAME_SHADOWING")
class UiLegacyGridViewBasicAdapter(private val context: Context, private val countryArrayList: ArrayList<Country>) : BaseAdapter() {
    private val layoutInflater: LayoutInflater

    init {

        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }


    override fun getCount(): Int {
        return countryArrayList.size
    }

    override fun getItem(position: Int): Country {
        return countryArrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView

        val country = getItem(position)

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.ui_legacy_grid_view_basic_item, parent, false)
        }

        val imageView = convertView?.iconImageView
        val textView = convertView?.titleTextView

        textView?.text = country.name

        val id = Utils.getDrawableInt(context, country.imageName)

        imageView?.let {
            Utils.setImageToImageView(context, imageView, id)
        }

        return convertView!!
    }
}
