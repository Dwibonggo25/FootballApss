package com.example.footballapps.ui.listsports

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.footballapps.repository.HomeRepository
import javax.inject.Inject

class ListSportsViewModel @Inject constructor(private var repository: HomeRepository) : ViewModel() {

    val data = MutableLiveData<String>()

    fun getListSports() {

    }
}