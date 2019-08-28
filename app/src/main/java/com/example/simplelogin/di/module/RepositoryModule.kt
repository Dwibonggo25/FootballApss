package com.example.simplelogin.di.module

import com.example.simplelogin.AppDatabase
import com.example.simplelogin.api.ApiService
import com.example.simplelogin.db.UserDao
import com.example.simplelogin.repository.LoginRepository
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
    fun providesLoginRepository (apiService: ApiService): LoginRepository = LoginRepository (apiService)


}