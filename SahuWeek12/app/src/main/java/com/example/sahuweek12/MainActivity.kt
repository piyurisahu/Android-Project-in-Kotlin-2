package com.example.sahuweek12

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val broadcastReceiver = BroadcastReceiverByMe()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val intentFiler = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)

            registerReceiver(broadcastReceiver, intentFiler)

        }

        fun  onStop(){
            super.onStop()
            unregisterReceiver(broadcastReceiver)
        }

    }
}
