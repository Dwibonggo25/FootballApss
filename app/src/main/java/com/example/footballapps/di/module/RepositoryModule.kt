package com.example.footballapps.di.module

import com.example.footballapps.AppDatabase
import com.example.footballapps.api.ApiService
import com.example.footballapps.db.dao.AllSportsDao
import com.example.footballapps.db.dao.UserDao
import com.example.footballapps.repository.HomeRepository
import com.example.footballapps.repository.LoginRepository
import com.example.footballapps.repository.NextMatchRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesUserDao (db: AppDatabase) = db.userDao()

    @Provides
    @Singleton
    fun providesAllSportsDao (db: AppDatabase) = db.allSportsDao()

    @Provides
    @Singleton
    fun providesLoginRepository (userDao: UserDao, apiService: ApiService): LoginRepository = LoginRepository (userDao, apiService)

    @Provides
    @Singleton
    fun providesHomeRepository (allSportsDao: AllSportsDao, apiService: ApiService): HomeRepository= HomeRepository (allSportsDao, apiService)

    @Provides
    @Singleton
    fun providesNextMatchRepository (allSportsDao: AllSportsDao, apiService: ApiService): NextMatchRepository= NextMatchRepository (allSportsDao, apiService)
}