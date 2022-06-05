package com.example.idehumidifier

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.idehumidifier.databinding.DehumidifierBinding

class DehumidifierActivity : AppCompatActivity() {

    private lateinit var binding : DehumidifierBinding
     var dehumidifier = Data.instance.getDehumidifier()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DehumidifierBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.textViewDehumidifierName.text = dehumidifier.name
        binding.textViewDehumidifierRoom.text = dehumidifier.room

        println(dehumidifier)

        binding.buttonMode.setOnClickListener {
            val intent = Intent(this,ModeActivity::class.java)
            startActivity(intent)
        }

        binding.buttonSpeed.setOnClickListener {
            val intent = Intent(this,SpeedActivity::class.java)
            startActivity(intent)
        }

        binding.buttonTimer.setOnClickListener {
            val intent = Intent(this,SchedulerActivity::class.java)
            startActivity(intent)
        }

        binding.imageViewBack.setOnClickListener {
            //Toast.makeText(this@ConnectDevice,binding.editTextName.text.toString())
            onBackPressed()
        }

        binding.imageViewSettings.setOnClickListener{
            val intent = Intent(this,SettingsActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onResume() {
        super.onResume()
        dehumidifier= Data.instance.getDehumidifier()
        binding.textViewDehumidifierName.text = dehumidifier.name
        binding.textViewDehumidifierRoom.text = dehumidifier.room

    }

}