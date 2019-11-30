package com.example.footballapps.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment <B: ViewDataBinding, V: ViewModel> : Fragment() {

    @Inject
    lateinit var viewModelVictory: ViewModelProvider.Factory

    private lateinit var mViewmodel: V
    private lateinit var mDatabinding: B

    val binding: B get() = mDatabinding
    val vm: V get() = mViewmodel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mViewmodel = ViewModelProviders.of(this, viewModelVictory).get(getViewModelClass())
        mDatabinding = DataBindingUtil.inflate(inflater, getLayoutResourceId(), container,false)
        mDatabinding.lifecycleOwner = this
        mDatabinding.executePendingBindings()
        return mDatabinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(BR.vm, vm)
        binding.setVariable(BR.fragment, this)
    }

    @LayoutRes
    abstract fun getLayoutResourceId(): Int

    abstract fun getViewModelClass(): Class<V>

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

}