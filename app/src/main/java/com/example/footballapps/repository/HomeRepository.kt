package com.example.footballapps.repository

import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.example.footballapps.api.ApiService
import com.example.footballapps.db.UserDao
import java.io.IOException
import javax.inject.Inject

class HomeRepository @Inject constructor(private val userDao: UserDao, private val api: ApiService) {

    fun fetchAllSports() = liveData {
        val disposable = emitSource(
            userDao.fetchAllLeague().map{

            }
        )

        try {
            val data = api.fetchAllSports()

            disposable.dispose()

            //Save in local

            emitSource(
                userDao.fetchAllLeague().map {

                }
            )
        }catch (exection: IOException){
            emitSource(
                userDao.fetchAllLeague().map {

                }
            )
        }
    }
}
