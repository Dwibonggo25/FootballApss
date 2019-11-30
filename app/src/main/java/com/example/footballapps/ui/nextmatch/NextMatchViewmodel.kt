package com.example.footballapps.ui.nextmatch

import androidx.lifecycle.ViewModel
import com.example.footballapps.repository.ScoresRepository
import javax.inject.Inject

class NextMatchViewmodel @Inject constructor(private val api: ScoresRepository): ViewModel() {
    val data = api.fetchAllNextEvent("4328")
}