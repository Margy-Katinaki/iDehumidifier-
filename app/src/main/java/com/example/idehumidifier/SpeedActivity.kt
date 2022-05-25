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
            Data.instance.changeSpeed(Speed(true,false,false))
        }

        binding.switchFast.setOnCheckedChangeListener{ compoundButton, isChecked->
            if(isChecked){
                binding.switchNormal.isChecked = !isChecked
                binding.switchAuto.isChecked = !isChecked}
            Data.instance.changeSpeed(Speed(false,true,false))
        }

        binding.switchAuto.setOnCheckedChangeListener{ compoundButton, isChecked->
            if(isChecked){
                binding.switchNormal.isChecked = !isChecked
                binding.switchFast.isChecked = !isChecked}
            Data.instance.changeSpeed(Speed(false,false,true))
        }


        binding.imageViewBack.setOnClickListener {
            //Toast.makeText(this@ConnectDevice,binding.editTextName.text.toString())
            onBackPressed()
        }
    }

    override fun onResume() {
        super.onResume()
        binding.switchNormal.isChecked = Data.instance.getDehumidifier().speed.normal
        binding.switchFast.isChecked = Data.instance.getDehumidifier().speed.fast
        binding.switchAuto.isChecked = Data.instance.getDehumidifier().speed.auto
    }

}