package com.example.footballapps.ui.nextmatch

import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.footballapps.R
import com.example.footballapps.base.BaseFragment
import com.example.footballapps.databinding.FragmentNextMatchBinding
import com.example.footballapps.db.entity.NextEvent
import com.example.footballapps.vo.Result

class NextMatchFragment : BaseFragment<FragmentNextMatchBinding, NextMatchViewmodel>(), NextMatchAdapter.ClickListener {

    override fun getLayoutResourceId(): Int = R.layout.fragment_next_match

    override fun getViewModelClass(): Class<NextMatchViewmodel> = NextMatchViewmodel::class.java

    lateinit var adapter : NextMatchAdapter

    companion object {
        fun newInstance() = NextMatchFragment()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        initRecyclerview()
        fetchDataFromApi()
    }

    private fun fetchDataFromApi() {
        vm.data.observe(this, Observer { data->
            when (data.status) {
                Result.Status.SUCCESS ->{
                    adapter.submitList(data.data)
                }
                Result.Status.ERROR -> {
                    Toast.makeText(activity, "Eror", Toast.LENGTH_SHORT).show()
                }
                Result.Status.LOADING -> {

                }
            }
        })
    }

    private fun initRecyclerview() {
        val itemDecor = DividerItemDecoration(context, ClipDrawable.HORIZONTAL)
        adapter = NextMatchAdapter(this)
        val layoutManager = LinearLayoutManager (activity)
        binding.rvNextMatch.layoutManager = layoutManager
        binding.rvNextMatch.adapter= adapter
        binding.rvNextMatch.addItemDecoration(itemDecor)
    }

    override fun onNextMatchClick(match: NextEvent) {
        initRecyclerview()
    }
}
