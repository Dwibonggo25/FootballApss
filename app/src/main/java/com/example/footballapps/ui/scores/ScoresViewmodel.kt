package com.example.footballapps.ui.scores

import androidx.lifecycle.ViewModel
import com.example.footballapps.repository.HomeRepository
import com.example.footballapps.repository.ScoresRepository
import javax.inject.Inject

class ScoresViewmodel @Inject constructor(private val api: ScoresRepository) : ViewModel() {
    val sports = api.getAllSports()
}