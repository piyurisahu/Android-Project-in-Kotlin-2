package com.example.hogwartsrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val hogwarsRecyclerView = findViewById<RecyclerView>(R.id.hogwartsRecyclerView)

        hogwarsRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val hogwartsList = ArrayList<Hogwarts>()

        val professors = resources.getStringArray(R.array.professor)
        val subject = resources.getStringArray(R.array.subject)
        val bio = resources.getStringArray(R.array.bio)

        for(i in professors.indices) {
            hogwartsList.add(Hogwarts(professors[i].toString(), subject[i].toString(), bio[i].toString()))
        }

        val myAdapter = HogwartsAdapter(hogwartsList)
        hogwarsRecyclerView.adapter = myAdapter


    }
}
