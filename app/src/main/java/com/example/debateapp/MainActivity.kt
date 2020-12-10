package com.example.debateapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO logic for seeing if user is signed in, if they are go to home, if not go to sign in
        var userSignedIn = false
        if (userSignedIn) {
            startHomeActivity()
        } else {
            startHomeActivity()
        }
    }

    private fun startHomeActivity() {
        intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun startSignInActivity() {
        intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }
}