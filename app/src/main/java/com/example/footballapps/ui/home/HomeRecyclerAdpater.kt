package com.example.footballapps.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.footballapps.R
import com.example.footballapps.db.entity.AllSportsLocal

class HomeRecyclerAdpater (var league : List<AllSportsLocal> , val context: Context) : PagerAdapter() {

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun getCount(): Int= league.size

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        val view = obj as View
        container.removeView(view)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_item_all_league, container, false)
        val imageView = view.findViewById<ImageView>(R.id.ivSports)

        Glide.with(context)
            .load(league[position].strSportThumb)
            .into(imageView)

        container.addView(view, 0)
        return view
    }

    fun refresh (league: List<AllSportsLocal>){
        this.league = league
        notifyDataSetChanged()
    }

}