package com.example.debateapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.debateapp.repositories.CurrentUser

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        findViewById<TextView>(R.id.profileName).text = CurrentUser.user.username
    }

    fun backAction(v: View) {
        startHomeActivity()
    }

    private fun startHomeActivity(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}