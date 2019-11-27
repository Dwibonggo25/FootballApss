package com.example.footballapps.ui.matchinfo

import androidx.lifecycle.ViewModel
import com.example.footballapps.repository.HomeRepository
import com.example.footballapps.repository.ScoresRepository
import javax.inject.Inject

class MatchInfoViewmodel @Inject constructor(private var api: ScoresRepository): ViewModel() {

    val match = api.getPreviousMatch("4328")
}