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
        val cityList = ArrayList<City>()


        try {
            val inputStream: InputStream = assets.open("cities_json.json")
            var cityArray = JSONArray(inputStream.bufferedReader().use { it.readText() })

            for (i in 0 until cityArray.length()) {
                val singleUser = cityArray.getJSONObject(i)
                val city= singleUser.getString("city")
                val hotel = singleUser.getString("hotel")
                val state = singleUser.getString("state")
                val description = singleUser.getString("description")
                val weather = singleUser.getString("weather")
                val image = singleUser.getString("image")
                val imageId= resources.getIdentifier(image, "drawable", packageName)
                cityList.add(City(city, hotel, description, weather, state, imageId))
            }

            cityView.adapter = CustomAdapter(this@MainActivity, cityList)
        } catch (ex: Exception) {
            Log.d("Look Here", ex.toString())
            Toast.makeText(this, "Error occured: ${ex.toString()}", Toast.LENGTH_LONG).show()
        }
    }

}
