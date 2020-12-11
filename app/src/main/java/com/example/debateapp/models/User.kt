package com.example.debateapp.models

import com.google.firebase.database.IgnoreExtraProperties
import java.util.*

@IgnoreExtraProperties
data class User(
    var username: String? = "",
    var password: String? = "",
    var description: String
)