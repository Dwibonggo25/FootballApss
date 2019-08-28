package com.example.simplelogin.di.module

import android.app.Activity
import com.example.simplelogin.MainActivity
import com.example.simplelogin.ui.LoginFragment
import com.example.simplelogin.ui.splashscreen.SplashScreenFragment
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributesLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributesSplashScreenFragment(): SplashScreenFragment
}