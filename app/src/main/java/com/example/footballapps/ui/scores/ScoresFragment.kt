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
import com.example.footballapps.R
import com.example.footballapps.base.BaseFragment
import com.example.footballapps.databinding.FragmentScoresBinding
import com.example.footballapps.db.entity.AllSportsLocal
import com.example.footballapps.ui.matchinfo.MatchInfoFragment
import com.example.footballapps.ui.nextmatch.NextMatchFragment
import com.example.footballapps.vo.Result

class ScoresFragment : BaseFragment<FragmentScoresBinding, ScoresViewmodel>() {

    private lateinit var spinnerAdapter: CustomAllLeagueSpinnerAdapter

    private lateinit var spinner: Spinner

    override fun getLayoutResourceId(): Int = R.layout.fragment_scores

    override fun getViewModelClass(): Class<ScoresViewmodel> = ScoresViewmodel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        settingTabLayout()
        settingViewpager()

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
        binding.tlInfoMatch.setupWithViewPager(binding.vpInfoMatch)
    }

    private fun settingViewpager() {
        val adapter = ViewpagerAdapter(childFragmentManager)
        adapter.addFragment(MatchInfoFragment(), "Match")
        adapter.addFragment(NextMatchFragment(), "Next Match")
        adapter.addFragment(NextMatchFragment(), "All Info Match")
        binding.vpInfoMatch.adapter = adapter
    }

    class ViewpagerAdapter constructor(val fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

        val fragmentList = mutableListOf<Fragment>()
        val fragmentTitle = mutableListOf<String>()

        override fun getItem(position: Int): Fragment = fragmentList[position]
        override fun getCount(): Int = fragmentList.size
        override fun getPageTitle(position: Int) = fragmentTitle[position]

        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            fragmentTitle.add(title)
        }

    }

}
