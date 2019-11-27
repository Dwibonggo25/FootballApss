package com.example.footballapps.ui.matchinfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.footballapps.R
import com.example.footballapps.databinding.RvMatchInfoBinding
import com.example.footballapps.db.entity.PreviousMatchLocal
import com.example.footballapps.ui.nextmatch.NextMatchAdapter

class PreviousMatchAdapter (private val idEvents: String, val listener: ClickListener): ListAdapter<PreviousMatchLocal, PreviousMatchAdapter.ViewHolder>(DiffCallback) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position), idEvents, listener)

    override fun onCreateViewHolder(parent: ViewGroup, position: Int) : ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvMatchInfoBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    class ViewHolder (private var binding: RvMatchInfoBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PreviousMatchLocal, id: String, listener: ClickListener) {
            binding.apply {
                if (item.idEvent == id) {
                    binding.imageView.setImageResource(R.drawable.ic_favorite)
                }else {
                    binding.imageView.setImageResource(R.drawable.ic_not_favorite)
                }
                list = item

                binding.imageView.setOnClickListener {
                    listener.isFavoriteSelected(item)
                }

                binding.executePendingBindings()
            }
        }
    }

    interface ClickListener {
        fun isFavoriteSelected (item: PreviousMatchLocal)
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