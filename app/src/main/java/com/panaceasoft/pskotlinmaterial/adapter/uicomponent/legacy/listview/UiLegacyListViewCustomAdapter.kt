package com.panaceasoft.pskotlinmaterial.adapter.uicomponent.legacy.listview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Country
import com.panaceasoft.pskotlinmaterial.utils.Utils
import java.util.*

class UiLegacyListViewCustomAdapter(data: ArrayList<Country>,context: Context) : ArrayAdapter<Country>(context, R.layout.ui_legacy_list_view_custom_item, data) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rowView: View

        rowView = inflater.inflate(R.layout.ui_legacy_list_view_custom_item, parent, false)

        val textView = rowView.findViewById<TextView>(R.id.titleTextView)
        val imageView = rowView.findViewById<ImageView>(R.id.iconImageView)

        val country = getItem(position)

        if (country != null) {
            textView.text = country.name

            val id = Utils.getDrawableInt(context, country.imageName)
            Utils.setImageToImageView(context, imageView, id)

            rowView.setOnClickListener { Toast.makeText(getContext(), country.name, Toast.LENGTH_SHORT).show() }

        }

        return rowView
    }
}
