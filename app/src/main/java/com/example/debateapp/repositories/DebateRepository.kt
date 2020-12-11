package com.example.debateapp.repositories

import android.util.Log
import com.example.debateapp.HomeActivity
import com.example.debateapp.models.Debate
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

object DebateRepository {

     var debates: MutableList<Debate> = mutableListOf()


    fun getData(): MutableList<Debate> {
        if (debates.size == 0)
            retrieveData()
        return debates
    }

    //just put mock data here - in reality it would be from a database
    private fun retrieveData() {
        val db = FirebaseFirestore.getInstance()

        db.collection("debates")
            .addSnapshotListener { value, e ->
                if (e != null) {
                    Log.w("test", "Listen failed.", e)
                    return@addSnapshotListener
                }

                for (document in value!!) {
                    val debate = document.toObject(Debate::class.java)
                    debate.id = document.id
                    debates.add(debate)
                }
            }
    }
}