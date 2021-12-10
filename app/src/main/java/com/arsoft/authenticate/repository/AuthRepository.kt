package com.arsoft.authenticate.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arsoft.authenticate.network.AuthApi
import com.arsoft.authenticate.response.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepository(private val api: AuthApi) {

    private val loginLiveData = MutableLiveData<LoginResponse>()

    val loginResult: LiveData<LoginResponse>
        get() = loginLiveData

    //suspend fun login(username:String, password:String) = safeApiCall { api.login(username, password) }
    suspend fun login(username:String, password:String) {
        withContext(Dispatchers.IO){
            val result = api.login(username, password)
            if (result?.body() != null){
                loginLiveData.postValue(result.body())
            }
        }

    }
}