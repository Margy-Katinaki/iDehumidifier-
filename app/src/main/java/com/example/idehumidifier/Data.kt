package com.example.idehumidifier

import android.app.Application

class Data : Application() {
     private lateinit var dehumidifiersList : MutableList<Dehumidifier>

    companion object {
        lateinit var instance: Data
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        dehumidifiersList = mutableListOf()
    }



    fun addDehumidifier(dehumidifier: Dehumidifier){
        dehumidifiersList.add(dehumidifier)
        println(dehumidifiersList.size)
    }

    fun getDehumidifiers(): MutableList<Dehumidifier>{
        return dehumidifiersList
    }

    fun removeDehumidifier(dehumidifier: Dehumidifier ){
        dehumidifiersList.remove(dehumidifier)
    }

    //fun changeName

}