package com.example.labweek5

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import java.lang.Double.parseDouble
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CtoFFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CtoFFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CtoFFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cto_f, container, false)
    }//end on create view

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //referencing controls

        val cToFButton = view.findViewById<Button>(R.id.cToFbutton)

            // on click event listener
        cToFButton.setOnClickListener{
            val fResultTextView = view.findViewById<TextView>(R.id.fResultTextView)
            val celciusEditText = view.findViewById<TextView>(R.id.celciusEditText)
            val celciusInput : Double
            var input:String = celciusEditText.text.toString()
            var farenheit : Double

            try {
                celciusInput = parseDouble(input)

                if(celciusInput !=null) {
                    //to celcious

                    farenheit = Rounder((celciusInput * 9 / 5) + 32)
                    //display
                    fResultTextView.text = celciusInput.toString() + "C will be " + farenheit.toString()+ " F."
                }
                else {
                    throw java.lang.Exception("Invalid Input. Try again")
                }
            }//end try
            catch (e: Exception) {
                fResultTextView.text = e.message
            }// endCatch
        }// onClickListener
    } //end onView Created

    private fun Rounder(d: Double): Double {
        return Math.round(d*100)/100.toDouble()
    }


}//
