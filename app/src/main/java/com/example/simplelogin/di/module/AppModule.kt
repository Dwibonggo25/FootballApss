package com.example.simplelogin.di.module

import android.content.Context
import androidx.room.Room
import com.example.simplelogin.SimpleApp
import com.example.simplelogin.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule (){

    @Provides
    @Singleton
    fun provideContext(app: SimpleApp) : Context = app

    @Provides
    @Singleton
    fun providesApplication(app: SimpleApp) : SimpleApp = app

    @Provides
    @Singleton
    fun providesDatabase (app: SimpleApp) = Room.databaseBuilder(app, AppDatabase::class.java, "simpleapp.db").build()

}