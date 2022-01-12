package com.example.citizensdata.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.citizensdata.LoginFragmentDirections
import com.example.citizensdata.R
import com.example.citizensdata.db.appEntity

class appAdapter(private val list_item : List<appEntity>,
                 private val listener: OnItemClickListener) : RecyclerView.Adapter<appViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): appViewHolder {
        val listItemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_layout, null)

        return appViewHolder(listItemView,listener)
    }

    override fun onBindViewHolder(holder: appViewHolder, position: Int) {
        holder.textName.text = list_item[position].name
        holder.textAddress.text = list_item[position].Address

//        holder.itemView.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(p0: View?) {
        //    val action = RegistryFragmentDirections.actionRegistryFragmentToLoginFragmnet()
        //  pO.findNavController().navigate(action)

//            }
//
//        })
    }

    override fun getItemCount(): Int {
        return list_item.size
    }



    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}