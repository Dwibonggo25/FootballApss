package com.example.footballapps.ui.scores

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.footballapps.R
import com.example.footballapps.base.BaseFragment
import com.example.footballapps.databinding.FragmentScoresBinding

class ScoresFragment : BaseFragment <FragmentScoresBinding, ScoresViewmodel>() {

    override fun getLayoutResourceId(): Int = R.layout.fragment_scores

    override fun getViewModelClass(): Class<ScoresViewmodel> = ScoresViewmodel::class.java

}
