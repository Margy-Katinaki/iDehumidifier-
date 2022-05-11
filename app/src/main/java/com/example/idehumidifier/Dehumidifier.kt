package com.example.idehumidifier

data class Dehumidifier(
    val id: Int,
    var name: String,
    val model: String,
    val humidity: Double,
    val temperature: Double,
    val room: String,
    val serial_number: String
)