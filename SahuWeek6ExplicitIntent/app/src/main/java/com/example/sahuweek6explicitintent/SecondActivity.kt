//Created by Piyuri Sahu
package com.example.sahuweek6explicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val button = findViewById<Button>(R.id.secondActButton)
        val messageTextView = findViewById<TextView>(R.id.messageTextView)

        val incomingIntent = intent

        val message = "Name: ${incomingIntent.getStringExtra("Name")}|n Number : ${incomingIntent.getStringExtra("Number")}"

        messageTextView.text = message

        button.setOnClickListener {
            val outGoingIntent = Intent(this, MainActivity::class.java)

            val numberSent : Int

            if(incomingIntent.getStringExtra("Number")?.toInt() !=null) {
                numberSent = incomingIntent.getStringExtra("Number")!!.toInt()
            }
            else numberSent = 0
            val returnMessage = numerology(numberSent)
            outGoingIntent.putExtra("Result", returnMessage)
            startActivity(outGoingIntent)


        }






    }

    private fun numerology(numberSent: Int): String {

        val returnString: String

        when(numberSent) {
            in 0..3 -> returnString = "Math is fun"
            in 4..6 -> returnString = "Coding is fun"
            in 7..10-> returnString = "Everything is fun"
            else -> returnString = "I am so happy"
        }
        return returnString
    }
}
