package com.example.debateapp.models

import com.google.firebase.Timestamp

data class Message(
    var timestamp: Timestamp,
    var content: String
)