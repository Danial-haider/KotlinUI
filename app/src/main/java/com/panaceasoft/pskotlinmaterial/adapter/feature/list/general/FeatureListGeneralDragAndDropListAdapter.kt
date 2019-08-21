package com.panaceasoft.pskotlinmaterial.adapter.feature.list.general

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.GeneralList
import com.panaceasoft.pskotlinmaterial.utils.Utils
import com.panaceasoft.pskotlinmaterial.utils.drag_and_swipe.ItemTouchDragHelperAdapter
import com.panaceasoft.pskotlinmaterial.utils.drag_and_swipe.OnStartDragListener
import kotlinx.android.synthetic.main.feature_list_general_drag_and_drop_list_item.view.*
import java.util.*

/**
 * Created by Panacea-Soft on 7/17/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class FeatureListGeneralDragAndDropListAdapter(private val generalListList: List<GeneralList>, private val mDragStartListener: OnStartDragListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), ItemTouchDragHelperAdapter {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: GeneralList, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        Collections.swap(generalListList, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_list_general_drag_and_drop_list_item, parent, false)
        return GeneralListViewHolder(itemView)

    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is GeneralListViewHolder) {
            val financeTransaction = generalListList[position]

            viewHolder.dragImageView.setOnTouchListener { _, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    mDragStartListener.onStartDrag(viewHolder)
                }
                false
            }

            val context = viewHolder.rowImageView.context
            if (context != null) {
                val id = Utils.getDrawableInt(context, financeTransaction.image)
                Utils.setImageToImageView(context, viewHolder.rowImageView, id)
            }

            viewHolder.titleTextView.text = financeTransaction.name
            viewHolder.captionTextView.text = financeTransaction.caption

        }
    }


    override fun getItemCount(): Int {

        return generalListList.size

    }

    inner class GeneralListViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var titleTextView: TextView = view.titleTextView
        internal var captionTextView: TextView = view.captionTextView
        internal var dragImageView: ImageView = view.dragImageView
        internal var rowImageView: ImageView = view.rowImageView

    }
}
