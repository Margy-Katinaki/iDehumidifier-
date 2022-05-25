package com.example.idehumidifier

import android.app.Application

class Data : Application() {
    private lateinit var dehumidifiersList : MutableList<Dehumidifier>
    private lateinit var timersList : MutableList<Timer>
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

    fun addTimer(timer: Timer){
        timersList.add(timer)
        println(timersList.size)
    }

    fun getTimers(): MutableList<Timer>{
        return timersList
    }

    fun changeMode(curMode: Mode){
        curDehumidifier.mode = curMode
    }

    fun changeSpeed(curSpeed: Speed){
        curDehumidifier.speed = curSpeed
    }
}