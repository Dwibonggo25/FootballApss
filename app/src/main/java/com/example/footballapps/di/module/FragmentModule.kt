package com.example.footballapps.di.module

import com.example.footballapps.ui.home.HomeFragment
import com.example.footballapps.ui.login.LoginFragment
import com.example.footballapps.ui.splashscreen.SplashScreenFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributesLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributesSplashScreenFragment(): SplashScreenFragment

    @ContributesAndroidInjector
    abstract fun contributesSplashHomeFragment(): HomeFragment
}