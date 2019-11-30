package com.example.footballapps.ui.allmatch

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.footballapps.db.relation.NextMatchAndLeagues
import com.example.footballapps.repository.ScoresRepository
import javax.inject.Inject

class AllMatchViewmodel @Inject constructor(val repository: ScoresRepository): ViewModel () {

    val leagues : LiveData<List<NextMatchAndLeagues>> = repository.fetchDataNextAndAll()
}