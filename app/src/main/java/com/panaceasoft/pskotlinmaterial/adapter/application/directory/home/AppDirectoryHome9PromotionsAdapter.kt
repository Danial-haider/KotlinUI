package com.panaceasoft.pskotlinmaterial.adapter.application.directory.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.DirectoryHome9PromotionsVO
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.app_directory_home_9_promotions_first_item.view.*
import kotlinx.android.synthetic.main.app_directory_home_9_promotions_item.view.*

class AppDirectoryHome9PromotionsAdapter(internal var promotionsList: List<DirectoryHome9PromotionsVO>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, promotion: DirectoryHome9PromotionsVO, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == 0) {
            val prmotionsView = LayoutInflater.from(parent.context).inflate(R.layout.app_directory_home_9_promotions_first_item, parent, false)
            return PromotionsViewHolder(prmotionsView)
        }

        val prmotionsView = LayoutInflater.from(parent.context).inflate(R.layout.app_directory_home_9_promotions_item, parent, false)
        return OtherViewHolder(prmotionsView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PromotionsViewHolder) {

            if (position == 0) {

                val context = holder.promotionsImageView.context

                val promotionsImageId = R.drawable.home9_promo_cell
                Utils.setImageToImageView(context, holder.promotionsImageView, promotionsImageId)


                    holder.promotionFirstItemConstraint.setOnClickListener { view -> itemClickListener.onItemClick(view, promotionsList[position], position) }


            } else {

                val PromotionsVO = promotionsList[position]
                val context = holder.promotionsImageView.context

                val promotionsImageId = Utils.getDrawableInt(context, PromotionsVO.image)
                Utils.setImageToImageView(context, holder.promotionsImageView, promotionsImageId)


//                    holder.promotionConstraint.setOnClickListener { view -> itemClickListener.onItemClick(view, promotionsList[position], position) }

            }
        }

        if(holder is OtherViewHolder){
            if(position == 0){
                val context = holder.promotionsImageView2.context

                val promotionsImageId = R.drawable.home9_promo_cell
                Utils.setImageToImageView(context, holder.promotionsImageView2, promotionsImageId)


//                holder.promotionFirstItemConstraint.setOnClickListener { view -> itemClickListener.onItemClick(view, promotionsList[position], position) }

            }else{
                val PromotionsVO = promotionsList[position]
                val context = holder.promotionsImageView2.context

                val promotionsImageId = Utils.getDrawableInt(context, PromotionsVO.image)
                Utils.setImageToImageView(context, holder.promotionsImageView2, promotionsImageId)


                    holder.promotionConstraint.setOnClickListener { view -> itemClickListener.onItemClick(view, promotionsList[position], position) }

            }
        }

    }
    override fun getItemCount(): Int {
        return promotionsList.size
    }

    inner class PromotionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var promotionFirstItemConstraint: ConstraintLayout
        internal var promotionsImageView: ImageView

        init {
            promotionFirstItemConstraint = itemView.promotionFirstItemConstraint
            promotionsImageView = itemView.promotionsImageView
        }
    }

    inner class OtherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var promotionConstraint: ConstraintLayout
        internal var promotionsImageView2: ImageView

        init {
            promotionConstraint = itemView.promotionConstraint
            promotionsImageView2 = itemView.promotionsImageView2
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
