package com.example.debateapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.debateapp.models.Debate
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DebatorActivity : AppCompatActivity() {
    var db = Firebase.firestore
    lateinit var id: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debator)

        db = FirebaseFirestore.getInstance();
        id = intent.getStringExtra("DEBATE_ID").toString()
        Log.d("test", id)
        retrieveDebateData(id)
    }

    fun backAction(v: View){
        startHomeActivity()
    }

    private fun startHomeActivity() {
        intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun retrieveDebateData(id: String) {
        val db = FirebaseFirestore.getInstance()
        db.collection("debates").document(id)
            .get()
            .addOnSuccessListener { result ->
                var currentDebate = result.toObject(Debate::class.java)
                if (currentDebate != null) {
                    findViewById<TextView>(R.id.debatorToolbarText).text = currentDebate.topic
                }
            }
    }
}