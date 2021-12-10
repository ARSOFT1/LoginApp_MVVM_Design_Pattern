package com.arsoft.authenticate.network

import com.arsoft.authenticate.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("username") email:String,
        @Field("password") password:String
    ): Response<LoginResponse>
}