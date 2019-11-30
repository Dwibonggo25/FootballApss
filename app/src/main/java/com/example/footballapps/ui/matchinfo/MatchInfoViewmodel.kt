package com.example.footballapps.ui.matchinfo

import androidx.lifecycle.*
import com.example.footballapps.db.entity.Favorites
import com.example.footballapps.db.entity.PreviousMatchLocal
import com.example.footballapps.db.relation.NextMatchAndLeagues
import com.example.footballapps.repository.HomeRepository
import com.example.footballapps.repository.ScoresRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MatchInfoViewmodel @Inject constructor(private var api: ScoresRepository): ViewModel() {

    val match = api.getPreviousMatch("4328")

    fun insertInFavorites (data: PreviousMatchLocal) = viewModelScope.launch {
        api.insertToFavorites(data.idEvent, 1)
    }

    val favorites : LiveData<List<Favorites>> = api.fetchDataFavorites()


}