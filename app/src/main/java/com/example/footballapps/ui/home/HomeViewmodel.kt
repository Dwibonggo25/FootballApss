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

    val sport = api.getAllSports()

}