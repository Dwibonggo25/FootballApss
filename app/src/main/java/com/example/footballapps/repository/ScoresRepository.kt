package com.example.footballapps.repository

import androidx.lifecycle.LiveData
import com.example.footballapps.api.ApiService
import com.example.footballapps.base.BaseRepository
import com.example.footballapps.db.dao.AllSportsDao
import com.example.footballapps.db.dao.FavoritesDao
import com.example.footballapps.db.dao.PreviousMatchDao
import com.example.footballapps.db.entity.AllSportsLocal
import com.example.footballapps.db.entity.Favorites
import com.example.footballapps.db.entity.PreviousMatchLocal
import com.example.footballapps.model.AllSportResponse
import com.example.footballapps.model.PreviousMatchResponse
import com.example.footballapps.utils.NetworkBoundResource
import com.example.footballapps.vo.Result
import javax.inject.Inject

class ScoresRepository @Inject constructor(val api: ApiService, val dao: PreviousMatchDao, val allSports: AllSportsDao, val favorites: FavoritesDao): BaseRepository() {

    fun getPreviousMatch (idLeague: String) : LiveData <Result<List<PreviousMatchLocal>>>{
        return object : NetworkBoundResource <List<PreviousMatchLocal>, PreviousMatchResponse>(){
            override fun processResponse(response: PreviousMatchResponse): List<PreviousMatchLocal> = response.events

            override suspend fun saveCallResult(item: List<PreviousMatchLocal>) {
                dao.inserPreviousMatch(item)
            }

            override fun shouldFetch(data: List<PreviousMatchLocal>?): Boolean = data == null || data.isEmpty()

            override fun loadFromDb(): LiveData<List<PreviousMatchLocal>> = dao.selectAllPreviousMatch()

            override suspend fun createCall(): Result<PreviousMatchResponse> {
                return getApiResult {api.fetchPreviousMatch(idLeague)}
            }
        }.asLivedata()
    }

    fun getAllSports () : LiveData<Result<List<AllSportsLocal>>> {
        return object : NetworkBoundResource <List<AllSportsLocal>, AllSportResponse>(){

            override fun processResponse(response: AllSportResponse): List<AllSportsLocal> = response.sports

            override suspend fun saveCallResult(item: List<AllSportsLocal>) {
               allSports.insetInAllSports(item)
            }

            override fun shouldFetch(data: List<AllSportsLocal>?): Boolean = data ==null || data.isEmpty()

            override fun loadFromDb(): LiveData<List<AllSportsLocal>> = allSports.fetchAllLeague()

            override suspend fun createCall(): Result<AllSportResponse> {
                return getApiResult{ api.fetchAllSports()}
            }
        }.asLivedata()
    }

    suspend fun insertToFavorites (idEvents: String, status: Int) = favorites.insertInfavorites(Favorites(0, idEvents, status))

    suspend fun fetchDataFavorites () : LiveData<List<Favorites>> = favorites.selectAllFavorites()
}