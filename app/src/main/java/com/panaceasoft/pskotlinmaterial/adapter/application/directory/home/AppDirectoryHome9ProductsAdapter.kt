package com.panaceasoft.pskotlinmaterial.adapter.application.directory.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.DirectoryHome9ProductsVO
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_directory_home_9_products_item.view.*

class AppDirectoryHome9ProductsAdapter(private val productsList: List<DirectoryHome9ProductsVO>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, product: DirectoryHome9ProductsVO, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val productView = LayoutInflater.from(parent.context).inflate(R.layout.app_directory_home_9_products_item, parent, false)
        return ProductsViewHolder(productView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ProductsViewHolder) {

            if (position == 9) {

                val context = holder.productImageView.context

                holder.productTextView.text = "All Products"

                val allProductImageId = R.drawable.home9_all_products
                Utils.setCircleImageToImageView(context, holder.productImageView, allProductImageId, 0, 0)

            } else {

                val productsVO = productsList[position]
                val context = holder.productImageView.context

                holder.productTextView.text = productsVO.name

                val productImageId = Utils.getDrawableInt(context, productsVO.icon)
                Utils.setCircleImageToImageView(context, holder.productImageView, productImageId, 0, 0)
            }


                holder.productConstraintLayout.setOnClickListener { view -> itemClickListener.onItemClick(view, productsList[position], position) }


        }
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    inner class ProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var productConstraintLayout: ConstraintLayout = itemView.productConstraint
        internal var productImageView: ImageView = itemView.productImageView
        internal var productTextView: TextView = itemView.productTextView

    }
}
