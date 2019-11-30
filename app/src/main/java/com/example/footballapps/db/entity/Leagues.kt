package com.example.footballapps.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "leagues")
data class Leagues (

    @PrimaryKey
    @ColumnInfo (name = "id")
    val idLeague: String,

    @ColumnInfo (name = "str_league")
    val strLeague: String?,

    @ColumnInfo (name = "str_sport")
    val strSport: String?,

    @ColumnInfo (name = "str_league_alternate")
    val strLeagueAlternate: String?
)