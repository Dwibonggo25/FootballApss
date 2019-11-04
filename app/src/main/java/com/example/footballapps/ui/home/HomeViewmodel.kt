package com.example.footballapps.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.footballapps.repository.HomeRepository
import com.example.footballapps.repository.LoginRepository
import javax.inject.Inject

class HomeViewmodel @Inject constructor(private var api: HomeRepository) : ViewModel() {

    val user = liveData {
        emit(api.fetchAllSports())
    }
}