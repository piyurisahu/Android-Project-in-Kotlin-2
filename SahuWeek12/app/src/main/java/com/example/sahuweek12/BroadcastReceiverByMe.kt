package com.example.sahuweek12

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadcastReceiverByMe : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Airplane mode Changed", Toast.LENGTH_LONG).show();
    }


}