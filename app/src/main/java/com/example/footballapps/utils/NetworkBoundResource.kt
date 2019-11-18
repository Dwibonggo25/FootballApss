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

    fun asLivedata(): LiveData<Result<ResultType>> = liveData (Dispatchers.IO){

        emit(Result.loading(null))

        val dbSource = loadFromDb()
        val map = dbSource.map{Result.success(it)}

        emitSource(map!!)

        if (shouldFetch(map.value?.data)){
                try {
                    fetchFromNetwork(map.value?.data!!)
                }catch (e: Exception){
                    Log.e("NetworkBoundResource", "An error happened: $e")
                    setValue(Result.error("$e", map.value?.data))
                }
            }else {
                Log.d(NetworkBoundResource::class.java.name, "Return data from local database")
                setValue(Result.success(map.value?.data!!))
            }

    }
//    suspend fun build(): NetworkBoundResource<ResultType, RequestType> = liveData{
//
//        emit( result.value = Result.loading(null))
//
//        withContext(Dispatchers.Main) {
//            result.value = Result.loading(null)
//        }
//        CoroutineScope(coroutineContext).launch (supervisorJob) {
//            val dbResource = loadFromDb()
//            if (shouldFetch(dbResource)){
//                try {
//                    fetchFromNetwork(dbResource)
//                }catch (e: Exception){
//                    Log.e("NetworkBoundResource", "An error happened: $e")
//                    setValue(Result.error("$e", loadFromDb()))
//                }
//            }else {
//                Log.d(NetworkBoundResource::class.java.name, "Return data from local database")
//                setValue(Result.success(dbResource))
//            }
//        }
//        return this
//    }

    private suspend fun fetchFromNetwork(dbSource: ResultType) {
        Log.d(NetworkBoundResource::class.java.name, "Fetch data from network")
        setValue(Result.loading(dbSource)) // Dispatch latest value quickly (UX purpose)
        val apiResponse = createCall()
        Log.e(NetworkBoundResource::class.java.name, "Data fetched from network")
        saveCallResult(processResponse(apiResponse))
        setValue(Result.success(dbSource))
    }

    @MainThread
    private fun setValue(newValue: Result<ResultType>) {
        if (result.value != newValue) {
            result.postValue(newValue)
        }
    }

    @WorkerThread
    protected abstract fun processResponse(response: RequestType): ResultType

    // Called to save the result of the API response into the database
    @WorkerThread
    protected abstract suspend fun saveCallResult(item: ResultType)

    // Called with the data in the database to decide whether to fetch
    // potentially updated data from the network.
    @MainThread
    protected abstract fun shouldFetch(data: ResultType?): Boolean

    // Called to get the cached data from the database.
    @MainThread
    abstract fun loadFromDb(): LiveData <ResultType>

    // Called to create the API call.
    @MainThread
    protected abstract suspend fun createCall(): RequestType

}