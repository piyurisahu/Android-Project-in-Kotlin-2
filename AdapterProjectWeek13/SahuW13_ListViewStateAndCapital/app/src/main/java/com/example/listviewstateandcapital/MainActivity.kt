package com.example.listviewstateandcapital

import android.os.Bundle
import android.view.Gravity
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val statesArray = resources.getStringArray(R.array.statesArray)
        val stateListView = findViewById<ListView>(R.id.stateListView)

        stateListView.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, statesArray)

        stateListView.setOnItemClickListener{parent, view, position, id ->
            val resultView = findViewById<TextView>(R.id.resultTextView)

            val capitalsArray = resources.getStringArray(R.array.captialsArray)

            val toastMsg = Toast.makeText(this, "You" +
                    "Selected" + statesArray[position], Toast.LENGTH_LONG)

            toastMsg.setGravity(Gravity.TOP, 0, 0)
            toastMsg.show()

            resultTextView.text = "Capital of ${statesArray[position]} is ${capitalsArray[position]}"

        }
    }




}
