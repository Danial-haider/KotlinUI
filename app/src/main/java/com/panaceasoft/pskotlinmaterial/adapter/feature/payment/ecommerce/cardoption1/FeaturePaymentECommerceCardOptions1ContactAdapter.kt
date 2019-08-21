package com.panaceasoft.pskotlinmaterial.adapter.feature.payment.ecommerce.cardoption1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.UserProfile
import com.panaceasoft.pskotlinmaterial.utils.Utils

/**
 * Created by Panacea-Soft on 7/18/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class FeaturePaymentECommerceCardOptions1ContactAdapter(private val userProfileList: List<UserProfile>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: UserProfile, position: Int)
        fun onAddItemClick(view: View, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == 0) {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_payment_ecommerce_card_options_1_add_contact_item, parent, false)

            return ItemViewHolder(itemView)
        } else {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_payment_ecommerce_card_options_1_contact_item, parent, false)

            return ItemViewHolder(itemView)
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (position == 0) {
            if (viewHolder is ItemViewHolder) {

                viewHolder.itemNameTextView.text = "Add New Account"

                    viewHolder.constraintLayout.setOnClickListener { v: View -> itemClickListener.onAddItemClick(v, position) }
            }
        } else {

            val correctPosition = position - 1

            if (viewHolder is ItemViewHolder) {

                val UserProfile = userProfileList!![correctPosition]

                viewHolder.itemNameTextView.text = UserProfile.name

                val context = viewHolder.constraintLayout.context

                val id = Utils.getDrawableInt(context, UserProfile.imageName)
                Utils.setCircleImageToImageView(context, viewHolder.itemImageView, id, 2, R.color.md_grey_200)

                    viewHolder.constraintLayout.setOnClickListener { v: View -> itemClickListener.onItemClick(v, userProfileList[correctPosition], correctPosition) }

            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            0
        } else {
            1
        }
    }

    override fun getItemCount(): Int {

        return if (userProfileList != null) {

            userProfileList.size + 1

        } else {
            0
        }
    }

    inner class ItemViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var itemImageView: ImageView
        internal var itemNameTextView: TextView
        internal var constraintLayout: ConstraintLayout

        init {

            itemImageView = view.findViewById(R.id.itemImageView)
            itemNameTextView = view.findViewById(R.id.itemNameTextView)
            constraintLayout = view.findViewById(R.id.constraintLayout)

        }
    }
}