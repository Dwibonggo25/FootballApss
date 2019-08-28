package com.example.simplelogin

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.simplelogin.db.User
import com.example.simplelogin.db.UserDao

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}