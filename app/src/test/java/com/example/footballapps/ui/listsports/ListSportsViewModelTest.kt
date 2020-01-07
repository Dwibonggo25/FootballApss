package com.example.footballapps.ui.listsports

import com.example.footballapps.repository.HomeRepository
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ListSportsViewModelTest {

    @Mock
    lateinit var repository: HomeRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @After
    fun tearDown() {

    }

    @Test
    fun `Given DataRepository returns data, when getStuff() called, then update live data`() {

      //  when(repository.getAllSports())
    }
}