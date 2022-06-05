package com.example.idehumidifier

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class SchedulerAdapter (
    private var schedulres: MutableList<Scheduler>
    ) :RecyclerView.Adapter<SchedulerAdapter.SchedulerViewHolder>() {


    class SchedulerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView.rootView) {
        val textView_Sch_Date : TextView = itemView.findViewById(R.id.text_view_sched_date)
        val textView_Sch_Time : TextView = itemView.findViewById(R.id.text_view_sched_time)
        val switch_Scheduler : Switch = itemView.findViewById(R.id.switch_scheduler)
        val cardView_sched : CardView= itemView.findViewById(R.id.card_view_scheduler)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SchedulerViewHolder {
       return SchedulerViewHolder(
           LayoutInflater.from(parent.context).inflate(
               R.layout.recycler_view_scheduler,
               parent,
               false
           )
       )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: SchedulerViewHolder, position: Int) {
        val curSched =schedulres[position]
        val day = curSched.day.toString()
        val month = curSched.month.toString()
        val year = curSched.year.toString()
        val hour = curSched.hour.toString()
        val min = curSched.min.toString()

        holder.apply {
            textView_Sch_Date.text = "$day/$month/$year"
            textView_Sch_Time.text = "$hour:$min"
        }

        holder.switch_Scheduler.setOnCheckedChangeListener { compoundButton, isChecked ->
            println()
            if(isChecked){
                Data.instance.saveState(true, position)
            } else {
                Data.instance.saveState(false,position)
            }

        }
    }

    override fun getItemCount(): Int {
        return schedulres.size
    }


}