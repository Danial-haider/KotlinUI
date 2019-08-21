package com.panaceasoft.pskotlinmaterial.adapter.application.news.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.NewsCategory
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_news_category_grid_2_item.view.*

/**
 * Created by Panacea-Soft on 8/11/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class AppNewsCategoryGrid2Adapter(private val itemArrayList: List<NewsCategory>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: NewsCategory, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_news_category_grid_2_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(reholder: RecyclerView.ViewHolder, position: Int) {

        if (reholder is PlaceViewHolder) {
            val item = itemArrayList[position]

            reholder.itemNameTextView.text = item.category

            val context = reholder.constraintLayout.context

            val id = Utils.getDrawableInt(context, item.categoryImage)
            Utils.setImageToImageView(context, reholder.itemImageView, id)

            if (item.isCheck == "true") {
                reholder.checkImageView.visibility = View.VISIBLE
            } else {
                reholder.checkImageView.visibility = View.GONE
            }

            reholder.constraintLayout.setOnClickListener { view ->

                    itemClickListener.onItemClick(view, itemArrayList[position], position)

            }

        }

    }

    override fun getItemCount(): Int {
        return itemArrayList.size
    }

    inner class PlaceViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var constraintLayout: ConstraintLayout = view.constraintLayout
        var checkImageView: ImageView = view.checkImageView
        var itemImageView: ImageView = view.itemImageView
        var itemNameTextView: TextView = view.itemNameTextView

    }

}