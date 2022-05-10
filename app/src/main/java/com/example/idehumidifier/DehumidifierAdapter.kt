package com.example.idehumidifier

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DehumidifierAdapter(
    private val dehumidifiers: MutableList<Dehumidifier>
): RecyclerView.Adapter<DehumidifierAdapter.DehumidifierViewHolder>() {

   class DehumidifierViewHolder(itemView: View ): RecyclerView.ViewHolder(itemView.rootView){
       val textView : TextView = itemView.findViewById(R.id.text_view)
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
            )
        )
    }

    override fun onBindViewHolder(
        holder: DehumidifierAdapter.DehumidifierViewHolder,
        position: Int
    ) {
        val curDehumidifier =dehumidifiers[position]
        holder.apply {
            textView.text= curDehumidifier.name

        }

    }

    override fun getItemCount(): Int {
        return dehumidifiers.size
    }


}