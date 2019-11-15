package com.example.footballapps.model

import com.example.footballapps.db.entity.AllSportsLocal

data class AllSportResponse(
    val sports: List<AllSportsLocal>
)

