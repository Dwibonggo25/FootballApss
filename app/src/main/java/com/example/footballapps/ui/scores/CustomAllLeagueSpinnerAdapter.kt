package com.example.footballapps.ui.scores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.fragment.app.FragmentActivity
import com.example.footballapps.databinding.CustomSpinnerFootballBinding
import com.example.footballapps.db.entity.AllSportsLocal

class CustomAllLeagueSpinnerAdapter (var context: FragmentActivity, var list: List<AllSportsLocal>): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val vh: ItemRowHolder

        if(convertView == null){
            val binding = CustomSpinnerFootballBinding.inflate(LayoutInflater.from(context), parent, false)
            vh = ItemRowHolder(binding)
            view = binding.root
            view.tag = vh
        }else {
            view = convertView
            vh = view.tag as ItemRowHolder
        }
        vh.bind(list[position].strSport)

        return view
    }

    class ItemRowHolder(val binding: CustomSpinnerFootballBinding) {

        fun bind (label: String){
            binding.tvSportsName.text = label
            binding.executePendingBindings()
        }
    }

    override fun getItem(p0: Int): Any? = null

    override fun getItemId(p0: Int): Long = 0

    override fun getCount(): Int = list.size

    fun refreshData(list: List<AllSportsLocal>) {
        this.list = list
        notifyDataSetChanged()
    }
}