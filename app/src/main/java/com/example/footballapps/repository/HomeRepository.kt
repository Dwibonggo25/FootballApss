package com.example.footballapps.repository

import androidx.lifecycle.LiveData
import com.example.footballapps.utils.NetworkBoundResource
import com.example.footballapps.api.ApiService
import com.example.footballapps.db.dao.AllSportsDao
import com.example.footballapps.db.entity.AllSportsLocal
import com.example.footballapps.model.AllSportResponse
import com.example.footballapps.vo.Result
import retrofit2.Response
import javax.inject.Inject

class HomeRepository @Inject constructor(private val allStartsDao: AllSportsDao, private val api: ApiService) {

    suspend fun getAllSports () : LiveData<Result<List<AllSportsLocal>?>> {
        return object : NetworkBoundResource <List<AllSportsLocal>, AllSportResponse >(){
            override fun processResponse(response: AllSportResponse): List<AllSportsLocal> = response.sports

            override suspend fun saveCallResult(item: List<AllSportsLocal>) {
                allStartsDao.insetInAllSports(item)
            }

            override fun shouldFetch(data: List<AllSportsLocal>?): Boolean = data ==null || data.isEmpty()

            override suspend fun loadFromDb(): List<AllSportsLocal> {
               return allStartsDao.fetchAllLeague()
            }

            override suspend fun createCall(): AllSportResponse {
                return api.fetchAllSports()
            }

        }.build().asLivedata()
    }

    suspend fun <T> getApiResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()

                if (body != null) {
                    return Result.success(body)
                }
            }
            return error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }
}
//emit(allStartsDao.fetchAllLeague())
//
//val sport = mutableListOf<AllSportsLocal>()
//val data = api.fetchAllSports()
//for (i in data.sports){
//    sport.add(AllSportsLocal(i.idSport, i.strSport, i.strFormat, i.strSportThumb, i.strSportDescription))
//}
//allStartsDao.insetInAllSports(sport)