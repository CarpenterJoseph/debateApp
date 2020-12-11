package com.example.debateapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.debateapp.models.Debate
import com.example.debateapp.models.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*

class CreateDebateActivity : AppCompatActivity() {
    var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_debate)

        db = FirebaseFirestore.getInstance();
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

    private fun startDebatorActivity(debateID: String){
        val intent = Intent(this, DebatorActivity::class.java)
        intent.putExtra("DEBATE_ID", debateID)
        startActivity(intent)
    }

    private fun addNewDebate(topic: String) {
        var ref = db.collection("debates").document()
        var refID = ref.id
        val debate = Debate(refID, topic, true)
        ref.set(debate)
        startDebatorActivity(refID)
    }
}