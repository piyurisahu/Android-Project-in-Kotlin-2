//Created by Piyuri Sahu

package com.example.sahuweek6explicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.firstActButton)
        val number = findViewById<EditText>(R.id.numberEditText)
        val name = findViewById<EditText>(R.id.nameEditText)

        val result = findViewById<TextView>(R.id.resultTextView)

        val incomingIntent = intent
        result.text = intent.getStringExtra("Result")

        button.setOnClickListener{
            Toast.makeText(this, "First Activity", Toast.LENGTH_SHORT).show()

            val secondIntent = Intent(this, SecondActivity::class.java)

            secondIntent.putExtra("Name", name.text.toString())
            secondIntent.putExtra("Number", number.text.toString())

            startActivity(secondIntent)
        }
    }
}
