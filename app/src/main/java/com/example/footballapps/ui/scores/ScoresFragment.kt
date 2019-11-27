package com.example.footballapps.ui.scores

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.footballapps.R
import com.example.footballapps.base.BaseFragment
import com.example.footballapps.databinding.FragmentScoresBinding
import com.example.footballapps.ui.matchinfo.MatchInfoFragment
import com.example.footballapps.ui.nextmatch.NextMatchFragment

class ScoresFragment : BaseFragment<FragmentScoresBinding, ScoresViewmodel>() {

    override fun getLayoutResourceId(): Int = R.layout.fragment_scores

    override fun getViewModelClass(): Class<ScoresViewmodel> = ScoresViewmodel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        settingTabLayout()
        settingViewpager()

    }

    private fun settingTabLayout() {
        binding.tlInfoMatch.setupWithViewPager(binding.vpInfoMatch)
    }

    private fun settingViewpager() {
        val adapter = ViewpagerAdapter(childFragmentManager)
        adapter.addFragment(MatchInfoFragment(), "Match")
        adapter.addFragment(NextMatchFragment(), "Next Match")
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
