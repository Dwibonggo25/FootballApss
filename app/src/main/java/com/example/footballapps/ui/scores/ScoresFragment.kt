package com.example.footballapps.ui.scores

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.footballapps.R
import com.example.footballapps.base.BaseFragment
import com.example.footballapps.databinding.FragmentScoresBinding
import com.example.footballapps.db.entity.AllSportsLocal
import com.example.footballapps.ui.allmatch.AllMatchFragment
import com.example.footballapps.ui.matchinfo.MatchInfoFragment
import com.example.footballapps.ui.nextmatch.NextMatchFragment
import com.example.footballapps.vo.Result
import com.google.android.material.tabs.TabLayoutMediator

class ScoresFragment : BaseFragment<FragmentScoresBinding, ScoresViewmodel>() {

    private lateinit var spinnerAdapter: CustomAllLeagueSpinnerAdapter

    private lateinit var spinner: Spinner

    override fun getLayoutResourceId(): Int = R.layout.fragment_scores

    override fun getViewModelClass(): Class<ScoresViewmodel> = ScoresViewmodel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        settingViewpager()
        settingTabLayout()

        spinner = binding.spinner

        vm.sports.observe(this, Observer {
            when(it.status){
                Result.Status.SUCCESS-> {
                    initSpinnerSports(it.data!!)
                }
                Result.Status.ERROR -> {
                    Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun initSpinnerSports(data: List<AllSportsLocal>) {

        spinnerAdapter = CustomAllLeagueSpinnerAdapter(activity!!, data)
        spinner.adapter = spinnerAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }
    }

    private fun settingTabLayout() {
        TabLayoutMediator(binding.tlInfoMatch, binding.vpInfoMatch) { tab, position ->
            when(position){
                0 -> {
                    tab.setText("Match info")
                }
                1 -> {
                    tab.setText("Next Match")
                }
                else -> {
                    tab.setText("All Match")
                }
            }
        }.attach()
    }

    private fun settingViewpager() {
        val adapter = ViewpagerAdapter(this)
        binding.vpInfoMatch.adapter = adapter
    }

    class ViewpagerAdapter (fragmentManager: Fragment) : FragmentStateAdapter(fragmentManager) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 ->{
                    MatchInfoFragment.newInstance()
                }
                1 ->{
                    NextMatchFragment.newInstance()
                }else -> {
                    AllMatchFragment.newInstance()
                }
            }
        }
    }

}
