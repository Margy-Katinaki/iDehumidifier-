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
            Data.instance.changeMode(Mode(true,false,false))
        }

        binding.switchClothes.setOnCheckedChangeListener{ compoundButton, isChecked->
            if(isChecked){
                binding.switchIoniser.isChecked = !isChecked
                binding.switchNormal.isChecked = !isChecked}
            Data.instance.changeMode(Mode(false,true,false))
        }

        binding.switchNormal.setOnCheckedChangeListener{ compoundButton, isChecked->
            if(isChecked){
                binding.switchIoniser.isChecked = !isChecked
                binding.switchClothes.isChecked = !isChecked}
            Data.instance.changeMode(Mode(false,false,true))
        }




        binding.imageViewBack.setOnClickListener {
            //Toast.makeText(this@ConnectDevice,binding.editTextName.text.toString())
            onBackPressed()
        }
    }
    override fun onResume() {
        super.onResume()
        binding.switchIoniser.isChecked = Data.instance.getDehumidifier().mode.ioniser
        binding.switchClothes.isChecked = Data.instance.getDehumidifier().mode.clothes
        binding.switchNormal.isChecked = Data.instance.getDehumidifier().mode.normal
    }
}