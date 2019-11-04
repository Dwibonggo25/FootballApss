package com.example.footballapps.ui.login

import androidx.lifecycle.ViewModel
import com.example.footballapps.repository.LoginRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val repository: LoginRepository): ViewModel() {

    var mCompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        mCompositeDisposable.dispose()
        super.onCleared()
    }
}