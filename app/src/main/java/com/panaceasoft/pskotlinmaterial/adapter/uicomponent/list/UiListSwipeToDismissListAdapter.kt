package com.panaceasoft.pskotlinmaterial.adapter.uicomponent.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.GeneralList
import com.panaceasoft.pskotlinmaterial.utils.Utils
import com.panaceasoft.pskotlinmaterial.utils.drag_and_swipe.ItemTouchHelperAdapter
import com.panaceasoft.pskotlinmaterial.utils.drag_and_swipe.OnStartDragListener
import kotlinx.android.synthetic.main.ui_list_swipe_to_dismiss_list_item.view.*

/**
 * Created by Panacea-Soft on 7/17/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


class UiListSwipeToDismissListAdapter(private val generalListList: MutableList<GeneralList>, private val mDragStartListener: OnStartDragListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), ItemTouchHelperAdapter {
    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: GeneralList, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        return true
    }

    override fun onItemDismiss(position: Int) {
        generalListList.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.ui_list_swipe_to_dismiss_list_item, parent, false)
        return GeneralListViewHolder(itemView)

    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is GeneralListViewHolder) {
            val financeTransaction = generalListList[position]

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
        internal var rowImageView: ImageView = view.rowImageView

    }
}
