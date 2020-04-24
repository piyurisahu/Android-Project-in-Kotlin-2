package com.example.spinnerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val professors = resources.getStringArray(R.array.professors)
        val professorsDescription = resources.getStringArray(R.array.professors_description)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val textBox = findViewById<TextView>(R.id.showTextView)
        if(spinner!= null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, professors)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                   textBox.text = professorsDescription[position]
                }
                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }
}
