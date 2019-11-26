package com.example.footballapps.base

import com.example.footballapps.vo.Result
import retrofit2.Response

open class BaseRepository {
    suspend fun <T> getApiResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()

                if (body != null) {
                    return Result.success(body)
                }
            }
            return Result.error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return Result.error(e.message ?: e.toString())
        }
    }
}