package com.example.debateapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.debateapp.models.Message
import com.example.debateapp.repositories.CurrentUser
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class NewMessageActivity : AppCompatActivity() {
    var db = Firebase.firestore
    lateinit var id: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_message)
        db = FirebaseFirestore.getInstance();
        id = intent.getStringExtra("DEBATE_ID").toString()
    }

    fun sendMessage(v: View){
        var message = Message(CurrentUser.user.username.toString(), Timestamp.now(), findViewById<EditText>(R.id.editDescription).text.toString())
        db.collection("debates")
            .document(id)
            .collection("messages")
            .add(message)
    }

    fun backAction(v: View){
        startDebateActivity()
    }

    private fun startDebateActivity(){
        val intent = Intent(this, DebatorActivity::class.java)
        intent.putExtra("DEBATE_ID", id)
        startActivity(intent)
    }
}