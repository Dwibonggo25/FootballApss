package com.example.footballapps.model


import com.example.footballapps.db.entity.PreviousMatchLocal
import com.google.gson.annotations.SerializedName

data class PreviousMatchResponse(
    @SerializedName("events")
    val events: List<PreviousMatchLocal>
)

