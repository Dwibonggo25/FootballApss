package com.example.footballapps.ui.matchinfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.footballapps.R
import com.example.footballapps.databinding.RvMatchInfoBinding
import com.example.footballapps.db.entity.Favorites
import com.example.footballapps.db.entity.PreviousMatchLocal
import com.example.footballapps.ui.nextmatch.NextMatchAdapter

class PreviousMatchAdapter (val listener: ClickListener): ListAdapter<PreviousMatchLocal, PreviousMatchAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int) : ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvMatchInfoBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position), listener)

    class ViewHolder (private var binding: RvMatchInfoBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PreviousMatchLocal, listener: ClickListener) {
            binding.apply {

                list = item

                binding.imageView.setOnClickListener {
                    listener.isFavoriteSelected(item)
                }

                binding.clMatchInfo.setOnClickListener {
                    listener.isMatchClicked(item.idEvent)
                }
                binding.executePendingBindings()
            }
        }
    }

    interface ClickListener {
        fun isFavoriteSelected (item: PreviousMatchLocal)
        fun isMatchClicked(id: String)
    }
    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<PreviousMatchLocal>() {
            override fun areItemsTheSame(oldItem: PreviousMatchLocal, newItem: PreviousMatchLocal): Boolean {
                return oldItem.idLeague == newItem.idLeague
            }

            override fun areContentsTheSame(oldItem: PreviousMatchLocal, newItem: PreviousMatchLocal): Boolean {
                return oldItem == newItem
            }
        }
    }
}