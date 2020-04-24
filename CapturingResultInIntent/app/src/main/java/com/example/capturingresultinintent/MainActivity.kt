 package com.example.capturingresultinintent

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

 class MainActivity : AppCompatActivity() {

    val TakrPicture = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton = findViewById<Button>(R.id.myButton)

        myButton.setOnClickListener {
            val myIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if(myIntent.resolveActivity(packageManager) != null) {
                startActivity(myIntent)

                startActivityForResult(myIntent, TakrPicture)
                Toast.makeText(this, "Hellp", Toast.LENGTH_SHORT).show()
            }
        }

    }
     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
         super.onActivityResult(requestCode, resultCode, data)

         val myImageView = findViewById<ImageView>(R.id.myImageView)

         if(requestCode == TakrPicture && resultCode == Activity.RESULT_OK) {
             val myBitMap = data!!.extras!!.get("data")
             myImageView.setImageBitmap(myBitMap as Bitmap)
         }
     }
}
