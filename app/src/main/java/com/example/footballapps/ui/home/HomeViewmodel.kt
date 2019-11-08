package com.example.footballapps.ui.home

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.example.footballapps.db.entity.AllSportsLocal
import com.example.footballapps.model.AllSport
import com.example.footballapps.repository.HomeRepository
import com.example.footballapps.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException
import javax.inject.Inject

class HomeViewmodel @Inject constructor(private var api: HomeRepository) : ViewModel() {

//    val user = liveData {
//        emit(api.loadAllLeague())
//    }

    private val userId : LiveData<AllSport> = MutableLiveData ()


    var user = liveData (Dispatchers.IO) {
        emit(api.loadAllLeague())
    }
}