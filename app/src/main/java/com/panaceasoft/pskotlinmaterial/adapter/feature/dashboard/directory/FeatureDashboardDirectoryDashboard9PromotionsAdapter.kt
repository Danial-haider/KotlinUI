package com.panaceasoft.pskotlinmaterial.adapter.feature.dashboard.directory

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.DirectoryHome9PromotionsVO
import com.panaceasoft.pskotlinmaterial.utils.Utils

class FeatureDashboardDirectoryDashboard9PromotionsAdapter(internal var promotionsList: List<DirectoryHome9PromotionsVO>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, promotion: DirectoryHome9PromotionsVO, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == 0) {
            val prmotionsView = LayoutInflater.from(parent.context).inflate(R.layout.feature_dashboard_directory_dashboard_9_promotions_first_item, parent, false)
            return PromotionsViewHolder(prmotionsView)
        }

        val prmotionsView = LayoutInflater.from(parent.context).inflate(R.layout.feature_dashboard_directory_dashboard_9_promotions_item, parent, false)
        return PromotionsViewHolder(prmotionsView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PromotionsViewHolder) {

            if (position == 0) {

                val context = holder.promotionsImageView.context

                val promotionsImageId = R.drawable.home9_promo_cell
                Utils.setImageToImageView(context, holder.promotionsImageView, promotionsImageId)


                    holder.promotionFirstConstraint.setOnClickListener { view -> itemClickListener.onItemClick(view, promotionsList[position], position) }


            } else {

                val PromotionsVO = promotionsList[position]
                val context = holder.promotionsImageView.context

                val promotionsImageId = Utils.getDrawableInt(context, PromotionsVO.image)
                Utils.setImageToImageView(context, holder.promotionsImageView, promotionsImageId)


                    holder.promotionConstraint.setOnClickListener { view -> itemClickListener.onItemClick(view, promotionsList[position], position) }

            }
        }
    }

    override fun getItemCount(): Int {
        return promotionsList.size
    }

    inner class PromotionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var promotionFirstConstraint: ConstraintLayout
        internal var promotionConstraint: ConstraintLayout
        internal var promotionsImageView: ImageView

        init {
            promotionFirstConstraint = itemView.findViewById(R.id.promotionFirstItemConstraint)
            promotionConstraint = itemView.findViewById(R.id.promotionConstraint)
            promotionsImageView = itemView.findViewById(R.id.promotionsImageView)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            0
        } else {
            1
        }
    }
}
