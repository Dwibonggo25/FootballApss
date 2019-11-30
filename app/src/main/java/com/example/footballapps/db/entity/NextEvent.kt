package com.example.footballapps.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "next_match")
data class NextEvent(
    @PrimaryKey
    @ColumnInfo (name = "idEvent")
    val idEvent: String,
    @ColumnInfo (name = "idLeague")
    val idLeague: String?,
    @ColumnInfo (name = "dateEvent")
    val dateEvent: String?,
    @ColumnInfo (name = "dateEventLocal")
    val dateEventLocal: String?,
    @ColumnInfo (name = "idAwayTeam")
    val idAwayTeam: String?,
    @ColumnInfo (name = "idHomeTeam")
    val idHomeTeam: String?,
    @ColumnInfo (name = "idSoccerXML")
    val idSoccerXML: String?,
    @ColumnInfo (name = "intAwayScore")
    val intAwayScore: String?,
    @ColumnInfo (name = "intAwayShots")
    val intAwayShots: String?,
    @ColumnInfo (name = "intHomeScore")
    val intHomeScore: String?,
    @ColumnInfo (name = "intHomeShots")
    val intHomeShots: String?,
    @ColumnInfo (name = "intRound")
    val intRound: String?,
    @ColumnInfo (name = "intSpectators")
    val intSpectators: String?,
    @ColumnInfo (name = "strAwayFormation")
    val strAwayFormation: String?,
    @ColumnInfo (name = "strAwayTeam")
    val strAwayTeam: String?,
    @ColumnInfo (name = "strHomeTeam")
    val strHomeTeam: String?,
    @ColumnInfo (name = "strAwayGoalDetails")
    val strAwayGoalDetails: String?,
    @ColumnInfo (name = "strAwayLineupDefense")
    val strAwayLineupDefense: String?,
    @ColumnInfo (name = "strAwayLineupDefense1")
    val strAwayLineupForward: String?,
    @ColumnInfo (name = "strAwayLineupDefense2")
    val strAwayLineupGoalkeeper: String?,
    @ColumnInfo (name = "strAwayLineupMidfield")
    val strAwayLineupMidfield: String?,
    @ColumnInfo (name = "strAwayLineupSubstitutes")
    val strAwayLineupSubstitutes: String?,
    @ColumnInfo (name = "strAwayRedCards")
    val strAwayRedCards: String?,
    @ColumnInfo (name = "strAwayRedCards1")
    val strAwayYellowCards: String?,
    @ColumnInfo (name = "strBanner")
    val strBanner: String?,
    @ColumnInfo (name = "strCircuit")
    val strCircuit: String?,
    @ColumnInfo (name = "strCity")
    val strCity: String?,
    @ColumnInfo (name = "strCountry")
    val strCountry: String?,
    @ColumnInfo (name = "strDate")
    val strDate: String?,
    @ColumnInfo (name = "strDescription")
    val strDescriptionEN: String?,
    @ColumnInfo (name = "strEvent")
    val strEvent: String?,
    @ColumnInfo (name = "dateEvent1")
    val strEventAlternate: String?,
    @ColumnInfo (name = "dateEvent2")
    val strFanart: String?,
    @ColumnInfo (name = "dateEvent3")
    val strFilename: String?,
    @ColumnInfo (name = "strHomeFormation")
    val strHomeFormation: String?,
    @ColumnInfo (name = "strHomeGoalDetails")
    val strHomeGoalDetails: String?,
    @ColumnInfo (name = "strHomeLineupGoalkeeper2")
    val strHomeLineupDefense: String?,
    @ColumnInfo (name = "strHomeLineupGoalkeeper1")
    val strHomeLineupForward: String?,
    @ColumnInfo (name = "strHomeLineupGoalkeeper")
    val strHomeLineupGoalkeeper: String?,
    @ColumnInfo (name = "strHomeLineupMidfield")
    val strHomeLineupMidfield: String?,
    @ColumnInfo (name = "strHomeLineupSubstitutes")
    val strHomeLineupSubstitutes: String?,
    @ColumnInfo (name = "strHomeYellowCards1")
    val strHomeRedCards: String?,
    @ColumnInfo (name = "strHomeYellowCards")
    val strHomeYellowCards: String?,
    @ColumnInfo (name = "strLeague")
    val strLeague: String?,
    @ColumnInfo (name = "strLocked:")
    val strLocked: String?,
    @ColumnInfo (name = "strMap")
    val strMap: String?,
    @ColumnInfo (name = "strPoster")
    val strPoster: String?,
    @ColumnInfo (name = " strResult")
    val strResult: String?,
    @ColumnInfo (name = "strSeason")
    val strSeason: String?,
    @ColumnInfo (name = "strSport")
    val strSport: String?,
    @ColumnInfo (name = "strTVStation")
    val strTVStation: String?,
    @ColumnInfo (name = "strThumb")
    val strThumb: String?,
    @ColumnInfo (name = "strTime")
    val strTime: String?,
    @ColumnInfo (name = "strTimeLocal")
    val strTimeLocal: String?,
    @ColumnInfo (name = "strTweet1")
    val strTweet1: String?,
    @ColumnInfo (name = "strTweet2")
    val strTweet2: String?,
    @ColumnInfo (name = "strTweet3")
    val strTweet3: String?,
    @ColumnInfo (name = "strVideo")
    val strVideo: String?
)