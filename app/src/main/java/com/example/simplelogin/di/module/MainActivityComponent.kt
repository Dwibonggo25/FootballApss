package com.example.simplelogin.di.module

import com.example.simplelogin.MainActivity
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.Subcomponent



@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}