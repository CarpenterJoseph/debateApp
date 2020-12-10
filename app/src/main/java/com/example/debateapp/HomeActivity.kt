package com.example.debateapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.debateapp.adapters.DebateAdapter
import com.example.debateapp.interfaces.UpdateCollection
import com.example.debateapp.models.Debate
import com.example.debateapp.repositories.DebateRepository
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), UpdateCollection {

    private lateinit var debateList: MutableList<Debate>
    private lateinit var adapter: DebateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        updateUI()
    }

    private fun updateUI() {
        debateList = DebateRepository.getData()

        debate_recyclerview.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        adapter = DebateAdapter(
            debateList, resources, this
        )

        debate_recyclerview.adapter = adapter
    }

    override fun update(nr: Int) {
        TODO("Not yet implemented")
    }

    fun startProfileActivity(v: View) {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }

    fun startCreateDebateActivity(v: View) {
        val intent = Intent(this, CreateDebateActivity::class.java)
        startActivity(intent)
    }
}