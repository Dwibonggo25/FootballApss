package com.example.simplelogin.ui

import androidx.lifecycle.ViewModel
import com.example.simplelogin.repository.LoginRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val repository: LoginRepository): ViewModel() {

    var mCompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        mCompositeDisposable.dispose()
        super.onCleared()
    }
}