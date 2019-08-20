package com.example.simplelogin.di.module

import com.example.simplelogin.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesActivutyMain(): MainActivity
}