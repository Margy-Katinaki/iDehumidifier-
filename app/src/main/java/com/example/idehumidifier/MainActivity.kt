package com.example.idehumidifier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = mutableListOf<Dehumidifier>()

        val a = Dehumidifier(1, "kati", "kati model", 100.0, 88.0)
        val b = Dehumidifier(2, "kati", "kati model", 100.0, 88.0)
        val c = Dehumidifier(3, "kati", "kati model", 100.0, 88.0)
        val d = Dehumidifier(4, "kati", "kati model", 100.0, 88.0)

        list.add(a)
        list.add(b)
        list.add(c)
        list.add(d)

        val adapter = DehumidifierAdapter(list)

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)






    }
}

