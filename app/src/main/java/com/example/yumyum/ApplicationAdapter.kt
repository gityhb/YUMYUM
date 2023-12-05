package com.example.yumyum

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ApplicationAdapter(val applicationList: List<ApplicationItem>) : RecyclerView.Adapter<ApplicationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_application_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return applicationList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val applicationItem = applicationList[position]
        //holder.cookimg.setImageResource(applicationItem.cookimgResource)
        holder.cook.text = applicationItem.cook
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //val cookimg: ImageView = itemView.findViewById(R.id.recipe_c1)
        val cook: TextView = itemView.findViewById(R.id.recipe_i1)
    }
}