package com.example.idehumidifier

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.idehumidifier.databinding.TimerBinding
import java.util.*

class SchedulerActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener {

    private lateinit var binding : TimerBinding

    private var adapter = SchedulerAdapter(Data.instance.getSchedulers())

    var day = 0
    var month = 0
    var year = 0
    var hour = 0
    var min = 0

    var savedDay = 0
    var savedMonth = 0
    var savedYear = 0
    var savedHour = 0
    var savedMin = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TimerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

//        adapter.setOnItemClickListener(object : TimerAdapter.onItemClickListener{
//            override fun onItemClick(timer: Timer) {
//                Log.e("eee","a")
//            }
//        })
        pickDate()


        binding.imageViewBack.setOnClickListener {
            //Toast.makeText(this@ConnectDevice,binding.editTextName.text.toString())
            onBackPressed()
        }
    }


    private fun getDateTimeCalendar() {
        val cal: Calendar = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        hour = cal.get(Calendar.HOUR)
        min = cal.get(Calendar.MINUTE)
    }

    private fun pickDate() {
        binding.buttonTime.setOnClickListener {
            getDateTimeCalendar()
            DatePickerDialog(this, this, year, month, day).show()
        }

    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDay = dayOfMonth
        savedMonth = month
        savedYear = year

        getDateTimeCalendar()
        TimePickerDialog(this, this, hour, min, true).show()
    }

    override fun onTimeSet(view: TimePicker?, hourofDay: Int, minutes: Int) {
        savedHour = hourofDay
        savedMin = minutes

        val savedsched = Scheduler(savedDay, savedMonth, savedYear, savedHour, savedMin, false)
        Data.instance.addScheduler(savedsched)
        adapter = SchedulerAdapter(Data.instance.getSchedulers())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

    }

}

