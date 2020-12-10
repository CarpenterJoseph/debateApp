package com.example.debateapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.debateapp.models.Debate
import com.example.debateapp.models.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

class CreateDebateActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_debate)
        database = Firebase.database.reference
    }

    fun createDebateAction(v: View) {
        val topic = findViewById<EditText>(R.id.editTextTopic).text.toString()

        addNewDebate(topic)
    }

    fun backAction(v: View) {
        startHomeActivity()
    }

    private fun startHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun addNewDebate(topic: String) {
        val id = UUID.randomUUID().toString()
        val debate = Debate(id, topic, true)
        database.child("debates").child(id).setValue(debate)
    }
}