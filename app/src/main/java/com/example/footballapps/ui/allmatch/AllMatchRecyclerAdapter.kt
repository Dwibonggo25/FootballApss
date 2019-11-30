package com.example.footballapps.ui.allmatch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.footballapps.R
import com.example.footballapps.db.entity.Leagues
import com.example.footballapps.db.relation.NextMatchAndLeagues

class AllMatchRecyclerAdapter (var list: List<NextMatchAndLeagues>) : RecyclerView.Adapter <AllMatchRecyclerAdapter.ViewHolder>(){

    companion object{
        private const val TYPE_TITLE = 0
        private const val TYPE_DETAIL = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllMatchRecyclerAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType){
            TYPE_TITLE -> ViewHolderTitle (inflater.inflate(R.layout.rv_title_league, null))
            else -> ViewHolderDetail (inflater.inflate(R.layout.rv_next_match, null))
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        val type = when (position) {
            0 -> TYPE_TITLE
            else -> TYPE_DETAIL
        }

        return type
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_TITLE -> {
                val bind = holder as ViewHolderTitle
                bind.tvTitle.text = list.get(position).leagues!!.strLeague
            }
            else -> {
                val bind = holder as ViewHolderDetail
               // bind.tvHomeTeam.text = list.get(position).leagues!!.
            }
        }
    }

    open inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class ViewHolderTitle (itemView: View): ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
    }

    inner class ViewHolderDetail (itemView: View): ViewHolder(itemView) {
        val tvHomeTeam: TextView = itemView.findViewById(R.id.tvHomeTeam)
    }

    fun refreshData(list: List<NextMatchAndLeagues>) {
        this.list = list
        notifyDataSetChanged()
    }
}