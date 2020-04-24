package com.example.fetchingjsonfromhttpserver

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchJsonData().execute()
    }

    inner class fetchJsonData(): AsyncTask<String, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
        }
        override fun doInBackground(vararg params: String?): String?{
            return URL("https://www.androdocs.com/files/uploads/original/sample-json-data-1567767983.txt").readText(
                    Charsets.UTF_8
            )
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            Log.d("FetchData", result)
        }
    }
}
