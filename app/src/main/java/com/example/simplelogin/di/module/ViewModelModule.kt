package com.example.simplelogin.di.module

import androidx.lifecycle.ViewModel
import com.example.simplelogin.LoginViewModel
import com.example.simplelogin.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun providesLoginViewModel(viewModel : LoginViewModel) : ViewModel
}