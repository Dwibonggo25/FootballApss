package com.example.footballapps

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.footballapps.db.dao.*
import com.example.footballapps.db.entity.*


@Database(entities = [User::class, AllSportsLocal::class, PreviousMatchLocal::class, Favorites::class, NextEvent::class, Leagues::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun allSportsDao(): AllSportsDao

    abstract fun perviousMatchDao(): PreviousMatchDao

    abstract fun favoritesDao(): FavoritesDao

    abstract fun nextMatchDao(): NextMatchDao

    abstract fun leaguesDao(): LeaguesDao
}
