package com.example.footballapps.ui.nextmatch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.footballapps.databinding.RvNextMatchBinding
import com.example.footballapps.model.NextEvent

class NextMatchAdapter (private val listener: ClickListener): ListAdapter<NextEvent, NextMatchAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextMatchAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvNextMatchBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NextMatchAdapter.ViewHolder, position: Int) = holder.bind(getItem(position), listener)

    class ViewHolder(private val binding: RvNextMatchBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind (nextEvent: NextEvent, listener: ClickListener) {

            binding.tvHomeTeam.setText(nextEvent.strHomeTeam)
            binding.tvAwayTeam.setText(nextEvent.strAwayTeam)

            binding.imageView.setOnClickListener {
                listener.onNextMatchClick(nextEvent)
            }
            binding.executePendingBindings()
        }
    }

    interface ClickListener{
        fun onNextMatchClick(match: NextEvent)
    }

    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<NextEvent>() {
            override fun areItemsTheSame(oldItem: NextEvent, newItem: NextEvent): Boolean {
                return oldItem.idEvent == newItem.idEvent
            }

            override fun areContentsTheSame(oldItem: NextEvent, newItem: NextEvent): Boolean {
                return oldItem == newItem
            }

        }
    }
}