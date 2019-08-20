package com.example.simplelogin.repository

import com.example.simplelogin.db.UserDao
import javax.inject.Inject

class LoginRepository @Inject constructor(val dao: UserDao) {

}