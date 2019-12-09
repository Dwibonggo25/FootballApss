package com.example.footballapps.ui.detailmatch

import androidx.fragment.app.Fragment
import com.example.footballapps.R
import com.example.footballapps.base.BaseFragment
import com.example.footballapps.databinding.FragmentDetailMatchBinding

class DetailMatchFragment : BaseFragment<FragmentDetailMatchBinding, DetailMatchViewmodel>() {

    override fun getLayoutResourceId(): Int = R.layout.fragment_detail_match

    override fun getViewModelClass(): Class<DetailMatchViewmodel> = DetailMatchViewmodel::class.java

}
