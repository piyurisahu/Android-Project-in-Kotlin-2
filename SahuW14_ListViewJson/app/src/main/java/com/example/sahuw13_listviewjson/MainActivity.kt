package com.example.sahuw13_listviewjson

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.io.InputStream
import java.lang.Exception
import android.widget.ListView as ListView1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        jsonReaderFunction()
    }

    fun jsonReaderFunction() {
        val potterListView = findViewById<ListView1>(R.id.potterListView)

        var potterRoleList = arrayListOf<String>()
        var potterActorList = arrayListOf<String>()

        try {
            val inputStream: InputStream = assets.open("potter.json")

            var potterArray = JSONArray(inputStream.bufferedReader().use { it.readText() })

            for (i in 0..potterArray.length() - 1) {
                var potterJsonObject = potterArray.getJSONObject(i)
                potterRoleList.add(potterJsonObject.getString("role"))
                potterActorList.add(potterJsonObject.getString("actor"))
            }

            potterListView.adapter = ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_activated_1,
                potterRoleList
            )

            potterListView.onItemClickListener =
                AdapterView.OnItemClickListener { parent, view, position, id ->
                    val actorTextView = findViewById<TextView>(R.id.actorTextView)
                    val role = potterRoleList[position]
                    val actor = potterActorList[position]

                    actorTextView.text = role + " was played by " + actor
                }
        } catch (ex: Exception) {
            Log.d("Look Here", ex.toString())
            Toast.makeText(this, "Error occured: ${ex.toString()}", Toast.LENGTH_LONG).show()
        }
    }


}
