package com.example.footballapps.utils

import android.util.Log
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.footballapps.vo.Result
import kotlinx.coroutines.*
import androidx.lifecycle.map
import kotlin.coroutines.coroutineContext

// ResultType: Type for the Resource data.
// RequestType: Type for the API response.

abstract class NetworkBoundResource<ResultType, RequestType> {

    private val result = MutableLiveData<Result<ResultType>>()

    private val supervisorJob = SupervisorJob()

    fun asLivedata(): LiveData<Result<ResultType>> = liveData (Dispatchers.IO) {

        emit(Result.loading(null))

        val dbSource = loadFromDb()
        val map = dbSource.map {Result.success(it) }

        emitSource(map!!)

        if (shouldFetch(map.value?.data)) {

//            setValue(Result.loading(map.value?.data))
            val apiResponse = createCall()

//            try {
//                apiResponse.data.let {
//                    saveCallResult(processResponse(it!!))
//                    setValue(Result.success(map.value?.data!!))
//                }
//            }catch (e: Exception){
//                Log.e("Message", "$e")
//                setValue(Result.success(map.value?.data!!))
//                setValue(Result.error("Message", map.value?.data))
//            }
            if (apiResponse.status == Result.Status.SUCCESS) {
                apiResponse.data.let {
                    saveCallResult(processResponse(it!!))
//                    setValue(Result.success(map.value?.data!!))
                }
            } else {
                Log.e("Message", "Tau ah")
                emit(Result.error("Message", null))
                emitSource(map)
            }
        }
    }

//    private suspend fun fetchFromLocal(dbSource: ResultType) {
//        Log.d(NetworkBoundResource::class.java.name, "Fetch data from network")
//        setValue(Result.loading(dbSource)) // Dispatch latest value quickly (UX purpose)
//        val apiResponse = createCall()
//        Log.e(NetworkBoundResource::class.java.name, "Data fetched from network")
//        saveCallResult(processResponse(apiResponse))
//        setValue(Result.success(dbSource))
//    }

    @MainThread
    private fun setValue(newValue: Result<ResultType>) {
        if (result.value != newValue) {
            result.postValue(newValue)
        }
    }

    @WorkerThread
    abstract fun processResponse(response: RequestType): ResultType

    // Called to save the result of the API response into the database
    @WorkerThread
    abstract suspend fun saveCallResult(item: ResultType)

    // Called with the data in the database to decide whether to fetch
    // potentially updated data from the network.
    @MainThread
    abstract fun shouldFetch(data: ResultType?): Boolean

    // Called to get the cached data from the database.
    @MainThread
    abstract fun loadFromDb(): LiveData <ResultType>

    // Called to create the API call.
    @MainThread
    abstract suspend fun createCall(): Result<RequestType>
}