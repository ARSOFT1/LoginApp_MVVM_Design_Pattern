package com.arsoft.authenticate.response

data class LoginResponse(
    val `data`: Data,
    val msg: String,
    val success: Boolean
)