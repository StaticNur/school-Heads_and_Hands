package com.example.lesson_24.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson_24.Fragment_life
import com.example.lesson_24.R

class RecyclerAdapter(var context: Context, var textLife: ArrayList<String>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_life_text,null)
        return StringViewHolder(view)
    }

    override fun getItemCount(): Int {
        return textLife.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val textLife:String = textLife[position]
        if(holder is StringViewHolder){
            val tv_life = holder.tv_life
            tv_life.setText(textLife)
        }
    }
    class StringViewHolder(val view:View):RecyclerView.ViewHolder(view){
        var tv_life: TextView
        init {
            tv_life = view.findViewById(R.id.tv_name_life)
        }
    }
}