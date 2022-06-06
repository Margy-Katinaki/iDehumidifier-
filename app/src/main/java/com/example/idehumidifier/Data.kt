package com.example.idehumidifier

import android.app.Application
import java.util.*

class Data : Application() {
    private lateinit var dehumidifiersList : MutableList<Dehumidifier>
    private lateinit var timersList : MutableList<Timer>
    private lateinit var weatherList : MutableList<Weather>
    private lateinit var schedulersList : MutableList<Scheduler>
    private lateinit var curDehumidifier: Dehumidifier

    companion object {
        lateinit var instance: Data
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        dehumidifiersList = mutableListOf()
        timersList= mutableListOf()
//+ (char) 0x00B0+"C"
        weatherList= mutableListOf(
            Weather("25","40"),
            Weather("27","32"),
            Weather("25","40"),
            Weather("24","50"),
            Weather("20","60"),
            Weather("22","48"),
            Weather("21","43"),
        )

        schedulersList= mutableListOf()
    }
    fun setDehumidifier(dehumidifier: Dehumidifier){
        this.curDehumidifier = dehumidifier
    }
    fun getDehumidifier(): Dehumidifier {
        return curDehumidifier
    }

    fun addDehumidifier(dehumidifier: Dehumidifier){
        dehumidifiersList.add(dehumidifier)
        println(dehumidifiersList.size)
    }

    fun getDehumidifiers(): MutableList<Dehumidifier>{
        return dehumidifiersList
    }

    fun removeDehumidifier(){
        dehumidifiersList.remove(curDehumidifier)
    }

    fun changeSettings(newName: String, newRoom: String){
        if(curDehumidifier.name != newName && newName.isNotEmpty()) curDehumidifier.name = newName
        if(curDehumidifier.room != newRoom) curDehumidifier.room = newRoom
    }

    fun addScheduler(scheduler: Scheduler){
        schedulersList.add(scheduler)
        println(schedulersList.size)
    }

    fun getSchedulers(): MutableList<Scheduler>{
        return schedulersList
    }

    fun saveState(state: Boolean, pos: Int){
        schedulersList[pos].isOn = state
    }

    fun changeMode(curMode: Mode){
        curDehumidifier.mode = curMode
    }

    fun changeSpeed(curSpeed: Speed){
        curDehumidifier.speed = curSpeed
    }

    fun getTodayWeather(): Weather{
        val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
        return weatherList[day]
    }
}