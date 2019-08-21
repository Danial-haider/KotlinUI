package com.panaceasoft.pskotlinmaterial.adapter.application.directory.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.DirectoryHome9PopularVO
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_directory_home_9_popular_item.view.*

class AppDirectoryHome9PopularAdapter(private val popularList: List<DirectoryHome9PopularVO>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, popular: DirectoryHome9PopularVO, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val popularView = LayoutInflater.from(parent.context).inflate(R.layout.app_directory_home_9_popular_item, parent, false)
        return PopularViewHolder(popularView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PopularViewHolder) {
            val popularVO = popularList[position]
            val context = holder.popularImageView.context

            holder.popularTitleTextView.text = popularVO.name
            holder.popularCityTextView.text = popularVO.place

            val popularImageId = Utils.getDrawableInt(context, popularVO.image)
            Utils.setImageToImageView(context, holder.popularImageView, popularImageId)


                holder.popularCardView.setOnClickListener { view -> itemClickListener.onItemClick(view, popularList[position], position) }

        }
    }

    override fun getItemCount(): Int {
        return popularList.size
    }

    inner class PopularViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var popularCardView: CardView = itemView.popularCardView
        internal var popularImageView: ImageView = itemView.popularImageView
        internal var popularTitleTextView: TextView = itemView.popularTitleTextView
        internal var popularCityTextView: TextView = itemView.popularCityTextView

    }
}
