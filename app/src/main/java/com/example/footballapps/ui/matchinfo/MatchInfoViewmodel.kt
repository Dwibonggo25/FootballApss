package com.example.footballapps.ui.matchinfo

import androidx.lifecycle.ViewModel
import com.example.footballapps.repository.HomeRepository
import javax.inject.Inject

class MatchInfoViewmodel @Inject constructor(private var api: HomeRepository): ViewModel() {

}