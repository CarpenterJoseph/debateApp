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
                id = 1,
                title = "Mining in Boundary Waters",
                canJoinAsDebater = true
            )
        )
        debates.add(
            Debate(
                id = 2,
                title = "Covid-19 Restrictions",
                canJoinAsDebater = false
            )
        )
        debates.add(
            Debate(
                id = 2,
                title = "Covid-19 is a virus balsdkasldj alfkjhsd lkfjhsd lk fjhsd klfjhsdk l fjh slkdf jhslk df jhsa lkd f jhsalkdfjh skld fjh",
                canJoinAsDebater = false
            )
        )
        debates.add(
            Debate(
                id = 2,
                title = "Covid-19 Restrictions",
                canJoinAsDebater = false
            )
        )
        debates.add(
            Debate(
                id = 2,
                title = "Covid-19 Restrictions",
                canJoinAsDebater = false
            )
        )
        debates.add(
            Debate(
                id = 2,
                title = "Covid-19 Restrictions",
                canJoinAsDebater = false
            )
        )
        debates.add(
            Debate(
                id = 2,
                title = "Covid-19 Restrictions",
                canJoinAsDebater = false
            )
        )
        debates.add(
            Debate(
                id = 2,
                title = "Covid-19 Restrictions",
                canJoinAsDebater = false
            )
        )
        debates.add(
            Debate(
                id = 2,
                title = "Covid-19 Restrictions",
                canJoinAsDebater = false
            )
        )
    }
}