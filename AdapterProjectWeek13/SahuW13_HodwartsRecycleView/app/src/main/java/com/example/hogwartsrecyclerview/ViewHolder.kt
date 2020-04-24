package com.example.hogwartsrecyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        val profTextView = itemView.findViewById<TextView>(R.id.profTextView)
        val subjectTextView = itemView.findViewById<TextView>(R.id.subjectTextView)
        val bioTextView = itemView.findViewById<TextView>(R.id.bioTextView)
}
