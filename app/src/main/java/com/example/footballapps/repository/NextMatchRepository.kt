package com.example.footballapps.repository

import com.example.footballapps.api.ApiService
import com.example.footballapps.db.dao.AllSportsDao
import javax.inject.Inject

class NextMatchRepository @Inject constructor(private val allStartsDao: AllSportsDao, private val api: ApiService) {

    suspend fun fetchAllNextEvent (id: String) = api.fetchNextEventLeague(id)
}