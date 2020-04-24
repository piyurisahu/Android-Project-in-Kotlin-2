package com.example.sahuweek13listview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val myListView = findViewById<ListView>(R.id.myListView)

        myListView.adapter = myAdapter(this)
        
    } //end of onCreate

    private class myAdapter(context: Context): BaseAdapter() {
        private val myContext: Context

        init {
            myContext = context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val myTextView = TextView(myContext)
            myTextView.text = "This is a row in myText view $position"

            return myTextView
        }

        override fun getItem(position: Int): Any {
            return "Whatever"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return 1000
        }

    }


}
