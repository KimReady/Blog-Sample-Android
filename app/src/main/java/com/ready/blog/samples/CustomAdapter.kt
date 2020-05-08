package com.ready.blog.samples

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by KimReady on 2020-05-06
 */
class CustomAdapter(private val items: List<Int>) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        Log.d("CustomViewHolder", "Create!")
        return CustomViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_item, parent,false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        Log.d("CustomViewHolder", "bind! $position")
        holder.sampleText.text = items[position].toString()
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sampleText: TextView = itemView.findViewById(R.id.sample_text)
    }
}