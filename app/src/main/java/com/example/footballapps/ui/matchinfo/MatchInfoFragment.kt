package com.example.footballapps.ui.matchinfo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.footballapps.R
import com.example.footballapps.base.BaseFragment
import com.example.footballapps.databinding.FragmentMatchInfoBinding
import com.example.footballapps.vo.Result

class MatchInfoFragment : BaseFragment<FragmentMatchInfoBinding, MatchInfoViewmodel>() {

    override fun getLayoutResourceId(): Int = R.layout.fragment_match_info

    override fun getViewModelClass(): Class<MatchInfoViewmodel> = MatchInfoViewmodel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getPreviousMatch()
    }

    private fun getPreviousMatch() {
        vm.match.observe(this, Observer {it ->
            when (it.status) {
                Result.Status.SUCCESS -> {
                    Toast.makeText(activity, "Succes", Toast.LENGTH_SHORT).show()
                }
                Result.Status.ERROR -> {
                    Toast.makeText(activity, "Gagal", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}
