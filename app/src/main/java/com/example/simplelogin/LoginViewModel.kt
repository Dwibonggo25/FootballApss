package com.example.simplelogin

import androidx.lifecycle.ViewModel
import com.example.simplelogin.repository.LoginRepository
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val repository: LoginRepository): ViewModel() {

}