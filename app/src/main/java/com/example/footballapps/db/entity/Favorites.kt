package com.example.footballapps.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class Favorites (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "id_events")
    val eventId: String?,
    @ColumnInfo(name = "status")
    val status: Int?
){
    constructor(): this(0,"",0)
}

