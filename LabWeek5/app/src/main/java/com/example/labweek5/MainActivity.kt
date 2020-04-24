package com.example.labweek5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val fragmentManager = supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val redButton = findViewById<Button>(R.id.showRedButton)
        val greenButton = findViewById<Button>(R.id.showGreenButton)

        redButton.setOnClickListener{
            val transaction = fragmentManager.beginTransaction()
            val redFragment =  CtoFFragment()
            transaction.replace(R.id.fragmentHolder, redFragment)
            transaction.addToBackStack(null)
            transaction.commit()

        }//redButton
        greenButton.setOnClickListener{
            val transaction = fragmentManager.beginTransaction()
            val greenFragment =  FtoCFragment()
            transaction.replace(R.id.fragmentHolder, greenFragment)
            transaction.addToBackStack(null)
            transaction.commit()

        }//greenButton


    }//end onCreate
}//end of main Activity
