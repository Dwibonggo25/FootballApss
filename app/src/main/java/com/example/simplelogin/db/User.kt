package com.example.simplelogin.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "user")
data class User (

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "id")
    val id : Int,

    @ColumnInfo (name = "username")
    val username: String,

    @ColumnInfo (name = "password")
    val password: String
){
    constructor(): this(0, "","")
}