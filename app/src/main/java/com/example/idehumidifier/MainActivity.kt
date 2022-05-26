package com.example.idehumidifier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.idehumidifier.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var adapter = DehumidifierAdapter(Data.instance.getDehumidifiers())

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter.setOnItemClickListener(object : DehumidifierAdapter.onItemClickListener{
            override fun onItemClick(dehumidifier: Dehumidifier) {
                val intent = Intent(baseContext,DehumidifierActivity::class.java)
                Data.instance.setDehumidifier(dehumidifier)
                startActivity(intent)
            }
        })

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        //val list = mutableListOf<Dehumidifier>()
//        val a = Dehumidifier("1", "kati", "kati model", 100.0, 88.0,Mode(),Speed())
//
//        Data.instance.addDehumidifier(a)



        binding.button.setOnClickListener {
         //UNCOMMENT THIS LATER
            val intent = Intent(this,ConnectDeviceActivity::class.java)
            startActivity(intent)


//            val deh = Dehumidifier("name","serial","room",null,null,Mode(),Speed())
//            Data.instance.addDehumidifier(deh)
            onResume()
        }


    }


    override fun onResume() {
        super.onResume()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}


