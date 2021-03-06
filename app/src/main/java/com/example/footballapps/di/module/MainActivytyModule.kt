package com.example.footballapps.di.module

import dagger.Provides
import com.example.footballapps.ui.activitymain.MainActivity
import dagger.Module


@Module
class MainActivityModule {

    @Provides
    internal fun provideMainView(mainActivity: MainActivity)= mainActivity

}