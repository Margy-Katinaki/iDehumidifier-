package com.example.idehumidifier

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.idehumidifier.databinding.SettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding : SettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imageViewBack.setOnClickListener {
            //Toast.makeText(this@ConnectDevice,binding.editTextName.text.toString())
            onBackPressed()
        }
    }


}