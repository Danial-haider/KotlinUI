package com.panaceasoft.pskotlinmaterial.adapter.feature.report

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.FinancePersonalLog
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_report_finance_report_1_item.view.*

class FeatureReportFinanceReport1Adapter(private val financePersonalLogList: List<FinancePersonalLog>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: FeatureReportFinanceReport1Adapter.OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: FinancePersonalLog, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: FeatureReportFinanceReport1Adapter.OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_report_finance_report_1_item, parent, false)
        return FinanceTransactionViewHolder(itemView)

    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is FeatureReportFinanceReport1Adapter.FinanceTransactionViewHolder) {
            val financePersonalLog = financePersonalLogList[position]

            viewHolder.titleTextView.text = financePersonalLog.title
            viewHolder.amountTextView.text = financePersonalLog.amount
            viewHolder.percentTextView.text = financePersonalLog.percentage + "%"

            val percent = Integer.parseInt(financePersonalLog.percentage)
            viewHolder.reportProgressBar.progress = percent

            val context = viewHolder.iconImageView.context

            if (context != null) {
                val id = Utils.getDrawableInt(context, financePersonalLog.icon)
                Utils.setImageToImageView(context, viewHolder.iconImageView, id)
            }


                viewHolder.constraintLayout.setOnClickListener { v: View -> itemClickListener.onItemClick(v, financePersonalLogList[position], position) }

        }
    }


    override fun getItemCount(): Int {

        return financePersonalLogList.size

    }

    inner class FinanceTransactionViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var titleTextView: TextView = view.titleTextView
        internal var amountTextView: TextView = view.amountTextView
        internal var constraintLayout: ConstraintLayout = view.constraintLayout
        internal var iconImageView: ImageView = view.iconImageView
        internal var percentTextView: TextView = view.percentTextView
        internal var reportProgressBar: ProgressBar = view.reportProgressBar


    }
}
