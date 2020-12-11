package com.example.debateapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.debateapp.models.User
import com.example.debateapp.repositories.CurrentUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
    var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        db = FirebaseFirestore.getInstance();
    }

    fun backAction(v: View) {
        startSignInActivity()
    }

    private fun startSignInActivity(){
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }

    fun signUpAction(v: View) {
        val userName = findViewById<EditText>(R.id.editTextTopic).text.toString()
        val password: String = findViewById<EditText>(R.id.editTextPassword).text.toString()
        val confirmPassword = findViewById<EditText>(R.id.editTextConfirmPassword).text.toString()

        var userNameExists = false

        db.collection("users")
            .get()
            .addOnSuccessListener { snapshot ->
                for(doc in snapshot){
                    var docUserName = doc.data["username"] as String
                    if(docUserName == userName){
                        userNameExists = true
                    }
                }
                if(password == confirmPassword){
                    if(!userNameExists){
                        addNewUser(userName, password)
                    } else {
                        Toast.makeText(this, "Username already exists!", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun addNewUser(userName: String, password: String?) {
        var user = User(userName, password, "")
        db.collection("users").add(user)
        Toast.makeText(this, "Account Created", Toast.LENGTH_LONG).show()
        startSignInActivity()
    }
}