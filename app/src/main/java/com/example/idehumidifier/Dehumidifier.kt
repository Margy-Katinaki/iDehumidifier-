package com.example.idehumidifier

data class Dehumidifier(
    var name: String,
    val serial_number: String,
    var room: String,
    var humidity: Double?,
    var temperature: Double?,
    var mode : Mode,
    var speed : Speed
)