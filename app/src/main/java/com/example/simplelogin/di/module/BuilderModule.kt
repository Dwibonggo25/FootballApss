package com.example.simplelogin.di.module

import com.example.simplelogin.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import android.app.Activity
import dagger.android.AndroidInjector
import dagger.android.ActivityKey
import dagger.multibindings.IntoMap
import dagger.Binds



@Module
abstract class BuilderModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun bindMainActivity(builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>

}