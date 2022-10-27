package com.example.zoeziapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class HurufAdapter(private val listHuruf: ArrayList<String>, var context: Context, val onClick: (Int) -> Unit):RecyclerView.Adapter<HurufAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val btn = itemView.findViewById<Button>(R.id.button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_huruf, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.btn.text = listHuruf[position]
        holder.btn.setOnClickListener(){
            onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return listHuruf.size
    }
}