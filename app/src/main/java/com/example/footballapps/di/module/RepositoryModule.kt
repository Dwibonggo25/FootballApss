package com.example.footballapps.di.module

import com.example.footballapps.AppDatabase
import com.example.footballapps.api.ApiService
import com.example.footballapps.db.UserDao
import com.example.footballapps.repository.LoginRepository
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
    fun providesLoginRepository (userDao: UserDao, apiService: ApiService): LoginRepository = LoginRepository (userDao, apiService)


}