package com.example.footballapps.ui.matchinfo

import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.footballapps.R
import com.example.footballapps.base.BaseFragment
import com.example.footballapps.databinding.FragmentMatchInfoBinding
import com.example.footballapps.db.entity.Favorites
import com.example.footballapps.db.entity.PreviousMatchLocal
import com.example.footballapps.vo.Result


class MatchInfoFragment : BaseFragment<FragmentMatchInfoBinding, MatchInfoViewmodel>(), PreviousMatchAdapter.ClickListener {

    override fun getLayoutResourceId(): Int = R.layout.fragment_match_info

    override fun getViewModelClass(): Class<MatchInfoViewmodel> = MatchInfoViewmodel::class.java

    lateinit var adapter: PreviousMatchAdapter

    companion object {
        fun newInstance() = MatchInfoFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        getPreviousMatch()
    }

    private fun initRecyclerView() {
        val itemDecor = DividerItemDecoration(context, HORIZONTAL)
        adapter = PreviousMatchAdapter(this)
        val layoutmanager = LinearLayoutManager(context)
        binding.rvPreviousMatch.layoutManager = layoutmanager
        binding.rvPreviousMatch.adapter = adapter
        binding.rvPreviousMatch.addItemDecoration(itemDecor)
    }

    private fun getPreviousMatch() {
        vm.match.observe(this, Observer {it ->
            when (it.status) {
                Result.Status.SUCCESS -> {
                    adapter.submitList(it.data)
                }
                Result.Status.ERROR -> {
                    Toast.makeText(activity, "Tidak ada internet", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun isFavoriteSelected(item: PreviousMatchLocal) {
        vm.insertInFavorites(item)
        initRecyclerView()
    }
}
