package com.example.hogwartsrecyclerview

import android.media.tv.TvRecordingClient
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HogwartsAdapter(val hogwartsData: ArrayList<Hogwarts>):
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewGenerator =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_card_view, parent, false)
        return ViewHolder(viewGenerator)
    }

    override fun getItemCount(): Int {
        return hogwartsData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hogwarts: Hogwarts = hogwartsData[position]
        holder.profTextView.text = hogwarts.professor
        holder.subjectTextView.text = hogwarts.subject
        holder.bioTextView.text = hogwarts.bio
    }
}