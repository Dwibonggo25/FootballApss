package com.example.footballapps.api

import com.example.footballapps.model.AllSportResponse
import com.example.footballapps.model.NextMatchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("all_sports.php")
    suspend fun fetchAllSports(): Response<AllSportResponse>

    @GET ("eventsnextleague.php")
    suspend fun fetchNextEventLeague (@Query("id") id: String) : NextMatchResponse
}