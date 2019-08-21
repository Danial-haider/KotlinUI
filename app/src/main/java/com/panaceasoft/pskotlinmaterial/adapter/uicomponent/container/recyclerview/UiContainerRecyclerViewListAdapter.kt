package com.panaceasoft.pskotlinmaterial.adapter.uicomponent.container.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Country
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.ui_container_recycler_view_list_item.view.*
import java.util.*

class UiContainerRecyclerViewListAdapter(private val countryArrayList: ArrayList<Country>) : RecyclerView.Adapter<UiContainerRecyclerViewListAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UiContainerRecyclerViewListAdapter.CountryViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.ui_container_recycler_view_list_item, parent, false)

        return CountryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countryArrayList[position]
        holder.titleTextView.text = country.name

        val context = holder.iconImageView.context

        val id = Utils.getDrawableInt(context, country.imageName)
        Utils.setImageToImageView(context, holder.iconImageView, id)

    }

    override fun getItemCount(): Int {
        return countryArrayList.size
    }

    inner class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iconImageView: ImageView = view.iconImageView
        var titleTextView: TextView = view.titleTextView

    }
}
