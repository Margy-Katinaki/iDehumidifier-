package com.example.idehumidifier

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.idehumidifier.databinding.SpeedBinding

class SpeedActivity: AppCompatActivity() {

    private lateinit var binding :SpeedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SpeedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.switchNormal.setOnCheckedChangeListener{ compoundButton, isChecked->
            if(isChecked){
                binding.switchFast.isChecked = !isChecked
                binding.switchAuto.isChecked = !isChecked}
        }

        binding.switchFast.setOnCheckedChangeListener{ compoundButton, isChecked->
            if(isChecked){
                binding.switchNormal.isChecked = !isChecked
                binding.switchAuto.isChecked = !isChecked}
        }

        binding.switchAuto.setOnCheckedChangeListener{ compoundButton, isChecked->
            if(isChecked){
                binding.switchNormal.isChecked = !isChecked
                binding.switchFast.isChecked = !isChecked}
        }


        binding.imageViewBack.setOnClickListener {
            //Toast.makeText(this@ConnectDevice,binding.editTextName.text.toString())
            onBackPressed()
        }
    }

}