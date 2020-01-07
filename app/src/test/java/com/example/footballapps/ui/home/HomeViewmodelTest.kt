package com.example.footballapps.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import com.example.footballapps.repository.HomeRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class HomeViewmodelTest {

    @get: Rule
    val testCoroutineRule = TestCoroutineRule()

    @get: Rule
    val instanExecutore = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: HomeRepository

    private lateinit var viewmodel: HomeViewmodel

    //private val obeserver: Observer<com.example.footballapps.vo.Result<List<AllSportsLocal>>> = mock()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewmodel = HomeViewmodel(repository)
    }

//    @Test
//    fun `Ketika server mengirimkan data`() = testCoroutineRule.runBlockingTest {
//
////        val data = LiveData<Result<>>
////
////       Mockito.`when`(repository.getAllSports()).thenReturn(data)
//
//    }
}