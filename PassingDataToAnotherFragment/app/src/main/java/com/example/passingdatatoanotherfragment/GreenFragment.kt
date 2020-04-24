package com.example.passingdatatoanotherfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_green.view.*


// created by Piyuri Sahu
class GreenFragment : Fragment() {

    lateinit var comm: Communicator //lateintialization when you can not supply a null but do
    // not want to check for null either

    var messageString: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_green, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //for dispalying message from fragment BLue
        messageString = arguments?.getString("nameString")

        if (messageString == null) messageString = "Piyuri Sahu"

        view.findViewById<TextView>(R.id.fragBTextView).text = "" +
                "Hello ${messageString} welcome to Fragment Green"

        val goToFragBButton =
            view.findViewById<Button>(R.id.goToFragBbutton) // Reference Button on the fragment

        // reference the communicator you declared above
        comm = activity as Communicator
        goToFragBButton.setOnClickListener {
            val nameString: String = view.messageEditText.text.toString()
            comm.passData(nameString, "G") // calling passData in main activity

        } //end onClick Listener
    }// on view create

}//end class
