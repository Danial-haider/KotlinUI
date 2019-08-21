package com.panaceasoft.pskotlinmaterial.adapter.feature.dialog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.FinancePersonalLog
import com.panaceasoft.pskotlinmaterial.adapter.application.finances.dialog.AppFinanceDialog1Adapter
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_dialog_finance_dialog_1_item.view.*

class FeatureDialogFinanceDialog1Adapter(private val financePersonalLogList: List<FinancePersonalLog>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: AppFinanceDialog1Adapter.OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: FinancePersonalLog, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: AppFinanceDialog1Adapter.OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_dialog_finance_dialog_1_item, parent, false)
        return FinanceTransactionViewHolder(itemView)

    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is AppFinanceDialog1Adapter.FinanceTransactionViewHolder) {
            val financePersonalLog = financePersonalLogList[position]

            val holder = viewHolder as FeatureDialogFinanceDialog1Adapter.FinanceTransactionViewHolder
            holder.titleTextView.text = financePersonalLog.title
            holder.amountTextView.text = financePersonalLog.amount
            holder.dateTextView.text = financePersonalLog.date

            val context = holder.iconImageView.context

            if (context != null) {
                val id = Utils.getDrawableInt(context, financePersonalLog.icon)
                Utils.setImageToImageView(context, holder.iconImageView, id)
            }


                holder.constraintLayout.setOnClickListener { v: View -> itemClickListener.onItemClick(v, financePersonalLogList[position], position) }

        }
    }


    override fun getItemCount(): Int {

        return financePersonalLogList.size

    }

    inner class FinanceTransactionViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var titleTextView: TextView = view.titleTextView
        internal var amountTextView: TextView = view.amountTextView
        internal var dateTextView: TextView = view.dateTextView
        internal var constraintLayout: ConstraintLayout = view.constraintLayout
        internal var iconImageView: ImageView = view.iconImageView


    }
}
