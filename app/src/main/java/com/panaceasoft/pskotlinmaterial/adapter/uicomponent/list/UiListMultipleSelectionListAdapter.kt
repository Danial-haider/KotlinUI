package com.panaceasoft.pskotlinmaterial.adapter.uicomponent.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Chat
import com.panaceasoft.pskotlinmaterial.utils.Utils

import java.util.ArrayList
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class UiListMultipleSelectionListAdapter(private val mContext: Context, var usersList: ArrayList<Chat>, selectedList: ArrayList<Chat>) : RecyclerView.Adapter<UiListMultipleSelectionListAdapter.MyViewHolder>() {
    var selected_usersList: ArrayList<Chat>

    inner class MyViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        var caption: TextView
        var name: TextView
        var time: TextView
        var count: TextView
        internal var holderCardView: ConstraintLayout
        var imageView: ImageView
        var checkImageView: ImageView
        var card: CardView


        init {
            caption = view.findViewById(R.id.messageTextView)
            name = view.findViewById(R.id.userNameTextView)
            time = view.findViewById(R.id.timeTextView)
            holderCardView = view.findViewById(R.id.holderCardView)
            imageView = view.findViewById(R.id.userImageView)
            count = view.findViewById(R.id.messagecount)
            card = view.findViewById(R.id.card_view)
            checkImageView = view.findViewById(R.id.checkImageView)
        }
    }

    init {
        selected_usersList = ArrayList()
        this.selected_usersList = selectedList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.ui_list_multiple_selection_list_item, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = usersList[position]
        holder.name.text = movie.Name

        holder.time.text = movie.Time
        val number = Integer.parseInt(movie.Count)
        holder.count.text = movie.Count
        holder.card.visibility = View.INVISIBLE
        if (number > 0) {
            holder.time.setTextColor(ContextCompat.getColor(mContext, R.color.md_orange_A700))
            holder.count.visibility = View.VISIBLE
            holder.card.visibility = View.VISIBLE

            if (number > 9)
                holder.count.text = "9+"
        }
        holder.caption.text = movie.Message

        val context = holder.imageView.context
        if (context != null) {
            val id = Utils.getDrawableInt(context, movie.Image)
            Utils.setCircleImageToImageView(context, holder.imageView, id, 0, 0)
        }

        if (selected_usersList.contains(usersList[position])) {
            holder.checkImageView.visibility = View.VISIBLE
            holder.holderCardView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.md_teal_100))


        } else {
            holder.holderCardView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.md_white_1000))
            holder.checkImageView.visibility = View.GONE
        }

    }

    override fun getItemCount(): Int {
        return usersList.size
    }
}


