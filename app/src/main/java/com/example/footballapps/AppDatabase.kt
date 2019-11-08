package com.example.footballapps

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.footballapps.db.dao.AllSportsDao
import com.example.footballapps.db.entity.User
import com.example.footballapps.db.dao.UserDao
import com.example.footballapps.db.entity.AllSportsLocal

@Database(entities = [User::class, AllSportsLocal::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun allSportsDao(): AllSportsDao
}