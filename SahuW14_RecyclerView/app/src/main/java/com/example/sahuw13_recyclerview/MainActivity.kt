package com.example.sahuw13_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import java.io.InputStream
import java.lang.Exception
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val potterQuotesRecyclerView = findViewById<RecyclerView>(R.id.pottorQuotesRecyclerView)

        potterQuotesRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val potterQuotesList = ArrayList<PotterQuoteDataClass>()

        try {
            val inputStream: InputStream = assets.open("potterQuotes.json")

            var quotesArray = JSONArray(inputStream.bufferedReader().use{it.readText()})

            for (i in 0 .. quotesArray.length()) {
                var potterQuoteObject = quotesArray.getJSONObject(i)

                potterQuotesList.add(
                    PotterQuoteDataClass(
                    potterQuoteObject.getString("quote"), potterQuoteObject.getString("book")
                    ,potterQuoteObject.getString("character")
                )
                )
            }
        }catch (e: Exception) {
            Log.d("Error reading json det", e.stackTrace.toString())
        }

        val potterQuoteAdapterClass = PotterQuoteAdapterClass(potterQuotesList)


        potterQuotesRecyclerView.adapter = potterQuoteAdapterClass
    }
}
