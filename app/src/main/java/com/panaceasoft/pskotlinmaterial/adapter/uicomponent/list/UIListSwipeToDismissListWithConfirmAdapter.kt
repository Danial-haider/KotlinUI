package com.panaceasoft.pskotlinmaterial.adapter.uicomponent.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.GeneralList
import com.panaceasoft.pskotlinmaterial.utils.Utils
import com.panaceasoft.pskotlinmaterial.utils.drag_and_swipe.ItemTouchHelperAdapter
import kotlinx.android.synthetic.main.ui_list_swipe_to_dismiss_list_with_confirm_item.view.*

class UIListSwipeToDismissListWithConfirmAdapter(private val context: Context, private val generalListList: MutableList<GeneralList>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), ItemTouchHelperAdapter {
    private lateinit var itemClickListener: UIListSwipeToDismissListWithConfirmAdapter.OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: GeneralList, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: UIListSwipeToDismissListWithConfirmAdapter.OnItemClickListener) {
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

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.ui_list_swipe_to_dismiss_list_with_confirm_item, parent, false)
        return GeneralListViewHolder(itemView)

    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is UIListSwipeToDismissListWithConfirmAdapter.GeneralListViewHolder) {
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
        internal var viewForeground: ConstraintLayout = view.view_foreground
        internal var viewBackground: RelativeLayout = view.view_background

    }

    fun removeItem(position: Int) {
        generalListList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun restoreItem(item: GeneralList, position: Int) {
        generalListList.add(position, item)
        notifyItemInserted(position)
    }

}

