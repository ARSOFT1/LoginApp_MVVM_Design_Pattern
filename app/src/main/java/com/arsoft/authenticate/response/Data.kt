package com.arsoft.authenticate.response

data class Data(
    val authToken: String,
    val email: String,
    val fullName: String,
    val mobileNumber: String,
    val userId: Int,
    val userTimestamp: String,
    val userType: String,
    val workshopTitle: String,
    val zones: String,
    val zonesTitle: String
)