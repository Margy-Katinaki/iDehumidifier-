package com.example.idehumidifier

import java.io.Serializable

data class Speed (
    var normal : Boolean = true,
    var fast : Boolean = false,
    var auto : Boolean = false
  ):Serializable
