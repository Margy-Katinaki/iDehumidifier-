package com.example.idehumidifier

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.idehumidifier.databinding.DehumidifierBinding

class DehumidifierActivity : AppCompatActivity() {

    private lateinit var binding : DehumidifierBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DehumidifierBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var dehumid = intent.getSerializableExtra("deh") as Dehumidifier
        binding.textViewDehumidifierName.text = dehumid.name
        binding.textViewDehumidifierRoom.text = dehumid.room

        println(dehumid)

        binding.buttonMode.setOnClickListener {
            val intent = Intent(this,ModeActivity::class.java)
            startActivity(intent)
        }

        binding.buttonSpeed.setOnClickListener {
            val intent = Intent(this,SpeedActivity::class.java)
            startActivity(intent)
        }

        binding.buttonTimer.setOnClickListener {
            val intent = Intent(this,TimerActivity::class.java)
            startActivity(intent)
        }

        binding.imageViewBack.setOnClickListener {
            //Toast.makeText(this@ConnectDevice,binding.editTextName.text.toString())
            onBackPressed()
        }
    }

}