package com.example.footballapps.ui.matchinfo

import com.example.footballapps.R
import com.example.footballapps.base.BaseFragment
import com.example.footballapps.databinding.FragmentMatchInfoBinding

class MatchInfoFragment : BaseFragment<FragmentMatchInfoBinding, MatchInfoViewmodel>() {

    override fun getLayoutResourceId(): Int = R.layout.fragment_match_info

    override fun getViewModelClass(): Class<MatchInfoViewmodel> = MatchInfoViewmodel::class.java

}
