package com.example.footballapps.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.footballapps.repository.HomeRepository
import javax.inject.Inject

class HomeViewmodel @Inject constructor(private var api: HomeRepository) : ViewModel() {

//    val user = liveData {
//        emit(api.loadAllLeague())
//    }

    private val movieId = MutableLiveData<Long>()


    val sports = liveData {
        emit(api.getAllSports())
    }

    fun initData(movieId: Long) {
        this.movieId.value = 2
    }
}