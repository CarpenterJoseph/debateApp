package com.example.debateapp.models

data class Debate(
    var id: String = "",
    var topic: String = "",
    var canJoinAsDebater: Boolean = false
)