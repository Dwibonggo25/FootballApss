package com.example.footballapps.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.example.footballapps.db.entity.AllSportsLocal
import com.example.footballapps.repository.HomeRepository
import com.example.footballapps.vo.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeViewmodel @Inject constructor(private val api: HomeRepository) : ViewModel() {

    private val movieId = MutableLiveData<Long>()

    private val _users = MediatorLiveData<Result<List<AllSportsLocal>>>()

    val users: LiveData<Result<List<AllSportsLocal>>> get() = _users

    private var usersSource: LiveData<Result<List<AllSportsLocal>>> = MutableLiveData()


    val sport = api.getAllSports()


    fun initData(movieId: Long) {
        this.movieId.value = 2
    }
}