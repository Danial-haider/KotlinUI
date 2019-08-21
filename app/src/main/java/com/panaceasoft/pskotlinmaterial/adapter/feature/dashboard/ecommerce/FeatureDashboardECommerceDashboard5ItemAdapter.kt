package com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.ecommerce

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.ShopItem
import com.panaceasoft.pskotlinmaterial.utils.Utils
import java.util.*

class FeatureDashboardECommerceDashboard5ItemAdapter(private val shopItemArrayList: ArrayList<ShopItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    internal lateinit var itemClickListener: FeatureDashboardECommerceDashboard5ItemAdapter.OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: ShopItem, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: FeatureDashboardECommerceDashboard5ItemAdapter.OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun getItemViewType(position: Int): Int {
        return position % 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var layoutId = R.layout.feature_dashboard_ecommerce_dashboard_5a_item

        if (viewType == 1) {
            layoutId = R.layout.feature_dashboard_ecommerce_dashboard_5b_item
        } else if (viewType == 2) {
            layoutId = R.layout.feature_dashboard_ecommerce_dashboard_5c_item
        }

        val layoutView = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)


        val imageView = layoutView.findViewById<ImageView>(R.id.itemImageView)

            imageView.setOnClickListener { v -> itemClickListener.onItemClick(v, shopItemArrayList[viewType], viewType) }

        return ItemViewHolder(layoutView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is FeatureDashboardECommerceDashboard5ItemAdapter.ItemViewHolder) {

            // Get Shop Item
            val shopItem = shopItemArrayList[position]

            // Convert Item Holder

            // Get Context

            // Get Context
            val context = viewHolder.itemImageView.context

            // Set Data to UI
            viewHolder.itemNameTextView.text = shopItem.name

            val price = shopItem.currency + shopItem.price
            viewHolder.priceTextView.text = price

            val id = Utils.getDrawableInt(context, shopItem.imageName)
            Utils.setImageToImageView(context, viewHolder.itemImageView, id)
        }

    }

    override fun getItemCount(): Int {
        return shopItemArrayList.size
    }

    inner class ItemViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var itemImageView: ImageView = view.findViewById(R.id.itemImageView)
        internal var itemNameTextView: TextView = view.findViewById(R.id.itemNameTextView)
        internal var priceTextView: TextView = view.findViewById(R.id.priceTextView)

    }
}


