package com.example.idehumidifier

import java.io.Serializable

data class Timer (
    var day  : Int,
    var month: Int,
    var year : Int,
    var hour : Int,
    var min : Int
        ): Serializable

