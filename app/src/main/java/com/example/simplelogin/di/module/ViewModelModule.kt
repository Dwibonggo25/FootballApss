package com.example.simplelogin.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.simplelogin.ui.LoginViewModel
import com.example.simplelogin.di.ViewModelFactory
import com.example.simplelogin.di.ViewModelKey
import com.example.simplelogin.ui.splashscreen.SplashScreenViewmodel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory : ViewModelFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun providesLoginViewModel(viewModel : LoginViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashScreenViewmodel::class)
    internal abstract fun providesSplashScreenViewmodel(viewModel : SplashScreenViewmodel) : ViewModel

}