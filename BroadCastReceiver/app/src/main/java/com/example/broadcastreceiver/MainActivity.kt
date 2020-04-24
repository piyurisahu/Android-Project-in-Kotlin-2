package com.example.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val myBroadCastReciever  = MyBroadCastReciever()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val broadCastButton = findViewById<Button>(R.id.broadcastButton)

        broadCastButton.setOnClickListener{
            val myIntentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)


            registerReceiver(myBroadCastReciever, myIntentFilter)
        }


        fun onStop() {
            super.onStop()
            unregisterReceiver(myBroadCastReciever)
        }
    }
}
