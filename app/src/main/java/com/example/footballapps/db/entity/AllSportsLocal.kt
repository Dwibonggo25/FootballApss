package com.example.footballapps.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "all_sports")
data class AllSportsLocal (

    @PrimaryKey
    @ColumnInfo(name = "id_sport")
    val idSport: String,

    @ColumnInfo(name = "str_sport")
    val strSport: String,

    @ColumnInfo(name = "strFormat")
    val strFormat: String,

    @ColumnInfo(name = "str_sport_thumb")
    val strSportThumb: String,

    @ColumnInfo(name = "str_sport_description")
    val strSportDescription: String
)