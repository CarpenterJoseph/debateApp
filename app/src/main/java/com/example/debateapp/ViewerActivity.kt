package com.example.debateapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.debateapp.models.Debate
import com.example.debateapp.models.Message
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ViewerActivity : AppCompatActivity() {
    var db = Firebase.firestore
    lateinit var id: String
    var messages = mutableListOf<Message>()
    lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewer)
        id = intent.getStringExtra("DEBATE_ID").toString()
        db = FirebaseFirestore.getInstance();
        retrieveDebateData(id)
        linearLayout = findViewById(R.id.linearLayout)
    }

    fun updateMessages() {
        messages.forEach {
            var textView = TextView(this)
            textView.text = it.username + ": " + it.content
            linearLayout.addView(textView)
        }
    }

    fun backAction(v: View) {
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

        db.collection("debates")
            .document(id)
            .collection("messages")
            .orderBy("timestamp")
            .addSnapshotListener { snapshot, e ->
                for (doc in snapshot!!) {
                    val userName = doc.data["username"] as String
                    val timeStamp = doc.data["timestamp"] as Timestamp
                    val content = doc.data["content"].toString()
                    if (timeStamp != null && content != null) {
                        messages.add(Message(userName, timeStamp, content))
                    }
                }
                updateMessages()
            }
    }
}