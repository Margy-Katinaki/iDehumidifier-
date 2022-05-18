package com.example.idehumidifier

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.idehumidifier.databinding.ConnectDeviceBinding

class ConnectDeviceActivity : AppCompatActivity() {

    private lateinit var binding: ConnectDeviceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ConnectDeviceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val roomsList = resources.getStringArray(R.array.rooms)
        var rposition = 0
        val sproomslist= binding.spinnerRoom
        sproomslist.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                rposition = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
        binding.buttonAdd.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val serial = binding.editTextSerial.text.toString()
            val room = when(rposition){
                1-> roomsList[1]
                2-> roomsList[2]
                3-> roomsList[3]
                4-> roomsList[4]
                5-> roomsList[5]
                6-> roomsList[6]
                else -> roomsList[0]
            }

            val deh = Dehumidifier(name,serial,room,null,null,Mode(),Speed())
            Data.instance.addDehumidifier(deh)

            onBackPressed()


        }


        binding.imageViewBack.setOnClickListener {
            //Toast.makeText(this@ConnectDevice,binding.editTextName.text.toString())
            onBackPressed()
        }






    }






}