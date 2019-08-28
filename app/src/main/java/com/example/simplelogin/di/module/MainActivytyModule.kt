package com.example.simplelogin.di.module

import dagger.Provides
import com.example.simplelogin.MainActivity
import dagger.Module


@Module
class MainActivityModule {

    @Provides
    internal fun provideMainView(mainActivity: MainActivity)= mainActivity

}