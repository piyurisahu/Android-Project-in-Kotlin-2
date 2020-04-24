//created by Piyuri Sahu
package com.example.sahuweek07intentimplicit

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.sendButton)
      button.setOnClickListener {   val emailText = findViewById<EditText>(R.id.emailText)
          val subjectText = findViewById<EditText>(R.id.subjectEditText)
          val messageEditText = findViewById<EditText>(R.id.messageEditText)

          val emailIntent = Intent(Intent.ACTION_SEND)
          emailIntent.action = Intent.ACTION_SEND

          emailIntent.data = Uri.parse("mailto:")
          emailIntent.type = "text/plain"
          emailIntent.putExtra(Intent.EXTRA_SUBJECT, subjectText.text.toString())
          emailIntent.putExtra(Intent.EXTRA_EMAIL, emailText.text.toString())
          emailIntent.putExtra(Intent.EXTRA_TEXT, messageEditText.text.toString())

          startActivity(Intent.createChooser(emailIntent, "Choose email program"))
      }

    }
}
