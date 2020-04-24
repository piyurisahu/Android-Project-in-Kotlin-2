package com.example.mytravelguide

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_citi_information.*

class CityInformation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_citi_information)
        val bundle:Bundle = intent.extras!!
        val name =bundle.getString("city")
        val age = bundle.getString("state")
        val image=bundle.getInt("image")
        cityImage.setImageResource(image)
        cityName.text=name
        }
}
