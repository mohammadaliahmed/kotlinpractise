package com.appslift.calssifiedadskotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.appslift.kotlinpractise.R

class ItemAdapter (private var items:List<Item>):RecyclerView.Adapter<ItemAdapter.ViewHolder>(){
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val title:TextView=itemView.findViewById(R.id.title);

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return  items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val  item=items[position]
        holder.title.text="UserId: "+item.userId+"\nTitle: "+item.title+"\nDesc: "+item.body
    }

    fun setData(data: List<Item>) {

        items=data;
        notifyDataSetChanged()

    }

}
