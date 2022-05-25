package com.example.idehumidifier

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DehumidifierAdapter(
    private val dehumidifiers: MutableList<Dehumidifier>
): RecyclerView.Adapter<DehumidifierAdapter.DehumidifierViewHolder>() {



    private lateinit var listener : onItemClickListener

    interface onItemClickListener {
        fun onItemClick(dehumidifier: Dehumidifier)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        this.listener = listener
    }

    class DehumidifierViewHolder(itemView: View,listener: onItemClickListener ): RecyclerView.ViewHolder(itemView.rootView){
        val textView_Name : TextView = itemView.findViewById(R.id.text_view_name)
        val textView_Room :TextView = itemView.findViewById(R.id.text_view_room)
        val imageView : ImageView = itemView.findViewById(R.id.image_view)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DehumidifierAdapter.DehumidifierViewHolder {
        return DehumidifierViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_view_dehumidifier,
                parent,
                false
            ),listener
        )
    }

    override fun onBindViewHolder(
        holder: DehumidifierAdapter.DehumidifierViewHolder,
        position: Int
    ) {
        val curDehumidifier =dehumidifiers[position]
        holder.apply {
            textView_Name.text= curDehumidifier.name
            textView_Room.text = curDehumidifier.room

//            holder.itemView.setOnClickListener{
//                onitemClick?.invoke((curDehumidifier))
//            }

            itemView.setOnClickListener {
                listener.onItemClick(curDehumidifier)
            }

        }
    }

    override fun getItemCount(): Int {
        return dehumidifiers.size
    }
}


