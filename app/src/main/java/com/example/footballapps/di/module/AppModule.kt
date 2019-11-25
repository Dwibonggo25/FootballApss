package com.example.footballapps.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.footballapps.SimpleApp
import com.example.footballapps.AppDatabase
import com.example.footballapps.MIGRATION_1_2
import com.example.footballapps.api.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(subcomponents =  [MainActivityComponent::class])
class AppModule{

    @Provides
    @Singleton
    fun provideContext(app: SimpleApp) : Context = app

    @Provides
    @Singleton
    fun providesApplication(app: SimpleApp) : Application = app

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun providesDatabase (context: Context) = Room.databaseBuilder(context, AppDatabase::class.java, "simpleapp.db").addMigrations(
        MIGRATION_1_2).fallbackToDestructiveMigration().build()

}

