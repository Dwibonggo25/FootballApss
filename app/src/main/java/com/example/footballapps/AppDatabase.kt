package com.example.footballapps

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.footballapps.db.dao.AllSportsDao
import com.example.footballapps.db.dao.PreviousMatchDao
import com.example.footballapps.db.dao.UserDao
import com.example.footballapps.db.entity.AllSportsLocal
import com.example.footballapps.db.entity.PreviousMatchLocal
import com.example.footballapps.db.entity.User


@Database(entities = [User::class, AllSportsLocal::class, PreviousMatchLocal::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun allSportsDao(): AllSportsDao

    abstract fun perviousMatchDao(): PreviousMatchDao
}
