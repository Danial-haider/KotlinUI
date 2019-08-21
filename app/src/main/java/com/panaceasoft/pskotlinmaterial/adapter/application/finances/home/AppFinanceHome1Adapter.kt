package com.panaceasoft.pskotlinmaterial.adapter.application.finances.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.FinancePersonalLog
import kotlinx.android.synthetic.main.app_finance_home_1_item.view.*

class AppFinanceHome1Adapter(private val financePersonalLogList: List<FinancePersonalLog>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: AppFinanceHome1Adapter.OnItemClickListener

    private val WHITE_CELL = 0
    private val GREY_CELL = 1

    interface OnItemClickListener {
        fun onItemClick(view: View, obj: FinancePersonalLog, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: AppFinanceHome1Adapter.OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val itemView: View

        when (viewType) {
            WHITE_CELL -> {

                itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_finance_home_1_item, parent, false)
                return FinanceTransactionViewHolder(itemView)
            }

            GREY_CELL -> {

                itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_finance_home_1_grey_item, parent, false)
                return FinanceTransactionViewHolder(itemView)
            }

            else -> {

                itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_finance_home_1_item, parent, false)
                return FinanceTransactionViewHolder(itemView)
            }
        }

    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is AppFinanceHome1Adapter.FinanceTransactionViewHolder) {
            val financePersonalLog = financePersonalLogList[position]

            viewHolder.titleTextView.text = financePersonalLog.title
            viewHolder.amountTextView.text = financePersonalLog.amount
            viewHolder.dateTextView.text = financePersonalLog.date
            viewHolder.typeTextView.text = financePersonalLog.type


                viewHolder.constraintLayout.setOnClickListener { v: View -> itemClickListener.onItemClick(v, financePersonalLogList[position], position) }

        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) {
            GREY_CELL
        } else {
            WHITE_CELL
        }
    }

    override fun getItemCount(): Int {

        return financePersonalLogList.size

    }

    inner class FinanceTransactionViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var titleTextView: TextView = view.titleTextView
        internal var amountTextView: TextView = view.amountTextView
        internal var dateTextView: TextView = view.dateTextView
        internal var typeTextView: TextView = view.typeTextView
        internal var constraintLayout: ConstraintLayout = view.constraintLayout


    }
}
