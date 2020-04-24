//  Created by Piyuri Sahu
package com.example.passingdatatoanotherfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_blue.view.*

/**

 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class BlueFragment : Fragment() {

    var nameString:String? = ""
    lateinit var commB: Communicator
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blue, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //get the input string
         nameString = arguments?.getString("nameString")

        view.findViewById<TextView>(R.id.messageTextView).text = "" +
                "Hello $nameString welcome to fragment Blue"

        //when text entered and button is clicked on fragment B
        commB = activity as Communicator
        val fragGButton = view.findViewById<Button>(R.id.goToFragGbutton)


        fragGButton.setOnClickListener{
            val yourName = view.nameFrBEditTextView.text.toString()
            commB.passData(yourName, "B")
        }


    }


}
