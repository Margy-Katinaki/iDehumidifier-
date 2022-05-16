package com.example.idehumidifier

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.idehumidifier.databinding.ModeBinding

class ModeActivity : AppCompatActivity(){

    private lateinit var binding:ModeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ModeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.switchIoniser.setOnCheckedChangeListener{ compoundButton, isChecked->
            if(isChecked){
            binding.switchClothes.isChecked = !isChecked
            binding.switchNormal.isChecked = !isChecked}
        }

        binding.switchClothes.setOnCheckedChangeListener{ compoundButton, isChecked->
            if(isChecked){
                binding.switchIoniser.isChecked = !isChecked
                binding.switchNormal.isChecked = !isChecked}
        }

        binding.switchNormal.setOnCheckedChangeListener{ compoundButton, isChecked->
            if(isChecked){
                binding.switchIoniser.isChecked = !isChecked
                binding.switchClothes.isChecked = !isChecked}
        }


        binding.imageViewBack.setOnClickListener {
            //Toast.makeText(this@ConnectDevice,binding.editTextName.text.toString())
            onBackPressed()
        }
    }
}