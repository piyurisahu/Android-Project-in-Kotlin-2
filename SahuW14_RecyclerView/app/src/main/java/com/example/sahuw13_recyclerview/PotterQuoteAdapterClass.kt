package com.example.sahuw13_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class PotterQuoteAdapterClass (val  potterQuetesData: ArrayList<PotterQuoteDataClass>)
    : RecyclerView.Adapter<PotterQuoteAdapterClass.ViewHolder>() {



    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val quoteTextView = itemView.findViewById<TextView>(R.id.quoteTextView)
        val bookTextView = itemView.findViewById<TextView>(R.id.bookTextView)
        val characterTextView = itemView.findViewById<TextView>(R.id.characterTextView)
        val separatorTextView = itemView.findViewById<TextView>(R.id.separatorTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val viewGenerator = LayoutInflater.from(parent.context).inflate(
           R.layout.recycle_view_layout, parent, false
       )

        return ViewHolder(viewGenerator)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val potterQuoteDataClass: PotterQuoteDataClass = potterQuetesData[position]

        holder.bookTextView.text= potterQuoteDataClass.book
        holder.characterTextView.text = potterQuoteDataClass.character
        holder.separatorTextView.text = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
        holder.quoteTextView.text = potterQuoteDataClass.quote


    }

}