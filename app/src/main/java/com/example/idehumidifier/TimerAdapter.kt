package com.example.idehumidifier

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class TimerAdapter(
    private  var timers: MutableList<Timer>
    ) : RecyclerView.Adapter<TimerAdapter.TimerViewHolder>() {

//    private lateinit var listener : onItemClickListener
//
//    interface onItemClickListener {
//        fun onItemClick(timer: Timer)
//    }
//
//    fun setOnItemClickListener(listener: onItemClickListener){
//        this.listener = listener
//    }

    class TimerViewHolder(itemView : View ): RecyclerView.ViewHolder(itemView.rootView){
        val textView_Date : TextView = itemView.findViewById(R.id.text_view_date)
        val textView_Time : TextView = itemView.findViewById(R.id.text_view_time)
        val cardView_time : CardView = itemView.findViewById(R.id.card_view_timer)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TimerViewHolder {
        return TimerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_view_timer,
                parent,
                false
            )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: TimerViewHolder, position: Int) {
        var selectedPos = RecyclerView.NO_POSITION
        val curTimer =timers[position]
        val day = curTimer.day.toString()
        val month = curTimer.month.toString()
        val year = curTimer.year.toString()
        val hour = curTimer.hour.toString()
        val min = curTimer.min.toString()
        holder.apply {
            textView_Date.text = "$day/$month/$year"
            textView_Time.text = "$hour:$min"
//            itemView.setOnClickListener {
//                listener.onItemClick(curTimer)
//            }

        }

        holder.itemView.setOnClickListener{
            selectedPos = position
            holder.cardView_time.setCardBackgroundColor(Color.parseColor("#00574B"))
            notifyItemChanged(position)
        }

    }

    override fun getItemCount(): Int {
        return timers.size
    }
}