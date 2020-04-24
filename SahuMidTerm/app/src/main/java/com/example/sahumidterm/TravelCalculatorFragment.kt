package com.example.sahumidterm


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_travel_calculator.view.*

//created by Piyuri Sahu
class TravelCalculatorFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_travel_calculator, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val describeTravel = view.findViewById<Button>(R.id.describe)

        var comm = activity as Communicator
        describeTravel.setOnClickListener {



            var speed = view.speedText.text?.toString()
            var distance = view.distanceText.text?.toString()
            if(speed == null) {
                speed = ""
            }
            if(distance == null) {
                distance = ""
            }

            if(speed == "") {
                Toast.makeText(context,"MPH is blank",Toast.LENGTH_SHORT).show()
            }
            if(distance == "") {
                Toast.makeText(context,"Distance is blank",Toast.LENGTH_SHORT).show()
            }
            comm.passData(speed, distance)
        }
    }

}
