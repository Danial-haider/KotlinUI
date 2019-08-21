package com.panaceasoft.pskotlinmaterial.adapter.feature.profile.general

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
import kotlinx.android.synthetic.main.feature_profile_general_profile_3_item.view.*

/**
 * Created by Panacea-Soft on 20/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureProfileGeneralProfile3Adapter(private val UserProfileArrayList: List<UserProfile>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: UserProfile, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_profile_general_profile_3_item, parent, false)

        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is ItemViewHolder) {

            val UserProfile = UserProfileArrayList!![position]

            viewHolder.itemNameTextView.text = UserProfile.name

            val context = viewHolder.constraintLayout.context

            val id = Utils.getDrawableInt(context, UserProfile.imageName)
            Utils.setCircleImageToImageView(context, viewHolder.itemImageView, id, 2, R.color.md_grey_200)

                viewHolder.constraintLayout.setOnClickListener { v: View -> itemClickListener.onItemClick(v, UserProfileArrayList[position], position) }
        }
    }

    override fun getItemCount(): Int {

        return UserProfileArrayList?.size ?: 0
    }

    inner class ItemViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var itemImageView: ImageView = view.itemImageView
        internal var itemNameTextView: TextView = view.itemNameTextView
        internal var constraintLayout: ConstraintLayout = view.constraintLayout

    }
}
