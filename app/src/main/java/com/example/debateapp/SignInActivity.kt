package com.example.debateapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.example.debateapp.models.Message
import com.example.debateapp.repositories.CurrentUser
import com.google.firebase.Timestamp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignInActivity : AppCompatActivity() {
    var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        db = FirebaseFirestore.getInstance();
    }

    fun signInAction(v: View) {
        val userName = findViewById<EditText>(R.id.editTextTopic).text.toString()
        val password: String = findViewById<EditText>(R.id.editTextPassword).text.toString()

        db.collection("users")
            .get()
            .addOnSuccessListener { snapshot ->
                for(doc in snapshot){
                    var docUserName = doc.data["username"] as String
                    var docPassWord = doc.data["password"] as String
                    var docDecsription = doc.data["description"] as String
                    if(docUserName == userName && docPassWord == password){
                        CurrentUser.updateUser(docUserName, docDecsription)
                        startHomeActivity()
                    }
                }
            }
    }

    fun signUpAction(v: View) {
        startSignUpActivity()
    }

    private fun startHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun startSignUpActivity() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }
}