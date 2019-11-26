package com.example.footballapps.ui.nextmatch

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.footballapps.R
import com.example.footballapps.base.BaseFragment
import com.example.footballapps.databinding.FragmentNextMatchBinding
import com.example.footballapps.model.NextEvent

class NextMatchFragment : BaseFragment<FragmentNextMatchBinding, NextMatchViewmodel>(), NextMatchAdapter.ClickListener {

    private var adapter = NextMatchAdapter(this)

    override fun getLayoutResourceId(): Int = R.layout.fragment_next_match

    override fun getViewModelClass(): Class<NextMatchViewmodel> = NextMatchViewmodel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerview()
    }

    private fun initRecyclerview() {
        val layoutManager = LinearLayoutManager (activity)
        binding.rvNextMatch.layoutManager = layoutManager
        binding.rvNextMatch.adapter= adapter
    }

    override fun onNextMatchClick(match: NextEvent) {

    }
}
