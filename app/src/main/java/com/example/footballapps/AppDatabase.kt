package com.example.footballapps

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.footballapps.db.User
import com.example.footballapps.db.UserDao

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}