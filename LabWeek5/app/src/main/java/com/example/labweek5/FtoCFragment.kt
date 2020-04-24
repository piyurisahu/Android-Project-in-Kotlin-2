package com.example.labweek5


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Double.parseDouble
import java.lang.Exception
import java.lang.Math.round

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FtoCFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FtoCFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FtoCFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fto_c, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //referencing controls

        val ftoC = view.findViewById<Button>(R.id.fToCbutton)
        val resultTextView = view.findViewById<TextView>(R.id.fResultTextView)
        val fToCButton = view.findViewById<Button>(R.id.fToCbutton)
        val farenheitEditText = view.findViewById<EditText>(R.id.farenheitEditText)
        // on click event listene

            fToCButton.setOnClickListener {
                var input: String = farenheitEditText.text.toString()
                var farenheitInput : Double
                var celcius: Double

                try {
                    farenheitInput = parseDouble(input)
                    if(farenheitEditText !=null) {
                        celcius = Rounder((farenheitInput - 32)*5/9)

                        resultTextView.text = farenheitInput.toString() + "F will be "+ celcius.toString() + " C."
                    }
                } catch (e: Exception) {

                }

        }
    }

    private fun Rounder(d: Double): Double {
        return round(d*100) /100.toDouble()
    }


}
