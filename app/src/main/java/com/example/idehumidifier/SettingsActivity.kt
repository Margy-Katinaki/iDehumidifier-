package com.example.idehumidifier

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.example.idehumidifier.databinding.SettingsBinding


class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: SettingsBinding
    private lateinit var dehumid: Dehumidifier

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dehumid = Data.instance.getDehumidifier()

        val roomsList = resources.getStringArray(R.array.rooms)
        var rposition = 0
        val sproomslist= binding.spinnerChangeRoom

        val oldroom = dehumid.room

        val positionList = roomsList.indexOf(oldroom)
        sproomslist.setSelection(positionList)
        sproomslist.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                rposition = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }


        binding.imageViewBack.setOnClickListener {
            //Toast.makeText(this@ConnectDevice,binding.editTextName.text.toString())
            onBackPressed()
        }


        binding.imageViewDelete.setOnClickListener {
            Data.instance.removeDehumidifier()
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        binding.buttonSave.setOnClickListener {
            val name = binding.editTextChangeName.text.toString()
            val room = when(rposition){
                1-> roomsList[1]
                2-> roomsList[2]
                3-> roomsList[3]
                4-> roomsList[4]
                5-> roomsList[5]
                6-> roomsList[6]
                else -> roomsList[0]
            }
//            if (!oldroom.equals(room)){
//                Data.instance.changeRoom(dehumid,room)
//            }
//            if(!dehumid.name.equals(name)){
//                Data.instance.changeName(dehumid,name)
//            }

            Data.instance.changeSettings(name, room)

            onBackPressed()

        }

    }

    override fun onResume() {
        super.onResume()
       // dehumid = Data.instance.getDehumidifiers().find { it == dehumid }!!
    }
}