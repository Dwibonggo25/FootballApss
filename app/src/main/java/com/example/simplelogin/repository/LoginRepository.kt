package com.example.simplelogin.repository

import com.example.simplelogin.api.ApiService
import com.example.simplelogin.db.UserDao
import javax.inject.Inject

class LoginRepository @Inject constructor( private val apiservice: ApiService) {

}