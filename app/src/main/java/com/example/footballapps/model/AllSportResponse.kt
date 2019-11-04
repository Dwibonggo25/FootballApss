package com.example.footballapps.model

data class AllSportResponse(
    val sports: List<AllSport>
)

data class AllSport(
    val idSport: String,
    val strFormat: String,
    val strSport: String,
    val strSportDescription: String,
    val strSportThumb: String
)
