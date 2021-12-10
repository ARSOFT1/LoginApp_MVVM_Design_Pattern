package com.arsoft.authenticate.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arsoft.authenticate.repository.AuthRepository
import com.arsoft.authenticate.response.LoginResponse
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AuthRepository):ViewModel() {

    val loginResponse :LiveData<LoginResponse>
        get() = repository.loginResult


    fun login(username:String, password:String) = viewModelScope.launch{
        repository.login(username, password )
    }
}