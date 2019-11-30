package com.example.footballapps.model


import com.example.footballapps.db.entity.PreviousMatchLocal

data class PreviousMatchResponse(
    val events: List<PreviousMatchLocal>
)

