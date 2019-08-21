package com.panaceasoft.pskotlinmaterial.adapter.feature.chat.general

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.`object`.Chat
import com.panaceasoft.pskotlinmaterial.utils.Utils
import kotlinx.android.synthetic.main.feature_chat_general_chat_1_item.view.*

/**
 * Created by Panacea-Soft on 19/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class FeatureChatGeneralChat1Adapter(private val chatList: List<Chat>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener


    interface OnItemClickListener {
        fun onItemClick(view: View, obj: Chat, position: Int)

        //void onDeleteClick(View view, Chat obj, int position);
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feature_chat_general_chat_1_item, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is PlaceViewHolder) {

            val chat = chatList[position]

            viewHolder.Name.text = chat.Name

            val context = viewHolder.holderCardView.context
            viewHolder.card.setCardBackgroundColor(ContextCompat.getColor(context, R.color.md_orange_A700))
            viewHolder.card.visibility = View.INVISIBLE

            val id = Utils.getDrawableInt(context, chat.Image)
            Utils.setImageToImageView(context, viewHolder.itemImageView, id)
            Utils.setCircleImageToImageView(context, viewHolder.itemImageView, id, 0, 0)

            viewHolder.Time.text = chat.Time
            val number = Integer.parseInt(chat.Count)

            viewHolder.Count.text = chat.Count
            if (number > 0) {
                viewHolder.Time.setTextColor(ContextCompat.getColor(context, R.color.md_orange_A700))
                viewHolder.Count.visibility = View.VISIBLE
                viewHolder.card.visibility = View.VISIBLE

                if (number > 9)
                    viewHolder.Count.text = "9+"
            }

            viewHolder.message.text = chat.Message


                viewHolder.holderCardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, chat, position) }


        }
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    inner class PlaceViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var itemImageView: ImageView
        internal var Name: TextView
        internal var message: TextView
        internal var holderCardView: ConstraintLayout
        internal var Time: TextView
        internal var Count: TextView
        internal var card: CardView

        init {

            itemImageView = view.userImageView
            Name = view.userNameTextView
            message = view.messageTextView
            holderCardView = view.holderCardView
            Time = view.timeTextView
            Count = view.messagecount
            card = view.card_view


        }
    }
}
