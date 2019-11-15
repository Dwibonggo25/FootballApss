package com.example.footballapps.api

import com.example.footballapps.model.AllSportResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET ("all_sports.php")
    suspend fun fetchAllSports () : AllSportResponse
}