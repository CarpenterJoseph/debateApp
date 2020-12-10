package com.example.debateapp.adapters

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.debateapp.R
import com.example.debateapp.interfaces.UpdateCollection
import com.example.debateapp.models.Debate
import kotlinx.android.synthetic.main.debate_list_element.view.*

//This class is our custom adapter - this is where most of the work is done.
class DebateAdapter(
    var debateList: List<Debate>,
    var resources: Resources,
    var updateListener: UpdateCollection
) : RecyclerView.Adapter<DebateAdapter.ViewHolder>() {


    //The context refers to the ui parent so to speak
    private lateinit var context: Context

    //This is a set of the items we have in our collection
    private var favorites: MutableSet<String> = HashSet()

    //this method is returning the view for each item in the list
    //also something you must override
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.debate_list_element, parent, false)
        context = parent.context

        return ViewHolder(v)
    }

    //this method is binding the data on the list - notice that this
    //overrides the same method in the RecyclerView.Adapter that we are extending
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(debateList[position], context, resources, updateListener)
    }

    //this method is giving the size of the list - this MUST be implemented as this
    //also overrides something from the RecyclerView Class
    override fun getItemCount(): Int {
        return debateList.size
    }


    //the class is holding the actual UI elements - the .xml file to use for each element
    //comes from the R.layout.list_element from the onCreateViewHolder method
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(
            debate: Debate,
            context: Context,
            resources: Resources,
            updateListener: UpdateCollection
        ) {
            //This refers to id's from the .xml file.
            itemView.title.text = debate.title

            if (debate.canJoinAsDebater) itemView.joinAsDebater.visibility = View.VISIBLE
            else itemView.joinAsDebater.visibility = View.INVISIBLE
        }
    }
}


