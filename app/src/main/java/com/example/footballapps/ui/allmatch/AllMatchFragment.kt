package com.example.footballapps.ui.allmatch

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.footballapps.R
import com.example.footballapps.base.BaseFragment
import com.example.footballapps.databinding.FragmentAllMatchBinding
import com.example.footballapps.db.relation.NextMatchAndLeagues

class AllMatchFragment : BaseFragment<FragmentAllMatchBinding, AllMatchViewmodel>() {
    override fun getLayoutResourceId(): Int = R.layout.fragment_all_match

    override fun getViewModelClass(): Class<AllMatchViewmodel> = AllMatchViewmodel::class.java

    private lateinit var adapter: AllMatchRecyclerAdapter

    companion object {
        fun newInstance() = AllMatchFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.leagues.observe(this, Observer {
            refreshData(it)
        })

        initRecyclerView()
    }

    private fun refreshData(data: List<NextMatchAndLeagues>?) {
        adapter.refreshData(data!!)
    }

    private fun initRecyclerView() {
        adapter = AllMatchRecyclerAdapter(listOf())
        val layoutManager = LinearLayoutManager(activity)
        binding.rvList.layoutManager = layoutManager
        binding.rvList.adapter = adapter
    }
}
