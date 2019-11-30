package com.example.footballapps.di.module

import com.example.footballapps.AppDatabase
import com.example.footballapps.api.ApiService
import com.example.footballapps.db.dao.*
import com.example.footballapps.repository.HomeRepository
import com.example.footballapps.repository.LoginRepository
import com.example.footballapps.repository.ScoresRepository
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
    fun providesPreviousMatchDao (db: AppDatabase) = db.perviousMatchDao()

    @Provides
    @Singleton
    fun providesFavoritesDao (db: AppDatabase) = db.favoritesDao()

    @Provides
    @Singleton
    fun providesNextMatchDao (db: AppDatabase) = db.nextMatchDao()

    @Provides
    @Singleton
    fun providesLeaguesDao (db: AppDatabase) = db.leaguesDao()

    @Provides
    @Singleton
    fun providesLoginRepository (userDao: UserDao, apiService: ApiService): LoginRepository = LoginRepository (userDao, apiService)

    @Provides
    @Singleton
    fun providesHomeRepository (allSportsDao: AllSportsDao, apiService: ApiService, leaguesDao: LeaguesDao): HomeRepository= HomeRepository (allSportsDao, apiService, leaguesDao)

    @Provides
    @Singleton
    fun providesScoresRepository (apiService: ApiService, previousMatchDao: PreviousMatchDao, allSportsDao: AllSportsDao, favoritesDao: FavoritesDao, nextDao: NextMatchDao, leaguesDao: LeaguesDao): ScoresRepository= ScoresRepository (apiService, previousMatchDao, allSportsDao, favoritesDao, nextDao, leaguesDao)

}