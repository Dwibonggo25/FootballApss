package com.example.footballapps

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

sealed class ResultWrapper <out T> {
    data class Success <out T>(val value: T): ResultWrapper<T>()
    data class Error (val code: Int? = null, val error: String? = null):  ResultWrapper<Nothing>()
    object NetworkError: ResultWrapper<Nothing>()
}
