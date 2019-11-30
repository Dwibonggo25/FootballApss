package com.example.footballapps.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapps.db.entity.Leagues
import com.example.footballapps.repository.HomeRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewmodel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    val sport = repository.getAllSports()

    fun insertLeague(data: List <Leagues>) = viewModelScope.launch{
        repository.insertLeagues(data)
    }
}