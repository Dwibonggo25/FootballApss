package com.example.footballapps.ui.favorite

import androidx.fragment.app.Fragment
import com.example.footballapps.R
import com.example.footballapps.base.BaseFragment
import com.example.footballapps.databinding.FragmentFavoriteBinding

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding, FavoriteViewmodel>() {
    override fun getLayoutResourceId(): Int = R.layout.fragment_favorite

    override fun getViewModelClass(): Class<FavoriteViewmodel> = FavoriteViewmodel::class.java

}
