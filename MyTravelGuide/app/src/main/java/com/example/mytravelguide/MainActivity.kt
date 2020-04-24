package com.example.mytravelguide

import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androdocs.populatelistview.CustomAdapter
import org.json.JSONArray
import java.io.InputStream


class MainActivity : AppCompatActivity() {
    var dataList = ArrayList<HashMap<String, String>>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jsonReaderFunction()
    }



    fun jsonReaderFunction() {
        val cityView = findViewById<ListView>(R.id.listView)


        try {
            val inputStream: InputStream = assets.open("cities_json.json")
            var cityArray = JSONArray(inputStream.bufferedReader().use { it.readText() })



            for (i in 0 until cityArray.length()) {
                val singleUser = cityArray.getJSONObject(i)
                val map = HashMap<String, String>()
                map["name"] = singleUser.getString("name")
                map["age"] = singleUser.getString("age")
                map["city"] = singleUser.getString("city")
                map["image"] = singleUser.getString("image")
                val image = singleUser.getString("image")
                dataList.add(map)
            }

            cityView.adapter = CustomAdapter(this@MainActivity, dataList)
//            potterListView.onItemClickListener =
//                AdapterView.OnItemClickListener { parent, view, position, id ->
//                    val actorTextView = findViewById<TextView>(R.id.actorTextView)
//                    val role = potterRoleList[position]
//                    val actor = potterActorList[position]
//
//                    actorTextView.text = role + " was played by " + actor
//                }
        } catch (ex: Exception) {
            Log.d("Look Here", ex.toString())
            Toast.makeText(this, "Error occured: ${ex.toString()}", Toast.LENGTH_LONG).show()
        }
    }

}
