package com.example.footballapps.model

import com.example.footballapps.db.entity.NextEvent


data class NextMatchResponse(
    val events: List<NextEvent>
)
