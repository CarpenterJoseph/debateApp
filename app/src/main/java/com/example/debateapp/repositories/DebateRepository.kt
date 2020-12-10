package com.example.debateapp.repositories

import com.example.debateapp.models.Debate

object DebateRepository {

    private var debates: MutableList<Debate> = mutableListOf()


    fun getData(): MutableList<Debate> {
        if (debates.size == 0)
            retrieveData()
        return debates
    }

    //just put mock data here - in reality it would be from a database
    private fun retrieveData() {
        debates.add(
            Debate(
                id = "1",
                topic = "Mining in Boundary Waters",
                canJoinAsDebater = true
            )
        )
        debates.add(
            Debate(
                id = "2",
                topic = "Covid-19 Restrictions",
                canJoinAsDebater = false
            )
        )
    }
}