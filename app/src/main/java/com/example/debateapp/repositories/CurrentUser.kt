package com.example.debateapp.repositories

import android.util.Log
import com.example.debateapp.models.User

object CurrentUser {
    lateinit var user: User

    fun updateUser(userName: String, descrption: String){
        user = User(userName, "", descrption)
    }
}