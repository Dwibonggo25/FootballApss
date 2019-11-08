package com.example.footballapps.repository

import com.example.footballapps.api.ApiService
import com.example.footballapps.db.dao.UserDao
import javax.inject.Inject

class LoginRepository @Inject constructor(private val userDao: UserDao, private val apiservice: ApiService) {

}