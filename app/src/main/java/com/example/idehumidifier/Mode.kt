package com.example.idehumidifier

import java.io.Serializable

data class Mode (
     var ioniser : Boolean = false,
     var clothes : Boolean = false,
     var normal : Boolean = true
         ):Serializable