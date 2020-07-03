package com.pragmum.demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.items_layout.view.*

class DemoAdapter(val coworkers: ArrayList<PersonModel>): RecyclerView.Adapter<DemoAdapter.ViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemoAdapter.ViewHolder {
        val layout = R.layout.items_layout
        val v: View = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = coworkers.size

    override fun onBindViewHolder(holder: DemoAdapter.ViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {
            val name = itemView.nameText
            val title = itemView.titleText

            name.text = coworkers[position].name
            title.text = coworkers[position].position
        }
    }


}