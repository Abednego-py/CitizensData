package com.example.citizensdata.recycler

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.citizensdata.R

class appViewHolder(view : View, private var listener : appAdapter.OnItemClickListener) : RecyclerView.ViewHolder(view),
    View.OnClickListener
{

    var textName = view.findViewById<TextView>(
        R.id.name)
    var textAddress = view.findViewById<TextView>(R.id.address)

    init {
        view.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val position = adapterPosition
        if (position != RecyclerView.NO_POSITION) {
            listener.onItemClick(position)
        }
    }
}