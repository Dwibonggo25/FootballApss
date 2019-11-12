package com.example.footballapps.utils

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.footballapps.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

abstract class NetworkBoundResource <ResultType, RequestType>{

    private val result =  MutableLiveData <Resource<ResultType>>()

    suspend fun build(): NetworkBoundResource<ResultType, RequestType> {
        withContext(Dispatchers.Main) {
            result.value = Resource.Loading()
        }
        CoroutineScope(coroutineContext).launch {
            val dbResource= loadFromDb()
            if (shouldFetch(dbResource)){
                try {
                    fetchFromNetwork(dbResource)
                }catch (e: Exception){
                    setValue(Resource.Error("$e", loadFromDb()))
                }
            }
        }
        return this
    }

    private fun fetchFromNetwork(dbResult: ResultType): LiveData<Resource<ResultType>> = liveData (Dispatchers.IO){
        emit(Resource.Loading())

        val local = loadFromDb()
        val api =  ishouldFetch(local)
        emitSource(api)

    }

    @MainThread
    private fun setValue(newValue: Resource<ResultType>) {
        if (result.value != newValue) {
            result.value = newValue
        }
    }

    // Called to save the result of the API response into the database
    @WorkerThread
    protected abstract fun saveCallRsult(item: RequestType)

    // Called with the data in the database to decide whether to fetch
    // potentially updated data from the network.
    @MainThread
    protected abstract fun shouldFetch(data: ResultType?): Boolean

    // Called to get the cached data from the database.
    @MainThread
    protected abstract fun loadFromDb(): ResultType

    // Called to create the API call.
    @MainThread
    protected abstract fun createCall(): Resource<RequestType>

    // Called when the fetch fails. The child class may want to reset components
    // like rate limiter.
    protected open fun onFetchFailed() {}

    // Returns a LiveData object that represents the resource that's implemented
    // in the base class.
    fun asLiveData(): LiveData<ResultType> = liveData (Dispatchers.IO){

    }



}