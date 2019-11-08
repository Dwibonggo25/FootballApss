package com.example.footballapps.repository

import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.example.footballapps.api.ApiService
import com.example.footballapps.db.dao.AllSportsDao
import com.example.footballapps.db.entity.AllSportsLocal
import com.example.footballapps.model.AllSport
import com.example.footballapps.model.Result
import java.io.IOException
import javax.inject.Inject

class HomeRepository @Inject constructor(private val allStartsDao: AllSportsDao, private val api: ApiService) {

    suspend fun loadAllLeague () = api.fetchAllSports()
}
//emit(allStartsDao.fetchAllLeague())
//
//val sport = mutableListOf<AllSportsLocal>()
//val data = api.fetchAllSports()
//for (i in data.sports){
//    sport.add(AllSportsLocal(i.idSport, i.strSport, i.strFormat, i.strSportThumb, i.strSportDescription))
//}
//allStartsDao.insetInAllSports(sport)