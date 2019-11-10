package com.example.footballapps.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.example.footballapps.NetworkBoundResource
import com.example.footballapps.Resource
import com.example.footballapps.api.ApiService
import com.example.footballapps.db.dao.AllSportsDao
import com.example.footballapps.db.entity.AllSportsLocal
import com.example.footballapps.model.AllSport
import com.example.footballapps.model.AllSportResponse
import com.example.footballapps.model.Result
import java.io.IOException
import javax.inject.Inject

class HomeRepository @Inject constructor(private val allStartsDao: AllSportsDao, private val api: ApiService) {

    suspend fun loadAllLeague () = api.fetchAllSports()

    fun loadLeague () = liveData {
        emitSource(allStartsDao.fetchAllLeague())
    }

    fun getAllSports () : LiveData<kotlin.Result<AllSportsLocal> > {
        return object : NetworkBoundResource <List<AllSportsLocal>, AllSportResponse>(){
            override fun saveCallRsult(item: AllSportResponse) {
                allStartsDao.insetInAllSports(item)
            }

            override fun shouldFetch(data: List<AllSportsLocal>?): Boolean = true

            override fun loadFromDb(): LiveData<List<AllSportsLocal>> {
                return allStartsDao.fetchAllLeague()
            }

            override fun createCall(): Resource<AllSportResponse> {
                return Resource(api.fetchAllSports())
            }

        }
    }.asLiveData()
}
//emit(allStartsDao.fetchAllLeague())
//
//val sport = mutableListOf<AllSportsLocal>()
//val data = api.fetchAllSports()
//for (i in data.sports){
//    sport.add(AllSportsLocal(i.idSport, i.strSport, i.strFormat, i.strSportThumb, i.strSportDescription))
//}
//allStartsDao.insetInAllSports(sport)