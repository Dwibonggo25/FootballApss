package com.example.footballapps.db.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.footballapps.db.entity.Leagues
import com.example.footballapps.db.entity.NextEvent

data class NextMatchAndLeagues (

    @Embedded
    val leagues: Leagues? = null,

    @Relation(
        parentColumn = "id",
        entityColumn = "idLeague",
        entity = NextEvent::class
    )

    var nextEvent: List<NextEvent> = emptyList()

)