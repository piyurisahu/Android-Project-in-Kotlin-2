package com.example.sahumidterm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

//created by Piyuri Sahu
class MainActivity : AppCompatActivity(), Communicator {
    val fragmentManager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction  = fragmentManager.beginTransaction()

        val inputFragment = TravelCalculatorFragment()
        transaction.replace(R.id.fragmentHolder, inputFragment, "Input Fragment")

        transaction.addToBackStack(null)
        transaction.commit()
        Toast.makeText(applicationContext, "MPH is blank", Toast.LENGTH_SHORT).show()
    }

    override fun passData(speed: String, distance: String) {
        val time = distance.toInt() * 60 / speed.toInt()
        val message = "It takes ${time} Minutes to travel ${distance} at ${speed}"
        val bundle = Bundle()
        bundle.putString("message", message)

        val transaction = fragmentManager!!.beginTransaction()

        val displayFragment = DisplayTravelDescriptionFragment()
        displayFragment.arguments = bundle
        transaction.replace(R.id.fragmentHolder, displayFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
