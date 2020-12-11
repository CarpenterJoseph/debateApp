package com.example.debateapp.models

import com.google.firebase.Timestamp

data class Message(
    var username: String,
    var timestamp: Timestamp,
    var content: String
)