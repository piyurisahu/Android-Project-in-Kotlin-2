 package com.example.passingdatatoanotherfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), Communicator {

    val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = fragmentManager.beginTransaction()

        val greenFragment = GreenFragment()
        transaction.replace(R.id.fragmentHolder, greenFragment, "Fragment Green")

        
        transaction.addToBackStack(null)
        transaction.commit()
  

    }

    override fun passData(editTextInput: String, fragName: String) {
        val bundle = Bundle()
        bundle.putString("nameString", editTextInput)
        val fragmentManager = supportFragmentManager

        val transaction = fragmentManager.beginTransaction()

        when(fragName) {
            "G"-> {
                val blueFragment = BlueFragment()
                blueFragment.arguments = bundle

                transaction.replace(R.id.fragmentHolder, blueFragment, "fragment Blue").addToBackStack(null).commit()
            }

            "B"-> {
                val greenFragment = GreenFragment()
                greenFragment.arguments = bundle

                transaction.replace(R.id.fragmentHolder, greenFragment, "fragment Green").addToBackStack(null).commit()
            }
        }
    }
}
